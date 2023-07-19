import javax.swing.*;
import java.awt.*;

public class MyGUI extends JFrame {
    private JTextArea textArea;

    public MyGUI() {
        setTitle("Text Area Example");
        setSize(400, 300); // Set the initial size of the JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create the JTextArea
        textArea = new JTextArea();
        textArea.setLineWrap(true); // Enable line wrapping to fit text within the area

        // Add the JTextArea to a JScrollPane to enable scrolling if the text exceeds
        // the visible area
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Add the JScrollPane to the JFrame
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyGUI gui = new MyGUI();
            gui.setVisible(true);
        });
    }
}
