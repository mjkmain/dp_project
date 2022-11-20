package decorator_pattern;

public class HotelSuiteRoom extends HotelRoom{
	public HotelSuiteRoom() {
		desc="½ºÀ§Æ® ·ë(150,000)";
	}
	@Override
	public int cost() {
		return 150000;
	}
}
