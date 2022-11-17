package design_pattern_project;
import decorator_pattern.HotelRoom;
import decorator_pattern.LuxuryBlanket;
import decorator_pattern.LuxuryPillow;
import decorator_pattern.SuiteRoom;
import type_strategy.HotelStrategy;
import type_strategy.PensionStrategy;
import type_strategy.TypeStrategy;

public class Client {
	public static void main(String[] args) {
		Yanolja yanolja = new Yanolja();
		Airbnb airbnb = new Airbnb();
		
		
		yanolja.reserveYanolja("mjkmain", Hotel(), "suite", true, true, true);
		yanolja.reserveYanolja("swsong", Hotel(), "single", true, true, true);
		yanolja.reserveYanolja("cschoi", Hotel(), "party", false, true, true);
		airbnb.reserveAirbnb("hslim", Hotel(), "party", false, true, true);
		airbnb.reserveAirbnb("ktlim", Hotel(), "party", false, true, true);
		airbnb.unreserveAirbnb("hslim", Hotel());

	}
	
	public static TypeStrategy Hotel() {
		return new HotelStrategy();
	}
	public static TypeStrategy Pension() {
		return new PensionStrategy();
	}

}
