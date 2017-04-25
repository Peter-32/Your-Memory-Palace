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
        TheController.getInstance(frame, new TheFileFinder());

    }

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

        this.setVisible(true);

    }
}
