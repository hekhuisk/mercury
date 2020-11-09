package hekhuis.mercury.api;

import hekhuis.mercury.entity.Income;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.service.IncomeService;
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
    public Response createIncome(Income income) {
        try {
            User user = userService.getUser(1);
            Income savedIncome = incomeService.createIncome(income, user);
            return Response.ok(savedIncome).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{incomeID}")
    public Response getIncome(@PathParam("incomeID") long incomeID) {
        try {
            User user = userService.getUser(1);
            Income income = incomeService.getIncome(incomeID, user);
            return Response.ok(income).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{incomeID}")
    public Response updateIncome(@PathParam("incomeID") long incomeID, Income income) {
        try {
            User user = userService.getUser(1);
            Income savedIncome = incomeService.updateIncome(incomeID, income, user);
            return Response.ok(savedIncome).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{incomeID}")
    public Response deleteIncome(@PathParam("incomeID") long incomeID) {
        try {
            User user = userService.getUser(1);
            incomeService.deleteIncome(incomeID, user);
            return Response.ok().build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllIncomesForUser() {
        try {
            User user = userService.getUser(1);
            List<Income> incomes = incomeService.getAllIncomesForUser(user.getUserID());
            return Response.ok(incomes).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }
}
