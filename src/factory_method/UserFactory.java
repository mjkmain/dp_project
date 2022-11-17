package factory_method;

public abstract class UserFactory {
	public User newInstance() {
		User user = creatUser();
		user.register();
		return user;
	}
	
	protected abstract User creatUser();
}
