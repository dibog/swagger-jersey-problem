package net.bogdoll;

import java.net.URISyntaxException;

import org.glassfish.grizzly.http.server.HttpServer;

public class SeparatePackagesBWithRegister extends BaseLauncher {

	private SeparatePackagesBWithRegister() throws URISyntaxException {
		register(net.bogdoll.resB.impl.DataResourceImpl.class);
		register(net.bogdoll.resB.BaseResource.class);
	}
	
	public static void main(String[] args) throws Exception {
		HttpServer server = new SeparatePackagesBWithRegister().startServer();
		System.in.read();
		server.shutdownNow();
		
		// http://localhost:8080/data -> succeeds
		// http://localhost:8080/base -> succeeds
		// http://localhost:8080/api-docs -> fails: {"apiVersion":"1.0.1","swaggerVersion":"1.2","apis":[{"path":"/base","description":"Operations for ..."}]}
		// previous line only shows /base but not /data
		
		// summary: REST works, Swagger fails
	}
}
