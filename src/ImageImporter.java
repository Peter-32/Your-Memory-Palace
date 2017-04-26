import java.io.File;
import java.io.IOException;
//import java.nio.file.*;
//import java.nio.file.attribute.BasicFileAttributes;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by peterjmyers on 4/21/17.
 */
public class ImageImporter {
    public static void main(String[] args) {
        int numFile = 0;
        File directory = new File("/Users/peterjmyers/Dropbox/Screenshots/");
        File[] files = directory.listFiles();
        List<File> fileList = new ArrayList<File>();
        for (File file : files) {
            fileList.add(file);
        }
        Collections.sort(fileList);
        for (File file : fileList) {
            file.renameTo(new File("/Users/peterjmyers/Dropbox/Screenshots/"+numFile+".jpg"));
            numFile++;
            System.out.println(file.toString());
        }
    }

    ImageImporter() {

    }
}
