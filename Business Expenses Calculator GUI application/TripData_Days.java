import java.awt.Color;
import javax.swing.*;
import java.awt.*;

/*
 * The TripData_Days class will be used to get the
 * number of days spent at a particular business trip.
 * The total cost will be shown to the screen and then
 * it will tell the user how much they saved or how much the need to top up 
 */

 public class TripData_Days extends JPanel
 {
    private final double EXPENSE_CAP = 400.00;
    private JTextField inputField;
    private JLabel firstPart, secondPart;

    /*
     * Constructor
     */
    public TripData_Days()
    {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        /* Initialise the variables */
        firstPart = new JLabel("How long was your trip? ");
        secondPart = new JLabel(" day(s)");
        inputField = new JTextField(10);
        // ADD THE COMPONENTS IN POSITION
        add(firstPart);
        add(inputField);
        add(secondPart);
    }

    /**
     * The getCapAmount function returns the total CAP amount of the trip
     * @return a double of the amount.
     */
    public double getCapAmount()
    {
        return EXPENSE_CAP;
    }

    /**
     * The getDays function will be used to get the number of days from the user
     * when the button is pressed in the Main Program.
     * The button action will not be implemented here.
     * @return DAYS if the user entered the data & -1 if no input is given.
     */
    public int getDays()
    {
        int DAYS = 0;
        String text;
        text = inputField.getText();
        if (!text.equals(""))
        {
            DAYS = Integer.parseInt(text);
            if (DAYS < 0)
            {
                DAYS = 0;
                return -1;
            }
        }
        else
        {
            return -1;
        }
        return DAYS;
    }
 }