/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj4
 * Date Assigned:   Thursday, 12 April 2007, 4:10 PM
 * Due date:        Friday, 4 May 2007, 10:00 PM
 * Description:
 * This session bean keeps track of the information on the student testing side.
 * It keeps track of number of questions, number of questions right, and the questions
 * themselves. It also handles the responsibility from getting the questions out
 * of the database to begin with.
 */

package proj4;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import javax.faces.FacesException;
import java.sql.*;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 * This session bean keeps track of the information on the student testing side.
 * It keeps track of number of questions, number of questions right, and the questions
 * themselves. It also handles the responsibility from getting the questions out
 * of the database to begin with.
 */
public class SessionBean1 extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>
    
    /**
     *Message to the user once they are finished with the test.
     */
    private String message;
    
    /**
     *Count of questions right.
     */
    private int count = 0;
    
    /**
     *Count of total questions.
     */
    private int count_total = 0;
    
    /**
     *The question set.
     */
    private Question q;
    
    public void setMessage(String m){
        message = m;
    }
    
    public String getMessage(){
        return message;
    }
    
    public void setCount(int c){
        count = c;
    }
    
    public int getCount(){
        return count;
    }
    
    public void setCountTotal(int ct){
        count_total = ct;
    }
    
    public int getCountTotal(){
        return count_total;
    }
    
    public void setQuestion(Question q){
        this.q = q;
    }
    
    public Question getQuestion(){
        return q;
    }
    
    
    /**
     * <p>Construct a new session data bean instance.</p> Registers the database
     * driver and then reads the questions from the database.
     *
     */
    public SessionBean1() {
        register();
        message = "";
        q = readQuestions();
    }
    
    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     *
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
     */
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("SessionBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }
    
    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     *
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    public void passivate() {
    }
    
    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     *
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    public void activate() {
    }
    
    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1)getBean("ApplicationBean1");
    }
    
    /**
     *Reads questions from database and stores them in a temporary variable for
     *use later.
     */
    private Question readQuestions(){
        Connection connection = getConnection(LoginInfo.url, LoginInfo.user, LoginInfo.pass);

        String tmp;
        Question q = new Question();
        q.setPrev(null);
        q.setNext(null);
        
        try{
            // create a Statement object for query execution
            Statement s = connection.createStatement();
            // create a result object
            ResultSet r;
            
            
            // query to get Teacher password info and display of results
            r = s.executeQuery("select * from questions;");
            while(r.next()) {
                q.setQ(r.getString(1));
                q.setA(r.getString(2));
                q.setChoiceA(r.getString(3));
                q.setChoiceB(r.getString(4));
                q.setChoiceC(r.getString(5));
                q.setChoiceD(r.getString(6));
                q.setNext(new Question());
                q.getNext().setPrev(q);
                q.getNext().setNext(null);
                q = q.getNext();
            }
            q = q.getPrevt();
            q.setNext(null);
        }
        catch(SQLException e){
            e.printStackTrace();
            System.exit(1);
        }

        while(q.getPrevt() != null){
            q = q.getPrevt();
        }
        
        closeConnection(connection);
        return q;
    }   
    
    /**
     *Register Mckoi JDBC driver
     */
    private boolean register(){
        try {
            Class.forName("com.mckoi.JDBCDriver").newInstance();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     *Attempts to get a connection to the database
     */
    private Connection getConnection(String url, String user, String pass){
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            return null;
        }  
    }
    
    /**
     *Closes the connection to the database
     */
    private void closeConnection(Connection c){
        // close the connection to database
        try {
            c.close();
        } catch (SQLException e) {
            return;
        }  
    }            
}
