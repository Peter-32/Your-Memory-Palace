import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by peterjmyers on 4/21/17.
 */
public class Frame extends JFrame {
    public static void main(String[] args) {
        Frame frame = new Frame();
    }

    Controller controller;
    FileFinder fileFinder;


    Frame() {
        this.setSize(1200,800);

        Toolkit tk = Toolkit.getDefaultToolkit();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("Memory Palace");

        //ListenForButton lForButton = new ListenForButton();

        // long way of centering the frame

        Dimension dim = tk.getScreenSize();

        int xPos = ((dim.width) - this.getWidth()) / 2;

        int yPos = ((dim.height) - this.getHeight()) / 2;

        this.setLocation(xPos, yPos);

        this.setResizable(false);


        //

        controller = TheController.getInstance();
        fileFinder = new TheFileFinder();
        controller.setFileFinder(fileFinder);
        controller.pressedRight();


        MainPanel mainPanel = new MainPanel(new File("/Users/peterjmyers/Dropbox/My_Files/Focus Area/YourMemoryPalace/resources/1.png"));

        this.add(mainPanel);

        this.setVisible(true);

    }


    class MainPanel extends JPanel {

        private int width, height;

        private BufferedImage image;

        public MainPanel(File filename) {
            try {
                image = ImageIO.read(filename);
            } catch (IOException ex) {
                // handle exception...
            }
            JTextArea textArea = new JTextArea(7, 95);
            JScrollPane scrollPane = new JScrollPane(textArea);
            this.add(scrollPane);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
        }


    }

    class ListenForKey implements KeyListener {

        ListenForKey() {

        }

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyCode() == 65 || e.getKeyCode() == 37) { // right
                controller.pressedRight();
            } else if (e.getKeyCode() == 68 || e.getKeyCode() == 39) { // left
                controller.pressedLeft();
            } else if (e.getKeyCode() == 87 || e.getKeyCode() == 38) { // up
                controller.pressedUp();
            } else if (e.getKeyCode() == 83 || e.getKeyCode() == 40) { // down
                controller.pressedDown();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }

}
