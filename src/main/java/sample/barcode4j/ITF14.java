package sample.barcode4j;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.krysalis.barcode4j.impl.int2of5.ITF14Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

public class ITF14 {
  public static void main( String[] args ) {
    // 生成するバーコードの情報を宣言
    ITF14Bean barcodeBean = new ITF14Bean();
    String message = "1234567890123";
    int dpi = 40;

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