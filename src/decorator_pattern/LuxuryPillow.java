package decorator_pattern;

public class LuxuryPillow extends AdditionalPriceDecorator{
	public LuxuryPillow(HotelRoom hotelRoomSize) {
		this.hotelRoomSize = hotelRoomSize;
	}
	@Override
	public String getDescription() {
		return hotelRoomSize.getDescription() + ", 고급 배게(+10,000)";
	}
	@Override
	public int cost() {
		return hotelRoomSize.cost() + 10000;
	}

}
