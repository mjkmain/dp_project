package decorator_pattern;

public class PensionARoom extends PensionRoom{
	public PensionARoom() {
		desc = "A µ¿ (200,000)";
	}
	@Override
	public int cost() {
		return 200000;
	}

}
