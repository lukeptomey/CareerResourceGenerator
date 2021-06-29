
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Retrieve class establishes connection to database with constructor and can
 * get values from the database.
 * 
 * @author lukeptomey
 */

public class Retrieve {
    private Connection conn;
    private final String url = "jdbc:postgresql://ec2-3-233-7-12.compute-1.amazonaws.com:5432/d5pqj8sk90bbb";
    private final String user = "jemwukbdtdbwly";
    private final String password = "10f23f5b5af171914b9981702253011916aa9dbd2a11ece20769493546bb0fa0";
    
    /**
     * Constructor
     */
    Retrieve(){
        
        //Connect to database with credentials above
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Create select sql statements based on the favorite activity and grade. 
     * Then print results to console.
     * 
     * @param activity what the user likes to do
     * @param grade what is the user grade level
     */
    public void getTableValues(String activity, String grade){
        try{

        String query = " ";

        //If computer science
        if(activity.equals("1")){
            if(grade.equals("1")){
                query = "select resource_type, name, link from careers where career_path = 'Computer Science'and grade_level = 'K-9'";
            }
            else if(grade.equals("2")){
                query = "select resource_type, name, link from careers where career_path = 'Computer Science'and grade_level = '9-12'";
            }
            else if (grade.equals("3")){
                query = "select resource_type, name, link from careers where career_path = 'Computer Science'and grade_level = 'PS/Industry'";

            }

        }
        //If biology
        if(activity.equals("2")){
            if(grade.equals("1")){
                query = "select resource_type, name, link from careers where career_path = 'Biology'and grade_level = 'K-9'";
            }
            else if(grade.equals("2")){
                query = "select resource_type, name, link from careers where career_path = 'Biology'and grade_level = '9-12'";

            }
            else if (grade.equals("3")){
                query = "select resource_type, name, link from careers where career_path = 'Biology'and grade_level = 'PS/Industry'";

            }


        }

        //Print result to console
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("Here are links to resources suggested by your intrest and grade level.");
        System.out.println();
            while (rs.next()){
                String resource = rs.getString("resource_type");
                String name = rs.getString("name");
                String link = rs.getString("link");

                System.out.print("Resource Type: " + resource);
                System.out.print(", Name: " + name);
                System.out.print(", Link: " + link);
                System.out.println();
            }
        }
        catch(Exception e){

        }
 
    }
}
