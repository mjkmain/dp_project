package decorator_pattern;

public abstract class HotelAdditionalServiceDecorator extends HotelRoom{
	HotelRoom RoomSize;
	public abstract String getDescription();
}

