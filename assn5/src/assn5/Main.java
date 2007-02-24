/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn5
 * Date Assigned:   Thursday, 15 February 2007, 09:20 AM
 * Due date:        Monday, 26 February 2007, 10:00 PM
 * Description:     This class shows how the media classes work.
 */

package assn5;

/**
 * This class shows how the media classes work.
 * @author Mark
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
        int total=9;
        int returned=20;
        out("Allocating memory for " + total + " media objects.");
        Media media[] = new Media[total];
        Media tmp;
        out("Creating new media objects.");
        for(int i = 0; i < 3; i++){
            media[i] = new VCR();
            media[3 + i] = new CD();
            media[6 + i] = new DVD();
            media[i].setDayRented(i);
            media[3 + i].setDayRented(i+3);
            media[6 + i].setDayRented(i+6);
            out("Creating new VCR, day rented " + i);
            out("Creating new CD, day rented " + (i+3));
            out("Creating new DVD, day rented " + (i+6));
        }
        out("Returning all media on day " + returned + "\n");
        for(int i = 0; i < total; i++){
            tmp=media[i];
            out(tmp.getName());
            out("COST: $" + tmp.getCost());
            out("RENT: $" + tmp.getRentalFee());
            out("DAY RENTED: " + tmp.getDayRented());
            out("DAY RETURNED: " + returned);
            out("LATE FEE: $" + tmp.calculateFine(tmp, returned));
            out("");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
    
    /**
     *Output an object to the terminal.
     */
    private void out(Object o){
        System.out.println(o);
    }
}
