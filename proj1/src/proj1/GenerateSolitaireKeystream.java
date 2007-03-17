/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj1
 * Date Assigned:   Monday, 5 March 2007, 10:05 AM
 * Due date:        Monday, 19 March 2007, 10:00 PM
 * Description:
 * This class reads from a keyed_deck file and loads the contents into an ArrayList
 * where the user can generate keystream letters based on the solitaire algorithm.
*/

package proj1;

import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * This class reads from a keyed_deck file and loads the contents into an ArrayList
 * where the user can generate keystream letters based on the solitaire algorithm.
 * @author Mark
 */
public class GenerateSolitaireKeystream{
    
    /**
     *The deck of cards we load from a file.
     */
    private ArrayList<Card> deck;
    
    /**
     *The iterator for the deck of cards.
     */
    private ListIterator<Card> deck_iterator;
    
    /**
     * Creates a new instance of GenerateSolitaireKeystream and runs it
     * in the interactive mode, allowing the user to generate a keystream.
     */
    public static void main(String args[]){
        JOptionPane.showMessageDialog(null, "This program will generate keystream letters.");
        String file_path = JOptionPane.showInputDialog(null, "Please input name of file for keyed-deck: ");        
        GenerateSolitaireKeystream gsk = new GenerateSolitaireKeystream(file_path);
        int times = Integer.parseInt(JOptionPane.showInputDialog(null, "Number of characters to produce?"));
        String keystream="";
        if(times > 0){
            for(int i = 0; i < times; i++){
                keystream += gsk.getKeystreamValue();
            }
        }
        JOptionPane.showMessageDialog(null, "Keystream is: " + keystream);
   }
    
    
    /**
     *Opens a reader to the file specified in the constructore. If the file DNE,
     *then the program prints an error message and halts, otherwise it passes
     *processing of the file to readDeck()
     */
    public GenerateSolitaireKeystream(String file_path_to_keyed_deck){
        Card cards[] = new Card[54];
        BufferedReader reader = null;
        deck = new ArrayList();
        
        try{
            reader = new BufferedReader(new FileReader(file_path_to_keyed_deck));
        }catch(FileNotFoundException fnfe){
            halt("FileNotFoundException: Loading file.");
        }
        
        if(reader != null) readDeck(reader, cards);
        else halt("BufferedReader is NULL.");
        try{
            reader.close();
        }catch(IOException ioe){
            System.out.println("IOException: Closing file.");
        }
        
        addCardsToArrayList(deck, cards);         
    }
    
    /**
     *This uses the solitaire algorithm and shuffles up the cards that have been
     *loaded into the deck, and produces an output keystream character.
     */
    public String getKeystreamValue(){
        boolean loopagain = true;
        String letter="";
        do{
            
        boolean keepgoing = true;
        int index1,index2, jka_index=-1, jkb_index=-1;
        Card tmp;
        ArrayList<Card> tmp_deck = new ArrayList();
        deck_iterator = deck.listIterator();
        
        //find the A joker and move it one card down.
        do{
            if(deck_iterator.hasNext()){
                tmp = deck_iterator.next();
                if(tmp.getLetterValue().equals("JKA")){
                    index1 = deck_iterator.nextIndex()-1;
                    index2 = index1 + 1;
                    jka_index = index1;
                    if(!deck_iterator.hasNext()) index2 = 0;
                    swap(index1, index2);
                    keepgoing = false;
                }
            }
            else{
                keepgoing = false;
            }
        }while(keepgoing);
        // reset variables
        keepgoing = true;
        deck_iterator = deck.listIterator();
        
        //find the B joker and move it two cards down.
        do{
            if(deck_iterator.hasNext()){
                tmp = deck_iterator.next();
                if(tmp.getLetterValue().equals("JKB")){
                    index1 = deck_iterator.nextIndex()-1;
                    index2 = deck_iterator.nextIndex()+1;
                    jkb_index = index1;
                    if(!deck_iterator.hasNext()) index2 = 1;
                    else{
                        deck_iterator.next();
                        if(!deck_iterator.hasNext()) index2 = 0;
                    }
                    swap(index1, index2);
                    keepgoing = false;
                }
            }
            else{
                keepgoing = false;
            }
        }while(keepgoing);
        
        // perform triple cut
        if(jka_index < jkb_index){ 
            index1 = jkb_index;
            index2 = jka_index;
        }
        else{
            index1 = jka_index;
            index2 = jkb_index;
        }
        deck_iterator = deck.listIterator(index1+1);
        while(deck_iterator.hasNext()){
            tmp_deck.add(deck_iterator.next());
        }
        deck_iterator = deck.listIterator(index2);
        while(deck_iterator.hasNext() && deck_iterator.nextIndex() != (index1+1)){
            tmp_deck.add(deck_iterator.next());
        }
        deck_iterator = deck.listIterator();
        while(deck_iterator.hasNext() && deck_iterator.nextIndex() != (index2+1)){
            tmp_deck.add(deck_iterator.next());
        }
        deck = tmp_deck;
        
        // perform count cut
        keepgoing = true;
        int total=-1;
        deck_iterator = deck.listIterator();
        while(keepgoing){
            deck_iterator.next();
            if(deck_iterator.hasNext()){
                total = deck_iterator.nextIndex();
            }
            else keepgoing = false;
        }
        index1 = deck.get(total).getNumber();
        deck_iterator = deck.listIterator(index1+1);
        tmp_deck = new ArrayList();
        while(deck_iterator.nextIndex() != total){
            tmp_deck.add(deck_iterator.next());
        }
        deck_iterator = deck.listIterator();
        while(deck_iterator.nextIndex() != (index1+1)){
            tmp_deck.add(deck_iterator.next());
        }
        tmp_deck.add(deck.get(total));
        deck = tmp_deck;
        
        //find output card
        index1 = deck.get(0).getNumber();
        deck_iterator = deck.listIterator(index1);
        tmp = deck_iterator.next();
        
        if(tmp.getLetterValue().equals("JKA") || tmp.getLetterValue().equals("JKB")){
            loopagain = true;
        }
        else{
            loopagain = false;            
            letter = tmp.getAlphabetValue();
        }
        
        }while(loopagain);        
        
        return letter;
    }
    
    /**
     *Swaps two elements in the deck ArrayList
     */
    private void swap(int index1, int index2){
        Card tmp;
        tmp = deck.get(index1);
        deck.set(index1, deck.get(index2));
        deck.set(index2, tmp);
    }
    
    /**
     *Adds the deck of cards to an ArrayList
     */
    private void addCardsToArrayList(ArrayList arrayList, Card cards[]){
        for(int i = 0; i < cards.length; i++){
            arrayList.add(cards[i]);
        }
    }
    
    /**
     *Reads a keyed deck from a file. The reader should already be initialized.
     */
    private void readDeck(BufferedReader reader, Card cards[]){
        int count=0;
        try{
            String line;
            while((line = reader.readLine()) != null){
                String card[] = line.split(" ");
                cards[count++] = new Card(Integer.parseInt(card[0]), Integer.parseInt(card[1]));
            }
        }catch(IOException ioe){
            halt("IOException: Reading from keyed_deck_file.");
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
     *Represents a record of a card
     */
    private class Card extends CharacterConversion implements Cloneable{
        /**
         *Suit of the card.
         */
        public int suit;
        /**
         *Value of the card.
         */
        public int value;
        
        /**
         *Initialize a card to a suit and value
         */
        public Card(int suit, int value){
            this.suit = suit;
            this.value = value;
        }
        
        /**
         *Returns the letter value of this card.
         */
        public String getLetterValue(){
            if(suit >= 1 && suit <= 4){
                if(value==1) return "A";
                else if(value==11) return "J";
                else if(value==12) return "Q";
                else if(value==13) return "K";
                else return Integer.toString(value);
            }
            else{
                if(value==1) return "JKA";
                else return "JKB";                        
            }
        }
        
        /**
         *Uses bridge order to determine number of this card.
         */
        public int getNumber(){
            // clubs, diamonds, hearts, spades
            if(suit != 5)
                return (suit-1)*13 + value;
            else return 53;
        }
        
        /**
         *Returns the alphabet value of the card in bridge order.
         */
        public String getAlphabetValue(){
            if(suit == 1 || suit == 3){
                return convertIntToEquivalentChar(value);
            }
            else{
                return convertIntToEquivalentChar(value + 13);
            }
        }
    }
}
