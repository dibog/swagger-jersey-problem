package net.bogdoll;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;

import net.bogdoll.swagger.SwaggerJaxrsConfig;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public abstract class BaseLauncher extends ResourceConfig {
	public final URI BASE_URI; 

	protected BaseLauncher() throws URISyntaxException {
		BASE_URI = new URI("http://localhost:8080");
		
		packages("com.wordnik.swagger.jaxrs.listing");
		Map<String, String> swaggerParams = new HashMap<>();
		swaggerParams.put("api.version", "1.0.1");
		swaggerParams.put("swagger.api.basepath", BASE_URI.toString());
        SwaggerJaxrsConfig.register(swaggerParams);
	}

	protected HttpServer startServer() throws JAXBException, IOException {
		return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, this);
	}
}
