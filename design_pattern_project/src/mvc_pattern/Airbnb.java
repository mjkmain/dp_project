package mvc_pattern;

import java.awt.TextArea;
import java.util.Map;

import decorator_pattern.HotelAdditionalBreakFastService;
import decorator_pattern.HotelAdditionalLuxuryBlanket;
import decorator_pattern.HotelAdditionalLuxuryPillow;
import decorator_pattern.HotelPartyRoom;
import decorator_pattern.HotelRoom;
import decorator_pattern.HotelSingleRoom;
import decorator_pattern.HotelSuiteRoom;
import decorator_pattern.PensionARoom;
import decorator_pattern.PensionAdditionalBreakFastService;
import decorator_pattern.PensionAdditionalLuxuryBlanket;
import decorator_pattern.PensionAdditionalLuxuryPillow;
import decorator_pattern.PensionBRoom;
import decorator_pattern.PensionCRoom;
import decorator_pattern.PensionRoom;
import factory_method.AirbnbUserFactory;
import factory_method.User;
import factory_method.UserFactory;
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
			boolean luxury_blanket, boolean break_fast, TextArea tf) {

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
			String message = userInfo.get("client_id") + " 고객님, " + userInfo.get("accommodation_type") + " 예약되었습니다.\n\n";

			printDetails(userInfo, room_type, luxury_pillow, luxury_blanket, break_fast, tf, message);
		} else {
			System.out.println(
					userInfo.get("client_id") + " 고객님 죄송합니다. " + userInfo.get("accommodation_type") + " 빈 방이 없습니다.");
			WaitingClient client = new WaitingClient(userInfo.get("client_id"), userInfo.get("accommodation_type"));
			notice.attach(client);
		}
	}

	public void unreserveAirbnb(String clientID, TypeStrategy accommodationType, TextArea tf) {
//		 예약 취소
		UserFactory userFactory = new AirbnbUserFactory();
		User user = userFactory.newInstance();
		Map<String, String> userInfo = user.unreservation(clientID, accommodationType);
		String message = userInfo.get("client_id") + " 고객님, " + userInfo.get("accommodation_type") + " 예약이 취소되었습니다.\n";
		tf.setText(message);
		if (reservedRoomCount(userInfo.get("accommodation_type"), "unreserve") >= 0) {
			notice.notifyObservers();
		}
	}

	// additional services
	public HotelRoom getAdditionalHotelService(HotelRoom h, boolean luxury_pillow, boolean luxury_blanket,
			boolean break_fast) {
		if (luxury_pillow)
			h = new HotelAdditionalLuxuryPillow(h);

		if (luxury_blanket)
			h = new HotelAdditionalLuxuryBlanket(h);

		if (break_fast)
			h = new HotelAdditionalBreakFastService(h);

		return h;
	}

	public PensionRoom getAdditionalPensionService(PensionRoom p, boolean luxury_pillow, boolean luxury_blanket,
			boolean break_fast) {
		if (luxury_pillow)
			p = new PensionAdditionalLuxuryPillow(p);

		if (luxury_blanket)
			p = new PensionAdditionalLuxuryBlanket(p);

		if (break_fast)
			p = new PensionAdditionalBreakFastService(p);

		return p;
	}

	public void printDetails(Map<String, String> userInfo, String room_type, boolean luxury_pillow,
			boolean luxury_blanket, boolean break_fast, TextArea tf, String message) {
		if (userInfo.get("accommodation_type").equals("호텔")) {
			// room types
			if (room_type.equals("suite")) {
				HotelRoom h = new HotelSuiteRoom();
				h = getAdditionalHotelService(h, luxury_pillow, luxury_blanket, break_fast);
				String desc = message + h.getDescription()+"\n";
				desc += "결제 금액 : "+h.cost();
				tf.setText(desc);
			} else if (room_type.equals("single")) {
				HotelRoom h = new HotelSingleRoom();
				h = getAdditionalHotelService(h, luxury_pillow, luxury_blanket, break_fast);
				String desc = message + h.getDescription()+"\n";
				desc += "결제 금액 : "+h.cost();
				tf.setText(desc);
			} else if (room_type.equals("party")) {
				HotelRoom h = new HotelPartyRoom();
				h = getAdditionalHotelService(h, luxury_pillow, luxury_blanket, break_fast);
				String desc = message + h.getDescription()+"\n";
				desc += "결제 금액 : "+h.cost();
				tf.setText(desc);
			}
		}

		if (userInfo.get("accommodation_type").equals("펜션")) {
			// room types
			if (room_type.equals("A")) {
				PensionRoom p = new PensionARoom();
				p = getAdditionalPensionService(p, luxury_pillow, luxury_blanket, break_fast);
				String desc = message + p.getDescription()+"\n";
				desc += "결제 금액 : "+p.cost();
				tf.setText(desc);
			} else if (room_type.equals("B")) {
				PensionRoom p = new PensionBRoom();
				p = getAdditionalPensionService(p, luxury_pillow, luxury_blanket, break_fast);
				String desc = message + p.getDescription()+"\n";
				desc += "결제 금액 : "+p.cost();
				tf.setText(desc);
			} else if (room_type.equals("C")) {
				PensionRoom p = new PensionCRoom();
				p = getAdditionalPensionService(p, luxury_pillow, luxury_blanket, break_fast);
				String desc = message + p.getDescription()+"\n";
				desc += "결제 금액 : "+p.cost();
				tf.setText(desc);
			}
		}
	}
}
