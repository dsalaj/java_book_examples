import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardBuilder {

  private JTextArea question;
  private JTextArea answer;
  private ArrayList<QuizCard> cardList;
  private JFrame frame;

  public static void main(String[] args) {

    QuizCardBuilder builder = new QuizCardBuilder();
    builder.go();
  }

  public void go() {

    frame = new JFrame("Quiz Card Builder");
    JPanel mainPanel = new JPanel();
    //
    question = new JTextArea(6,20);
    question.setLineWrap(true);
    question.setWrapStyleWord(true);
    //

    JScrollPane qScroller = new JScrollPane(question);
    //
    
    answer = new JTextArea(6,20);
    answer.setLineWrap(true);
    answer.setWrapStyleWord(true);
    //

    JScrollPane aScroller = new JScrollPane(answer);
    //
    
    JButton nextButton = new JButton("Next Card");
    cardList = new ArrayList<QuizCard>();
    JLabel qLabel = new JLabel("Question:");
    JLabel aLabel = new JLabel("Answer:");

    mainPanel.add(qLabel);
    mainPanel.add(aLabel);
    mainPanel.add(qScroller);
    mainPanel.add(aScroller);
    mainPanel.add(nextButton);
    nextButton.addActionListener(new NextCardListener());

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem newMenuItem = new JMenuItem("New");
    JMenuItem saveMenuItem = new JMenuItem("Save");

    newMenuItem.addActionListener(new NewMenuListener());
    saveMenuItem.addActionListener(new SaveMenuListener());
    fileMenu.add(newMenuItem);
    fileMenu.add(saveMenuItem);
    menuBar.add(fileMenu);

    frame.setJMenuBar(menuBar);
    frame.add(mainPanel, BorderLayout.CENTER);
    frame.setSize(500,600);
    frame.setVisible(true);
  }

  private class NextCardListener implements ActionListener {

    public void actionPerformed(ActionEvent ev) {
      QuizCard card = new QuizCard(question.getText(), answer.getText());
      cardList.add(card);
      clearCard();
    }
  }

  private class SaveMenuListener implements ActionListener {

    public void actionPerformed(ActionEvent ev) {
      QuizCard card = new QuizCard(question.getText(), answer.getText());
      cardList.add(card);

      JFileChooser fileSave = new JFileChooser();
      fileSave.showSaveDialog(frame);
      saveFile(fileSave.getSelectedFile());
    }
  }

  private class NewMenuListener implements ActionListener {

    public void actionPerformed(ActionEvent ev) {
      cardList.clear();
      clearCard();
    }
  }

  private void clearCard() {
    question.setText("");
    answer.setText("");
    question.requestFocus();
  }

  private void saveFile(File file) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));

      for(QuizCard card:cardList) {
        writer.write(card.getQuestion() + "/");
        writer.write(card.getAnswer() + "\n");
      }
      writer.close();
    } catch(IOException ex) {
      ex.printStackTrace();
    }
  }
}
