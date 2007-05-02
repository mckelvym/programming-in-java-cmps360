/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj4
 * Date Assigned:   Thursday, 12 April 2007, 4:10 PM
 * Due date:        Friday, 4 May 2007, 10:00 PM
 * Description:
 * Contains information about database creation. Has username and password for 
 * logging into database as well as proper URLs for connection.
 */

package proj4;

/**
 * Contains information about database creation. Has username and password for 
 * logging into database as well as proper URLs for connection.
 * @author mark
 */
public interface LoginInfo {
    public static String user = "admin";
    public static String pass = "teacher";
    public static String url_create = "jdbc:mckoi://localhost:9157/test.conf?create=true";        
    public static String url = "jdbc:mckoi://localhost:9157/test.conf?create=false";  
    
}
