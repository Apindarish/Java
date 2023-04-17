import java.awt.*;
import javax.swing.*;


public class Conferences extends JPanel {
    private JLabel conference_label;
    private JTextArea seminar_cost_input;
    private double conference_costs = 0.0;

    public Conferences()
    {
        conference_label = new JLabel("Log conference or seminar costs, if any: ");
        seminar_cost_input = new JTextArea(1, 5);
        add(conference_label, FlowLayout.LEFT);
        add(seminar_cost_input);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /**
     * getConferenceCosts method is called to get the amount entered by a user for any conferences or seminars attended.
     * @return conferences_costs variable after update.
     */
    public double getConferenceCosts()
    {
        String cost_input = seminar_cost_input.getText();

        if (cost_input.isBlank())
        {
            return 0.0;
        }

        else
        {
            conference_costs = Double.parseDouble(cost_input);

            if (conference_costs < 0)
            {
                conference_costs = 0.0;
                JOptionPane.showMessageDialog(null, "Error: The conference costs entered are invalid!");
            }
        }
        return conference_costs;
    }

}
