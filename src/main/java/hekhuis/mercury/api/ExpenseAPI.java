package hekhuis.mercury.api;

import hekhuis.mercury.entity.Expense;
import hekhuis.mercury.service.ExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import java.util.NoSuchElementException;

@Component
@Path("/expense")
public class ExpenseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ExpenseAPI.class);

    @Autowired
    private ExpenseService expenseService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createExpense(Expense expense) {
        try {
            Expense savedExpense = expenseService.saveExpense(expense);
            return Response.ok(savedExpense).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{expenseID}")
    public ResponseEntity<Expense> getExpense(@PathParam("expenseID") long expenseID) {
        try {
            Expense expense = expenseService.getExpense(expenseID);
            return new ResponseEntity<>(expense, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{expenseID}")
    public ResponseEntity<Expense> updateExpense(@PathParam("expenseID") long expenseID, Expense expense) {
        try {
            expenseService.getExpense(expenseID); // Make sure the Expense being updated actually exists
            Expense savedExpense = expenseService.saveExpense(expense);
            return new ResponseEntity<>(savedExpense, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{expenseID}")
    public ResponseEntity<?> deleteExpense(@PathParam("expenseID") long expenseID) {
        expenseService.deleteExpense(expenseID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Expense> getExpenses() {
        return expenseService.getAllExpenses();
    }
}


//curl -X PUT -H "Content-Type: application/json" -d "{\"id\":1,\"name\":\"iPad\",\"price\":888}" http://localhost:8080/products/1
//curl -X POST -H "Content-Type: application/json" -d "{\"description\":\"XBox 360\"}" http://localhost:8080/mercury/api/expense