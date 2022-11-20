package decorator_pattern;

public class PensionAdditionalLuxuryBlanket extends PensionAdditionalPriceDecorator{
	public PensionAdditionalLuxuryBlanket(PensionRoom RoomSize) {
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
