package decorator_pattern;

public class HotelPartyRoom extends HotelRoom{
	public HotelPartyRoom() {
		desc = "��Ƽ ��(300,000)";
	}
	@Override
	public int cost() {
		return 300000;
	}
}
