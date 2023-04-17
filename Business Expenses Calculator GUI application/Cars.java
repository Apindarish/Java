import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * This class will take information about the cars the businessman used on his business trip
 */
public class Cars extends JPanel {
    private JLabel label1;  // used to ask a user if they rented a car
    private double RentedCar_Cost = 0.0;      //used if a user did rent a car; amount incurred
    private JRadioButton rentedCar_Yes, rentedCar_No;   //answers whether a car was rented or not.
    private ButtonGroup rentedCar_Group;    //mutual exclusion of radio buttons

    private JLabel label2;  //used to ask a user if they used a private car
    private double PrivateCar_miles = 0.0;  //used if the user did use a private car
    private JRadioButton privateCar_Yes, privateCar_No;     //answers whether a private car was used or not
    private ButtonGroup privateCar_Group;   //mutual exclusion of radio buttons
    private double PARKING_FEE;

    public Cars()
    {
        //try out the GridLayout
        setLayout(new GridLayout(2, 3));
        // initialise variables
        label1 = new JLabel("Did you rent a car? ");
        rentedCar_Yes = new JRadioButton("Yes");
        rentedCar_No = new JRadioButton("No");
        rentedCar_Group = new ButtonGroup();
        rentedCar_Group.add(rentedCar_Yes);
        rentedCar_Group.add(rentedCar_No);

        rentedCar_Yes.addActionListener(new rentedCarListener());
        add(label1);
        add(rentedCar_Yes);
        add(rentedCar_No);

        label2 = new JLabel("Used a private car? ");
        privateCar_Yes = new JRadioButton("Yes");
        privateCar_No = new JRadioButton("No");
        privateCar_Group = new ButtonGroup();
        privateCar_Group.add(privateCar_Yes);
        privateCar_Group.add(privateCar_No);
        privateCar_Yes.addActionListener(new privateCarListener());
        add(label2);
        add(privateCar_Yes);
        add(privateCar_No);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class privateCarListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        String source = e.getActionCommand();

        if (source.equals("Yes"))
        {
            String input = JOptionPane.showInputDialog(null, "How many miles did you drive?");
            PrivateCar_miles = Double.parseDouble(input);

            if (PrivateCar_miles < 0)
            {
                JOptionPane.showMessageDialog(null,"Invalid input");
            }
            input = JOptionPane.showInputDialog(null, "How much were the Parking Fees: ");
            PARKING_FEE = Double.parseDouble(input);

            if (PARKING_FEE < 0)
            {
                JOptionPane.showMessageDialog(null, "Error: I'll take that as $0.00");
                PARKING_FEE = 0.0;
            }
        }

    }
}

private class rentedCarListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String source = e.getActionCommand();
            if (source.equals("Yes"))
            {
                String input = JOptionPane.showInputDialog(null, "How much is the total rental cost?");
                RentedCar_Cost = Double.parseDouble(input);

                if (RentedCar_Cost < 0.0)
                {
                    JOptionPane.showMessageDialog(null, "Invalid amount!");
                }
            }

        }
    }

    /**
     * GetMiles function is called to retrieve data in the background about the miles for private car use
     * @return double representing the number of Miles
     */
    public double GetMiles()
    {
        return this.PrivateCar_miles;
    }
    /**
     * GetCarRentalCost function returns the amount used to rent a car for the trip
     * @return double value representing the cost
     */
    public double GetCarRentalCost()
    {
        return this.RentedCar_Cost;
    }
    /**
     * GetParkingFees function is used to get the amount of Parking fees incurred when a user did use 
     * a private car on the business trip
     */
    public double GetParkingFees()
    {
        return this.PARKING_FEE;
    }
}
