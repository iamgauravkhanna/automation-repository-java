package javaExamples.barCodeReader;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class QRCodeReader {

	private static String decodeQRCode() throws IOException {
		//BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
		URL url = new URL("https://cdn.barcodesinc.com/themes/barcodesinc/images/upc.gif");
		BufferedImage bufferedImage = ImageIO.read(url);
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

		try {
			Result result = new MultiFormatReader().decode(bitmap);
			return result.getText();
		} catch (NotFoundException e) {
			System.out.println("There is no QR code in the image");
			return null;
		}
	}

	public static void main(String[] args) {
		try {
			//File file = new File("MyQRCode.png");
			String decodedText = decodeQRCode();
			if (decodedText == null) {
				System.out.println("No QR Code found in the image");
			} else {
				System.out.println("Decoded text = " + decodedText);
			}
		} catch (IOException e) {
			System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
		}
	}
}