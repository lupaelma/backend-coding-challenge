package com.example.helloworld.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "expense")
@NamedQueries(
    {
        @NamedQuery(
            name = "com.example.helloworld.core.Expense.findAll",
            query = "SELECT e FROM Expense e"
        )
    })
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "reason")
    private String reason;

    public Expense() {
    }

    public Expense(
        final LocalDateTime created,
        final Double value,
        final String reason) {
        this.created = created;
        this.value = value;
        this.reason = reason;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(final LocalDateTime created) {
        this.created = created;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(final Double value) {
        this.value = value;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(final String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Expense)) {
            return false;
        }

        final Expense that = (Expense) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.created, that.created) &&
                Objects.equals(this.value, that.value) &&
                Objects.equals(this.reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, value, reason);
    }
}
