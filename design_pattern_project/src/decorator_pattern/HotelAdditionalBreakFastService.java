package decorator_pattern;

public class HotelAdditionalBreakFastService extends HotelAdditionalServiceDecorator{
	public HotelAdditionalBreakFastService(HotelRoom RoomSize) {
		this.RoomSize = RoomSize;
	}
	@Override
	public String getDescription() {
		return RoomSize.getDescription() + ", 조식 추가(+10,000)";
	}
	@Override
	public int cost() {
		return RoomSize.cost() + 10000;
	}
}


