package decorator_pattern;

public class PartyRoom extends HotelRoom{
	public PartyRoom() {
		desc = "ÆÄÆ¼ ·ë(300,000)";
	}
	@Override
	public int cost() {
		return 300000;
	}
}
