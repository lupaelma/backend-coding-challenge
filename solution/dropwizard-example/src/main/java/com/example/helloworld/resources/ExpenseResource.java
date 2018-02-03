package com.example.helloworld.resources;

import com.example.helloworld.core.Person;
import com.example.helloworld.db.PersonDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/expense")
@Produces(MediaType.APPLICATION_JSON)
public class ExpenseResource {

    @GET
    @UnitOfWork
    public List<String> listExpenses() {
        return new ArrayList<String>(3);
    }

}
