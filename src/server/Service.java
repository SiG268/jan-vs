package server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import customerservice.gen.CustomerService;
import customerservice.gen.CustomerServiceService;
import depotservice.gen.DepotService;
import depotservice.gen.DepotServiceService;
import priceservice.gen.PriceService;
import priceservice.gen.PriceServiceService;

@Path("service")
public class Service {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{id}")
	public Customer serviceFunktion(@PathParam("id") int id) {

		// Import Services
		CustomerServiceService cs_lookup = new CustomerServiceService();
		CustomerService customer_service = cs_lookup.getCustomerServicePort();

		DepotServiceService dp_lookup = new DepotServiceService();
		DepotService depot_service = dp_lookup.getDepotServicePort();

		PriceServiceService ps_lookup = new PriceServiceService();
		PriceService price_service = ps_lookup.getPriceServicePort();

		Customer c = new Customer();
		return c;
	}
}
