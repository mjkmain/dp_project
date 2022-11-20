package decorator_pattern;

public class HotelAdditionalLuxuryBlanket extends HotelAdditionalServiceDecorator{
	public HotelAdditionalLuxuryBlanket(HotelRoom RoomSize) {
		this.RoomSize = RoomSize;
	}
	@Override
	public String getDescription() {
		return RoomSize.getDescription() + ", 고급 이불(+20,000)";
	}
	@Override
	public int cost() {
		return RoomSize.cost() + 20000;
	}
}

