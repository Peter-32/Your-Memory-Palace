import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

/**
 * Created by peterjmyers on 4/21/17.
 */
public class TheController implements Controller {

    private FileFinder fileFinder;
    private Frame frame;
    private static MainPanel mainPanel;

    private TheController(Frame frame, FileFinder fileFinder) {
        this.frame = frame;
        this.fileFinder = fileFinder;
        KeyListener lForKey = new ListenForKey();
        frame.addKeyListener(lForKey);
    }

    public static TheController getInstance(Frame frame, FileFinder fileFinder) {
        mainPanel = new MainPanel(fileFinder.getCurrentFile());
        frame.add(mainPanel); // adds the panel and gives an initial image
        return new TheController(frame, fileFinder);
    }

    class ListenForKey implements KeyListener {

        ListenForKey() {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == 65 || e.getKeyCode() == 37) { // left
                mainPanel.setNewRoomLocation(fileFinder.getPrevFile());
            } else if (e.getKeyCode() == 68 || e.getKeyCode() == 39) { // right
                mainPanel.setNewRoomLocation(fileFinder.getNextFile());
            } else if (e.getKeyCode() == 87 || e.getKeyCode() == 38) { // up
                mainPanel.setNewRoomLocation(fileFinder.getZoomOutFile());
            } else if (e.getKeyCode() == 83 || e.getKeyCode() == 40) { // down
                mainPanel.setNewRoomLocation(fileFinder.getZoomInFile());
            } else if (e.getKeyCode() == 46) {
                mainPanel.setNewRoomLocation(fileFinder.getPrevRoomFile());
            } else if (e.getKeyCode() == 44) {
                mainPanel.setNewRoomLocation(fileFinder.getNextRoomFile());
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }
}
