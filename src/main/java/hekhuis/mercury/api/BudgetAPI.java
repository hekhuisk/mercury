package hekhuis.mercury.api;

import hekhuis.mercury.entity.User;
import hekhuis.mercury.entity.budget.Budget;
import hekhuis.mercury.service.BudgetService;
import hekhuis.mercury.service.UserService;
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
@Path("/budget")
public class BudgetAPI {
    private static final Logger logger = LoggerFactory.getLogger(BudgetAPI.class);

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBudget(Budget budget) {
        try {
            User user = userService.getUser(1);
            Budget savedBudget = budgetService.saveBudget(budget, user);
            return Response.ok(savedBudget).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{budgetID}")
    public ResponseEntity<Budget> getBudget(@PathParam("budgetID") long budgetID) {
        try {
            User user = userService.getUser(1);
            Budget budget = budgetService.getBudget(budgetID, user);
            return new ResponseEntity<>(budget, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{budgetID}")
    public ResponseEntity<Budget> updateBudget(@PathParam("budgetID") long budgetID, Budget budget) {
        try {
            User user = userService.getUser(1);
            Budget savedBudget = budgetService.saveBudget(budget, user);
            return new ResponseEntity<>(savedBudget, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{budgetID}")
    public ResponseEntity<?> deleteBudget(@PathParam("budgetID") long budgetID) {
        try {
            User user = userService.getUser(1);
            budgetService.deleteBudget(budgetID, user);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Error", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<Budget>> getBudgets() {
        return new ResponseEntity<>(budgetService.getAllBudgets(), HttpStatus.OK);
    }
}
