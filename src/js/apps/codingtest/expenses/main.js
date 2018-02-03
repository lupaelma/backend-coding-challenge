"use strict";

/******************************************************************************************

Tasks main

******************************************************************************************/

require("./expenses-controller.js");

var app = angular.module("expenses.controllers", [
	"expenses.controller"
]);

app.config(["$routeProvider", function($routeProvider) {
	// Labour analysis routes

  // have not found another way to include partials from template cache
  // using brute force approach for now
	$routeProvider.when("/expenses", { templateUrl: "codingtest/c:/gigi/projects/engage/backend-coding-challenge/build/source/js/apps/codingtest/partials/expenses-content.html" });

	$routeProvider.otherwise({redirectTo: "/expenses"});
}]);

app.run(["$rootScope", function($rootScope) {
	// Add app button
	$rootScope.appSections = $rootScope.appSections || [];
	$rootScope.appSections.push({ title: "Expenses", image: "img/icon-generic.png", app: "expenses" });

	// Configure tab sections
	$rootScope.tabSections = $rootScope.tabSections || {};
	$rootScope.tabSections.expenses = [
		{ title: "Expenses", app: "expenses" }
	];
}]);
