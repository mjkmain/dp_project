package factory_method;

public class YanoljaUser implements User{
	
	@Override
	public void register() {
		System.out.println("야놀자로 접속");
	}
}
