package code;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class DoMain {
    static class Student {
        public int id;
        public String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        PDDocument document = PDDocument.load(DoMain.class.getClassLoader().getResourceAsStream("1.pdf"));
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        for (int i = 0; i < document.getNumberOfPages(); ++i) {
            BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(i, 100);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            //ImageIO.write(bufferedImage,"png",new File("D://1.png"));
            ImageIO.write(bufferedImage,"png",out);
            byte[] bytes = out.toByteArray();
            System.out.println(new BASE64Encoder().encode(bytes));
        }
    }
}
