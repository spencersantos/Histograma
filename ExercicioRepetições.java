import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Principal {

	public static void main(String[] args) {

		int[] vet = new int[256];
		BufferedImage buf = null;
		Raster raster = null;
		int aux;
		int valor;
		int[] pixel = new int[1];

		try {
			buf = ImageIO.read(new File("lena.png"));
			raster = buf.getRaster();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		for (int i = 0; i < buf.getWidth(); i++) {
			for (int j = 0; j < buf.getHeight(); j++) {

				valor = raster.getPixel(i, j, pixel)[0];
				vet[valor] = vet[valor] + 1;
			}
		}
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 255; b++) {
				if (vet[b] > vet[b + 1]) {
					aux = vet[b];
					vet[b] = vet[b + 1];
					vet[b + 1] = aux;

				}
			}
		}
		for (int i = 0; i < 256; i++) {
			if (vet[i] != 0) {
				System.out.println("valor = " + i + "  repetições: " + vet[i]);
			}
		}
	}

}