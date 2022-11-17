package decorator_pattern;

public abstract class HotelRoom{
	
	String desc = "";
	public String getDescription() {
		return desc;
	}
	
	public abstract int cost();
}
