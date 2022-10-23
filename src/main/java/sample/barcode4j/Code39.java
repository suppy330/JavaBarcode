package sample.barcode4j;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

public class Code39 {
  public static void main( String[] args ) {
    // 生成するバーコードの情報を宣言
    Code39Bean barcodeBean = new Code39Bean();
    String message = "1234567890123";
    int dpi = 400;

    // バーコードを生成してファイルに出力する
    try {
      File file = new File("Path\\barcode.png");
      FileOutputStream outputStream = new FileOutputStream(file);
      BitmapCanvasProvider canvas =
        new BitmapCanvasProvider(outputStream, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

      barcodeBean.generateBarcode(canvas, message);
      canvas.finish();
      outputStream.close();
    }
    catch(IOException exception) {
      exception.printStackTrace();
    }
  }
}