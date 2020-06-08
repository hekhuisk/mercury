package hekhuis.mercury.api;

import hekhuis.mercury.entity.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/greeting")
public class GreetingAPI {
    private static final Logger logger = LoggerFactory.getLogger(GreetingAPI.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting getGreeting() {
        return new Greeting(1, "Well hello there!");
    }
}
