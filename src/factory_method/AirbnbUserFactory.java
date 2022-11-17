package factory_method;

public class AirbnbUserFactory extends UserFactory{
	@Override
	protected User creatUser() {

		return new AirbnbUser();
	}

}
