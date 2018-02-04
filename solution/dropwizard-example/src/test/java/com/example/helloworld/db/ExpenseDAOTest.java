package com.example.helloworld.db;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.example.helloworld.core.Expense;

import io.dropwizard.testing.junit.DAOTestRule;

public class ExpenseDAOTest {

    @Rule
    public DAOTestRule daoTestRule = DAOTestRule.newBuilder()
        .addEntityClass(Expense.class)
        .build();

    private ExpenseDAO expenseDAO;

    @Before
    public void setUp() throws Exception {
        expenseDAO = new ExpenseDAO(daoTestRule.getSessionFactory());
    }

    @Test
    public void createExpense() {
        final LocalDateTime now = LocalDateTime.now();
        final Double value = 1.1;
        final String reason = "various";
        final Expense expense = daoTestRule.inTransaction(() -> 
            expenseDAO.create(new Expense(now, value, reason)));
        assertThat(expense.getId()).isGreaterThan(0);
        assertThat(expense.getCreated()).isEqualTo(now);
        assertThat(expense.getValue()).isEqualTo(value);
        assertThat(expense.getReason()).isEqualTo(reason);
        assertThat(expenseDAO.findById(expense.getId())).isEqualTo(Optional.of(expense));
    }

    @Test
    public void findAll() {
        final LocalDateTime now = LocalDateTime.now();
        daoTestRule.inTransaction(() -> {
            expenseDAO.create(new Expense(now, 1.0, "r1"));
            expenseDAO.create(new Expense(now, 1.1, "r2"));
            expenseDAO.create(new Expense(now, 1.2, "r3"));
        });

        final List<Expense> expenses = expenseDAO.findAll();
        assertThat(expenses).extracting("created").containsOnly(now);
        assertThat(expenses).extracting("value").containsOnly(1.0, 1.1, 1.2);
        assertThat(expenses).extracting("reason").containsOnly("r1", "r2", "r3");
    }

    @Test(expected = ConstraintViolationException.class)
    public void handlesNullCreated() {
        daoTestRule.inTransaction(() -> expenseDAO.create(new Expense(null, 1.1, "")));
    }

    @Test(expected = ConstraintViolationException.class)
    public void handlesNullValue() {
        final LocalDateTime now = LocalDateTime.now();
        daoTestRule.inTransaction(() -> expenseDAO.create(new Expense(now, null, "")));
    }
}
