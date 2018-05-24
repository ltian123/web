package day05;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class CodeServlet extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if("/show.code".equals(path)){
			show(request, response);
		}
		if("/check.code".equals(path)){
			checkCode(request, response);
		}
	}
	
	
	protected void checkCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String codeInput = request.getParameter("code");
		String code = (String) request.getSession().getAttribute("code");
		if("admin".equals(name) && "123".equals(password) && code.equals(codeInput)){
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
		}
	}
	
	protected void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Random random = new Random();
		
		//在内存中创建画板
		BufferedImage image = new BufferedImage(60, 25, BufferedImage.TYPE_INT_RGB);
		
		//创建画笔
		Graphics graphics = image.getGraphics();
		
		//填充背景
		graphics.fillRect(0, 0, 60, 25);
		
		
		//设置画笔颜色
		//颜色
		//new Random().nextInt(2)
		graphics.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
		
		//设置字体
		graphics.setFont(new Font("宋体", Font.BOLD+Font.ITALIC, 18));
		
		
		//生成一个随机数
		String str = "0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuffer code = new StringBuffer();
		for(int i = 0; i < 4; i++){
			code.append(str.charAt(new Random().nextInt(str.length())));
		}
		
		//将生成的字符串写入到图片上
		graphics.drawString(code.toString(), 10, 20);
		
		//将生成的随机数放入到session中,方便后期校验
		request.getSession().setAttribute("code", code.toString());
		System.out.println("当前验证码:"+code.toString());
		
		OutputStream out = response.getOutputStream();
		
		//将图片压缩成JPEG格式写入到out中
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		
		encoder.encode(image);
		
		
	}
	
	
	public static void main(String[] args) {
//		System.out.println(new Random().nextInt(2));
//		char c = (char) (Math.random() * ('z'-'a'+1) +'a');
//		System.out.println(c);
//		System.out.println((int)(Math.random()*5+3));
//		char c = (char) ((Math.random())*('B'-'A'+1) +'A');
//		System.out.println(c);
		String str = "0123456789abcdefghijklmnopqrstuvwxyz张三李四王五";
		StringBuffer code = new StringBuffer();
		for(int i = 0; i < 4; i++){
			code.append(str.charAt(new Random().nextInt(str.length())));
		}
		System.out.println(code.toString());
	}
	
	
	
	
}
