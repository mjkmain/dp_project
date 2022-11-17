package decorator_pattern;

public class SingleRoom extends HotelRoom{
	public SingleRoom() {
		desc = "½Ì±Û ·ë(100,000)";
	}
	@Override
	public int cost() {
		return 100000;
	}

}
