package hekhuis.mercury.spring;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/mercury/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("hekhuis.mercury.api");
    }
}
