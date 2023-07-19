import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PanelSwitchExample extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardsPanel;

    // Helper method to create individual panels
    private JPanel createPanel(String title, Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        JLabel label = new JLabel(title);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label);
        return panel;
    }

    public PanelSwitchExample() {
        // Set up the main frame
        setTitle("Panel Switch Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize the CardLayout and JPanel to hold cards
        cardLayout = new CardLayout();
        cardsPanel = new JPanel(cardLayout);
        add(cardsPanel);

        // Add different panels to the cardsPanel
        cardsPanel.add(createPanel("Panel 1", Color.RED), "Panel 1");
        cardsPanel.add(createPanel("Panel 2", Color.GREEN), "Panel 2");
        cardsPanel.add(createPanel("Panel 3", Color.BLUE), "Panel 3");
        // Create buttons to switch between panels
        JButton panel1Button = new JButton("Panel 1");
        JButton panel2Button = new JButton("Panel 2");
        JButton panel3Button = new JButton("Panel 3");

        panel1Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardsPanel, "Panel 1");
            }
        });

        panel2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardsPanel, "Panel 2");
            }
        });

        panel3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardsPanel, "Panel 3");
            }
        });

        // Add buttons to a separate panel for better layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(panel1Button);
        buttonPanel.add(panel2Button);
        buttonPanel.add(panel3Button);

        // Add the buttonPanel at the bottom of the main frame
        add(buttonPanel, BorderLayout.SOUTH);

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PanelSwitchExample example = new PanelSwitchExample();
            example.setVisible(true);
        });
    }
}

// ... Rest of the code ...
