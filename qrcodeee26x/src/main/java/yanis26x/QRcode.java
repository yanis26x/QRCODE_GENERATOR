package yanis26x;

import lombok.Data;

@Data
public class QRcode {
    private String id;
    private String format;
    private String url;
    private String path;
    private int height;
    private int width;
}
