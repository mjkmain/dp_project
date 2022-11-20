package decorator_pattern;

public class HotelAdditionalLuxuryPillow extends HotelAdditionalServiceDecorator{
	public HotelAdditionalLuxuryPillow(HotelRoom RoomSize) {
		this.RoomSize = RoomSize;
	}
	@Override
	public String getDescription() {
		return RoomSize.getDescription() + ", ��� ���(+10,000)";
	}
	@Override
	public int cost() {
		return RoomSize.cost() + 10000;
	}
}
