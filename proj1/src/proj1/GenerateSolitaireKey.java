/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj1
 * Date Assigned:   Monday, 5 March 2007, 10:05 AM
 * Due date:        Monday, 19 March 2007, 10:00 PM
 * Description:
 * This class keys a deck of cards and stores the resulting deck in a file.
*/

package proj1;

import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * This class keys a deck of cards and stores the resulting deck in a file.
 * @author Mark
 */
public class GenerateSolitaireKey{
    
    /**
     *This represents if everything went ok, it will be true if so.
     */
    public boolean success = false;
    
    /**
     *Prompts the user for a keyed-file name, and writes to the file with a 
     * solitaire key (shuffled deck/keyed-deck).
     */
    public static void main(String args[]){
        JOptionPane.showMessageDialog(null, "This program will generate a keyed-file.");
        String file_path = JOptionPane.showInputDialog(null, "Please input name of file to create: ");        
        GenerateSolitaireKey gsk = new GenerateSolitaireKey(file_path);
        if(gsk.success){
            JOptionPane.showMessageDialog(null, "The file " + file_path + " was written to successfully.");
        }
    }
    
    /**
     *Does nothing
     */
    private GenerateSolitaireKey(){}
    
    /** Creates a deck of cards, shuffles them randomly, then writes them to a file. */
    public GenerateSolitaireKey(String keyed_deck_file) {
        Card cards[] = new Card[54];
        TreeSet deck = new TreeSet();
        PrintWriter writer = null;
        
        try{
            writer = new PrintWriter(new BufferedWriter(new FileWriter(keyed_deck_file)));
        }catch(IOException ioe){
            halt("IOException: Cannot open " + keyed_deck_file + " for writing.");
        }        
        
        if(writer == null) halt("PrintWriter is NULL.");
        
        initializeCards(cards);        
        addCardsToTreeSet(deck, cards);        
        outputCardsToFile(writer, deck);        
        writer.close();
        success = true;
    }
    
    /**
     *Goes through the deck and writes them to the file that is opened by
     *the writer.
     */
    private void outputCardsToFile(PrintWriter writer, TreeSet deck){
        Card temp;
        Iterator<Card> iterator = deck.iterator();
        
        while(iterator.hasNext()){
            temp = (Card)iterator.next();
            writer.println(temp.suit + " " + temp.value);
        }
    }
    
    /**
     *Takes an array of cards and adds them to a TreeSet, sorting them by the
     *random key
     */
    private void addCardsToTreeSet(TreeSet deck, Card cards[]){
        for(int i = 0; i < cards.length; i++){
            deck.add(cards[i]);
        }
    }
    
    /**
     *Initializes a deck of cards
     */
    private void initializeCards(Card cards[]){
        int counter=0;
        int innerlimit=13;
        
        for(int i = 1; i <= 5; i++){
            if(i == 5) innerlimit=2;
            for(int j = 1; j <= innerlimit; j++){
                cards[counter++] = new Card(i,j);
            }
        }
    }
    
    /**
     * Called when there is an unrecoverable error, prints a warning message and
     * exits.
     */
    private void halt(String message){
        System.out.println(message);
        System.out.println("Exiting.");
        System.exit(0);
    }

    /**
     *Represents a card from a deck, with a randomized key.
     */
    private class Card implements Cloneable, Comparable{
        
        /**
         *Random key for this card.
         */
        public long key;
        
        /**
         *Suit of this card.
         */
        public int suit;
        
        /**
         *Value of this card.
         */
        public int value;
        
        /**
         *Initializes a card to "suit" and "value" and also generates a random key
         */
        public Card(int suit, int value){
            this.suit = suit;
            this.value = value;
            key = (long) (Math.random() * 1000000);
        }
        
        /**
         *Check two cards for equality
         */
        public boolean equals(Object obj) {
            Card temp = (Card)obj;
            if(this.key == temp.key && this.suit == temp.suit && this.value == temp.value)
                return true;
            else return false;
        }

        /**
         *Compare two cards, returns 0 if they are equal, -1 if it is less than,
         *1 if it is greater than.
         */
        public int compareTo(Object o) {
            Card temp = (Card)o;
            
            if(this.key < temp.key) return -1;
            else if(this.key == temp.key) return 0;
            else return 1;
        }        
    }
}
