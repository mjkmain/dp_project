package observerPattern;

import java.util.ArrayList;
import java.util.List;
import type_strategy.*;

public class Notice {
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(Observer o:observers) {
			o.receive(o.client_id, o.accommodationType);
		}
	}
}

