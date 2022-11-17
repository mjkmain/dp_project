package decorator_pattern;

public class BreakFastService extends AdditionalPriceDecorator{
	public BreakFastService(HotelRoom hotelRoomSize) {
		this.hotelRoomSize = hotelRoomSize;
	}
	@Override
	public String getDescription() {
		return hotelRoomSize.getDescription() + ", ���� �߰�(+10,000)";
	}
	@Override
	public int cost() {
		return hotelRoomSize.cost() + 10000;
	}

}