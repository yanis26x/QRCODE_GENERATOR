package yanis26x;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.FileOutputStream;

public class RUN_THIS {

    public static boolean createQRcode(QRcode qrcode){
        BitMatrix bitMatrix = null;
        Writer writer = new QRCodeWriter();

        try {
            bitMatrix = writer.encode(qrcode.getUrl(), BarcodeFormat.QR_CODE, qrcode.getHeight(), qrcode.getWidth());
            MatrixToImageWriter.writeToStream(bitMatrix, qrcode.getFormat(),
                    new FileOutputStream(new File(qrcode.getPath())));
            System.out.println("QRcode generated !!");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new File(qrcode.getPath()).exists();
    }

    public static void main(String[] args) throws Exception {
        QRcode qrcode = new QRcode();
        qrcode.setFormat("png");
        qrcode.setHeight(300);
        qrcode.setWidth(300);
        qrcode.setPath("./data/QR_CODE.PNG");

        // HERE, REPLACE THE URL WITH WHATEVER YOU WANT!
        qrcode.setUrl("https://github.com/yanis26x");

        System.out.println(createQRcode(qrcode));
    }

}
