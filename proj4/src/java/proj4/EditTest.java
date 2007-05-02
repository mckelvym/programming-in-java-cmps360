/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj4
 * Date Assigned:   Thursday, 12 April 2007, 4:10 PM
 * Due date:        Friday, 4 May 2007, 10:00 PM
 * Description:
 * This portion of the project allows the teacher log in securely to a database
 * and add questions to the test.
 */

package proj4;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Body;
import com.sun.rave.web.ui.component.Button;
import com.sun.rave.web.ui.component.Form;
import com.sun.rave.web.ui.component.Head;
import com.sun.rave.web.ui.component.Html;
import com.sun.rave.web.ui.component.Label;
import com.sun.rave.web.ui.component.Link;
import com.sun.rave.web.ui.component.Page;
import com.sun.rave.web.ui.component.StaticText;
import com.sun.rave.web.ui.component.TextArea;
import com.sun.rave.web.ui.component.TextField;
import javax.faces.FacesException;
import java.sql.*;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * This portion of the project allows the teacher log in securely to a database
 * and add questions to the test.
 */
public class EditTest extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    
    private Page page1 = new Page();
    
    public Page getPage1() {
        return page1;
    }
    
    public void setPage1(Page p) {
        this.page1 = p;
    }
    
    private Html html1 = new Html();
    
    public Html getHtml1() {
        return html1;
    }
    
    public void setHtml1(Html h) {
        this.html1 = h;
    }
    
    private Head head1 = new Head();
    
    public Head getHead1() {
        return head1;
    }
    
    public void setHead1(Head h) {
        this.head1 = h;
    }
    
    private Link link1 = new Link();
    
    public Link getLink1() {
        return link1;
    }
    
    public void setLink1(Link l) {
        this.link1 = l;
    }
    
    private Body body1 = new Body();
    
    public Body getBody1() {
        return body1;
    }
    
    public void setBody1(Body b) {
        this.body1 = b;
    }
    
    private Form form1 = new Form();
    
    public Form getForm1() {
        return form1;
    }
    
    public void setForm1(Form f) {
        this.form1 = f;
    }

    private StaticText staticText1 = new StaticText();

    public StaticText getStaticText1() {
        return staticText1;
    }

    public void setStaticText1(StaticText st) {
        this.staticText1 = st;
    }

    private TextArea question = new TextArea();

    public TextArea getQuestion() {
        return question;
    }

    public void setQuestion(TextArea ta) {
        this.question = ta;
    }

    private Label label1 = new Label();

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label l) {
        this.label1 = l;
    }

    private StaticText staticText2 = new StaticText();

    public StaticText getStaticText2() {
        return staticText2;
    }

    public void setStaticText2(StaticText st) {
        this.staticText2 = st;
    }

    private StaticText staticText3 = new StaticText();

    public StaticText getStaticText3() {
        return staticText3;
    }

    public void setStaticText3(StaticText st) {
        this.staticText3 = st;
    }

    private StaticText staticText4 = new StaticText();

    public StaticText getStaticText4() {
        return staticText4;
    }

    public void setStaticText4(StaticText st) {
        this.staticText4 = st;
    }

    private StaticText staticText5 = new StaticText();

    public StaticText getStaticText5() {
        return staticText5;
    }

    public void setStaticText5(StaticText st) {
        this.staticText5 = st;
    }

    private TextField a = new TextField();

    public TextField getA() {
        return a;
    }

    public void setA(TextField tf) {
        this.a = tf;
    }

    private TextField b = new TextField();

    public TextField getB() {
        return b;
    }

    public void setB(TextField tf) {
        this.b = tf;
    }

    private TextField c = new TextField();

    public TextField getC() {
        return c;
    }

    public void setC(TextField tf) {
        this.c = tf;
    }

    private TextField d = new TextField();

    public TextField getD() {
        return d;
    }

    public void setD(TextField tf) {
        this.d = tf;
    }

    private StaticText staticText6 = new StaticText();

    public StaticText getStaticText6() {
        return staticText6;
    }

    public void setStaticText6(StaticText st) {
        this.staticText6 = st;
    }

    private TextField answer = new TextField();

    public TextField getAnswer() {
        return answer;
    }

    public void setAnswer(TextField tf) {
        this.answer = tf;
    }

    private Button save = new Button();

    public Button getSave() {
        return save;
    }

    public void setSave(Button b) {
        this.save = b;
    }

    private Button quit = new Button();

    public Button getQuit() {
        return quit;
    }

    public void setQuit(Button b) {
        this.quit = b;
    }
    
    // </editor-fold>
    /**
     *Database connection for adding questions to the questions table.
     */
    private Connection connection;
    
    /**
     * <p>Construct a new Page bean instance.</p>Register the database driver, get
     * a connection.
     */
    public EditTest() {
        register();
        connection = getConnection(LoginInfo.url, LoginInfo.user, LoginInfo.pass);
        if(connection == null)
            return;
    }
    
    /**
     *Handles closing of database connection.
     */
    public void quit(){
        // close the connection to database
        try {
             connection.close();
        } catch(SQLException e) {
             //e.printStackTrace();
        }         
    }
    
    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     *
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
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
            log("EditTest Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }
    
    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    public void preprocess() {
    }
    
    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    public void prerender() {
    }
    
    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
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
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1)getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected proj4.SessionBean1 getSessionBean1() {
        return (proj4.SessionBean1)getBean("SessionBean1");
    }

    /**
     *Called when the save button is pressed. A new query is formed and the question
     *is inserted into the database then all the fields are cleared and the page is
     *reset.
     */
    public String save_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        try{
            Statement s = connection.createStatement();
            String query = "insert into questions (question, answer, a, b, c, d) values (" +
                    "'" + (String)question.getText() + "', " + 
                    "'" + (String)answer.getText() + "', " + 
                    "'" + (String)a.getText() + "', " + 
                    "'" + (String)b.getText() + "', " + 
                    "'" + (String)c.getText() + "', " + 
                    "'" + (String)d.getText() + "');";
            s.executeQuery(query);
        }
        catch(SQLException e){
            //return "case2";
        }
        question.setText("");
        a.setText("");
        b.setText("");
        c.setText("");
        d.setText("");
        answer.setText("");
        
        return "case1";
    }

    /**
     *Called when the quit button is pressed.
     */
    public String quit_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        quit();
        return "case2";
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

