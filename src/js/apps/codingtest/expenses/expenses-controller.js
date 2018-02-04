"use strict";

/******************************************************************************************

Expenses controller

******************************************************************************************/

var app = angular.module("expenses.controller", []);

app.controller("ctrlExpenses", ["$rootScope", "$scope", "config", "restalchemy", function ExpensesCtrl($rootScope, $scope, $config, $restalchemy) {
	// Update the headings
	$rootScope.mainTitle = "Expenses";
	$rootScope.mainHeading = "Expenses";

	// Update the tab sections
	$rootScope.selectTabSection("expenses", 0);

	var restExpenses = $restalchemy.init({ root: $config.apiroot }).at("expense");

	$scope.dateOptions = {
		changeMonth: true,
		changeYear: true,
		dateFormat: "dd/mm/yy"
	};

  var createdToDate = function(created) {
    // created is from Java LocalDateTime [2018,2,4,11,22]
    var result = null;
    if (Array.isArray(created)) {
      result = new Date(created[0], created[1]-1, created[2], created[3], created[4]);
    }
    return result;
  }

  var dateInputToCreated = function(dateInput) {
    // dateInput is of the form dd/mm/yy
    // brute force parsing... but there must be better approach
    var dateParts = dateInput.split("/");
    var year = dateParts[2];
    var month = "0" + dateParts[1]; 
    var day = "0" + dateParts[0]; 
    month = month.slice(-2);
    day = day.slice(-2);
    var result = `${year}-${month}-${day}T00:00`;
    return result;
  }

	var loadExpenses = function() {
		// Retrieve a list of expenses via REST
		restExpenses.get().then(function(expenses) {
			expenses.forEach(function(element) {
        // map backend fields to the form fields
        element.date = createdToDate(element.created);
        element.amount = element.value;
      });
      $scope.expenses = expenses;
		});
	}

	$scope.saveExpense = function() {
		if ($scope.expensesform.$valid) {
      // map form fields to POST expense api 
      var expense = {};
      expense.created = dateInputToCreated($scope.newExpense.date);
      expense.value = parseFloat($scope.newExpense.amount);
      expense.reason = $scope.newExpense.reason;
			// Post the expense via REST
			restExpenses.post(expense).then(function() {
        // clean form
        $scope.clearExpense();
				// Reload new expenses list
				loadExpenses();
			}).error(function(ex) {
        alert(JSON.stringify(ex));
      });
		}
	};

	$scope.clearExpense = function() {
		$scope.newExpense = {};
	};

	// Initialise scope variables
	loadExpenses();
	$scope.clearExpense();
}]);
