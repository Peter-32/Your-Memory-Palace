import java.io.File;
import java.io.IOException;

/**
 * Created by peterjmyers on 4/25/17.
 */
public class TextImporter {
    public static void main(String[] args) {
        for (int i = 0; i < 291; i++) {
            File file = new File("/Users/peterjmyers/Dropbox/Screenshots/"+i+".txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
