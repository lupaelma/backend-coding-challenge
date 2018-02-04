package com.example.helloworld.db;

import com.example.helloworld.core.Expense;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class ExpenseDAO extends AbstractDAO<Expense> {
    public ExpenseDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Expense> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public Expense create(final Expense expense) {
        return persist(expense);
    }

    public List<Expense> findAll() {
        return list(namedQuery("com.example.helloworld.core.Expense.findAll"));
    }
}
