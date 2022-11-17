package model_view_controler;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {
	// JPanel�Ӽ��� ��ӹ��� �̹��� �г� ����, �̹����� �׸��� ����
	@SuppressWarnings("serial")
	static class ImagePanel extends JPanel {
		// 1�����: img�� ���� �����ϰ� �Ʒ��� ��� ���ֱ�
		private Image img;
		// 2�����: img�� �����ϰ� ��ε� �ѹ��� ���� ���ֱ�
		private Image manual_img = new ImageIcon("C:\\\\workpace\\\\THcoffeeSystem\\\\images\\\\��뼳��.jpg").getImage();

		public ImagePanel(Image img) {
			this.img = img;

		}

		// �׸��� ���� ���ȭ��, ��뼭 �̹��� �׸���
		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, 1900, 1200, null);
			g.drawImage(manual_img, 1050, 300, 800, 600, null);
		}
	}

	public static void main(String[] args) {
		JFrame fr = new JFrame("Taehoung Ŀ�ǽý���");
		// �̹��� �г� �׸���
		ImagePanel pn = new ImagePanel(new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\���ȭ��.jpg").getImage());
		fr.pack();
		fr.add(pn);
		JPanel Hotpn = new JPanel();
		JPanel Icepn = new JPanel();
		JPanel Adepn = new JPanel();
		JPanel Dstpn = new JPanel(); // ����Ʈ �޴��� ���� �г�
		JPanel Orderpn = new JPanel();

		// �ֹ�����
		JTextArea ordertxt = new JTextArea();

		// �ֹ������� Ȯ���Ҽ��ִ� �ؽ�Ʈ �ʵ带 ���̰�, �����߰�
		pn.add(ordertxt);
		ordertxt.append("<�ֹ��Ͻ� ��ǰ�� Ȯ���Ҽ� �ֽ��ϴ�.> \n\n");
		ordertxt.setBounds(250, 900, 1000, 300); // �ֹ��ѳ����� �����ִ� txtarea�� ����
		ordertxt.setEditable(false);
		ordertxt.setFont(new Font("���� ���", Font.BOLD, 20));

		JTextArea listtxt = new JTextArea();
		listtxt.setBounds(0, 0, 1600, 600);
		listtxt.setFont(new Font("���� ���", Font.BOLD, 12));

		JButton[] bt = new JButton[6];
		JButton order_bt = new JButton("�ֹ����");

		// �޴��� ���̺� �����
		String[] heading = new String[] { "��ǰ��", "����" };
		Object[][] data = new Object[][] { { "��ǰ��", "����" }, { "(Hot)�Ƹ޸�ī��", "1500��" }, { "(Hot)īǪġ��", "2000��" },
				{ "(Ice)�Ƹ޸�ī��", "2000��" }, { "(Ice)ī���", "2500��" }, { "�����̵�", "3000��" }, { "�ڸ����̵�", "3000��" },
				{ "��������ũ(1����)", "3000��" }, { "��������ũ(1����)", "3500��" }

		};

		JTable table = new JTable(data, heading);
		pn.add(new JScrollPane(table));
		pn.add(table);
		table.setBounds(250, 300, 800, 600);
		table.setFont(new Font("���� ���", Font.BOLD, 30));
		table.setRowHeight(50);

		// ��ư�� ��ġ�� ũ�� ����
		int width[] = { 300, 300, 300, 300, 200, 200 };
		int height[] = { 150, 150, 150, 150, 100, 100 };
		int x[] = { 80, 480, 880, 1280, 30, 30 };
		int y[] = { 100, 100, 100, 100, 300, 500 };

		// �̹��� �г� ũ�⼳��
		pn.setLayout(null);
		pn.setBounds(0, 0, 1900, 1200);
		// �� �޴��� Vector ��ü�ӿ� �̸� �����س���
		CoffeeSystem.setupMenu();

		// ���� ��ư 6�� ����
		bt[0] = new JButton("HOT");
		bt[1] = new JButton("ICE");
		bt[2] = new JButton("ADE");
		bt[3] = new JButton("Dessert");
		bt[4] = new JButton("Main");
		bt[5] = new JButton("Order");

		for (int i = 0; i < bt.length; i++) {
			pn.add(bt[i]);
			bt[i].setBounds(x[i], y[i], width[i], height[i]);
			// ��Ʈ ����
			bt[i].setFont(new Font("Blackadder ITC", Font.BOLD, 60));
			// ��ư�� �����ϰ� �����, ��ư�۾� ���� ����
			bt[i].setContentAreaFilled(false);
			bt[i].setBorderPainted(false);
			bt[i].setFocusPainted(false);
			bt[i].setForeground(Color.WHITE);
		}

		// ��ư 0���� ��ɼ���
		bt[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn = (JButton) e.getSource();
				if (srcBtn == bt[0]) {
					doHot();

					// hotpn �� ũ�� �� ����
					Hotpn.setLayout(null);
					Hotpn.setBounds(250, 300, 1600, 600);
					Hotpn.setBackground(Color.gray);

					// hotpn ������, ������ �г��� ������ �ʰ��ϱ�
					Hotpn.setVisible(true);
					Icepn.setVisible(false);
					Adepn.setVisible(false);
					Dstpn.setVisible(false);
					Orderpn.setVisible(false);
					ordertxt.setVisible(true);

					table.setVisible(false);
					order_bt.setVisible(true);
				}
			}

			private void doHot() {
				// Hotpn�� ������ ������ ��ư���� ����
				JButton HotButton_�Ƹ޸�ī�� = new JButton("");
				fr.add(Hotpn);
				HotButton_�Ƹ޸�ī��.setIcon(new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\�Ƹ޸�ī��.JFIF"));
				Hotpn.add(HotButton_�Ƹ޸�ī��);
				HotButton_�Ƹ޸�ī��.setBounds(20, 20, 260, 195);
				// �޴��̸� ����� �ؽ�Ʈ �ʵ� ����
				JTextField hot_�Ƹ޸�ī�� = new JTextField("(HOT)�Ƹ޸�ī��  1500��");
				Hotpn.add(hot_�Ƹ޸�ī��);
				hot_�Ƹ޸�ī��.setBounds(20, 215, 260, 30);
				hot_�Ƹ޸�ī��.setEditable(false);

				// �Ƹ޸�ī�븦 ������ �˸�â�� �߰Բ� ��� ����
				HotButton_�Ƹ޸�ī��.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JButton srcBtn = (JButton) e.getSource();
						if (srcBtn == HotButton_�Ƹ޸�ī��) {
							int result = JOptionPane.showConfirmDialog(HotButton_�Ƹ޸�ī��, "�Ƹ޸�ī�븦 �ֹ��Ͻðٽ��ϱ�?", "�ֹ�Ȯ��",
									JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.OK_OPTION) {
								ordertxt.append((CoffeeSystem.hot_drink.get(0).toString()));
								CoffeeSystem.order.add(CoffeeSystem.hot_drink.get(0));
								CoffeeSystem.new_Price(1500);
							}
						}
					}
				});

				JButton HotButton_īǪġ�� = new JButton("");
				HotButton_īǪġ��.setIcon(new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\īǪġ��.JFIF"));
				Hotpn.add(HotButton_īǪġ��);
				HotButton_īǪġ��.setBounds(280, 20, 259, 194);
				// �޴��̸� ����� �ؽ�Ʈ �ʵ� ����
				JTextField īǪġ�� = new JTextField("(Hot)īǪġ��  2000��");
				Hotpn.add(īǪġ��);
				īǪġ��.setBounds(280, 215, 260, 30);
				īǪġ��.setEditable(false);
				// īǪġ�븦 ������ �˸�â�� �߰Բ� ����
				HotButton_īǪġ��.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton srcBtn = (JButton) e.getSource();
						if (srcBtn == HotButton_īǪġ��) {
							int result = JOptionPane.showConfirmDialog(HotButton_īǪġ��, "īǪġ�븦 �ֹ��Ͻðٽ��ϱ�?", "�ֹ�Ȯ��",
									JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.OK_OPTION) {
								ordertxt.append((CoffeeSystem.hot_drink.get(1).toString()));
								CoffeeSystem.order.add(CoffeeSystem.hot_drink.get(1));
								CoffeeSystem.new_Price(2500);

							}

						}
					}
				});
			}

		}

		);
		// bt[0] �� ���� ������.
		bt[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn = (JButton) e.getSource();
				if (srcBtn == bt[1]) {
					doICE();

					Icepn.setLayout(null);
					Icepn.setBounds(250, 300, 1600, 600);
					Icepn.setBackground(Color.gray);

					Hotpn.setVisible(false);
					Icepn.setVisible(true);
					Adepn.setVisible(false);
					Dstpn.setVisible(false);
					Orderpn.setVisible(false);
					ordertxt.setVisible(true);

					table.setVisible(false);
					order_bt.setVisible(true);
				}
			}

			private void doICE() {

				fr.add(Icepn);
				JButton IceButton_���̽��Ƹ޸�ī�� = new JButton("");
				IceButton_���̽��Ƹ޸�ī��.setIcon(new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\(ICE)�Ƹ޸�ī��.JFIF"));
				Icepn.add(IceButton_���̽��Ƹ޸�ī��);
				IceButton_���̽��Ƹ޸�ī��.setBounds(20, 20, 259, 194);
				// �޴��̸� ����� �ؽ�Ʈ �ʵ� ����
				JTextField Ice_�Ƹ޸�ī�� = new JTextField("(ICE)�Ƹ޸�ī��  2000��");
				Icepn.add(Ice_�Ƹ޸�ī��);
				Ice_�Ƹ޸�ī��.setBounds(20, 215, 260, 30);
				Ice_�Ƹ޸�ī��.setEditable(false);
				// ��ư ��� �߰�
				IceButton_���̽��Ƹ޸�ī��.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JButton srcBtn = (JButton) e.getSource();
						if (srcBtn == IceButton_���̽��Ƹ޸�ī��) {
							int result = JOptionPane.showConfirmDialog(IceButton_���̽��Ƹ޸�ī��, "���̽��Ƹ޸�ī�븦 �ֹ��Ͻðٽ��ϱ�?",
									"�ֹ�Ȯ��", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.OK_OPTION) {
								ordertxt.append((CoffeeSystem.ice_drink.get(0).toString()));
								CoffeeSystem.order.add(CoffeeSystem.ice_drink.get(0));
								CoffeeSystem.new_Price(2000);
							}

						}
					}
				});
				// �̹��� ũ�������ϱ�!
				ImageIcon icon_���̽�ī��� = new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\���̽�ī���.jpg");
				JButton IceButton_���̽�ī��� = new JButton(CoffeeSystem.resizeIcon(icon_���̽�ī���, 259, 194));
				Icepn.add(IceButton_���̽�ī���);
				IceButton_���̽�ī���.setBounds(280, 20, 259, 194);
				// �޴��̸� ����� �ؽ�Ʈ �ʵ� ����
				JTextField Ice_���̽�ī��� = new JTextField("(ICE)ī���  2500��");
				Icepn.add(Ice_���̽�ī���);
				Ice_���̽�ī���.setBounds(280, 215, 260, 30);
				Ice_���̽�ī���.setEditable(false);
				// ��ư ��� �߰�
				IceButton_���̽�ī���.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JButton srcBtn = (JButton) e.getSource();
						if (srcBtn == IceButton_���̽�ī���) {
							int result = JOptionPane.showConfirmDialog(IceButton_���̽�ī���, "���̽� ī��󶼸� �ֹ��Ͻðٽ��ϱ�?", "�ֹ�Ȯ��",
									JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.OK_OPTION) {
								ordertxt.append((CoffeeSystem.ice_drink.get(1).toString()));
								CoffeeSystem.order.add(CoffeeSystem.ice_drink.get(1));
								CoffeeSystem.new_Price(2500);
							}

						}
					}
				});
			}

		}

		);

		bt[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn = (JButton) e.getSource();
				if (srcBtn == bt[2]) {
					doAde();

					Adepn.setLayout(null);
					Adepn.setBounds(250, 300, 1600, 600);
					Adepn.setBackground(Color.gray);
					Hotpn.setVisible(false);
					Icepn.setVisible(false);
					Adepn.setVisible(true);
					Dstpn.setVisible(false);
					Orderpn.setVisible(false);
					ordertxt.setVisible(true);

					table.setVisible(false);
					order_bt.setVisible(true);
				}
			}

			private void doAde() {
				fr.add(Adepn);
				JButton AdeButton_�����̵� = new JButton(
						new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\�����̵�.JFIF"));
				Adepn.add(AdeButton_�����̵�);
				AdeButton_�����̵�.setBounds(20, 20, 259, 194);
				// �޴��̸� ����� �ؽ�Ʈ �ʵ� ����
				JTextField �����̵� = new JTextField("�����̵�  3000��");
				Adepn.add(�����̵�);
				�����̵�.setBounds(20, 215, 260, 30);
				�����̵�.setEditable(false);
				AdeButton_�����̵�.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JButton srcBtn = (JButton) e.getSource();
						if (srcBtn == AdeButton_�����̵�) {
							int result = JOptionPane.showConfirmDialog(AdeButton_�����̵�, "�����̵带 �ֹ��Ͻðٽ��ϱ�?", "�ֹ�Ȯ��",
									JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.OK_OPTION) {
								ordertxt.append((CoffeeSystem.ade_drink.get(0).toString()));
								CoffeeSystem.order.add(CoffeeSystem.ade_drink.get(0));
								CoffeeSystem.new_Price(3000);
							}
						}
					}
				});

				ImageIcon icon_�ڸ����̵� = new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\�ڸ����̵�.JPG");
				JButton AdeButton_�ڸ����̵� = new JButton(CoffeeSystem.resizeIcon(icon_�ڸ����̵�, 260, 195));

				Adepn.add(AdeButton_�ڸ����̵�);
				AdeButton_�ڸ����̵�.setBounds(280, 20, 259, 194);
				// �޴��̸� ����� �ؽ�Ʈ �ʵ� ����
				JTextField �ڸ����̵� = new JTextField("�ڸ����̵�  3000��");
				Adepn.add(�ڸ����̵�);
				�ڸ����̵�.setBounds(280, 215, 260, 30);
				�ڸ����̵�.setEditable(false);
				AdeButton_�ڸ����̵�.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JButton srcBtn = (JButton) e.getSource();
						if (srcBtn == AdeButton_�ڸ����̵�) {
							int result = JOptionPane.showConfirmDialog(AdeButton_�ڸ����̵�, "�ڸ����̵带 �ֹ��Ͻðٽ��ϱ�?", "�ֹ�Ȯ��",
									JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.OK_OPTION) {
								ordertxt.append((CoffeeSystem.ade_drink.get(1).toString()));
								CoffeeSystem.order.add(CoffeeSystem.ade_drink.get(1));
								CoffeeSystem.new_Price(3000);
							}
						}
					}
				});
			}
		});

		bt[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn = (JButton) e.getSource();
				if (srcBtn == bt[3]) {
					doDeasert();

					Dstpn.setLayout(null);
					Dstpn.setBounds(250, 300, 1600, 600);
					Dstpn.setBackground(Color.gray);

					Hotpn.setVisible(false);
					Icepn.setVisible(false);
					Adepn.setVisible(false);
					Dstpn.setVisible(true);
					Orderpn.setVisible(false);
					ordertxt.setVisible(true);

					table.setVisible(false);
					order_bt.setVisible(true);
				}
			}

			private void doDeasert() {
				fr.add(Dstpn);
				JButton DstButton_��������ũ = new JButton(
						new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\��������ũ.JFIF"));
				Dstpn.add(DstButton_��������ũ);
				DstButton_��������ũ.setBounds(20, 20, 259, 194);
				// �޴��̸� ����� �ؽ�Ʈ �ʵ� ����
				JTextField ��������ũ = new JTextField("��������ũ (1����) 3000��");
				Dstpn.add(��������ũ);
				��������ũ.setBounds(20, 215, 260, 30);
				��������ũ.setEditable(false);
				DstButton_��������ũ.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JButton srcBtn = (JButton) e.getSource();
						if (srcBtn == DstButton_��������ũ) {
							int result = JOptionPane.showConfirmDialog(DstButton_��������ũ, "��������ũ�� �ֹ��Ͻðٽ��ϱ�?", "�ֹ�Ȯ��",
									JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.OK_OPTION) {
								ordertxt.append((CoffeeSystem.deasert.get(0).toString()));
								CoffeeSystem.order.add(CoffeeSystem.deasert.get(0));
								CoffeeSystem.new_Price(3000);
							}

						}
					}
				});
				ImageIcon icon_��������ũ = new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\��������ũ.JFIF");
				JButton DstButton_��������ũ = new JButton(CoffeeSystem.resizeIcon(icon_��������ũ, 260, 195));
				Dstpn.add(DstButton_��������ũ);
				DstButton_��������ũ.setBounds(280, 20, 259, 194);
				// �޴��̸� ����� �ؽ�Ʈ �ʵ� ����
				JTextField ��������ũ = new JTextField("��������ũ (1����) 3500��");
				Dstpn.add(��������ũ);
				��������ũ.setBounds(280, 215, 260, 30);
				��������ũ.setEditable(false);
				DstButton_��������ũ.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JButton srcBtn = (JButton) e.getSource();
						if (srcBtn == DstButton_��������ũ) {
							int result = JOptionPane.showConfirmDialog(DstButton_��������ũ, "��������ũ�� �ֹ��Ͻðٽ��ϱ�?", "�ֹ�Ȯ��",
									JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.OK_OPTION) {
								ordertxt.append((CoffeeSystem.deasert.get(1).toString()));
								CoffeeSystem.order.add(CoffeeSystem.deasert.get(1));
								CoffeeSystem.new_Price(3500);
							}

						}
					}
				});

			}
		});
		// ����ȭ�� ��ư ���
		bt[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn = (JButton) e.getSource();
				if (srcBtn == bt[4]) {

					Hotpn.setVisible(false);
					Icepn.setVisible(false);
					Adepn.setVisible(false);
					Dstpn.setVisible(false);
					Orderpn.setVisible(false);
					ordertxt.setVisible(false);
					table.setVisible(true);
					order_bt.setVisible(false);
				}

			}

		});

		// �ֹ�����Ʈ ��ư ���
		bt[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn = (JButton) e.getSource();
				if (srcBtn == bt[5]) {
					fr.add(Orderpn);
					Hotpn.setVisible(false);
					Icepn.setVisible(false);
					Adepn.setVisible(false);
					Dstpn.setVisible(false);
					Orderpn.setVisible(true);
					ordertxt.setVisible(false);

					table.setVisible(false);
					order_bt.setVisible(false);

					Orderpn.add(listtxt);
					Orderpn.setBounds(250, 300, 1600, 600);
					Orderpn.setBackground(Color.white);

				}

			}

		});

		// �ֹ���� ��ư �߰� �� ����
		order_bt.setFont(new Font("����", Font.PLAIN, 25));
		order_bt.setBounds(1400, 950, 300, 150);
		pn.add(order_bt); // �ֹ���� ��ư ���� �� ���
		order_bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn = (JButton) e.getSource();
				if (srcBtn == order_bt) {
					int result = JOptionPane.showConfirmDialog(order_bt, "�ֹ��Ͻðڽ��ϱ�?", "�ֹ�Ȯ��",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {

						Custmoer_Order();
						// �ֹ���� ��ư�� ������ �ֹ�����,�� �ֹ���� �� ��� ����� �ٽ� �ֹ����� ����
						ordertxt.setText("");
						int sum = 0;
						listtxt.append(CoffeeSystem.total_Price(sum));
						ordertxt.append("<�ֹ��Ͻ� ��ǰ�� Ȯ���Ҽ� �ֽ��ϴ�.> \n\n");
						CoffeeSystem.order.removeAllElements();
						CoffeeSystem.price.removeAllElements();

					}
				}

			}

			// �ֹ�����Ʈ�� ������ ������ ����
			private void Custmoer_Order() {

				Menu m;
				listtxt.append("------------------------��� �ֹ� ����Ʈ-------------------------\n");

				// ��� �ֹ�����Ʈ�� �ҷ���
				for (int i = 0; i < CoffeeSystem.getNumOrders(); i++) {
					m = CoffeeSystem.getOrder(i);
					listtxt.append(i + 1 + ". ");
					listtxt.append(m.toString());

				}

				listtxt.append("\n--------------------------------------------------------------------\n");
			}

		});

		// ù ȭ�鿡�� �ֹ���� ������ �ʰ��ϱ�
		ordertxt.setVisible(false);
		order_bt.setVisible(false);

		// ������ ����
		fr.setLocation(300, 150);
		fr.setContentPane(pn);
		fr.setSize(1900, 1200);
		fr.setVisible(true);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
