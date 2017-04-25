import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by peterjmyers on 4/24/17.
 */
public class MainPanel extends JPanel {

    private int width, height;

    private BufferedImage image;

    public MainPanel(File initialImgFile) {
        setNewRoomLocation(initialImgFile);
    }

    public void setNewRoomLocation(File file) {
        try {
            image = ImageIO.read(file);
        } catch (IOException ex) {
            // handle exception...
        }
        JTextArea textArea = new JTextArea(7, 95);
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(scrollPane);
        repaint();
        System.out.println("repainting");
        System.out.println(file.getAbsoluteFile());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
    }


}

