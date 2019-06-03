import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

class Pixel {
	final int B = 256;
	BufferedImage image;
	BufferedImage maskImage ;
	int width;
	int height;
	int totalSkin,totalNonskin;
	PrintStream out ;
	String filePath;
	double [] skin = new double[B * B * B+5];
	double [] nonSkin = new double[B * B * B+5];
	void readPixel(String name , String mask) {
		try {
			File input = new File(name);
			File maskFile = new File(mask);

			image = ImageIO.read(input);
			maskImage = ImageIO.read(maskFile);
			width = image.getWidth();
			height = image.getHeight();

			for(int i=0; i<height; i++){

				for(int j=0; j<width; j++){

					Color c = new Color(image.getRGB(j, i));
					Color maskColor  = new Color(maskImage.getRGB(j, i));
					if(maskColor.getRed() >= 245 && maskColor.getGreen() >= 245 && maskColor.getBlue() >= 245) {
						totalNonskin++;
						int id = maskColor.getRed() * B * B + maskColor.getGreen()*B + maskColor.getBlue();
						nonSkin[id]++;
					}
					else {
						totalSkin++;
						int id = c.getRed() * B * B + c.getGreen()*B + c.getBlue();
						skin[id]++;
					}
				}
			}

		} catch (Exception e) {}
	}
	
	void readData() throws IOException{
		long s = System.currentTimeMillis();
		out = new PrintStream(new File("C:\\Users\\bsse0\\Desktop\\traingSet.txt"));
		
		Files.walk(Paths.get("F:\\ibtd\\")).forEach(filePath -> {
			if (Files.isRegularFile(filePath)) {
				String[] tokens = filePath.toString().split("\\");
				tokens = tokens[1].split(".jpg");
				String maskPath = "F:\\ibtd\\Mask\\" + tokens[0] + ".bmp";


				readPixel(filePath.toString() , maskPath);
			}
		
		});
		System.out.println(System.currentTimeMillis()-s);
		for (int i = 0; i < 256	; i++) {
			for (int j = 0; j < 256; j++) {
				for (int l = 0; l < 256; l++) {
					int id = i * B * B +j*B + l;
					if(nonSkin[id] == 0){
						double val = ((double)skin[id]/(double)totalSkin)/(1D / (double)totalNonskin);
						out.printf("%.20f\n",val);
					}
					else {
						double val = ((double)skin[id]/(double)totalSkin)/((double)nonSkin[id] / (double)totalNonskin);
						out.printf("%.20f\n",val);
					}
				}
			}
		}
		
		System.out.println(System.currentTimeMillis()-s);

	}
	static public void main(String args[]) throws Exception 
	{
		
		new Pixel().readData();
		
	}
}
