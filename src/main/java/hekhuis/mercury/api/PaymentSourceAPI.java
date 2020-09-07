package hekhuis.mercury.api;

import hekhuis.mercury.entity.PaymentSource;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.service.PaymentSourceService;
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
@Path("/paymentSource")
public class PaymentSourceAPI {
    private static final Logger logger = LoggerFactory.getLogger(PaymentSourceAPI.class);

    @Autowired
    private PaymentSourceService paymentSourceService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPaymentSource(PaymentSource paymentSource) {
        try {
            User user = new User();
            PaymentSource savedPaymentSource = paymentSourceService.savePaymentSource(paymentSource, user);
            return Response.ok(savedPaymentSource).build();
        } catch (Exception e) {
            logger.error("Error", e);
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{paymentSourceID}")
    public ResponseEntity<PaymentSource> getPaymentSource(@PathParam("paymentSourceID") long paymentSourceID) {
        try {
            User user = new User();
            PaymentSource paymentSource = paymentSourceService.getPaymentSource(paymentSourceID, user);
            return new ResponseEntity<>(paymentSource, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{paymentSourceID}")
    public ResponseEntity<PaymentSource> updatePaymentSource(@PathParam("paymentSourceID") long paymentSourceID, PaymentSource paymentSource) {
        try {
            User user = new User();
            PaymentSource savedPaymentSource = paymentSourceService.savePaymentSource(paymentSource, user);
            return new ResponseEntity<>(savedPaymentSource, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{paymentSourceID}")
    public ResponseEntity<?> deletePaymentSource(@PathParam("paymentSourceID") long paymentSourceID) {
        User user = new User();
        try {
            paymentSourceService.deletePaymentSource(paymentSourceID, user);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PaymentSource> getPaymentSources() {
        return paymentSourceService.getAllPaymentSources();
    }
}
