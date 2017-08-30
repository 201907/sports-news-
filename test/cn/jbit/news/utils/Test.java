package cn.jbit.news.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test {
	public void show(){
		System.out.println("test");
	}
	public static void main(String[] args) {
		BufferedImage bufferedImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();
		graphics.fillRect(50, 50, 50, 50);
		
		graphics.setColor(Color.white);
		graphics.drawString("2333", 21, 20);
		try {
			ImageIO.write(bufferedImage, "jpg", new FileOutputStream("C:/Documents and Settings/User1/桌面/temp/temp.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Test2 extends Test{
	public void test2(){
		System.out.println("test2");
	}
}