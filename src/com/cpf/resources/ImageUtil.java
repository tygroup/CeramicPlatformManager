package com.cpf.resources;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ImageIcon;


public class ImageUtil {
	/**
	 * 降低图片像素（大小）并保持原图尺寸
	 * 
	 * @param originalFile
	 * @param resizedFile
	 * @return
	 * @throws IOException
	 */
	public static File resize(File originalFile, File resizedFile)
			throws IOException {
		float quality = 0.5f;
		ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
		Image i = ii.getImage();
		Image resizedImage = null;

		int iWidth = i.getWidth(null);
		int iHeight = i.getHeight(null);
		resizedImage = i.getScaledInstance(iWidth, iHeight, Image.SCALE_SMOOTH);
		// This code ensures that all the pixels in the image are loaded.
		Image temp = new ImageIcon(resizedImage).getImage();

		// Create the buffered image.
		BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
				temp.getHeight(null), BufferedImage.TYPE_INT_RGB);

		// Copy image to buffered image.
		Graphics g = bufferedImage.createGraphics();

		// Clear background and paint the image.
		g.setColor(Color.white);
		g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
		g.drawImage(temp, 0, 0, null);
		g.dispose();

		// Soften.
		float softenFactor = 0.05f;
		float[] softenArray = { 0, softenFactor, 0, softenFactor,
				1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };
		Kernel kernel = new Kernel(3, 3, softenArray);
		ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		bufferedImage = cOp.filter(bufferedImage, null);

		// Write the jpeg to a file.
		FileOutputStream out = new FileOutputStream(resizedFile);

		// Encodes image as a JPEG data stream
		//JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

		//JPEGEncodeParam param = encoder
		//		.getDefaultJPEGEncodeParam(bufferedImage);

		/*param.setQuality(quality, true);

		encoder.setJPEGEncodeParam(param);
		encoder.encode(bufferedImage);*/
		out.close();
		return resizedFile;
	} // Example usage

	public static void main(String[] args) throws IOException {
//		 File originalImage = new File("C:\\11.jpg");
//		 resize(originalImage, new File("c:\\11-0.jpg"),150, 0.7f);
//		 resize(originalImage, new File("c:\\11-1.jpg"),150, 1f);
		 File originalImage = new File("E:\\1.jpg");
		 resize(originalImage, new File("e:\\new.jpg"));
		
	}
}
