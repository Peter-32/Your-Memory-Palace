import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by peterjmyers on 4/21/17.
 */
public class TheFileFinder implements FileFinder {

    private String currentDirectory = "/Users/peterjmyers/IdeaProjects/YourMemoryPalace/resources/";
    private int currentFileNum = 1; // values 1 to 10 only


    public File getCurrentFile() {
        return new File(currentDirectory + currentFileNum + ".png");
    }
    // don't go back up if in the resource folder
    // use model to find out if the file exists

    @Override
    public File getNextFile() { // will act strangely if 1.png doesn't exist initially
        int newFileNumber = (currentFileNum==10) ? 1 : currentFileNum+1;
        return searchForFileInDirectory(newFileNumber);
    }

    @Override
    public File getPrevFile() {
        int newFileNumber = (currentFileNum==1) ? 10 : currentFileNum-1;
        System.out.println("Get prev");
        return searchForFileInDirectory(newFileNumber);
    }

    @Override
    public File getZoomInFile() {
        String newDirectoryPath = currentDirectory + currentFileNum + "/";
        File newFile = new File(newDirectoryPath + "1.png");
        if (newFile.exists()) { // only works if 1.png is in the new directory
            this.currentDirectory = newDirectoryPath;
            currentFileNum = 1;
        }
        return newFile;
    }

    @Override
    public File getZoomOutFile() {
        Pattern p = Pattern.compile("^(.*)/([^/]+)/$");
        Matcher m = p.matcher(currentDirectory);
        //System.out.println(m.toString());
        String newDirectoryPath = m.group(1);
        String parent = m.group(2);
        File newFile = new File(currentDirectory + currentFileNum + ".png"); // fallback path
        if (parent!="resources") { // can't go to the root folder
            try {
                currentFileNum = Integer.parseInt(parent); // if parse succeeds we do two assigns
                currentDirectory = newDirectoryPath + "/";
                newFile = new File(currentDirectory + parent + ".png");
            } catch (NumberFormatException e) {
                // Do nothing because it corrects itself
            }
        }
        return newFile;
    }

    public File searchForFileInDirectory(int newFileNumber) {
        String newFilePath = currentDirectory + newFileNumber + ".png";
        File file = new File(newFilePath);

        if (file.exists()) {
            this.currentFileNum = newFileNumber;
        } else {
            newFilePath = currentDirectory + currentFileNum + ".png";
        }
        return new File(newFilePath);
    }
}
