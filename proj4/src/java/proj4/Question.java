/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj4
 * Date Assigned:   Thursday, 12 April 2007, 4:10 PM
 * Due date:        Friday, 4 May 2007, 10:00 PM
 * Description:
 * This is a temporary storage datatype for the questions read from the database.
 * It is basically a linked list.
 */

package proj4;

/**
 * This is a temporary storage datatype for the questions read from the database.
 * It is basically a linked list.
 * @author mark
 */
public class Question {
    
    private String question;
    private String correctAnswer;
    private String a,b,c,d;
    private Question next;
    private Question prev;

    /** Creates a new instance of Question */
    public Question() {
    }
    
    /**
     *Set the question
     */
    public void setQ(String q){
        question = q;
    }
    
    /**
     *Get the question
     */
    public String getQ(){
        return question;
    }
    
    /**
     *Set the answer
     */
    public void setA(String a){
        this.correctAnswer = a;
    }
    
    /**
     *Get the answer.
     */
    public String getA(){
        return this.correctAnswer;
    }
    
    /**
     *Set the choice
     */
    public void setChoiceA(String choice){
        this.a = choice;
    }
    
    /**
     *Get the choice
     */
    public String getChoiceA(){
        return this.a;
    }

    /**
     *Set the choice
     */
    public void setChoiceB(String choice){
        this.b = choice;
    }
    
    /**
     *Get the choice
     */
    public String getChoiceB(){
        return this.b;
    }
    
    /**
     *Set the choice
     */
    public void setChoiceC(String choice){
        this.c = choice;
    }
    
    /**
     *Get the choice
     */
    public String getChoiceC(){
        return this.c;
    }
    
    /**
     *Set the choice
     */
    public void setChoiceD(String choice){
        this.d = choice;
    }
    
    /**
     *Get the choice
     */
    public String getChoiceD(){
        return this.d;
    }    
    
    /**
     *Set the pointer to the next question.
     */
    public void setNext(Question next){
        this.next = next;
    }
    
    /**
     *Get the pointer to the next question.
     */
    public Question getNext(){
        return this.next;
    }
    
    /**
     *Set the pointer to the previous question.
     */
    public void setPrev(Question prev){
        this.prev = prev;
    }
    
    /**
     *Get the pointer to the previous question.
     */
    public Question getPrevt(){
        return this.prev;
    }    
}
