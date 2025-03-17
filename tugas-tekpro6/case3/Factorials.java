// ****************************************************************
// Factorials.java
// Reads integers from the user and prints the factorial of each.
//
// ****************************************************************
import java.util.Scanner;
public class Factorials{
    public static void main(String[] args){
        String keepGoing = "y";
        Scanner scan = new Scanner(System.in);
        // while (keepGoing.equals(“y”) || keepGoing.equals(“Y”)){
        //     System.out.print("Enter an integer: ");
        //     int val = scan.nextInt();
        //     System.out.println("Factorial(" + val + ") = "+ MathUtils.factorial(val));
        //     System.out.print("Another factorial? (y/n) ");
        //     keepGoing = scan.next();
        // }
        
        while (keepGoing.equals("y") || keepGoing.equals("Y")) {
            System.out.print("Enter an integer: ");
            int val = scan.nextInt();
            try {
                System.out.println("Factorial(" + val + ") = " + MathUtils.factorial(val));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Another factorial? (y/n) ");
            keepGoing = scan.next();
        }
    }
}


// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// ****************************************************************
class MathUtils{
    //-------------------------------------------------------------
    // Returns the factorial of the argument given
    //-------------------------------------------------------------
    public static int factorial(int n){
        
        if (n < 0) {
            throw new IllegalArgumentException("integer negatif tidak dapat difaktorialkan.");
        }
        if (n > 16) {
            throw new IllegalArgumentException("nilai faktorialnya terlalu besar untuk sebuah integer (n harus <= 16).");
        }

        int fac = 1;
        for (int i=n; i>0; i--)
            fac *= i;
        return fac;
    }
}
