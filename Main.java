import java.util.Scanner;


/**
 * Main method it prints instructions to the console
 * 
 * @author lukeptomey
 */
public class Main{

    public static void main (String args[]){
        //Prompt the user with what they like to do
        System.out.println("What do you like to do? Enter the number of the activity you like the most.");
        System.out.println("1. Code");
        System.out.println("2. Interact with animals");
        Scanner input = new Scanner(System.in);
        String activityAnswer = input.nextLine();
        //Prompt the user with grade level
        System.out.println("What is your current grade level? Enter the number coresponding to your current grade level.");
        System.out.println("1. K-9");
        System.out.println("2. 9-12");
        System.out.println("3. PS/Industry");
        String gradeLevelAnswer = input.nextLine();
        //Establish connection with retrieve constructor
        Retrieve ret = new Retrieve();
        //Call getTableValues
        ret.getTableValues(activityAnswer,gradeLevelAnswer);
        //Close scanner
        input.close();
        
        



        
        
        //Parse String then call db method 

        //Arrow
     
       
      

    }
}