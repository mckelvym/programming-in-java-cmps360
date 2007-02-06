/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn3
 * Date Assigned:   Sunday, 28 January 2007, 10:25 AM 	
 * Due Date:        Monday, 12 February 2007, 10:00 PM
 * Description:     A hypothetical alien type.
 */

package assn3;

/**
 * A hypothetical alien type.
 * @author Mark
 */
public class Aliens {
    
    /**
     *Where is the alien from?
     */
    protected String home_planet;
    
    /**
     *What does the alien breathe?
     */
    protected String breathes;
    
    /**
     *What does the alien eat?
     */
    protected String eats;
    
    /** Creates a new instance of Aliens, all values "N/A" */
    public Aliens() {
        home_planet = "N/A";
        breathes = "N/A";
        eats = "N/A";
    }
    
    /**
     *Create a new instance of Aliens.
     *@param home Where the alien is from.
     *@param breathes What the alien breathes.
     *@param eats What the alien eats.
     */
    public Aliens(String home, String breathes, String eats){
        this.home_planet = home;
        this.breathes = breathes;
        this.eats = eats;
    }
    
    /**
     *Get where the alien is from.
     */
    public String getHomePlanet(){
        return home_planet;
    }
    
    /**
     *Set where the alien is from.
     */
    public void setHomePlanet(String new_home){
        home_planet = new_home;
    }
    
    /**
     *Get what the alien breathes.
     */
    public String getBreathes(){
        return breathes;
    }
    
    /**
     *Set what the alien breathes.
     */
    public void setBreathes(String breathes){
        this.breathes = breathes;
    }
    
    /**
     *Get what the alien eats.
     */
    public String getEats(){
        return eats;
    }
    
    /**
     *Set what the alien eats.
     */
    public void setEats(String eats){
        this.eats = eats;
    }
    
    /**
     *Compare two aliens for equality.
     */
    public boolean equals(Object o){
        if(o instanceof Aliens){
            Aliens tmp = (Aliens)o;
            if(tmp.home_planet.equals(this.home_planet) && tmp.breathes.equals(this.breathes) && tmp.eats.equals(this.eats)){
                return true;
            }
            else return false;
        }
        else return false;
    }
}
