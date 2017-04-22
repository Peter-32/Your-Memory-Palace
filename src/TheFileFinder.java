import java.io.File;

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
        int fileNumber = (currentFileNum==10) ? 1 : currentFileNum+1;
        return searchForFileInDirectory(fileNumber);
    }

    @Override
    public String getPrevFile() {
        int fileNumber = (currentFileNum==1) ? 10 : currentFileNum-1;
        return searchForFileInDirectory(fileNumber);
    }

    @Override
    public String getZoomInFile() {
        return "";
    }

    @Override
    public String getZoomOutFile() {
        return "";
    }

    public String searchForFileInDirectory(int fileNumber) {
        String filePath = currentDirectory + fileNumber + ".png";
        File file = new File(filePath);

        if (file.exists()) {
            this.currentFileNum = fileNumber;
        } else {
            filePath = currentDirectory + currentFileNum + ".png";
        }
        return filePath;
    }
}
