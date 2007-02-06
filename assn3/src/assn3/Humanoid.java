/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn3
 * Date Assigned:   Sunday, 28 January 2007, 10:25 AM 	
 * Due Date:        Monday, 12 February 2007, 10:00 PM
 * Description:     A hypothetical humanoid type that descended from an animaloid.
 */

package assn3;

/**
 *A hypothetical humanoid type that descended from an animaloid.
 * @author Mark
 */
public class Humanoid extends Animaloid{
    
    /**
     *Set some default values
     */
    {
        num_arms = 2;
        num_legs = 2;
        num_heads = 1;
        num_ears = 2;
        num_eyes = 2;
    }
    
    /** Creates a new instance of Humanoid */
    public Humanoid(){
        super();
    }
    
    /** Creates a new instance of Humanoid with 2legs,2arms,1head,2ears,2eyes only.
     *@param home Where it is from.
     *@param breathes What it breathes.
     *@param eats What it eats.
     */
    public Humanoid(String home, String breathes, String eats) {
        super(home, breathes, eats, 2, 2, 1, 2, 2);
    }
    
    /**
     *Overriding, doesn't set any value.
     */
    public final void setArms(int arms){}
    
    /**
     *Overriding, doesn't set any value.
     */
    public final void setLegs(int legs){}
    
    /**
     *Overriding, doesn't set any value.
     */
    public final void setHeads(int heads){}
    
    /**
     *Overriding, doesn't set any value.
     */
    public final void setEars(int ears){}
    
    /**
     *Overriding, doesn't set any value.
     */
    public final void setEyes(int eyes){}
    
    /**
     *For comparision against other humanoids.
     */
    public boolean equals(Object o){
        if(o instanceof Humanoid){
            Humanoid tmp = (Humanoid)o;
            if(!(tmp.home_planet.equals(this.home_planet) && tmp.breathes.equals(this.breathes) && tmp.eats.equals(this.eats))){
                return false;
            }
            if(tmp.num_arms != 2)
                return false;
            if(tmp.num_legs != 2)
                return false;
            if(tmp.num_heads != 1)
                return false;
            if(tmp.num_ears != 2)
                return false;
            if(tmp.num_eyes != 2)
                return false;
            return true;
        }
        return false;
    }
}
