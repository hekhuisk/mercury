package hekhuis.mercury.api;

import hekhuis.mercury.entity.PaymentSource;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.service.PaymentSourceService;
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
@Path("/paymentSource")
public class PaymentSourceAPI {
    private static final Logger logger = LoggerFactory.getLogger(PaymentSourceAPI.class);

    @Autowired
    private PaymentSourceService paymentSourceService;

    @Autowired
    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPaymentSource(PaymentSource paymentSource) {
        try {
            User user = userService.getUser(1);
            PaymentSource savedPaymentSource = paymentSourceService.createPaymentSource(paymentSource, user);
            return Response.ok(savedPaymentSource).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{paymentSourceID}")
    public Response getPaymentSource(@PathParam("paymentSourceID") long paymentSourceID) {
        try {
            User user = userService.getUser(1);
            PaymentSource paymentSource = paymentSourceService.getPaymentSource(paymentSourceID, user);
            return Response.ok(paymentSource).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{paymentSourceID}")
    public Response updatePaymentSource(@PathParam("paymentSourceID") long paymentSourceID, PaymentSource paymentSource) {
        try {
            User user = userService.getUser(1);
            PaymentSource savedPaymentSource = paymentSourceService.updatePaymentSource(paymentSourceID, paymentSource, user);
            return Response.ok(savedPaymentSource).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{paymentSourceID}")
    public Response deletePaymentSource(@PathParam("paymentSourceID") long paymentSourceID) {
        try {
            User user = userService.getUser(1);
            paymentSourceService.deletePaymentSource(paymentSourceID, user);
            return Response.ok().build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPaymentSourcesForUser() {
        try {
            User user = userService.getUser(1);
            List<PaymentSource> paymentSources = paymentSourceService.getAllPaymentSourcesForUser(user.getUserID());
            return Response.ok(paymentSources).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }
}
