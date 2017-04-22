import javax.naming.ldap.Control;

/**
 * Created by peterjmyers on 4/21/17.
 */
public class TheController implements Controller {

    private static TheController instance = null;
    private FileFinder fileFinder;

    private TheController() {

    }

    public static TheController getInstance() {
        if (instance == null) {
            instance = new TheController();
        }
        return instance;
    }

    @Override
    public void setFileFinder(FileFinder fileFinder) {
        this.fileFinder = fileFinder;
    }

    @Override
    public void pressedRight() { // next
        String str = fileFinder.getNextFile();
    }

    @Override
    public void pressedLeft() { // previous
        String str = fileFinder.getPrevFile();
    }

    @Override
    public void pressedUp() { // back
        String str = fileFinder.getZoomOutFile();
    }

    @Override
    public void pressedDown() { // drill in
        String str = fileFinder.getZoomInFile();
    }

    private void template() {
        // ask the file finder if zoom in/out possible (optional)
        // pass next file string to the Frame
        // if can't zoom out do nothing


    }
}
