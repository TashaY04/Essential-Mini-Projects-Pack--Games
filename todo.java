import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ToDoListGUI extends JFrame {

    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField newTaskField;

    public ToDoListGUI() {
        setTitle("To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        // Task List
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList); // Add scrolling
        add(scrollPane, BorderLayout.CENTER);


        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout());
        newTaskField = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        inputPanel.add(newTaskField);
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);

        // Add Button Action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = newTaskField.getText().trim();
                if (!task.isEmpty()) {
                    listModel.addElement(task);  // Add to the list
                    newTaskField.setText("");    // Clear the input field
                }
            }
        });


        // Delete Button (South Panel)
        JPanel deletePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Align right
        JButton deleteButton = new JButton("Delete Selected");
        deletePanel.add(deleteButton);
        add(deletePanel, BorderLayout.SOUTH);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToDoListGUI());
    }
}