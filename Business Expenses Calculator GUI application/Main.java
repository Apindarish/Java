import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * The Main class is used to create a GUI that will be used to
 * Run the application
 */

public class Main extends JFrame {
    private JPanel Panel;
    private JButton CalculateButton;
    //input panels for data
    private TripData_Days days_Input;
    private AeroplaneTransport air_trip;
    private Cars car_information;
    private Taxi taxi_information;
    private Conferences conference_space;

    private int DAYS;
    private double TOTAL_COST = 0.0;
    // other information
    private double BUDGET_LIMIT= 250.00;   //max amount of the budget for the trip
    private boolean more = false;       //checks if the TOTAL_COST exceeds the budget limit

    public Main()
    {
        setSize(450, 450);
        setTitle("Travel Expenses");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Panel = new JPanel();
        Panel.setLayout(new GridLayout(10, 1 ));  //updates layout of the GUI
        Panel.setBorder(BorderFactory.createTitledBorder("Business Trip Costs"));
        days_Input = new TripData_Days();
        Panel.add(days_Input);
        CalculateButton = new JButton("CALCULATE");
        CalculateButton.addActionListener(new CalculateListener());     //ActionListener registered for the calculate button
        /* AeroplaneTransport spot */
        air_trip = new AeroplaneTransport();
        Panel.add(air_trip);
        /* Road Transport Panel */
        car_information = new Cars();
        Panel.add(car_information);
        /* Taxi Information */
        taxi_information = new Taxi();
        Panel.add(taxi_information);
        /* conferences space */
        conference_space = new Conferences();
        Panel.add(conference_space);
        //End: Calculate Button
        Panel.add(CalculateButton);
        add(Panel);
        setVisible(true);
    }

    /**
     * The show_Cost_Information method will be used to show data to the user.
     * Data shown will be the Budget Limit and the amount the user needs to pay
     * @param total
     * @param more
     */
    private void show_Cost_Information(double total, boolean more)
    {
        if (more == true)
        {
            JOptionPane.showMessageDialog(null,"Budget Limit: $"+BUDGET_LIMIT+"\nTotal Expenses: $" + total + "\nExcess: $"+(total - BUDGET_LIMIT)+"\nYou have to pay $" + (total - BUDGET_LIMIT)+" from your own pocket.\n");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Budget Limit: $" + BUDGET_LIMIT +"\nTotal Expenses: $" + total + "\nAmount Saved by the business: $"+ (BUDGET_LIMIT - total));
        }
    }

    /*Action Listener for the CalculateButton */
    private class CalculateListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int days = days_Input.getDays();

            if (days == -1)
            {
                JOptionPane.showMessageDialog(null, "You did not enter any input!");
            }
            else
            {
                System.out.println("The days input are " + days + " days.");
                DAYS = days;
                //ADD THE TOTAL UP
                TOTAL_COST = (37.0 * DAYS);
                TOTAL_COST += air_trip.getPlaneAmount(); //cost of flights
                TOTAL_COST += car_information.GetCarRentalCost();   //cost of rented cars
                double MILES = car_information.GetMiles();  //miles used by a private car
                TOTAL_COST += MILES * 0.27; //cost using MILES  
                TOTAL_COST += car_information.GetParkingFees(); //Parking fees incurred  
                TOTAL_COST += conference_space.getConferenceCosts();   
                
                if (TOTAL_COST > BUDGET_LIMIT)
                {
                    more = true;
                }
                show_Cost_Information(TOTAL_COST, more);
            }
        }
    }

    public static void main(String [] args)
    {
        new Main();
    }
}
