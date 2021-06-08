import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Crossword extends JFrame implements ActionListener {

    int[] p1Cols = {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 4, 4, 4, 5, 5, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 9};
    int[] p1Rows = {6, 6, 1, 2, 3, 4, 5, 6, 7, 8, 6, 1, 5, 6, 7, 1, 6, 1, 6, 1, 2, 3, 4, 5, 6, 1, 6, 6};
    char[] p1Chars = {'H', 'E', 'K', 'E', 'Y', 'B', 'O', 'A', 'R', 'D', 'D', 'M', 'C', 'P', 'U', 'O', 'H', 'U', 'O', 'S', 'C', 'R', 'E', 'E', 'N', 'E', 'E', 'S'};

    int col = 10;
    int row = 10;
    String[] puzzles = {"None", "Puzzle 1", "Puzzle 2"};
    JTextField[][] slots = new JTextField[col][row];
    JPanel slotHolder;
    JLabel slotIndex;
    JPanel playPanel = new JPanel();

    JPanel questionPanel = new JPanel();
    JLabel across = new JLabel();
    JLabel down = new JLabel();
    JLabel strong = new JLabel();
    JTextArea acrossHints = new JTextArea();
    JScrollPane acrossScroll;
    JTextArea downHints = new JTextArea();
    JScrollPane downScroll;
    JComboBox<? extends String> puzzleSelector = new JComboBox<>(puzzles);
    JButton createBtn = new JButton();
    JButton checkBtn = new JButton();

    Crossword() {
        setBounds(100, 200, 1060, 638);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        add(playPanel());
        add(questionPanel());
        setVisible(true);
    }

    public JPanel playPanel() {


        playPanel.setBounds(0, 0, 600, 600);
        playPanel.setLayout(new GridLayout(10, 10));
        playPanel.setBackground(Color.darkGray);
        playPanel.setVisible(true);
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                slots[i][j] = new JTextField();
                slots[i][j].setSize(60, 60);
                slots[i][j].setEditable(false);
                slots[i][j].setFocusable(false);
                slots[i][j].setForeground(Color.darkGray);
                slots[i][j].setHorizontalAlignment(JTextField.CENTER);
                slots[i][j].setBackground(Color.darkGray);
                slots[i][j].setFont(new Font("Arial", Font.BOLD, 18));
                slots[i][j].addActionListener(this);
                slotHolder = new JPanel();
                slotIndex = new JLabel();
                slotIndex.setText(" " + i + "/" + j);
                slotIndex.setFont(new Font("Arial", Font.BOLD, 10));
                slotIndex.setForeground(Color.lightGray);
                slotIndex.setSize(30, 20);
                slotHolder.setLayout(null);
                slotHolder.add(slotIndex);
                slotHolder.add(slots[i][j]);
                playPanel.add(slotHolder);
            }
        }
        return playPanel;
    }

    public JPanel questionPanel() {

        questionPanel.setBounds(620, 0, 400, 600);
        questionPanel.setLayout(null);
        questionPanel.setBackground(Color.darkGray);

        puzzleSelector.setBounds(0, 0, 240, 34);
        puzzleSelector.setBackground(Color.darkGray);
        puzzleSelector.setForeground(Color.white);
        puzzleSelector.addActionListener(this);

        createBtn.setBounds(320, 0, 80, 34);
        createBtn.setFocusable(false);
        createBtn.setText("Create");
        createBtn.setBackground(Color.darkGray);
        createBtn.setForeground(Color.white);
        createBtn.addActionListener(this);

        checkBtn.setBounds(240, 0, 80, 34);
        checkBtn.setFocusable(false);
        checkBtn.setText("Check");
        checkBtn.setBackground(Color.darkGray);
        checkBtn.setForeground(Color.white);
        checkBtn.addActionListener(this);

        across.setText("Across");
        across.setForeground(Color.white);
        across.setFont(new Font("Arial", Font.BOLD, 18));
        across.setBounds(20, 60, 400, 34);
        across.setVisible(true);

        acrossHints.setForeground(Color.white);
        acrossHints.setBackground(Color.darkGray);
        acrossHints.setFont(new Font("Arial", Font.BOLD, 14));
        acrossHints.setSize(360, 200);
        acrossHints.setText("");

        acrossScroll = new JScrollPane(acrossHints);
        acrossScroll.setBounds(20, 100, 380, 200);
        acrossScroll.setLayout(new ScrollPaneLayout());
        acrossScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        acrossScroll.setForeground(Color.darkGray);
        acrossScroll.setBackground(Color.darkGray);
        acrossScroll.setFocusable(false);
        acrossScroll.setBorder(BorderFactory.createEmptyBorder());

        down.setText("Down");
        down.setForeground(Color.white);
        down.setFont(new Font("Arial", Font.BOLD, 18));
        down.setBounds(20, 320, 400, 34);
        down.setVisible(true);

        downHints.setForeground(Color.white);
        downHints.setBackground(Color.darkGray);
        downHints.setFont(new Font("Arial", Font.BOLD, 14));
        downHints.setSize(360, 200);
        downHints.setText("");

        downScroll = new JScrollPane(downHints);
        downScroll.setBounds(20, 360, 380, 200);
        downScroll.setLayout(new ScrollPaneLayout());
        downScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        downScroll.setForeground(Color.darkGray);
        downScroll.setBackground(Color.darkGray);
        downScroll.setFocusable(false);
        downScroll.setBorder(BorderFactory.createEmptyBorder());

        strong.setText("Strong");
        strong.setForeground(Color.white);
        strong.setFont(new Font("Arial", Font.BOLD, 18));
        strong.setBounds(20, 60, 400, 34);
        strong.setVisible(true);



        questionPanel.add(puzzleSelector);
        questionPanel.add(createBtn);
        questionPanel.add(checkBtn);
        questionPanel.add(across);
        questionPanel.add(down);
        questionPanel.add(acrossScroll);
        questionPanel.add(downScroll);
        questionPanel.setVisible(true);

        return questionPanel;
    }

    public void initializeGame() {

        if (puzzleSelector.getSelectedIndex() == 1) {
            initializeSlot(p1Cols, p1Rows, p1Chars);
            acrossHints.setText("""
                    * From one side to the other of (a place, area, etc.).
                    * Expressing position or orientation in relation to (an area or passage).
                    """);
            downHints.setText("""
                    * Towards or in a lower place or position, especially to or on the ground or another surface.
                    * To or at a lower level of intensity, volume, or activity.
                    * From a higher to a lower point of (something).""");
        }

    }

    public void initializeSlot(int[] cols, int[] rows, char[] chars) {
        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    if (i == cols[k] && j == rows[k]) {
                        slots[i][j].setBackground(Color.white);
                        slots[i][j].setEditable(true);
                        slots[i][j].setFocusable(true);
                        slots[i][j].setName(String.valueOf(chars[k]));
                        k++;
                    }
                } catch (Exception ignored) {

                }

            }
        }
    }

    public void checkWords(int[] cols, int[] rows) {
        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    if (i == cols[k] && j == rows[k]) {
                        if (slots[i][j].getName().equals(slots[i][j].getText())) {
                            slots[i][j].setForeground(new Color(0, 134, 30));
                        } else {
                            slots[i][j].setForeground(Color.red);
                        }
                        k++;
                    }
                } catch (Exception ignored) {

                }

            }
        }
        if(checkWin(cols,rows)){

            System.out.println("You Won");
        }
    }
    public boolean checkWin(int[] cols,int[] rows){
        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    if (i == cols[k] && j == rows[k]) {
                        if(slots[i][j].getForeground()==Color.red){
                            return false;
                        }
                    }
                } catch (Exception ignored) {

                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Crossword();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == createBtn) {
            System.out.println("Create new");

        }
        if (e.getSource() == checkBtn) {
            if (puzzleSelector.getSelectedIndex() == 1) {
                checkWords(p1Cols, p1Rows);
            }
        }
        if (puzzleSelector.getSelectedIndex() != 0) {
            initializeGame();
        }
    }

}
