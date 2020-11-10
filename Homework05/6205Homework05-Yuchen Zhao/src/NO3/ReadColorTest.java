package NO3;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ReadColorTest {
	
	public double[] getImagePixel(String image) throws Exception {
		int[] rgb = new int[3];
		File file = new File(image);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();
		double[] I = new double[width * height];
		System.out.println("width: " + width + "\nheight: " + height + "\npixel number: " + width * height + "\n");
		int count = 0;
		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {
				int pixel = bi.getRGB(i, j);
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				I[count++] = 0.2989 * rgb[0] + 0.5870 * rgb[1] + 0.1140 * rgb[2];
			}
		}
		return I;
	}
}
