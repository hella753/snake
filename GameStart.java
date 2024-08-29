import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GameStart extends JFrame implements ActionListener, MouseListener {
   JButton startTheGame;
   JLabel labelTitle = new JLabel("Submit your name and press 'Start' to Play");
   JPanel panelTitle = new JPanel();
   JPanel panelFooter = new JPanel();
   JLabel labelFooter = new JLabel("Kristine Gaphrindashvili");
   JButton submitNameButton;
   JTextField textField;
   String playersName;
   JColorChooser chooseYourTheme;
   Color snakeColor;
   Color color;
   JButton colorChooserButton;
   JButton snakeColorChooserButton;

   GameStart() {
      this.snakeColor = Color.WHITE;
      this.color = new Color(248, 200, 220);
      this.panelTitle.setOpaque(true);
      this.panelTitle.setBackground(Color.white);
      this.panelFooter.setOpaque(true);
      this.panelFooter.setBackground(Color.white);
      this.labelFooter.setBounds(0, 535, 20, 20);
      this.panelFooter.setBounds(0, 535, 600, 30);
      this.panelTitle.setBounds(0, 0, 600, 30);
      this.labelTitle.setBounds(0, 0, 20, 20);
      this.startTheGame = new JButton();
      this.startTheGame.setBounds(220, 330, 150, 50);
      this.startTheGame.addActionListener(this);
      this.startTheGame.setText("Start");
      this.startTheGame.setFocusable(false);
      this.startTheGame.setFont(new Font("Comic Sans", 1, 20));
      this.startTheGame.setForeground(Color.PINK);
      this.startTheGame.setBackground(Color.WHITE);
      this.startTheGame.setBorder((Border)null);
      this.startTheGame.setEnabled(false);
      this.textField = new JTextField();
      this.textField.setBounds(130, 80, 200, 40);
      this.textField.setForeground(Color.gray);
      this.textField.setBackground(Color.WHITE);
      this.textField.setBorder((Border)null);
      this.textField.setText("Enter your name");
      this.textField.setFont(new Font("Comic Sans", 1, 20));
      this.textField.addMouseListener(this);
      this.submitNameButton = new JButton();
      this.submitNameButton.setText("Submit");
      this.submitNameButton.setBounds(340, 80, 100, 40);
      this.submitNameButton.setFocusable(false);
      this.submitNameButton.setForeground(Color.WHITE);
      this.submitNameButton.setBackground(Color.magenta);
      this.submitNameButton.setBorder((Border)null);
      this.submitNameButton.addActionListener(this::actionPerformed2);
      this.colorChooserButton = new JButton();
      this.colorChooserButton.setText("Change the Background");
      this.colorChooserButton.setBounds(120, 200, 150, 40);
      this.colorChooserButton.setFocusable(false);
      this.colorChooserButton.setBackground(new Color(250, 230, 240));
      this.colorChooserButton.setBorder((Border)null);
      this.colorChooserButton.addActionListener(this::actionPerformed3);
      this.snakeColorChooserButton = new JButton();
      this.snakeColorChooserButton.setText("Change the Snake");
      this.snakeColorChooserButton.setBounds(300, 200, 150, 40);
      this.snakeColorChooserButton.setFocusable(false);
      this.snakeColorChooserButton.setBackground(new Color(250, 230, 240));
      this.snakeColorChooserButton.setBorder((Border)null);
      this.snakeColorChooserButton.addActionListener(this::actionPerformed3);
      ImageIcon image = new ImageIcon("snake.png");
      this.setIconImage(image.getImage());
      this.setVisible(true);
      this.setDefaultCloseOperation(3);
      this.setSize(600, 600);
      this.setLocationRelativeTo((Component)null);
      this.setResizable(false);
      this.getContentPane().setBackground(this.color);
      this.setTitle("Snake Game");
      this.setLayout((LayoutManager)null);
      this.panelTitle.add(this.labelTitle);
      this.panelFooter.add(this.labelFooter);
      this.add(this.panelFooter);
      this.add(this.panelTitle);
      this.add(this.textField);
      this.add(this.submitNameButton);
      this.add(this.startTheGame);
      this.add(this.colorChooserButton);
      this.add(this.snakeColorChooserButton);
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == this.startTheGame) {
         new SnakeFrame(this.color, this.snakeColor);
         this.dispose();
      }

   }

   public void actionPerformed2(ActionEvent e) {
      if (e.getSource() == this.submitNameButton && !this.textField.getText().isEmpty() && !this.textField.getText().equals("Enter your name")) {
         this.playersName = this.textField.getText();
         System.out.println(this.playersName);
         this.textField.setText("");
         this.submitNameButton.setEnabled(false);
         this.startTheGame.setEnabled(true);
         this.textField.setEnabled(false);
      }

   }

   public void actionPerformed3(ActionEvent e) {
      if (e.getSource() == this.colorChooserButton) {
         new JColorChooser();
         this.color = JColorChooser.showDialog((Component)null, "Pick but DON'T CHOOSE RED(YOU WILL NOT SEE THE APPLES)", Color.black);
         this.getContentPane().setBackground(this.color);
      } else if (e.getSource() == this.snakeColorChooserButton) {
         new JColorChooser();
         this.snakeColor = JColorChooser.showDialog((Component)null, "Pick the Snake Color", Color.BLACK);
         System.out.println(this.snakeColor);
      }

   }

   public void mouseClicked(MouseEvent e) {
   }

   public void mousePressed(MouseEvent e) {
      if (e.getSource() == this.textField) {
         this.textField.setText("");
         this.textField.setForeground(Color.MAGENTA);
      }

   }

   public void mouseReleased(MouseEvent e) {
   }

   public void mouseEntered(MouseEvent e) {
   }

   public void mouseExited(MouseEvent e) {
   }
}
