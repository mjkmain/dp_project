package observerPattern;

import type_strategy.*;

public class Observer {
	public String client_id;
	public String accommodationType;
	
	public void receive(String client_id, String accommodationType) {
		System.out.println(client_id+" ����, �����Ͻ� " + accommodationType + 
				" �ڸ��� �����ϴ�.");
	}
}

