package design_pattern_project;

import java.util.Map;

import decorator_pattern.BreakFastService;
import decorator_pattern.HotelRoom;
import decorator_pattern.LuxuryBlanket;
import decorator_pattern.LuxuryPillow;
import decorator_pattern.PartyRoom;
import decorator_pattern.SingleRoom;
import decorator_pattern.SuiteRoom;
import factory_method.AirbnbUserFactory;
import factory_method.User;
import factory_method.UserFactory;
import factory_method.YanoljaUserFactory;
import observerPattern.Notice;
import observerPattern.WaitingClient;
import type_strategy.TypeStrategy;

public class Airbnb {
	int max_hotel = 1;
	int max_pension = 3;
	Notice notice = new Notice();

	public int reservedRoomCount(String accommodationType, String reserve) {
		if (reserve.equals("reserve")) {
			if (accommodationType.equals("호텔")) {
				
				return max_hotel--;
			} else if (accommodationType.equals("펜션")) {
				return max_pension--;
			}
		}
		if (reserve.equals("unreserve")) {
			if (accommodationType.equals("호텔")) {
				return ++max_hotel;
			} else if (accommodationType.equals("펜션")) {
				return ++max_pension;
			}
		}

		return 0;
	}

	public void reserveAirbnb(String clientID, TypeStrategy accommodationType, String room_type, boolean luxury_pillow,
			boolean luxury_blanket, boolean break_fast) {
		
		/*
		 * Factory Method Pattern - 각 어플에 따른 객체 생성
		 * 
		 * Strategy Pattern - 호텔 or 펜션 전략 정하기
		 */
		UserFactory userFactory = new AirbnbUserFactory();
		User user = userFactory.newInstance(); // 객체 생성
		// 예약
		Map<String, String> userInfo = user.reservation(clientID, accommodationType);
		if (reservedRoomCount(userInfo.get("accommodation_type"), "reserve") > 0) {
			System.out.println(userInfo.get("client_id") + " 고객님, " + userInfo.get("accommodation_type") + " 예약되었습니다.");
			printDetails(userInfo, room_type, luxury_pillow, luxury_blanket, break_fast);
		} else {
			System.out.println(
					userInfo.get("client_id") + " 고객님 죄송합니다. " + userInfo.get("accommodation_type") + " 빈 방이 없습니다.");
			WaitingClient client = new WaitingClient(userInfo.get("client_id"), userInfo.get("accommodation_type"));
			notice.attach(client);
		}
		System.out.println("==========================================\n");

	}

	public void unreserveAirbnb(String clientID, TypeStrategy accommodationType) {
//		 예약 취소
		UserFactory userFactory = new AirbnbUserFactory();
		User user = userFactory.newInstance();
		Map<String, String> userInfo = user.unreservation(clientID, accommodationType);
		System.out.println(userInfo.get("client_id") + " 고객님, " + userInfo.get("accommodation_type") + " 예약이 취소되었습니다.");
		System.out.println("==========================================\n");
		if (reservedRoomCount(userInfo.get("accommodation_type"), "unreserve") >= 0) {
			notice.notifyObservers();
		}
		System.out.println("==========================================\n");
	}

	// additional services
	public HotelRoom getAdditionalHotelService(HotelRoom h, boolean luxury_pillow, boolean luxury_blanket,
			boolean break_fast) {
		if (luxury_pillow)
			h = new LuxuryPillow(h);

		if (luxury_blanket)
			h = new LuxuryBlanket(h);

		if (break_fast)
			h = new BreakFastService(h);

		return h;
	}

	public void printDetails(Map<String, String> userInfo, String room_type, boolean luxury_pillow,
			boolean luxury_blanket, boolean break_fast) {
		if (userInfo.get("accommodation_type").equals("호텔")) {
			// room types
			if (room_type.equals("suite")) {
				HotelRoom h = new SuiteRoom();
				h = getAdditionalHotelService(h, luxury_pillow, luxury_blanket, break_fast);
				System.out.println(h.getDescription());
				System.out.println("결제 금액 : "+h.cost());
			} else if (room_type.equals("single")) {
				HotelRoom h = new SingleRoom();
				h = getAdditionalHotelService(h, luxury_pillow, luxury_blanket, break_fast);
				System.out.println(h.getDescription());
				System.out.println("결제 금액 : "+h.cost());
			} else if (room_type.equals("party")) {
				HotelRoom h = new PartyRoom();
				h = getAdditionalHotelService(h, luxury_pillow, luxury_blanket, break_fast);
				System.out.println(h.getDescription());
				System.out.println("결제 금액 : "+h.cost());
			}
		}
	}
}
