package server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("service")
public class Service {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{id}")
	public TestObject serviceFunktion(@PathParam("id") int id) {

		// Import Services
		// ServiceService lookup = new ServiceService();
		// Service service = Lookup.getServicePort();

		TestObject obj = new TestObject();
		obj.setTest1("Hallo Jan");
		obj.setTest2(id);
		return obj;
	}
}
