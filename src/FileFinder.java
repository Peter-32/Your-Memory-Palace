import java.io.File;

/**
 * Created by peterjmyers on 4/22/17.
 */
public interface FileFinder {
    public File getCurrentFile();
    public File getNextFile();
    public File getPrevFile();
    public File getZoomInFile();
    public File getZoomOutFile();
}
