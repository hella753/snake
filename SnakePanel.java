import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakePanel extends JPanel implements ActionListener, KeyListener {
   final int FRAME_H = 600;
   final int FRAME_W = 600;
   final int GRID_S = 30;
   final int UNITS = 12000;
   final int TIM_DEL = 65;
   final int[] SnakeXPos = new int[12000];
   final int[] SnakeYPos = new int[12000];
   int snakeLength = 4;
   int eaten = 0;
   int appleXPos;
   int appleYPos;
   char chars = 'R';
   boolean isRunning = false;
   Timer timer;
   Random random;
   public Color color3;
   public int getRRed;
   public int getBBlue;
   public int getGGreen;

   SnakePanel(Color color1, Color color2) {
      this.color3 = color2;
      this.random = new Random();
      this.timer = new Timer(65, this);
      this.setPreferredSize(new Dimension(600, 600));
      this.setBackground(color1);
      this.setFocusable(true);
      this.addKeyListener(this);
      this.getRRed = this.color3.getRed();
      this.getBBlue = this.color3.getBlue();
      this.getGGreen = this.color3.getGreen();
      System.out.println(this.getRRed);
      if (this.getRRed <= 19 && this.getBBlue <= 19 && this.getGGreen <= 19) {
         this.getBBlue += 20;
         this.getRRed += 20;
         this.getGGreen += 20;
      } else if (this.getRRed >= 236 && this.getBBlue >= 236 && this.getGGreen >= 236) {
         this.getBBlue -= 20;
         this.getRRed -= 20;
         this.getGGreen -= 20;
      } else {
         if (this.getRRed <= 19) {
            if (this.getGGreen < 236 && this.getBBlue < 236) {
               this.getBBlue += 20;
               this.getGGreen += 20;
            } else {
               this.getBBlue -= 20;
               this.getGGreen -= 20;
            }

            this.getRRed += 20;
         }

         if (this.getGGreen <= 19) {
            if (this.getRRed < 236 && this.getBBlue < 236) {
               this.getRRed += 20;
               this.getBBlue += 20;
            } else {
               this.getRRed -= 20;
               this.getBBlue -= 20;
            }

            this.getGGreen += 20;
         }

         if (this.getBBlue <= 19) {
            if (this.getRRed < 236 && this.getGGreen < 236) {
               this.getRRed += 20;
               this.getGGreen += 20;
            } else {
               this.getRRed -= 20;
               this.getGGreen -= 20;
            }

            this.getBBlue += 20;
         }

         if (this.getRRed <= 19) {
            if (this.getGGreen < 236 && this.getBBlue < 236) {
               this.getBBlue += 20;
               this.getGGreen += 20;
            } else {
               this.getBBlue -= 20;
               this.getGGreen -= 20;
            }

            this.getRRed += 20;
         }

         if (this.getGGreen <= 19) {
            if (this.getRRed < 236 && this.getBBlue < 236) {
               this.getRRed += 20;
               this.getBBlue += 20;
            } else {
               this.getRRed -= 20;
               this.getBBlue -= 20;
            }

            this.getGGreen += 20;
         }

         if (this.getBBlue >= 236) {
            if (this.getRRed > 19 && this.getGGreen > 19) {
               this.getRRed -= 20;
               this.getGGreen -= 20;
            } else {
               this.getRRed += 20;
               this.getGGreen += 20;
            }

            this.getBBlue -= 20;
         }

         if (this.getGGreen >= 236) {
            if (this.getRRed > 19 && this.getBBlue > 19) {
               this.getRRed -= 20;
               this.getBBlue -= 20;
            } else {
               this.getRRed += 20;
               this.getBBlue += 20;
            }

            this.getGGreen -= 20;
         }

         if (this.getRRed >= 236) {
            if (this.getBBlue > 19 && this.getGGreen > 19) {
               this.getBBlue -= 20;
               this.getGGreen -= 20;
            } else {
               this.getBBlue += 20;
               this.getGGreen += 20;
            }

            this.getRRed -= 20;
         }
      }

      this.createApple();
      this.isRunning = true;
      this.timer.start();
   }

   public void createApple() {
      this.appleXPos = this.random.nextInt(20) * 30;
      this.appleYPos = this.random.nextInt(20) * 30;
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      this.draw(g);
   }

   public void draw(Graphics g) {
      if (this.isRunning) {
         g.setColor(Color.RED);
         g.fillOval(this.appleXPos, this.appleYPos, 30, 30);

         for(int i = 0; i < this.snakeLength; ++i) {
            if (i == 0) {
               g.setColor(this.color3);
               g.fillRect(this.SnakeXPos[i], this.SnakeYPos[i], 30, 30);
            } else {
               System.out.println(this.getRRed + " " + this.getGGreen + " " + this.getBBlue);
               g.setColor(new Color(this.getRRed, this.getGGreen, this.getBBlue));
               g.fillRect(this.SnakeXPos[i], this.SnakeYPos[i], 30, 30);
            }
         }

         g.setColor(new Color(this.getRRed, this.getGGreen, this.getBBlue));
         g.setFont(new Font("Calibri", 1, 40));
         g.drawString("Score: " + this.eaten, 220, 40);
      } else {
         this.gameOver(g);
      }

   }

   public void gameOver(Graphics g) {
      g.setColor(new Color(this.getRRed, this.getGGreen, this.getBBlue));
      g.setFont(new Font("Calibri", 1, 75));
      g.drawString("Game Over", 120, 300);
      g.setColor(new Color(this.getRRed, this.getGGreen, this.getBBlue));
      g.setFont(new Font("Calibri", 1, 40));
      this.getFontMetrics(g.getFont());
      g.drawString("Score: " + this.eaten, 220, 40);
   }

   public void move() {
      for(int i = this.snakeLength; i > 0; --i) {
         this.SnakeXPos[i] = this.SnakeXPos[i - 1];
         this.SnakeYPos[i] = this.SnakeYPos[i - 1];
      }

      switch(this.chars) {
      case 'D':
         this.SnakeYPos[0] += 30;
         break;
      case 'L':
         this.SnakeXPos[0] -= 30;
         break;
      case 'R':
         this.SnakeXPos[0] += 30;
         break;
      case 'U':
         this.SnakeYPos[0] -= 30;
      }

   }

   public void eatApple() {
      if (this.SnakeXPos[0] == this.appleXPos && this.SnakeYPos[0] == this.appleYPos) {
         ++this.snakeLength;
         ++this.eaten;
         this.createApple();
      }

   }

   public void xdebaShejaxeba() {
      for(int i = this.snakeLength; i > 0; --i) {
         if (this.SnakeXPos[0] == this.SnakeXPos[i] && this.SnakeYPos[0] == this.SnakeYPos[i]) {
            this.isRunning = false;
         }

         if (this.SnakeXPos[0] < 0) {
            this.isRunning = false;
         }

         if (this.SnakeXPos[0] > 600) {
            this.isRunning = false;
         }

         if (this.SnakeYPos[0] < 0) {
            this.isRunning = false;
         }

         if (this.SnakeYPos[0] > 600) {
            this.isRunning = false;
         }

         if (!this.isRunning) {
            this.timer.stop();
         }
      }

   }

   public void actionPerformed(ActionEvent e) {
      if (this.isRunning) {
         this.move();
         this.eatApple();
         this.xdebaShejaxeba();
      }

      this.repaint();
   }

   public void keyTyped(KeyEvent e) {
      switch(e.getKeyChar()) {
      case 'a':
         if (this.chars != 'R') {
            this.chars = 'L';
         }
         break;
      case 'd':
         if (this.chars != 'L') {
            this.chars = 'R';
         }
         break;
      case 's':
         if (this.chars != 'U') {
            this.chars = 'D';
         }
         break;
      case 'w':
         if (this.chars != 'D') {
            this.chars = 'U';
         }
      }

   }

   public void keyPressed(KeyEvent e) {
      switch(e.getKeyCode()) {
      case 37:
         if (this.chars != 'R') {
            this.chars = 'L';
         }
         break;
      case 38:
         if (this.chars != 'D') {
            this.chars = 'U';
         }
         break;
      case 39:
         if (this.chars != 'L') {
            this.chars = 'R';
         }
         break;
      case 40:
         if (this.chars != 'U') {
            this.chars = 'D';
         }
      }

   }

   public void keyReleased(KeyEvent e) {
   }
}
