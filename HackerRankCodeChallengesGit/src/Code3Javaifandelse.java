import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Code3Javaifandelse {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if(n%2 != 0){
            System.out.println("Weird");
        }else if (n%2 == 0 )
        {
            if(n<5 && n>2)
            {
                System.out.println("Not Weird");
            }else if (n<=20 && n>6)
            {
                System.out.println("Weird");
            }else if (n>20) 
            {
                System.out.println("Not Weird");
            }
        }

        scanner.close();
    }
}
