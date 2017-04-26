import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by peterjmyers on 4/24/17.
 */
public class MainPanel extends JPanel {

    private int width, height;

    JLabel label1 = new JLabel("");
    JLabel label2 = new JLabel("");

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
        // text
        String textFilePath = file.getAbsolutePath().replace(".jpg",".txt");
        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get(textFilePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //JTextArea textArea = new JTextArea(7, 95);
        //textArea.append(text);
        //textArea.setEditable(false);
        //JScrollPane scrollPane = new JScrollPane(textArea);
        //this.add(scrollPane);
        label1.setText(text);
        this.add(label1);

        /*
        String text = null;
        try {
            String textFilePath = file.getAbsolutePath().replace(".jpg",".txt");
            Files.lines(Paths.get(textFilePath), StandardCharsets.UTF_8).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

         */

        // location number
        String locationNumber = file.getName().replace(".jpg","");
        System.out.println(locationNumber);
        label2.setText("Location Number: " + locationNumber);
        this.add(label2);

        // paint
        repaint();



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
    }


}

