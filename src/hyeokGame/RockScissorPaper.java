package hyeokGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import hyeokGame.*;

public class RockScissorPaper extends JFrame{
	private JButton submitButton;							//�޴��гο��� ������ ��ư�� �Ӽ��� �����гη� ����
	private int[] receiveButtonFromMenu = new int[2];		//�޴��гο��� Ŭ���� ��ư���� �Ӽ��� (0�� : ù��°, 1�� : �ι�°)
	private MenuPanel menuPanel;
	private GamePanel gamePanel;
	public static int leftScore = 0, rightScore = 0;
	public RockScissorPaper() {
		super("���������� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		menuPanel = new MenuPanel();
		gamePanel = new GamePanel();
		submitButton = new JButton("���� ����!");
		
		container.add(menuPanel, BorderLayout.NORTH);
		container.add(gamePanel, BorderLayout.CENTER);
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				receiveButtonFromMenu = menuPanel.getSelectedButton();
				if(receiveButtonFromMenu[0] != 0 && receiveButtonFromMenu[1] != 0) {	//�Ѵ� ���õǾ��� ���
					/*
					 * �����̳��� �г��� ����� �ٽ� �׷��� �� ���
					 * remove()�� �����̳ʿ� ������Ʈ ���� ������ ����
					 * validate()�� ��ȿ�� �˻� �� repaint()�� �ٽ� �г��� �׸�
					 * render()�Լ� ������ ���� �����丵 ���ɼ� ����
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
					//�ϳ��� ���� �ȵǾ������� �˸��˾�â ���
					JOptionPane.showMessageDialog(null, "�ΰ��� ��ư�� �����ϼ���", "Message", JOptionPane.WARNING_MESSAGE, null);
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