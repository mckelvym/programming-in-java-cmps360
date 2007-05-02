/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj4
 * Date Assigned:   Thursday, 12 April 2007, 4:10 PM
 * Due date:        Friday, 4 May 2007, 10:00 PM
 * Description:
 * This part of the project allows the student to take multiple choice questions
 * as a cumulative test and they can choose with radio buttons. When test is finished
 * a summary page is shown.
 */

package proj4;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Body;
import com.sun.rave.web.ui.component.Button;
import com.sun.rave.web.ui.component.DropDown;
import com.sun.rave.web.ui.component.Form;
import com.sun.rave.web.ui.component.Head;
import com.sun.rave.web.ui.component.Html;
import com.sun.rave.web.ui.component.Hyperlink;
import com.sun.rave.web.ui.component.Label;
import com.sun.rave.web.ui.component.Link;
import com.sun.rave.web.ui.component.Message;
import com.sun.rave.web.ui.component.Page;
import com.sun.rave.web.ui.component.RadioButton;
import com.sun.rave.web.ui.component.RadioButtonGroup;
import com.sun.rave.web.ui.component.StaticText;
import com.sun.rave.web.ui.component.TextArea;
import com.sun.rave.web.ui.component.TextField;
import com.sun.rave.web.ui.model.SingleSelectOptionsList;
import javax.faces.FacesException;
import java.sql.*;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 * This part of the project allows the student to take multiple choice questions
 * as a cumulative test and they can choose with radio buttons. When test is finished
 * a summary page is shown.
 */
public class TakeTest extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        answerDefaultOptions.setOptions(new com.sun.rave.web.ui.model.Option[] {new com.sun.rave.web.ui.model.Option("a", "Item 1"), new com.sun.rave.web.ui.model.Option("b", "Item 2"), new com.sun.rave.web.ui.model.Option("c", "Item 3"), new com.sun.rave.web.ui.model.Option("d", "display")});
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

    private StaticText staticText2 = new StaticText();

    public StaticText getStaticText2() {
        return staticText2;
    }

    public void setStaticText2(StaticText st) {
        this.staticText2 = st;
    }

    private Button next = new Button();

    public Button getNext() {
        return next;
    }

    public void setNext(Button b) {
        this.next = b;
    }
    
    // </editor-fold>
    
    /**
     *Session bean for questions and stats.
     */
    private SessionBean1 bean;
    
    private StaticText staticText3 = new StaticText();

    private RadioButtonGroup answer = new RadioButtonGroup();

    public RadioButtonGroup getAnswer() {
        return answer;
    }

    public void setAnswer(RadioButtonGroup rbg) {
        this.answer = rbg;
    }

    private SingleSelectOptionsList answerDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getAnswerDefaultOptions() {
        return answerDefaultOptions;
    }

    public void setAnswerDefaultOptions(SingleSelectOptionsList ssol) {
        this.answerDefaultOptions = ssol;
    }

    private TextField questionNum = new TextField();

    public TextField getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(TextField tf) {
        this.questionNum = tf;
    }

    private TextField percentage = new TextField();

    public TextField getPercentage() {
        return percentage;
    }

    public void setPercentage(TextField tf) {
        this.percentage = tf;
    }

    /**
     * <p>Construct a new Page bean instance.</p> Sets all the fields to blank or
     * their default values.
     */
    public TakeTest() {
        bean = (SessionBean1)this.getBean("SessionBean1"); 
        
        if(bean.getCountTotal() == 0){
            questionNum.setText("N/A");
            if(bean.getCountTotal() == 0){
                percentage.setText("0.00%");
            }
            else{
                percentage.setText(String.valueOf(100 * ((float)bean.getCount() / (float)bean.getCountTotal())) + "%");
            }
            question.setText("Please click next to begin test.");
            answer.setLabel("");
            answer.setItems(new com.sun.rave.web.ui.model.Option[] {
                //new com.sun.rave.web.ui.model.Option("a", ""), 
                //new com.sun.rave.web.ui.model.Option("b", ""), 
                //new com.sun.rave.web.ui.model.Option("c", ""), 
                //new com.sun.rave.web.ui.model.Option("d", "")
            });
        }
    }
        
    public StaticText getStaticText3() {
        return staticText3;
    }

    public void setStaticText3(StaticText st) {
        this.staticText3 = st;
    }

    private TextArea question = new TextArea();

    public TextArea getQuestion() {
        return question;
    }

    public void setQuestion(TextArea ta) {
        this.question = ta;
    }

    private StaticText staticText4 = new StaticText();

    public StaticText getStaticText4() {
        return staticText4;
    }

    public void setStaticText4(StaticText st) {
        this.staticText4 = st;
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
            log("TakeTest Initialization Failure", e);
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
    

    public void answer_processValueChange(ValueChangeEvent event) {
        // TODO: Replace with your code
        
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected proj4.SessionBean1 getSessionBean1() {
        return (proj4.SessionBean1)getBean("SessionBean1");
    }

    /**
     *Called when the next button is pressed. If there are no more questions then
     *it goes to the stats page, otherwise it sets up the fields and radio buttons
     *for the next question.
     */
    public String next_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        
        if(bean.getQuestion() == null){
            String msg = "You are done with the test\n" + 
                    "Out of " + bean.getCountTotal() + " questions\n" + 
                    "You got " + bean.getCount() + " right\n" +
                    "Final score is " + String.valueOf(100 * ((float)bean.getCount() / (float)bean.getCountTotal())) + "%";
            this.getSessionBean1().setMessage(msg); 
            question.setText(msg);
            return "case2";
        }
        
        questionNum.setText(String.valueOf(bean.getCountTotal() + 1));
        if(bean.getCountTotal() == 0){
            percentage.setText("0.00%");
        }
        else{
            percentage.setText(String.valueOf(100 * ((float)bean.getCount() / (float)bean.getCountTotal())) + "%");
        }
        question.setText(bean.getQuestion().getQ());
        answer.setLabel("Answer");
        answer.setItems(new com.sun.rave.web.ui.model.Option[] {
            new com.sun.rave.web.ui.model.Option("a", bean.getQuestion().getChoiceA()), 
            new com.sun.rave.web.ui.model.Option("b", bean.getQuestion().getChoiceB()), 
            new com.sun.rave.web.ui.model.Option("c", bean.getQuestion().getChoiceC()), 
            new com.sun.rave.web.ui.model.Option("d", bean.getQuestion().getChoiceD())});
        answer.setSelected(null);
        answer.setColumns(2);
        bean.setCountTotal(bean.getCountTotal() + 1);
        
        return "case1";
    }
    
    /**
     *Validation for the radio buttons, if the selected value is right then the
     *correct questions count is increased. Afterward the question pointer is
     *moved to the next one.
     */
    public void answer_validate(FacesContext context, UIComponent component, Object value) {
        // TODO: Replace with your code
        String selectValue = (String)value;
        
        if(bean.getCountTotal() != 0){            
            if(selectValue.equals(bean.getQuestion().getA())){
                bean.setCount(bean.getCount() + 1);
            }
        }
        
        bean.setQuestion(bean.getQuestion().getNext()); 
    }
    
}

