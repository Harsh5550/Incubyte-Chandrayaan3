import java.util.Scanner;

public class Input {

    private static Scanner scanner=new Scanner(System.in);

    //Function to take input from user
    public void readInput(){
        readCommands();
        readInitialCoordinates();
        readDirection();
    }

    //Function to check validity of command character
    private boolean checkValidCommand(char c){
        return c == 'f' || c == 'r' || c == 'u' || c == 'b' || c == 'l' || c=='d';
    }

    //Function to check validity of command character
    private boolean checkValidDirection(char c){
        return c == 'N' || c == 'S' || c == 'E' || c == 'W' || c == 'U' || c=='D';
    }

    public void readDirection(){

        //Fetching initial direction
        System.out.print("Enter initial direction: ");
        char dir = scanner.next().charAt(0);
        if(checkValidDirection(dir)){
            Variables.direction=dir;
        }
        else{
            System.out.println("Invalid Direction");
            System.exit(0);
        }
        
    }

    public void readInitialCoordinates(){
        
        //Fetching initial co-ordinates
        System.out.print("Enter initial co-ordinates: ");
        
        Variables.intArray = new int[3];
        
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter co-ordinate at index " + i + ": ");
            Variables.intArray[i] = scanner.nextInt();
            scanner.nextLine();
        }

    }

    public void readCommands(){
        
        System.out.print("Enter the length of the character array: ");
        int length = scanner.nextInt();
        
        scanner.nextLine(); // Consume newline left in the buffer
        
        //Fetching commands
        Variables.charArray = new char[length];
        
        for (int i = 0; i < length; i++) {
            System.out.print("Enter character at index " + i + ": ");
            char c = scanner.nextLine().charAt(0);
            if(checkValidCommand(c)){
                Variables.charArray[i] = c;
            }
            else{
                System.out.println("Invalid Command");
                System.exit(0);
                break;
            }
        }

    }
}
