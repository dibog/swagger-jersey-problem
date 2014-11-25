package net.bogdoll.resC.interf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Path("/data")
@Produces("text/plain")
@Api(value="/data", description="Operations for ...")
public interface DataResource {
	@GET
	@ApiOperation(
            value = "Returns all known data",
            response = String.class
            )
	String getData();
}
