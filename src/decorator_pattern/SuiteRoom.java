package decorator_pattern;

public class SuiteRoom extends HotelRoom{
	public SuiteRoom() {
		desc="½ºÀ§Æ® ·ë(150,000)";
	}
	@Override
	public int cost() {
		
		return 150000;
	}

}
