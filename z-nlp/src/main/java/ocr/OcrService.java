package ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class OcrService {

    public static void main(String[] args) {

            //实现图片的二值化


            Tesseract tesseract = new Tesseract();
            try {

                tesseract.setDatapath("C:/Users/z/Desktop/");
                tesseract.setLanguage("chi_sim");
                tesseract.setOcrEngineMode(1);
                // the path of your tess date folder
                // inside the extracted file
                String text = tesseract.doOCR(new File("C:/Users/z/Desktop/c1.png"));

                //text处理
                text = text.replace("=", "-");

                // path of your image file
                System.out.print(text.trim());
            }
            catch (TesseractException e) {
                e.printStackTrace();
            }
    }
}
