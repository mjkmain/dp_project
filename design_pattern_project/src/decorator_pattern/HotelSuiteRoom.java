package decorator_pattern;

public class HotelSuiteRoom extends HotelRoom{
	public HotelSuiteRoom() {
		desc="����Ʈ ��(150,000)";
	}
	@Override
	public int cost() {
		return 150000;
	}
}
