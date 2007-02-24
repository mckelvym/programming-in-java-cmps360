/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn5
 * Date Assigned:   Thursday, 15 February 2007, 09:20 AM
 * Due date:        Monday, 26 February 2007, 10:00 PM
 * Description:     This is a child of Media that implements Fine. It is a VCR.
 */

package assn5;

/**
 * This is a child of Media that implements Fine. It is a VCR.
 * @author Mark
 */
public class VCR extends Media implements Fine{
    
    /** Creates a new instance of VCR */
    public VCR() {
        super();
        this.setCost(9.99);
        this.setRentalRate(0.14);
        this.setRentalFee(getCost()*getRentalRate());
        name = "VCR";
    }

    /**
     * Calculates a fine for the media object based upon when it was returned.
     */
    public double calculateFine(Media media, int day_returned) {
        int days_late = day_returned - media.getDayRented();
        if(days_late > 0){
            return days_late*1.00;
        }
        return 0.0;
    }
    
}
