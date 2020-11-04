package hekhuis.mercury.api;

import hekhuis.mercury.entity.Income;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.service.IncomeService;
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
import java.util.List;
import java.util.NoSuchElementException;

@Component
@Path("/income")
public class IncomeAPI {
    private static final Logger logger = LoggerFactory.getLogger(IncomeAPI.class);

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Income> createIncome(Income income) {
        try {
            User user = userService.getUser(1);
            Income savedIncome = incomeService.saveIncome(income, user);
            return new ResponseEntity<>(savedIncome, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{incomeID}")
    public ResponseEntity<Income> getIncome(@PathParam("incomeID") long incomeID) {
        try {
            User user = userService.getUser(1);
            Income income = incomeService.getIncome(incomeID, user);
            return new ResponseEntity<>(income, HttpStatus.OK);
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
    @Path("/{incomeID}")
    public ResponseEntity<Income> updateIncome(@PathParam("incomeID") long incomeID, Income income) {
        try {
            User user = userService.getUser(1);
            Income savedIncome = incomeService.saveIncome(income, user);
            return new ResponseEntity<>(savedIncome, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{incomeID}")
    public ResponseEntity<?> deleteIncome(@PathParam("incomeID") long incomeID) {
        try {
            User user = userService.getUser(1);
            incomeService.deleteIncome(incomeID, user);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Error", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Income> getIncomes() {
        return incomeService.getAllIncomes();
    }
}
