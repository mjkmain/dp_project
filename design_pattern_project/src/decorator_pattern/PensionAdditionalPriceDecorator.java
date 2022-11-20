package decorator_pattern;

public abstract class PensionAdditionalPriceDecorator extends PensionRoom{
	PensionRoom RoomSize;
	public abstract String getDescription();
}
