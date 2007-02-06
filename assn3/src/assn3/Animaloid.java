/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn3
 * Date Assigned:   Sunday, 28 January 2007, 10:25 AM 	
 * Due Date:        Monday, 12 February 2007, 10:00 PM
 * Description:     A hypothetical animaloid type that descended from an alien.
 */

package assn3;

/**
 *A hypothetical animaloid type that descended from an alien.
 * @author Mark
 */
public class Animaloid extends Aliens{
    
    /**
     *Number of arms.
     */
    protected int num_arms;
    
    /**
     *Number of legs.
     */
    protected int num_legs;
    
    /**
     *Number of heads.
     */
    protected int num_heads;
    
    /**
     *Number of ears.
     */
    protected int num_ears;
    
    /**
     *Number of eyes.
     */
    protected int num_eyes;
    
    /**
     *Mininum arms.
     */
    private final int min_arms = 0;
    
    /**
     *Minimum legs.
     */
    private final int min_legs = 0;
    
    /**
     *Minimum heads.
     */
    private final int min_heads = 1;
    
    /**
     *Minimum ears.
     */
    private final int min_ears = 1;
    
    /**
     *Minimum eyes.
     */
    private final int min_eyes = 1;
    
    /**
     *Set some default values.
     */
    {
        num_arms = min_arms;
        num_legs = min_legs;
        num_heads = min_heads;
        num_ears = min_ears;
        num_eyes = min_eyes;
    }
    
    /**
     *Default constructor.
     */
    public Animaloid(){
        super();
    }
    
    /**
     *Creates a new animaloid.
     *@param home Where it is from.
     *@param breathes What it breates.
     *@param eats What it eats.
     *@param arms Number of arms.
     *@param legs Number of legs.
     *@param heads Number of heads.
     *@param ears Number of ears.
     *@param eyes Number of eyes.
     */
    public Animaloid(String home, String breathes, String eats, int arms, int legs, int heads, int ears, int eyes) {
        super(home, breathes, eats);
        if(arms > num_arms)
            num_arms = arms;
        if(legs > num_legs)
            num_legs = legs;
        if(heads > num_heads)
            num_heads = heads;
        if(ears > num_ears)
            num_ears = ears;
        if(eyes > num_eyes)
            num_eyes = eyes;
    }
    
    /**
     *Get the number of arms.
     */
    public int getArms(){
        return num_arms;
    }
    
    /**
     *Set the number of arms.
     */
    public void setArms(int arms){
        if(arms >= min_arms)
            num_arms = arms;
    }
    
    /**
     *Get the number of legs.
     */
    public int getLegs(){
        return num_legs;
    }
    
    /**
     *Set the number of legs.
     */
    public void setLegs(int legs){
        if(legs >= min_legs)
            num_legs = legs;
    }
    
    /**
     *Get the number of heads.
     */
    public int getHeads(){
        return num_heads;
    }
    
    /**
     *Set the number of heads.
     */
    public void setHeads(int heads){
        if(heads >= min_heads)
            num_heads = heads;
    }
    
    /**
     *Get the number of ears.
     */
    public int getEars(){
        return num_ears;
    }
    
    /**
     *Set the number of ears.
     */
    public void setEars(int ears){
        if(ears >= min_ears)
            num_ears = ears;
    }
    
    /**
     *Get the number of eyes.
     */
    public int getEyes(){
        return num_eyes;
    }
    
    /**
     *Set the number of eyes.
     */
    public void setEyes(int eyes){
        if(eyes >= min_eyes)
            num_eyes = eyes;
    }
    
    /**
     *Compare to another animaloid.
     */
    public boolean equals(Object o){
        if(o instanceof Animaloid){
            Animaloid tmp = (Animaloid)o;
            if(!(tmp.home_planet.equals(this.home_planet) && tmp.breathes.equals(this.breathes) && tmp.eats.equals(this.eats))){
                return false;
            }
            if(tmp.num_arms != this.num_arms)
                return false;
            if(tmp.num_legs != this.num_legs)
                return false;
            if(tmp.num_heads != this.num_heads)
                return false;
            if(tmp.num_ears != this.num_ears)
                return false;
            if(tmp.num_eyes != this.num_eyes)
                return false;
            return true;
        }
        return false;
    }
}
