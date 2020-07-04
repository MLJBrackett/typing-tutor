import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TypingTutor {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Typing Tutor - Michael Brackett");

        JPanel typingTutor = new JPanel();
        typingTutor.setLayout(new BorderLayout(0, 15));
        typingTutor.setBorder(new EmptyBorder(5, 15, 15, 0));

        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridLayout(2, 1));

        JLabel welcomeMessage1 = new JLabel("Type some text using your keyboard. The keys you press will be highlighted and the text will be displayed.");
        JLabel welcomeMessage2 = new JLabel("Note: Clicking the buttons with your mouse will not perform any action.");
        welcomePanel.add(welcomeMessage1);
        welcomePanel.add(welcomeMessage2);

        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new GridLayout(5, 1));

        java.util.HashMap<Integer, JButton> keyMap = new java.util.HashMap<Integer, JButton>();

        //INIT FIRST ROW
        JPanel firstRow = new JPanel();
        firstRow.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JButton[] firstRowKeys =
                {
                        new JButton("~"),
                        new JButton("1"),
                        new JButton("2"),
                        new JButton("3"),
                        new JButton("4"),
                        new JButton("5"),
                        new JButton("6"),
                        new JButton("7"),
                        new JButton("8"),
                        new JButton("9"),
                        new JButton("0"),
                        new JButton("-"),
                        new JButton("+"),
                        new JButton("Backspace")
                };
        for (JButton firstRowKey : firstRowKeys) {
            firstRowKey.setPreferredSize(new Dimension(50, 50));
        }
        firstRowKeys[13].setPreferredSize(new Dimension(100, 50));
        for (JButton firstRowKey : firstRowKeys) {
            firstRow.add(firstRowKey);
        }

        // INIT SECOND ROW
        JPanel secondRow = new JPanel();
        secondRow.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JButton[] secondRowKeys =
                {
                        new JButton("Tab"),
                        new JButton("Q"),
                        new JButton("W"),
                        new JButton("E"),
                        new JButton("R"),
                        new JButton("T"),
                        new JButton("Y"),
                        new JButton("U"),
                        new JButton("I"),
                        new JButton("O"),
                        new JButton("P"),
                        new JButton("["),
                        new JButton("]"),
                        new JButton("\\")
                };
        for (JButton secondRowKey : secondRowKeys) {
            secondRowKey.setPreferredSize(new Dimension(50, 50));
        }
        secondRowKeys[0].setPreferredSize(new Dimension(75, 50));
        for (JButton secondRowKey : secondRowKeys) {
            secondRow.add(secondRowKey);
        }

        //INIT THIRD ROW
        JPanel thirdRow = new JPanel();
        thirdRow.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JButton[] thirdRowKeys =
                {
                        new JButton("Caps"),
                        new JButton("A"),
                        new JButton("S"),
                        new JButton("D"),
                        new JButton("F"),
                        new JButton("G"),
                        new JButton("H"),
                        new JButton("J"),
                        new JButton("K"),
                        new JButton("L"),
                        new JButton(":"),
                        new JButton("\""),
                        new JButton("Enter")
                };
        for (JButton thirdRowKey : thirdRowKeys) {
            thirdRowKey.setPreferredSize(new Dimension(50, 50));
        }
        thirdRowKeys[0].setPreferredSize(new Dimension(75, 50));
        thirdRowKeys[12].setPreferredSize(new Dimension(100, 50));
        for (JButton thirdRowKey : thirdRowKeys) {
            thirdRow.add(thirdRowKey);
        }

        //INIT FOURTH ROW
        JPanel fourthRow = new JPanel();
        fourthRow.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JPanel fourthRow1 = new JPanel();
        fourthRow1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JPanel fourthRow2 = new JPanel();
        fourthRow2.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 0));
        JButton[] fourthRowKeys =
                {
                        new JButton("Shift"),
                        new JButton("Z"),
                        new JButton("X"),
                        new JButton("C"),
                        new JButton("V"),
                        new JButton("B"),
                        new JButton("N"),
                        new JButton("M"),
                        new JButton(","),
                        new JButton("."),
                        new JButton("?"),
                        new JButton("^")
                };
        for (JButton fourthRowKey : fourthRowKeys) {
            fourthRowKey.setPreferredSize(new Dimension(50, 50));
        }
        fourthRowKeys[0].setPreferredSize(new Dimension(100, 50));
        for (int i = 0; i < fourthRowKeys.length - 1; i++) {
            fourthRow1.add(fourthRowKeys[i]);
        }
        fourthRow2.add(fourthRowKeys[11]);
        fourthRow.add(fourthRow1);
        fourthRow.add(fourthRow2);

        //INIT FIFTH ROW
        JPanel fifthRow = new JPanel();
        fifthRow.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JPanel fifthRow1 = new JPanel();
        fifthRow1.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 0));
        JPanel fifthRow2 = new JPanel();
        fifthRow2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JButton[] fifthRowKeys =
                {
                        new JButton(""),
                        new JButton("<"),
                        new JButton("\u02c5"),
                        new JButton(">"),
                };
        for (JButton fifthRowKey : fifthRowKeys) {
            fifthRowKey.setPreferredSize(new Dimension(50, 50));
        }
        fifthRowKeys[0].setPreferredSize(new Dimension(310, 50));
        fifthRow1.add(fifthRowKeys[0]);
        for (int i = 1; i < fifthRowKeys.length; i++) {
            fifthRow2.add(fifthRowKeys[i]);
        }
        fifthRow1.setBorder(new EmptyBorder(0, 130, 0, 0));
        fifthRow2.setBorder(new EmptyBorder(0, 25, 0, 0));
        fifthRow.add(fifthRow1);
        fifthRow.add(fifthRow2);

        //INIT HASH MAP
        for (int i = 0; i < firstRowKeys.length; i++) {
            if (i == 0) keyMap.put(192, firstRowKeys[0]);
            else if (i == 12) keyMap.put(61, firstRowKeys[12]);
            else if (i == 13) keyMap.put(8, firstRowKeys[13]);
            else keyMap.put((int) firstRowKeys[i].getActionCommand().charAt(0), firstRowKeys[i]);
        }
        for (int i = 0; i < secondRowKeys.length; i++) {
            if (i == 0) keyMap.put(9, secondRowKeys[0]);
            else keyMap.put((int) secondRowKeys[i].getActionCommand().charAt(0), secondRowKeys[i]);
        }
        for (int i = 0; i < thirdRowKeys.length; i++) {
            if (i == 0) keyMap.put(20, thirdRowKeys[0]);
            else if (i == 10) keyMap.put(59, thirdRowKeys[10]);
            else if (i == 11) keyMap.put(222, thirdRowKeys[11]);
            else if (i == 12) keyMap.put(10, thirdRowKeys[12]);
            else keyMap.put((int) thirdRowKeys[i].getActionCommand().charAt(0), thirdRowKeys[i]);
        }
        for (int i = 0; i < fourthRowKeys.length; i++) {
            if (i == 0) keyMap.put(16, fourthRowKeys[0]);
            else if (i == 10) keyMap.put(47, fourthRowKeys[10]);
            else if (i == 11) keyMap.put(38, fourthRowKeys[11]);
            else keyMap.put((int) fourthRowKeys[i].getActionCommand().charAt(0), fourthRowKeys[i]);
        }
        keyMap.put(32, fifthRowKeys[0]);
        keyMap.put(37, fifthRowKeys[1]);
        keyMap.put(40, fifthRowKeys[2]);
        keyMap.put(39, fifthRowKeys[3]);

        Color defaultColor = firstRowKeys[0].getBackground();

        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(750, 200));

        textArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                try {
                    keyMap.get(e.getKeyCode()).setBackground(Color.YELLOW);
                    keyMap.get(e.getKeyCode()).setOpaque(true);
                } catch (NullPointerException error) {
                    System.out.println("Key pressed that is not mapped");
                    System.out.println("Key Code: " + e.getKeyCode());
                }
            }
            public void keyReleased(KeyEvent e) {
                try {
                    keyMap.get(e.getKeyCode()).setBackground(defaultColor);
                } catch (NullPointerException error) {
                    System.out.print("");
                }
            }
        });

        keyPanel.add(firstRow);
        keyPanel.add(secondRow);
        keyPanel.add(thirdRow);
        keyPanel.add(fourthRow);
        keyPanel.add(fifthRow);

        typingTutor.add(welcomePanel, BorderLayout.NORTH);
        typingTutor.add(textArea, BorderLayout.WEST);
        typingTutor.add(keyPanel, BorderLayout.SOUTH);

        frame.add(typingTutor);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(785, 500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
