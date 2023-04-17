import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Taxi extends JPanel {
    private JLabel label1;  //prompt question
    private JRadioButton yes, no;   //choices
    private double TAXI_CHARGES = 0.0;
    private ButtonGroup group;

    public Taxi()
    {   setLayout(new GridLayout(1, 3));
        label1 = new JLabel("Did you use a taxi? ");
        yes = new JRadioButton("Yes");
        no = new JRadioButton("No");
        group = new ButtonGroup();
        group.add(yes);
        group.add(no);

        yes.addActionListener(new RadioListener());
        add(label1);
        add(yes);
        add(no);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class RadioListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String source = e.getActionCommand();
            if (source.equals("Yes"))
            {
                String input = JOptionPane.showInputDialog(null, "How much are the total taxi costs?");
                TAXI_CHARGES = Double.parseDouble(input);

                if (TAXI_CHARGES < 0)
                {
                    JOptionPane.showMessageDialog(null, "Error: Invalid amount for taxi fees!");
                    TAXI_CHARGES = 0.0;
                }
            }
        }
    }

    /**
     * GetTaxiCharges function gets the value in TAXI_CHARGES back to the calling function
     * @return the double value stored in the local variable, TAXI_CHARGES
     */
    public double GetTaxiCharges()
    {
        return this.TAXI_CHARGES;
    }
}
