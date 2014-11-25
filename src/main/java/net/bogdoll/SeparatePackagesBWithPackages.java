package net.bogdoll;

import java.net.URISyntaxException;

import org.glassfish.grizzly.http.server.HttpServer;

public class SeparatePackagesBWithPackages extends BaseLauncher {

	private SeparatePackagesBWithPackages()  throws URISyntaxException {
		packages("net.bogdoll.resB");
	}

	public static void main(String[] args) throws Exception {
		HttpServer server = new SeparatePackagesBWithPackages().startServer();
		System.in.read();
		server.shutdownNow();
		
		// http://localhost:8080/data -> fails with 500
		// http://localhost:8080/base -> succeeds
		// http://localhost:8080/api-docs -> succeeds: {"apiVersion":"1.0.1","swaggerVersion":"1.2","apis":[{"path":"/data","description":"Operations for ..."},{"path":"/base","description":"Operations for ..."}]}		
		// previous line shows both /base and /data
		
		// summary: REST fails, Swagger works
	}
}
