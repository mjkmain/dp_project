package factory_method;

public class YanoljaUserFactory extends UserFactory{
	@Override
	protected User creatUser() {
		return new YanoljaUser();
	}
}
