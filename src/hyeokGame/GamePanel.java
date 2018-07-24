package hyeokGame;

import javax.swing.JPanel;
import hyeokUtil.ImageLoader;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel{
	private JButton leftButton;
	private JButton rightButton;
	private JLabel leftPlayer, rightPlayer;
	private JLabel gameStateLabel;
	public GamePanel() {
		setBackground(Color.decode("#c5e8ed"));
		setLayout(null);
	}
	
	public GamePanel(int[] selectedButton) {
		//게임 패널의 요소들 (Button, Label) 초기화
		this();
		leftButton = new JButton(ImageLoader.getGameIcon(selectedButton[0] - 1));
		rightButton = new JButton(ImageLoader.getGameIcon(selectedButton[1] - 1));
		gameStateLabel = new JLabel();
		leftPlayer = new JLabel("Player1" + " :  " + RockScissorPaper.leftScore);
		rightPlayer = new JLabel("Player2" + " :  " +  RockScissorPaper.rightScore);
		
		//Button 위치, 크기 지정 후 숫자 속성값을 rock, scissor, paper 등의 문자열 속성으로 변경
		leftButton.setBounds(110, 120, 80, 80);
		rightButton.setBounds(300, 120, 80, 80);
		add(leftButton);
		add(rightButton);
		this.setButtonProperty(selectedButton[0], selectedButton[1]);
		
		//Label 추가 후 게임 결과 갱신
		leftPlayer.setBounds(110, 80, 70, 30);
		rightPlayer.setBounds(300, 80, 70, 30);
		gameStateLabel.setBounds(205, 60, 90, 30);
		add(leftPlayer);
		add(rightPlayer);
		add(gameStateLabel);
		this.executeGame(leftButton.getName(), rightButton.getName());
		
	}
	
	//기존 버튼의 숫자 속성값을 버튼 이미지아이콘에 맞는 문자열 속성값으로 변경
	public void setButtonProperty(int leftButtonProperty, int rightButtonProperty) {
		switch(leftButtonProperty) {
		case 1 : 
			leftButton.setName("rock");
			break;
		case 2 : 
			leftButton.setName("scissor");
			break;
		case 3 : 
			leftButton.setName("paper");
			break;
		}
		switch(rightButtonProperty) {
		case 1 : 
			rightButton.setName("rock");
			break;
		case 2 : 
			rightButton.setName("scissor");
			break;
		case 3 : 
			rightButton.setName("paper");
			break;
		}
	}
	
	//버튼의 문자열 속성값에 따라 가위바위보 실행, 상황 별 Label 갱신
	public void executeGame(String leftButtonProperty, String rightButtonProperty) {
		if(leftButtonProperty.equals(rightButtonProperty)) {
			gameStateLabel.setText("Draw");
		}
		else if(leftButtonProperty.equals("rock") && rightButtonProperty.equals("scissor")) {
			gameStateLabel.setText("Player1 Win!");
			leftPlayer.setText("Player1" + " : " + ++RockScissorPaper.leftScore);
		}
		else if(leftButtonProperty.equals("rock") && rightButtonProperty.equals("paper")) {
			gameStateLabel.setText("Player2 Win!");
			rightPlayer.setText("Player2" + " : " + ++RockScissorPaper.rightScore);
		}
		else if(leftButtonProperty.equals("scissor") && rightButtonProperty.equals("paper")) {
			gameStateLabel.setText("Player1 Win!");
			leftPlayer.setText("Player1" + " : " + ++RockScissorPaper.leftScore);
		}
		else if(leftButtonProperty.equals("scissor") && rightButtonProperty.equals("rock")) {
			gameStateLabel.setText("Player2 Win!");
			rightPlayer.setText("Player2" + " : " + ++RockScissorPaper.rightScore);
		}
		else if(leftButtonProperty.equals("paper") && rightButtonProperty.equals("rock")) {
			gameStateLabel.setText("Player1 Win!");
			leftPlayer.setText("Player1" + " : " + ++RockScissorPaper.leftScore);
		}
		else if(leftButtonProperty.equals("paper") && rightButtonProperty.equals("scissor")) {
			gameStateLabel.setText("Player2 Win!");
			rightPlayer.setText("Player2" + " : " + ++RockScissorPaper.rightScore);
		}
	}
}
