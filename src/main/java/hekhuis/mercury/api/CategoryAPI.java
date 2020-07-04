package hekhuis.mercury.api;

import hekhuis.mercury.entity.budget.Budget;
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

@Component
@Path("/category")
public class CategoryAPI {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createBudget(Budget budget) {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{budgetID}")
    public Budget getBudget(@PathParam("budgetID") int budgetID) {
        return new Budget();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{budgetID}")
    public void updateBudget(@PathParam("budgetID") int budgetID, Budget budget) {

    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{budgetID}")
    public void deleteBudget(@PathParam("budgetID") int budgetID) {

    }
}
