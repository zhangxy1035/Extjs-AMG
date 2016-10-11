package com.ow.action.login;
/**
 * ���������������δʹ��
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class GetCodeController {
	
	@RequestMapping("/getCode")
	public void execute(
		HttpServletResponse response,
		HttpSession session) throws Exception{
		//0.�����հ�ͼƬ
		BufferedImage image = new BufferedImage(100,30,BufferedImage.TYPE_INT_RGB);
		//1.��ȡͼƬ����
		Graphics g = image.getGraphics();
		Random r = new Random();
		//2.���û�����ɫ
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		//3.���ƾ��εı���
		g.fillRect(0, 0, 100, 30);	
		//4.�����Զ���ķ�������ȡ����Ϊ5����ĸ������ϵ��ַ���
		String number = getNumber(5);	
		//��ͼƬ�ַ�����session,������֤����ʹ��
		session.setAttribute("scode", number);
		g.setColor(new Color(0,0,0));
		g.setFont(new Font(null,Font.BOLD,24));
		//5.������ɫ����󣬻����ַ���
		g.drawString(number, 5, 25);
		//6.����8��������
		for(int i=0;i<8;i++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
		}
		response.setContentType("image/jpeg");
		OutputStream ops = response.getOutputStream();
		ImageIO.write(image, "jpeg", ops);
		ops.close();
	}
	
	private String getNumber(int size){
		String str = "qwertyuioplkjhgfdsazxcvbnmABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String number = "";
		Random r = new Random();
		for(int i=0;i<size;i++){
			number+=str.charAt(r.nextInt(str.length()));
		}
		return number;
	}
}
