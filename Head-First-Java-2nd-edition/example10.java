import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class example10 {

  public static void main(String[] args) {

    example10 gui = new example10();
    gui.start();
  }

  public void start() {

    JFrame frame = new JFrame();
    JPanel p1 = new JPanel();
    p1.setBackground(Color.gray);
    JPanel p2 = new JPanel();
    p2.setBackground(Color.darkGray);
    p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));
    JPanel p3 = new JPanel();
  
    final JTextArea text = new JTextArea();
    JScrollPane scroller = new JScrollPane(text);
    p2.add(scroller);

    JButton save_button = new JButton("Save");
    save_button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) { 
        try {
          FileWriter w = new FileWriter("output.txt");
          w.write(text.getText());
          w.close();
        } catch(Exception ex) {
          ex.printStackTrace();
        }
      }
    });

    JButton clear_button = new JButton("Clear");
    clear_button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) { 
        text.setText("");
        text.requestFocus();
      }
    });

    final JCheckBox wrap_box = new JCheckBox("Wrap");
    wrap_box.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) { 
        if(wrap_box.isSelected()) { text.setLineWrap(true); }
        else { text.setLineWrap(false); }
        text.requestFocus();
      }
    });

    //TODO: make fonts change on valueChanged of list
    String[] fonts = {"asd","fefe","4f4f4"};
    final JList fonts_list = new JList<String>(fonts);
    fonts_list.setVisibleRowCount(1);
    fonts_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    fonts_list.addListSelectionListener( new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) { 
        text.setText(fonts_list.getSelectedValue().toString());
        text.requestFocus();
      }
    });
    JScrollPane font_list = new JScrollPane(fonts_list);
    font_list.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    p1.add(save_button);
    p1.add(clear_button);
    p1.add(wrap_box);
    p1.add(font_list);
    p1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

    frame.add(p1, BorderLayout.NORTH);
    frame.add(p2, BorderLayout.CENTER);
    frame.add(p3, BorderLayout.WEST);

    frame.pack();
    frame.setVisible(true);
    text.requestFocus();
  }
}
