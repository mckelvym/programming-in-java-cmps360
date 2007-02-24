/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn5
 * Date Assigned:   Thursday, 15 February 2007, 09:20 AM
 * Due date:        Monday, 26 February 2007, 10:00 PM
 * Description:     This class is a parent to all media types. It also implements Fine.
 */

package assn5;

/**
 * This class is a parent to all media types. It also implements Fine.
 * @author Mark
 */
public class Media implements Fine{
    
    /**
     *The day of rental of this media item.
     */
    private int day_rented;
    
    /**
     *The cost of this item.
     */
    private double cost;
    
    /**
     *The rental fee of this item.
     */
    private double rental_fee;
    
    /**
     *The rental rate of this item.
     */
    private double rental_rate;
    
    /**
     *The name of the media type.
     */
    protected String name;
    
    /** Creates a new instance of Media, default values. */
    public Media() {
        day_rented = 0;
        cost = 0;
        rental_fee = 0;
        rental_rate = 0.1;
    }
    
    /**
     *Set the day that this media item was rented.
     */
    public void setDayRented(int day_rented){
        if(day_rented >= 0)
            this.day_rented = day_rented;
    }
    
    /**
     *Get teh day that this media item was rented.
     */
    public int getDayRented(){
        return day_rented;
    }
    
    /**
     *Set the cost of this media item.
     */
    public void setCost(double cost){
        if(cost >= 0.0)
            this.cost = cost;
    }
    
    /**
     *Get the cost of this media item.
     */
    public double getCost(){
        return cost;
    }
    
    /**
     *Set the rental fee of this media item.
     */
    public void setRentalFee(double rental_fee){
        if(rental_fee >= 0.0)
            this.rental_fee = rental_fee;
    }
    
    /**
     *Get the rental fee of this media item.
     */
    public double getRentalFee(){
        return rental_fee;
    }
    
    /**
     *Set the rental rate of this media item.
     */
    protected void setRentalRate(double rental_rate){
        if(rental_rate >= 0.0)
            this.rental_rate = rental_rate;
    }
    
    /**
     *Get the rental rate of this media item.
     */
    protected double getRentalRate(){
        return rental_rate;
    }
    
    /**
     * Calculates a fine for the media object based upon when it was returned.
     */
    public double calculateFine(Media media, int day_returned) {
        return 0.0;
    }    
    
    /**
     *Gets the name of this media type.
     */
    public String getName(){
        return name;
    }
}
