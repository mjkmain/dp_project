package decorator_pattern;

public class PensionCRoom extends PensionRoom{
	public PensionCRoom() {
		desc = "C µ¿ (400,000)";
	}
	@Override
	public int cost() {
		return 400000;
	}

}
