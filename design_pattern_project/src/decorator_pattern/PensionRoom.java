package decorator_pattern;

public abstract class PensionRoom{
	
	String desc = "";
	public String getDescription() {
		return desc;
	}
	
	public abstract int cost();
}

