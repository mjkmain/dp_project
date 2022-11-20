package mvc_pattern;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;

import type_strategy.HotelStrategy;
import type_strategy.PensionStrategy;
import type_strategy.TypeStrategy;

public class User_GUI extends JFrame {
	Container c = getContentPane();
	Yanolja yanolja = new Yanolja();
	Airbnb airbnb = new Airbnb();
	
	String user_name;
	TypeStrategy accType;
	String roomType;
	Boolean isBreakFast;
	Boolean LuxuryPillow;
	Boolean LuxuryBlanket;
	
	public User_GUI() {
		Label lcp = new Label("예약 회사 :", Label.RIGHT);
		lcp.setBounds(50, 70, 90, 50);
		lcp.setFont(new Font("Arial", Font.PLAIN, 18));
		CheckboxGroup company = new CheckboxGroup();
		Checkbox cb_yanolja = new Checkbox("야놀자", company, true);
		cb_yanolja.setBounds(150, 70, 100, 50);
		cb_yanolja.setFont(new Font("Arial", Font.PLAIN, 18));
		Checkbox cb_airbnb = new Checkbox("airbnb", company, false);
		cb_airbnb.setBounds(350, 70, 100, 50);
		cb_airbnb.setFont(new Font("Arial", Font.PLAIN, 18));

		
		Label lac = new Label("숙박 종류 :", Label.RIGHT);
		lac.setBounds(50, 120, 90, 50);
		lac.setFont(new Font("Arial", Font.PLAIN, 18));
		CheckboxGroup accommodataionType = new CheckboxGroup();
		Checkbox cb_hotel = new Checkbox("호텔", accommodataionType, true);
		cb_hotel.setBounds(150, 120, 100, 50);
		cb_hotel.setFont(new Font("Arial", Font.PLAIN, 18));
		Checkbox cb_pension = new Checkbox("펜션", accommodataionType, false);
		cb_pension.setBounds(350, 120, 100, 50);
		cb_pension.setFont(new Font("Arial", Font.PLAIN, 18));
		
		/*
		 * Hotel config
		 * */
		Label lrt = new Label("방 종류 :", Label.RIGHT);
		lrt.setBounds(50, 170, 90, 50);
		lrt.setFont(new Font("Arial", Font.PLAIN, 18));
		
		CheckboxGroup roomTypeHotel = new CheckboxGroup();
		Checkbox cb_hotelSingle = new Checkbox("싱글룸", roomTypeHotel, true);
		cb_hotelSingle.setBounds(150, 170, 100, 50);
		cb_hotelSingle.setFont(new Font("Arial", Font.PLAIN, 18));
		Checkbox cb_hotelSuite = new Checkbox("스위트룸", roomTypeHotel, false);
		cb_hotelSuite.setBounds(250, 170, 100, 50);
		cb_hotelSuite.setFont(new Font("Arial", Font.PLAIN, 18));
		Checkbox cb_hotelParty = new Checkbox("파티룸", roomTypeHotel, false);
		cb_hotelParty.setBounds(350, 170, 100, 50);
		cb_hotelParty.setFont(new Font("Arial", Font.PLAIN, 18));
		
		/*
		 * Pension config
		 * */
		CheckboxGroup roomTypePension = new CheckboxGroup();
		Checkbox cb_pensionA = new Checkbox("A동", roomTypePension, true);
		cb_pensionA.setBounds(150, 170, 100, 50);
		cb_pensionA.setFont(new Font("Arial", Font.PLAIN, 18));
		cb_pensionA.setVisible(false);
		Checkbox cb_pensionB = new Checkbox("B동", roomTypePension, false);
		cb_pensionB.setBounds(250, 170, 100, 50);
		cb_pensionB.setFont(new Font("Arial", Font.PLAIN, 18));
		cb_pensionB.setVisible(false);
		Checkbox cb_pensionC = new Checkbox("C동", roomTypePension, false);
		cb_pensionC.setBounds(350, 170, 100, 50);
		cb_pensionC.setFont(new Font("Arial", Font.PLAIN, 18));
		cb_pensionC.setVisible(false);
		
		Label la = new Label("추가 옵션 :", Label.RIGHT);
		la.setBounds(50, 220, 90, 50);
		la.setFont(new Font("Arial", Font.PLAIN, 18));
		
		CheckboxGroup AdditionalBreakFast = new CheckboxGroup();
		Checkbox cb_Breakfast = new Checkbox("조식", AdditionalBreakFast, true);
		cb_Breakfast.setBounds(150, 220, 100, 50);
		cb_Breakfast.setFont(new Font("Arial", Font.PLAIN, 18));
		
		CheckboxGroup AdditionalBlanket = new CheckboxGroup();
		Checkbox cb_LuxuryBlanket = new Checkbox("베개", AdditionalBlanket, false);
		cb_LuxuryBlanket.setBounds(250, 220, 100, 50);
		cb_LuxuryBlanket.setFont(new Font("Arial", Font.PLAIN, 18));
		
		CheckboxGroup AdditionalPillow = new CheckboxGroup();
		Checkbox cb_LuxuryPillow = new Checkbox("이불", AdditionalPillow, false);
		cb_LuxuryPillow.setBounds(350, 220, 100, 50);
		cb_LuxuryPillow.setFont(new Font("Arial", Font.PLAIN, 18));
		
		cb_hotel.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				cb_hotelSingle.setVisible(true);
				cb_hotelSuite.setVisible(true);
				cb_hotelParty.setVisible(true);
				cb_pensionA.setVisible(false);
				cb_pensionB.setVisible(false);
				cb_pensionC.setVisible(false);
			}
		});
		
		cb_pension.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				cb_hotelSingle.setVisible(false);
				cb_hotelSuite.setVisible(false);
				cb_hotelParty.setVisible(false);
				cb_pensionA.setVisible(true);
				cb_pensionB.setVisible(true);
				cb_pensionC.setVisible(true);
			}
		});

		setSize(500, 550);
		c.setLayout(null);

		Label lid = new Label("ID :", Label.RIGHT);
		lid.setBounds(120, 40, 40, 20);
		TextField id = new TextField(10);
		id.setBounds(160, 40, 200, 20);
		
		TextArea tfResult = new TextArea();
		tfResult.setBounds(25, 370, 450, 100);
		tfResult.setFont(new Font("Arial", Font.PLAIN, 16));
		tfResult.setText("Message");
		
		Button btn = new Button("예약");
		btn.setBounds(150, 300, 100, 50);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				user_name = id.getText();
				
				if(cb_hotel.getState()) {
					accType = Hotel();
					if(cb_hotelSingle.getState()) roomType = "single";
					if(cb_hotelSuite.getState()) roomType = "suite";
					if(cb_hotelParty.getState()) roomType = "party";
				}
				if(cb_pension.getState()) {
					accType = Pension();
					if(cb_pensionA.getState()) roomType = "A";
					if(cb_pensionB.getState()) roomType = "B";
					if(cb_pensionC.getState()) roomType = "C";
				}
				
				if(cb_yanolja.getState()) {
					yanolja.reserveYanolja(user_name, accType, roomType,  cb_LuxuryPillow.getState(),
							cb_LuxuryBlanket.getState(), cb_Breakfast.getState(), tfResult);
				}
				
				if(cb_airbnb.getState()) {
					airbnb.reserveAirbnb(user_name, accType, roomType,  cb_LuxuryPillow.getState(),
							cb_LuxuryBlanket.getState(), cb_Breakfast.getState(), tfResult);
				}
			}
		});
		
		Button btn2 = new Button("예약 취소");
		btn2.setBounds(250, 300, 100, 50);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				user_name = id.getText();
				
				if(cb_hotel.getState()) {
					accType = Hotel();
					if(cb_hotelSingle.getState()) roomType = "single";
					if(cb_hotelSuite.getState()) roomType = "suite";
					if(cb_hotelParty.getState()) roomType = "party";
				}
				if(cb_pension.getState()) {
					accType = Pension();
					if(cb_pensionA.getState()) roomType = "A";
					if(cb_pensionB.getState()) roomType = "B";
					if(cb_pensionC.getState()) roomType = "C";
				}
				
				if(cb_yanolja.getState()) {
					yanolja.unreserveYanolja(user_name, accType, tfResult);
				}
				
				if(cb_airbnb.getState()) {
					airbnb.unreserveAirbnb(user_name, accType, tfResult);
				}
			}
		});
		
		
		
		c.add(lcp);
		c.add(lac);
		c.add(lid);
		c.add(lrt);
		c.add(la);
		c.add(id);
		c.add(btn);
		c.add(btn2);
		c.add(cb_yanolja);
		c.add(cb_airbnb);
		c.add(cb_hotel);
		c.add(cb_pension);
		c.add(cb_hotelSingle);
		c.add(cb_hotelSuite);
		c.add(cb_hotelParty);
		c.add(cb_pensionA);
		c.add(cb_pensionB);
		c.add(cb_pensionC);
		c.add(cb_Breakfast);
		c.add(cb_LuxuryPillow);
		c.add(cb_LuxuryBlanket);
		c.add(tfResult);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		new User_GUI();
	}
	public static TypeStrategy Hotel() {
		return new HotelStrategy();
	}
	public static TypeStrategy Pension() {
		return new PensionStrategy();
	}

}
