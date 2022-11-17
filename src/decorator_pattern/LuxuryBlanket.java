package decorator_pattern;

public class LuxuryBlanket extends AdditionalPriceDecorator{
	public LuxuryBlanket(HotelRoom hotelRoomSize) {
		this.hotelRoomSize = hotelRoomSize;
	}
	@Override
	public String getDescription() {
		return hotelRoomSize.getDescription() + ", 고급 이불(+20,000)";
	}
	@Override
	public int cost() {
		return hotelRoomSize.cost() + 20000;
	}

}