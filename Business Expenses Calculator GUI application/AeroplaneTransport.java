import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AeroplaneTransport extends JPanel {
    private JRadioButton YES, NO;
    private JLabel prompt1;
    private double AMOUNT;
    private ButtonGroup group;
    public JPanel Additional_Panel;

    public AeroplaneTransport()
    {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        YES = new JRadioButton("Yes");
        YES.addActionListener(new YesButtonListener());
        NO = new JRadioButton("No");
        group = new ButtonGroup();
        group.add(YES);
        group.add(NO);
        prompt1 = new JLabel("Did you use an aeroplane when you travelled? ");
    // add components accordingly
    add(prompt1);
    add(YES);
    add(NO);

    }

    private class YesButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String input = JOptionPane.showInputDialog("How much did you pay for flights?");
            AMOUNT = Double.parseDouble(input);
            if (AMOUNT < 0)
            {
                AMOUNT = 0;
                JOptionPane.showMessageDialog(null, "Error: Invalid amount for flights!");
                return;
            }
            System.out.println("You paid $"+ AMOUNT+ " for flights.");
        }
    }

    /**
     * the getPlaneAmount function returns the amount paid for aeroplane tickets
     * @return amt double amount for aeroplane tickets.
     */
    public double getPlaneAmount()
    {
        return this.AMOUNT;
    }

}
