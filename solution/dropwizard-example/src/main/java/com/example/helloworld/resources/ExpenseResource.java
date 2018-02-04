package com.example.helloworld.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.helloworld.core.Expense;
import com.example.helloworld.db.ExpenseDAO;

import io.dropwizard.hibernate.UnitOfWork;

@Path("/expense")
@Produces(MediaType.APPLICATION_JSON)
public class ExpenseResource {

    private final ExpenseDAO expenseDAO;

    public ExpenseResource(final ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    @GET
    @UnitOfWork
    public List<Expense> listExpenses() {
        return expenseDAO.findAll();
    }

    @POST
    @UnitOfWork
    public Expense createExpense(final Expense expense) {
        return expenseDAO.create(expense);
    }
}
