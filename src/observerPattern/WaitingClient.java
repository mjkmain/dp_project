package observerPattern;

import type_strategy.*;

public class WaitingClient extends Observer{
	public WaitingClient(String client_id, String accommodationType) {
		this.client_id = client_id;
		this.accommodationType = accommodationType;
	}

}
