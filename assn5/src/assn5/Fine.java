/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn5
 * Date Assigned:   Thursday, 15 February 2007, 09:20 AM
 * Due date:        Monday, 26 February 2007, 10:00 PM
 * Description:     This is a wrapper for calculating fines.
 */

package assn5;

/**
 * This is a wrapper for calculating fines.
 * @author Mark
 */
public interface Fine {
    /**
     *Calculates a fine for the media object based upon when it was returned.
     */
    public double calculateFine(Media media, int day_returned);
}
