package decorator_pattern;

public class HotelPartyRoom extends HotelRoom{
	public HotelPartyRoom() {
		desc = "ÆÄÆ¼ ·ë(300,000)";
	}
	@Override
	public int cost() {
		return 300000;
	}
}
