package hyeokGame;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.event.*;
import hyeokGame.GamePanel;
import hyeokUtil.ImageLoader;

public class MenuPanel extends JPanel{
	private JButton[] gameButton = new JButton[3];
	private int[] selectedButton = new int[2];						//������ ��ư�� �Ӽ��� ����
	public MenuPanel() {
		setBackground(Color.decode("#96ff00"));
		setLayout(new FlowLayout());
		for(int i = 0; i < gameButton.length; i++) {
			gameButton[i] = new JButton(ImageLoader.getGameIcon(i));	//�̹����δ� Ŭ������ �̹��� ȣ�� �� ��ư����
			gameButton[i].setName(Integer.toString(i));					//����, ����, �� ���� 0,1,2 �� �ο�
			add(gameButton[i]);
		}
		for(int i = 0; i < gameButton.length; i++){
			gameButton[i].addActionListener(new ActionListener() {
				private String[] setButtonOption = {"����", "������"};
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton tmpButton = (JButton)e.getSource();			//��ư Ŭ���� ������� ������Ʈ ������Ʈ ������ JButton���� ����ȯ
					// TODO Auto-generated method stub
					// �˸�â ���� �� ���� Ŭ���� selectedButton[0], ������ Ŭ���� selectedButton[1]�� ��ư�Ӽ��� ����
					int result = JOptionPane.showOptionDialog(null, "���ϴ� ��ư ��ġ�� �����ϼ���", "��ư ��ġ", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, setButtonOption, null);
					if(result == 0) {
						selectedButton[0] = Integer.parseInt(tmpButton.getName()) + 1;
					}
					else {
						selectedButton[1] = Integer.parseInt(tmpButton.getName()) + 1;
					}
				}
			});
		}
	}
	
	public int[] getSelectedButton() {
		return selectedButton;
	}
}
