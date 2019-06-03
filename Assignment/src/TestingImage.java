import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;

public class TestingImage {
	final static int B = 256;
	BufferedImage image;
	BufferedImage maskImage ;
	ImageWriter writer;
	int width;
	int height;
	int totalSkin,totalNonskin;
	PrintStream out ;
	static double [] data = new double[B * B * B+5];
	void readPixel(String name ) {
		try {
			File input = new File(name);
			image = ImageIO.read(input);
			int width = image.getWidth(), height = image.getHeight();
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					Color c = new Color(image.getRGB(j, i));
					int id = c.getRed() * B * B + c.getGreen()*B + c.getBlue();
					if(data[id] < 0.4) {
						image.setRGB(j, i, new Color(0, 0, 0).getRGB());
					}
					/*else {
						image.setRGB(j, i, new Color(255, 255, 255).getRGB());
					}*/
				}
			}
			
		} catch (Exception e) {}
		try {
			ImageIO.write(image, "jpg", new File("C:/Users/bsse0/Desktop/01.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			File file = new File("C:/Users/bsse0/Desktop/traingSet.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file)); 
			String s;
			int len = 0;
			while((s = reader.readLine()) != null) {
				data[len++] = Double.parseDouble(s);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		new TestingImage().readPixel("C:/Users/bsse0/Desktop/test.jpg");
	}
}
