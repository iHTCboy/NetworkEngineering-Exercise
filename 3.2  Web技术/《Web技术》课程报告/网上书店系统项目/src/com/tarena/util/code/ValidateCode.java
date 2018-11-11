package com.tarena.util.code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.tarena.web.action.BaseAction;

public class ValidateCode extends BaseAction{

	// ͼƬ��
	private static int WIDTH = 100;

	// ͼƬ��
	private static int HEIGHT = 30;

	// ��֤������
	private static int NUM = 4;

	// ����������
	private static int line = 4;

	private static char[] seq = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9' };

	/**
	 * �����������֤��
	 * 
	 * @return
	 * @throws Exception
	 */
	private byte[] generator(Map<String, Object> session) throws Exception {
		Random r = new Random();

		// ͼƬ���ڴ�ӳ��
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);

		// ��û��ʶ���
		Graphics g = image.getGraphics();
		g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(new Color(0, 0, 0));
		g.drawRect(0, 0, WIDTH-1, HEIGHT-1);

		// ���ڴ洢������ɵ���֤��
		StringBuffer number = new StringBuffer();

		// ������֤��
		for (int i = 0; i < NUM; i++) {
			g.setColor(randomColor(r));
			int h = (int) ((HEIGHT * 70 / 100) * r.nextDouble() + (HEIGHT * 40 / 100));
			g.setFont(new Font(null, Font.BOLD, h));
			String ch = String.valueOf(seq[r.nextInt(seq.length)]);
			number.append(ch);
			g.drawString(ch, i * WIDTH / NUM * 90 / 100, h);
		}
		session.put("validate_code_session", number.toString());
		// ���Ƹ�����
		for (int i = 0; i <= line; i++) {
			g.setColor(randomColor(r));
			g.drawLine(r.nextInt(WIDTH), r.nextInt(HEIGHT), r.nextInt(WIDTH), r
					.nextInt(HEIGHT));

		}

		// ѹ����jpeg��ʽ
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);

		// ��BufferedImage�����е�ͼ����Ϣ�����
		// �򴴽��ö���(encoder)ʱָ������������
		encoder.encode(image);
		session.put("imageCode", number.toString());
		return os.toByteArray();
	}

	private Color randomColor(Random r) {
		return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));

	}

	// ��ȡ��֤��
	public InputStream getCode(Map<String, Object> session) throws Exception {
		return new ByteArrayInputStream(generator(session));
	}

}
