package decorator_pattern;

public class PensionBRoom extends PensionRoom{
	public PensionBRoom() {
		desc = "B �� (300,000)";
	}
	@Override
	public int cost() {
		return 300000;
	}

}
