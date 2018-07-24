package hyeokUtil;

import javax.swing.ImageIcon;

public class ImageLoader {
	/*
	 * ImageLoader Ŭ������ �̹��� ȣ�� Ŭ���� ���� �и�
	 * getClassLoader() Ŭ�����δ� ȣ��
	 * getResource() ImageLoader Ŭ������ ����Ǵ� ��ġ�� bin���� ��� ȹ�� �� ���� image ���� ����
	 * replaceAll() ���� �Լ��� ȣ���� ��� ���ξ�� file:/ ���ڿ��� ���ԵǾ��ֱ⿡ �̸� ����
	 */
	private static String path = ImageLoader
			.class
			.getClassLoader()
			.getResource("image/")
			.toString()
			.replaceAll("file:/", "");
	// image ���� ��ο� ������ ���� �̸� �߰�
	private static final String ROCK_IMAGE_PATH = path + "rock.png";
	private static final String SCISSOR_IMAGE_PATH = path + "scissor.png";
	private static final String PAPER_IMAGE_PATH = path + "paper.png";
	private static final int ROCK = 0, SCISSOR = 1, PAPER = 2;
	
	public static ImageIcon getGameIcon(int icon) {
		ImageIcon gameIcon = null;
		switch(icon) {
		case ROCK : 
			gameIcon = new ImageIcon(ROCK_IMAGE_PATH);
			break;
		case SCISSOR : 
			gameIcon = new ImageIcon(SCISSOR_IMAGE_PATH);
			break;
		case PAPER : 
			gameIcon = new ImageIcon(PAPER_IMAGE_PATH);
			break;
		}
		return gameIcon;
	}
}
