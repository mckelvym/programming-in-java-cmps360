/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn3
 * Date Assigned:   Sunday, 28 January 2007, 10:25 AM 	
 * Due Date:        Monday, 12 February 2007, 10:00 PM
 * Description:     Demonstrates the use of the various alien classes to show
 *                  that they are fully functional.
 */

package assn3;

/**
 *Demonstrates the use of the various alien classes to show that they are fully 
 * functional.
 * @author Mark
 */
public class Demo {
    
    public static void main(String[] args){
        new Demo();
    }
    
    /** Creates a new instance of Demo */
    public Demo() {
        Aliens al1, al2;
        Animaloid an1, an2;
        Bloboid b1, b2;
        Humanoid h1, h2;
        int count = 1;
        
        outln((count++) + ". " + "Creating two equal aliens and testing." + " (Default Constructor)");
        al1 = new Aliens();
        al2 = new Aliens();
        outln("Are they equal? " + al1.equals(al2));
        
        outln((count++) + ". " + "Creating two equal aliens and testing." + " (Special Constructor)");
        al1 = new Aliens("Xindi", "Varies", "Food");
        al2 = new Aliens("Xindi", "Varies", "Food");
        outln("Are they equal? " + al1.equals(al2));
        
        outln((count++) + ". " + "Creating two equal animaloids and testing." + " (Default Constructor)");
        an1 = new Animaloid();
        an2 = new Animaloid();
        outln("Are they equal? " + an1.equals(an2));
        
        outln((count++) + ". " + "Creating two equal animaloids and testing." + " (Special Constructor)");
        an1 = new Animaloid("Mars", "CO2", "Hamburgers", 3, 1, 2, 4, 3);
        an2 = new Animaloid("Mars", "CO2", "Hamburgers", 3, 1, 2, 4, 3);
        outln("Are they equal? " + an1.equals(an2));
        
        outln((count++) + ". " + "Creating two equal bloboids and testing." + " (Default Constructor)");
        b1 = new Bloboid();
        b2 = new Bloboid();
        outln("Are they equal? " + b1.equals(b2));
        
        outln((count++) + ". " + "Creating two equal bloboids and testing." + " (Special Constructor)");
        b1 = new Bloboid("Remus", "H2O", "People", "Yucky", 42);
        b2 = new Bloboid("Remus", "H2O", "People", "Yucky", 42);
        outln("Are they equal? " + b1.equals(b2));
        
        outln((count++) + ". " + "Creating two equal humanoids and testing." + " (Default Constructor)");
        h1 = new Humanoid();
        h2 = new Humanoid();
        outln("Are they equal? " + h1.equals(h2));
        
        outln((count++) + ". " + "Creating two equal humanoids and testing." + " (Special Constructor)");
        h1 = new Humanoid("Earth", "O2", "Pizza");
        h2 = new Humanoid("Earth", "O2", "Pizza");
        outln("Are they equal? " + h1.equals(h2));
        
        outln("");
        outln("Now testing alien get/set methods");
        outln("Get home: " + al1.getHomePlanet());
        outln("Get breathes: " + al1.getBreathes());
        outln("Get eats: " + al1.getEats());
        outln("Set home."); 
        al1.setHomePlanet("Mercury");
        outln("Set breathes."); 
        al1.setBreathes("Glue");
        outln("Set eats.");
        al1.setEats("Monkeys");
        outln("Get home: " + al1.getHomePlanet());
        outln("Get breathes: " + al1.getBreathes());
        outln("Get eats: " + al1.getEats());
        
        outln("");
        outln("Now testing animaloid get/set methods");
        outln("Get home: " + an1.getHomePlanet());
        outln("Get breathes: " + an1.getBreathes());
        outln("Get eats: " + an1.getEats());
        outln("Get arms: " + an1.getArms());
        outln("Get legs: " + an1.getLegs());
        outln("Get heads: " + an1.getHeads());
        outln("Get ears: " + an1.getEars());
        outln("Get eyes: " + an1.getEyes());        
        outln("Set home."); 
        an1.setHomePlanet("Vulcan");
        outln("Set breathes."); 
        an1.setBreathes("Methane");
        outln("Set eats.");
        an1.setEats("Worms");
        outln("Set arms.");
        an1.setArms(99);
        outln("Set legs.");
        an1.setLegs(99);
        outln("Set heads.");
        an1.setHeads(99);
        outln("Set ears.");
        an1.setEars(99);
        outln("Set eyes.");
        an1.setEyes(99);
        outln("Get home: " + an1.getHomePlanet());
        outln("Get breathes: " + an1.getBreathes());
        outln("Get eats: " + an1.getEats());
        outln("Get arms: " + an1.getArms());
        outln("Get legs: " + an1.getLegs());
        outln("Get heads: " + an1.getHeads());
        outln("Get ears: " + an1.getEars());
        outln("Get eyes: " + an1.getEyes());
        
        outln("");
        outln("Now testing bloboid get/set methods");
        outln("Get home: " + b1.getHomePlanet());
        outln("Get breathes: " + b1.getBreathes());
        outln("Get eats: " + b1.getEats());
        outln("Get goo: " + b1.getGooType());
        outln("Get tentacles: " + b1.getTentacles());
        outln("Set home."); 
        b1.setHomePlanet("Romulus");
        outln("Set breathes."); 
        b1.setBreathes("Helium");
        outln("Set eats.");
        b1.setEats("Grass");
        outln("Set goo.");
        b1.setGooType("Green");
        outln("Set tentacles.");
        b1.setTentacles(99);
        outln("Get home: " + b1.getHomePlanet());
        outln("Get breathes: " + b1.getBreathes());
        outln("Get eats: " + b1.getEats());
        outln("Get goo: " + b1.getGooType());
        outln("Get tentacles: " + b1.getTentacles());
        
        outln("");
        outln("Now testing humanoid get/set methods");
        outln("Get home: " + h1.getHomePlanet());
        outln("Get breathes: " + h1.getBreathes());
        outln("Get eats: " + h1.getEats());
        outln("Get arms: " + h1.getArms());
        outln("Get legs: " + h1.getLegs());
        outln("Get heads: " + h1.getHeads());
        outln("Get ears: " + h1.getEars());
        outln("Get eyes: " + h1.getEyes());        
        outln("Set home."); 
        h1.setHomePlanet("Kronos");
        outln("Set breathes."); 
        h1.setBreathes("Nitrogen");
        outln("Set eats.");
        h1.setEats("Rats");
        outln("Set arms.");
        h1.setArms(99);
        outln("Set legs.");
        h1.setLegs(99);
        outln("Set heads.");
        h1.setHeads(99);
        outln("Set ears.");
        h1.setEars(99);
        outln("Set eyes.");
        h1.setEyes(99);
        outln("Get home: " + h1.getHomePlanet());
        outln("Get breathes: " + h1.getBreathes());
        outln("Get eats: " + h1.getEats());
        outln("Get arms: " + h1.getArms());
        outln("Get legs: " + h1.getLegs());
        outln("Get heads: " + h1.getHeads());
        outln("Get ears: " + h1.getEars());
        outln("Get eyes: " + h1.getEyes());
        
    }
    
    /**
     *Shortens the System.out.println() statement.
     */
    private void outln(Object o){
        System.out.println(o);
    }
    
}
