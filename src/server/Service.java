package server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import customerservice.gen.Customer;
import customerservice.gen.CustomerService;
import customerservice.gen.CustomerServiceService;
import depotservice.gen.Depot;
import depotservice.gen.DepotService;
import depotservice.gen.DepotServiceService;
import depotservice.gen.Position;
import priceservice.gen.PriceService;
import priceservice.gen.PriceServiceService;

@Path("service")
public class Service {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{id}")
	public User serviceFunktion(@PathParam("id") int id) {

		// Import Services
		CustomerServiceService cs_lookup = new CustomerServiceService();
		CustomerService customer_service = cs_lookup.getCustomerServicePort();

		DepotServiceService dp_lookup = new DepotServiceService();
		DepotService depot_service = dp_lookup.getDepotServicePort();

		PriceServiceService ps_lookup = new PriceServiceService();
		PriceService price_service = ps_lookup.getPriceServicePort();
		User u = new User();
		Customer cus = customer_service.getCustomer(id);

		List<Depot> depotsService = depot_service.getDepot(id);
		List<Depots> depotsList = new ArrayList<Depots>();
		for (Depot depotS : depotsService) {

			List<Position> positionService = depotS.getPositions();
			List<Double> positionen = new ArrayList<Double>();
			for (Position pos : positionService) {
				double amount = pos.getAmount();
				String ISIN = pos.getInternationalSecurityNumber();
				double price = price_service.getPrice(ISIN, pos.getCurrency());
				double price_change = price_service.getExchangeRate(pos.getCurrency(), cus.getCurrency());

				double positionWealth = price * price_change * amount;

				positionen.add(positionWealth);
			}

			double depotWealth = 0;
			for (Double pos : positionen) {
				depotWealth = depotWealth + pos;
			}

			Depots depot = new Depots();

			depot.setDepot_wealth(depotWealth);
			depot.setPositions(positionen);
			depotsList.add(depot);
		}

		double customerWealth = 0;
		for (Depots depot : depotsList) {
			customerWealth = customerWealth + depot.getDepot_wealth();
		}

		u.setName(cus.getFirstName() + " " + cus.getSurName());
		u.setDepotlist(depotsList);
		u.setWealth(customerWealth);
		return u;
	}
}
