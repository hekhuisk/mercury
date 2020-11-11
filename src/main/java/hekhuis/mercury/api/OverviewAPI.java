package hekhuis.mercury.api;

import hekhuis.mercury.entity.Overview;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.service.OverviewService;
import hekhuis.mercury.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/overview")
public class OverviewAPI {
    private static final Logger logger = LoggerFactory.getLogger(OverviewAPI.class);

    @Autowired
    private OverviewService overviewService;

    @Autowired
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{year}")
    public Response getOverviewForYear(@PathParam("year") int year) {
        try {
            User user = userService.getUser(1);
            Overview overview = overviewService.getOverviewForYear(year, user);
            return Response.ok(overview).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }
}
