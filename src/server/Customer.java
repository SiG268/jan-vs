package server;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

	private String name;
	private List<Depots> depotlist;
	private double wealth;

	public Customer() {

	}

	public Customer(String name, List<Depots> depotlist, double wealth) {
		this.name = name;
		this.depotlist = depotlist;
		this.wealth = wealth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Depots> getDepotlist() {
		return depotlist;
	}

	public void setDepotlist(List<Depots> depotlist) {
		this.depotlist = depotlist;
	}

	public double getWealth() {
		return wealth;
	}

	public void setWealth(double wealth) {
		this.wealth = wealth;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", wealth=" + wealth + "]";
	}

}
