import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by peterjmyers on 4/21/17.
 */
public class TheFileFinder implements FileFinder {

    String currentDirectory = "/Users/peterjmyers/Dropbox/My_Files/Focus Area/YourMemoryPalace/resources/";
    int currentFileNum = 1; // values 1 to 10 only

    // don't go back up if in the resource folder
    // use model to find out if the file exists

    @Override
    public String getNextFile() { // will act strangely if 1.png doesn't exist initially
        int newFileNumber = (currentFileNum==10) ? 1 : currentFileNum+1;
        return searchForFileInDirectory(newFileNumber);
    }

    @Override
    public String getPrevFile() {
        int newFileNumber = (currentFileNum==1) ? 10 : currentFileNum-1;
        return searchForFileInDirectory(newFileNumber);
    }

    @Override
    public String getZoomInFile() {
//getparent, isdirectory
        String newDirectoryPath = currentDirectory + currentFileNum + "/";
        String newFilePath = newDirectoryPath + "1.png";
        File file = new File(newFilePath);
        if (file.exists()) { // only works if 1.png is in the new directory
            this.currentDirectory = newDirectoryPath;
            currentFileNum = 1;
        }
        return newFilePath;
    }

    @Override
    public String getZoomOutFile() {
        Pattern p = Pattern.compile("(.*)/([^/]+)/$");
        Matcher m = p.matcher(currentDirectory);
        String newDirectoryPath = m.group(1);
        String parent = m.group(2);
        String newFilePath = currentDirectory + currentFileNum + ".png"; // fallback path
        if (parent!="resources") { // can't go to the root folder
            try {
                currentFileNum = Integer.parseInt(parent); // if parse succeeds we do two assigns
                currentDirectory = newDirectoryPath + "/";
                newFilePath = currentDirectory + parent + ".png";
            } catch (NumberFormatException e) {
                // Do nothing because it corrects itself
            }
        }
        return newFilePath;
    }

    public String searchForFileInDirectory(int newFileNumber) {
        String newFilePath = currentDirectory + newFileNumber + ".png";
        File file = new File(newFilePath);

        if (file.exists()) {
            this.currentFileNum = newFileNumber;
        } else {
            newFilePath = currentDirectory + currentFileNum + ".png";
        }
        return newFilePath;
    }
}
