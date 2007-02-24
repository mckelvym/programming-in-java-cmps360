/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn5
 * Date Assigned:   Thursday, 15 February 2007, 09:20 AM
 * Due date:        Monday, 26 February 2007, 10:00 PM
 * Description:     This is a child of Media that implements Fine. It is a DVD.
 */


package assn5;

/**
 * This is a child of Media that implements Fine. It is a DVD.
 * @author Mark
 */
public class DVD extends Media implements Fine{
    
    /** Creates a new instance of DVD */
    public DVD() {
        super();
        this.setCost(19.99);
        this.setRentalFee(getCost()*getRentalRate());
        name = "DVD";
    }

    /**
     * Calculates a fine for the media object based upon when it was returned.
     */
    public double calculateFine(Media media, int day_returned) {
        int days_late = day_returned - media.getDayRented();
        if(days_late > 0){
            return days_late*(1.00 + 0.05*media.getCost());
        }
        return 0.0;
    }
 
}
