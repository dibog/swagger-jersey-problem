package net.bogdoll;

import java.net.URISyntaxException;

import org.glassfish.grizzly.http.server.HttpServer;

public class SeparatePackagesCWithPackages extends BaseLauncher {

	private SeparatePackagesCWithPackages()  throws URISyntaxException {
		packages("net.bogdoll.resC");
	}

	public static void main(String[] args) throws Exception {
		HttpServer server = new SeparatePackagesCWithPackages().startServer();
		System.in.read();
		server.shutdownNow();
		
		// http://localhost:8080/data -> fails with 500
		// http://localhost:8080/base -> succeeds
		// http://localhost:8080/api-docs -> succeeds: {"apiVersion":"1.0.1","swaggerVersion":"1.2","apis":[{"path":"/data","description":"Operations for ..."},{"path":"/base","description":"Operations for ..."}]}		
		// previous line shows both /base and /data
		
		// summary: REST fails, Swagger works
	}
}
