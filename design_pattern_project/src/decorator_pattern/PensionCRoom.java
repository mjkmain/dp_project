package decorator_pattern;

public class PensionCRoom extends PensionRoom{
	public PensionCRoom() {
		desc = "C �� (400,000)";
	}
	@Override
	public int cost() {
		return 400000;
	}

}
