package decorator_pattern;

public class HotelSingleRoom extends HotelRoom{
	public HotelSingleRoom() {
		desc = "�̱� ��(100,000)";
	}
	@Override
	public int cost() {
		return 100000;
	}
}
