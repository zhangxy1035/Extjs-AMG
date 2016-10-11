package com.ow.action.login;

import java.awt.Color;  
import java.awt.Font;  
import java.awt.Graphics;  
import java.awt.image.BufferedImage;  
import java.util.Map;  
  
import javax.servlet.http.HttpServletResponse;  
  
import org.apache.struts2.interceptor.ServletResponseAware;  
import org.apache.struts2.interceptor.SessionAware;  
  
import com.opensymphony.xwork2.ActionSupport;  
import com.sun.image.codec.jpeg.JPEGCodec;  
import com.sun.image.codec.jpeg.JPEGImageEncoder;  
  
public class LoginAction extends ActionSupport implements SessionAware,ServletResponseAware  
{  
    private Map<String, Object> session;  
    private HttpServletResponse response;  
    private static final long serialVersionUID = 1L;  
    private String chknumber;  
    @Override  
    public String execute() throws Exception  
    {  
        response.setHeader("Cache-Control", "no-cache");  
        int width=50; //ͼƬ���  
        int height=20; //ͼƬ�߶�  
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);  
        Graphics graphics=image.createGraphics();  
        graphics.setColor(this.getColor());   //������ɫ  
        graphics.fillRect(0, 0, width, height);  
        graphics.setFont(new Font("Arial",Font.BOLD,18));  
        graphics.setColor(this.getColor());   //�ֵ���ɫ  
        String number=String.valueOf(System.currentTimeMillis()%90000+1000);   //����5λ�����  
        session.put("randomCode", number);     //д��session��  
        graphics.drawString(number, (int)(width*0.1), (int)(height*0.8));  
        graphics.dispose();  
        JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(response.getOutputStream());  
        encoder.encode(image);  
        response.getOutputStream().flush();    //ˢ�µ�ҳ������ͼƬ  
        response.getOutputStream().close();    //�ر�writer  
        return null;  
    }  
    private Color getColor(){  
        int red=(int)(Math.random()*1000%256);  
        int green=(int)(Math.random()*1000%256);  
        int blue=(int)(Math.random()*1000%256);  
        return new Color(red,green,blue);  
     }  
    public String getChknumber()  
    {  
        return chknumber;  
    }  
    public void setChknumber(String chknumber)  
    {  
        this.chknumber = chknumber;  
    }
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}  
	
	public String Login()  
    {  
        if(session.get("randomCode").equals(chknumber))  
        {  
            return SUCCESS;  
        }  
        else  
        {  
            return ERROR;  
        }  
    }  
	
	
    
      
}  
