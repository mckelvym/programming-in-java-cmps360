/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn3
 * Date Assigned:   Sunday, 28 January 2007, 10:25 AM 	
 * Due Date:        Monday, 12 February 2007, 10:00 PM
 * Description:     A hypothetical bloboid type that descended from an alien.
 */

package assn3;

/**
 *A hypothetical bloboid type that descended from an alien.
 * @author Mark
 */
public class Bloboid extends Aliens{
    
    /**
     *Type of goo that it has.
     */
    protected String goo_type;
    
    /**
     *The number of tentacles.
     */
    protected int num_tentacles;
    
    /**
     *Set some default values.
     */
    {
        goo_type = "N/A";
        num_tentacles = 0;
    }
    
    /** Creates a new instance of Bloboid */
    public Bloboid() {
        super();
    }
    
    /** Creates a new instance of Bloboid 
     *@param home Where it is from.
     *@param breathes What it breathes.
     *@param eats What it eats.
     *@param goo_type What type of goo it has.
     *@param tentacles Number of tentacles.
     */
    public Bloboid(String home, String breathes, String eats, String goo_type, int tentacles){
        super(home, breathes, eats);
        this.goo_type = goo_type;
        if(tentacles > num_tentacles)
            num_tentacles = tentacles;
    }
    
    /**
     *Get goo type.
     */
    public String getGooType(){
        return goo_type;
    }
    
    /**
     *Set goo type.
     */
    public void setGooType(String goo_type){
        this.goo_type = goo_type;        
    }
    
    /**
     *Get number of tentacles.
     */
    public int getTentacles(){
        return num_tentacles;
    }
    
    /**
     *Set number of tentacles.
     */
    public void setTentacles(int num_tentacles){
        if(num_tentacles >= 0)
            this.num_tentacles = num_tentacles;
    }
    
    /**
     *Compare against another bloboid.
     */
    public boolean equals(Object o){
        if(o instanceof Bloboid){
            Bloboid tmp = (Bloboid)o;
            if(!(tmp.home_planet.equals(this.home_planet) && tmp.breathes.equals(this.breathes) && tmp.eats.equals(this.eats))){
                return false;
            }
            if(tmp.num_tentacles != this.num_tentacles)
                return false;
            if(!tmp.goo_type.equals(this.goo_type))
                return false;
            return true; 
        }
        return false;
    }
}
