package decorator_pattern;

public class PensionAdditionalLuxuryPillow extends PensionAdditionalPriceDecorator{
	public PensionAdditionalLuxuryPillow(PensionRoom RoomSize) {
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
