package decorator_pattern;

public class SingleRoom extends HotelRoom{
	public SingleRoom() {
		desc = "�̱� ��(100,000)";
	}
	@Override
	public int cost() {
		return 100000;
	}

}
