package server;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Depots {

	List<Double> positions;
	private double depot_wealth;

	public Depots(List<Double> positions) {
		this.positions = positions;
	}

	public List<Double> getPositions() {
		return positions;
	}

	public void setPositions(List<Double> positions) {
		this.positions = positions;
	}

	public double getDepot_wealth() {
		return depot_wealth;
	}

	public void setDepot_wealth(double depot_wealth) {
		this.depot_wealth = depot_wealth;
	}

	@Override
	public String toString() {
		return "Depots [positions=" + positions + ", depot_wealth=" + depot_wealth + "]";
	}

}
