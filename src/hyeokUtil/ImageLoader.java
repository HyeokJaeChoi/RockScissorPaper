package hyeokUtil;

import javax.swing.ImageIcon;

public class ImageLoader {
	/*
	 * ImageLoader 클래스로 이미지 호출 클래스 별도 분리
	 * getClassLoader() 클래스로더 호출
	 * getResource() ImageLoader 클래스가 실행되는 위치인 bin폴더 경로 획득 및 하위 image 폴더 접근
	 * replaceAll() 위의 함수로 호출할 경우 접두어로 file:/ 문자열이 포함되어있기에 이를 제거
	 */
	private static String path = ImageLoader
			.class
			.getClassLoader()
			.getResource("image/")
			.toString()
			.replaceAll("file:/", "");
	// image 폴더 경로에 각각의 파일 이름 추가
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
