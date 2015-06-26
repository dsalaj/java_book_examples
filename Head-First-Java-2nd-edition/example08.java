import java.lang.Math;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class example08 {

  public static void main(String[] args) {

    final JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    final MyDrawPanel panel = new MyDrawPanel();

    final JButton button_color = new JButton("set color");
    button_color.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) { 
      button_color.setText("you clicked me!");
      panel.setObjectColor();
      frame.repaint();
      }
    });

    final JButton button_position = new JButton("set position");
    button_position.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) { 
      panel.setObjectPosition();
      frame.repaint();
      }
    });

    frame.getContentPane().add(BorderLayout.SOUTH, button_color);
    frame.getContentPane().add(BorderLayout.EAST, button_position);
    frame.getContentPane().add(BorderLayout.CENTER, panel);
    frame.setSize(300,300);
    frame.setVisible(true);
  }

}

class MyDrawPanel extends JPanel {

  private int red = 255;
  private int green = 255;
  private int blue = 255;
  private int x = 50;
  private int y = 50;

  public void setObjectColor() {
    red = (int)(Math.random() * 255);
    green = (int)(Math.random() * 255);
    blue = (int)(Math.random() * 255);
  }

  public void setObjectPosition() {

    x = (int)(Math.random() * this.getWidth());
    y = (int)(Math.random() * this.getHeight());
  }

  public void paintComponent(Graphics g) {

    g.fillRect(0, 0, this.getWidth(), this.getHeight());

    Color randomColor = new Color(red, green, blue);
    g.setColor(randomColor);
    g.fillOval(x, y, 100, 100);
  }
}
