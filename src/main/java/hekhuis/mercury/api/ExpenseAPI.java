package hekhuis.mercury.api;

import hekhuis.mercury.entity.Expense;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.service.ExpenseService;
import hekhuis.mercury.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/expense")
public class ExpenseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ExpenseAPI.class);

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createExpense(Expense expense) {
        try {
            User user = userService.getUser(1);
            Expense savedExpense = expenseService.createExpense(expense, user);
            return Response.ok(savedExpense).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{expenseID}")
    public Response getExpense(@PathParam("expenseID") long expenseID) {
        try {
            User user = userService.getUser(1);
            Expense expense = expenseService.getExpense(expenseID, user);
            return Response.ok(expense).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{expenseID}")
    public Response updateExpense(@PathParam("expenseID") long expenseID, Expense expense) {
        try {
            User user = userService.getUser(1);
            Expense savedExpense = expenseService.updateExpense(expenseID, expense, user);
            return Response.ok(savedExpense).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{expenseID}")
    public Response deleteExpense(@PathParam("expenseID") long expenseID) {
        try {
            User user = userService.getUser(1);
            expenseService.deleteExpense(expenseID, user);
            return Response.ok().build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllExpensesForUser() {
        try {
            User user = userService.getUser(1);
            List<Expense> expenses = expenseService.getAllExpensesForUser(user.getUserID());
            return Response.ok(expenses).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }
}
