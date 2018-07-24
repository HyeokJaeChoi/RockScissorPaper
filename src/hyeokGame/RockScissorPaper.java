package hyeokGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import hyeokGame.*;

public class RockScissorPaper extends JFrame{
	private JButton submitButton;							//메뉴패널에서 선택한 버튼의 속성을 게임패널로 전송
	private int[] receiveButtonFromMenu = new int[2];		//메뉴패널에서 클릭한 버튼들의 속성값 (0번 : 첫번째, 1번 : 두번째)
	private MenuPanel menuPanel;
	private GamePanel gamePanel;
	public static int leftScore = 0, rightScore = 0;
	public RockScissorPaper() {
		super("가위바위보 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		menuPanel = new MenuPanel();
		gamePanel = new GamePanel();
		submitButton = new JButton("게임 시작!");
		
		container.add(menuPanel, BorderLayout.NORTH);
		container.add(gamePanel, BorderLayout.CENTER);
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				receiveButtonFromMenu = menuPanel.getSelectedButton();
				if(receiveButtonFromMenu[0] != 0 && receiveButtonFromMenu[1] != 0) {	//둘다 선택되었을 경우
					/*
					 * 컨테이너의 패널을 지우고 다시 그려야 될 경우
					 * remove()로 컨테이너와 컴포넌트 간의 연결을 끊고
					 * validate()로 유효성 검사 후 repaint()로 다시 패널을 그림
					 * render()함수 등으로 추후 리팩토링 가능성 있음
					 */
					container.remove(gamePanel);
					container.validate();
					container.repaint();
					gamePanel = new GamePanel(receiveButtonFromMenu);
					container.add(gamePanel);
					container.validate();
					container.repaint();
				}
				else {
					//하나라도 선택 안되어있으면 알림팝업창 출력
					JOptionPane.showMessageDialog(null, "두개의 버튼을 선택하세요", "Message", JOptionPane.WARNING_MESSAGE, null);
				}
			}
		});
		menuPanel.add(submitButton);
		setSize(500, 500);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RockScissorPaper();
	}
}