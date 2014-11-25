package net.bogdoll.resA;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;


@Path("/base")
@Produces("text/plain")
@Api(value="/base", description="Operations for ...")
public class BaseResource {
	@GET
	@ApiOperation(
            value = "Returns all known data",
            response = String.class
            )
	public String getData() {
		return new Date().toString();
	}
}
