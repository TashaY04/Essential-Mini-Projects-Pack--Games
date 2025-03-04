import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleQuizGUI extends JFrame {

    private JLabel questionLabel;
    private JRadioButton[] options;
    private JButton submitButton;
    private ButtonGroup buttonGroup;
    private int currentQuestion = 0;
    private int score = 0;

    private String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the 'Red Planet'?",
            "What is the largest mammal in the world?"
    };

    private String[][] quizOptions = {
            {"Berlin", "Paris", "Madrid", "Rome"},
            {"Jupiter", "Mars", "Venus", "Saturn"},
            {"African Elephant", "Blue Whale", "Polar Bear", "Giraffe"}
    };

    private int[] correctAnswers = {1, 1, 1}; // Indices of correct answers

    public SimpleQuizGUI() {
        setTitle("Simple Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        questionLabel = new JLabel(questions[currentQuestion]);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        options = new JRadioButton[4];
        buttonGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton(quizOptions[currentQuestion][i]);
            optionsPanel.add(options[i]);
            buttonGroup.add(options[i]);
        }
        add(optionsPanel, BorderLayout.CENTER);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });
        add(submitButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void checkAnswer() {
        int selectedOption = -1;
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                selectedOption = i;
                break;
            }
        }

        if (selectedOption != -1 && selectedOption == correctAnswers[currentQuestion]) {
            score++;
        }

        currentQuestion++;
        if (currentQuestion < questions.length) {
            loadNextQuestion();
        } else {
            showResult();
        }
    }

    private void loadNextQuestion() {
        questionLabel.setText(questions[currentQuestion]);
        for (int i = 0; i < 4; i++) {
            options[i].setText(quizOptions[currentQuestion][i]);
            options[i].setSelected(false); // Important: Unselect previous options
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Quiz Over!\nYour score: " + score + "/" + questions.length);
        System.exit(0); // Or you could reset the quiz
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleQuizGUI());
    }
}