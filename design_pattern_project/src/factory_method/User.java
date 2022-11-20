package factory_method;

import java.util.HashMap;
import java.util.Map;

import type_strategy.TypeStrategy;

public interface User {
	void register();
	
	// strategy¿Í ¿¬°á
	default Map<String,String> reservation(String clientId, TypeStrategy type) {
		Map<String, String> userInfo = new HashMap<String, String>();
		userInfo.put("accommodation_type", type.selectRoom());
		userInfo.put("client_id", clientId);
		return userInfo;
	}
	
	default Map<String,String> unreservation(String clientId, TypeStrategy type) {
		Map<String, String> userInfo = new HashMap<String, String>();
		userInfo.put("accommodation_type", type.selectRoom());
		userInfo.put("client_id", clientId);
		return userInfo;
	}
}
