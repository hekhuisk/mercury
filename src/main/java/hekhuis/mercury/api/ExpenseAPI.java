package hekhuis.mercury.api;

import hekhuis.mercury.entity.Expense;
import hekhuis.mercury.service.ExpenseService;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/expense")
public class ExpenseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ExpenseAPI.class);

    @Autowired
    private ExpenseService expenseService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createExpense(Expense expense) {
        expenseService.createExpense(expense);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{expenseID}")
    public Expense getExpense(@PathParam("expenseID") int expenseID) {
        return expenseService.getExpense(expenseID);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{expenseID}")
    public void updateExpense(@PathParam("expenseID") int expenseID, Expense expense) {
        expenseService.updateExpense(expenseID, expense);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{expenseID}")
    public void deleteExpense(@PathParam("expenseID") int expenseID) {
        expenseService.deleteExpense(expenseID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Expense> getExpenses(@QueryParam("month") int month,
                                     @QueryParam("year") int year) {
        return expenseService.getExpenses(month, year);
    }
}
