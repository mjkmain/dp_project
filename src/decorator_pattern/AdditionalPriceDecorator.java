package decorator_pattern;

public abstract class AdditionalPriceDecorator extends HotelRoom{
	HotelRoom hotelRoomSize;
	public abstract String getDescription();
}
