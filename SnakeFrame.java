import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SnakeFrame extends JFrame {
   SnakeFrame(Color color1, Color color2) {
      this.add(new SnakePanel(color1, color2));
      ImageIcon image = new ImageIcon("snake.png");
      this.setIconImage(image.getImage());
      this.setDefaultCloseOperation(3);
      this.setResizable(false);
      this.pack();
      this.setVisible(true);
      this.setLocationRelativeTo((Component)null);
      this.getContentPane().setBackground(color1);
      this.setTitle("Snake Game");
      this.setVisible(true);
   }
}
