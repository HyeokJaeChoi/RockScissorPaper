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
	private int[] selectedButton = new int[2];						//선택한 버튼의 속성값 저장
	public MenuPanel() {
		setBackground(Color.decode("#96ff00"));
		setLayout(new FlowLayout());
		for(int i = 0; i < gameButton.length; i++) {
			gameButton[i] = new JButton(ImageLoader.getGameIcon(i));	//이미지로더 클래스로 이미지 호출 및 버튼생성
			gameButton[i].setName(Integer.toString(i));					//바위, 가위, 보 각각 0,1,2 값 부여
			add(gameButton[i]);
		}
		for(int i = 0; i < gameButton.length; i++){
			gameButton[i].addActionListener(new ActionListener() {
				private String[] setButtonOption = {"왼쪽", "오른쪽"};
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton tmpButton = (JButton)e.getSource();			//버튼 클릭시 얻어지는 컴포넌트 오브젝트 정보를 JButton으로 형변환
					// TODO Auto-generated method stub
					// 알림창 생성 후 왼쪽 클릭시 selectedButton[0], 오른쪽 클릭시 selectedButton[1]에 버튼속성값 저장
					int result = JOptionPane.showOptionDialog(null, "원하는 버튼 배치를 선택하세요", "버튼 배치", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, setButtonOption, null);
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
