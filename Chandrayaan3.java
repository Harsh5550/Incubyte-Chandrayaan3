import java.util.Scanner;

public class Chandrayaan3 {

    private static char[] charArray;
    private static int[] intArray;
    private static char direction;

    //Function to take input from user
    private static void input(){
        Scanner scanner=new Scanner(System.in);
        
        System.out.print("Enter the length of the character array: ");
        int length = scanner.nextInt();
        
        // Consume the newline character left in the buffer
        scanner.nextLine();
        
        //Fetching commands
        charArray = new char[length];
        
        for (int i = 0; i < length; i++) {
            System.out.print("Enter character at index " + i + ": ");
            char c=scanner.nextLine().charAt(0);
            if(checkValidCommand(c)){
                charArray[i] = c;
            }
            else{
                System.out.println("Invalid Command");
                System.exit(0);
                break;
            }
        }

        //Fetching initial co-ordinates
        System.out.print("Enter initial co-ordinates: ");
        
        intArray = new int[3];
        
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter co-ordinate at index " + i + ": ");
            intArray[i] = scanner.nextInt();
            scanner.nextLine();
        }

        //Fetching initial direction
        System.out.print("Enter initial direction: ");
        char dir = scanner.next().charAt(0);
        if(checkValidDirection(dir)){
            direction=dir;
        }
        else{
            System.out.println("Invalid Direction");
            System.exit(0);
        }
        
        scanner.close();
    }

    //Function to check validity of command character
    private static boolean checkValidCommand(char c){
        return c == 'f' || c == 'r' || c == 'u' || c == 'b' || c == 'l';
    }

    //Function to check validity of command character
    private static boolean checkValidDirection(char c){
        return c == 'N' || c == 'S' || c == 'E' || c == 'W' || c == 'U' || c=='D';
    }

    public static void main(String[] args) {
        input();
    }
}
