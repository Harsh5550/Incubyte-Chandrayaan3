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
        return c == 'f' || c == 'r' || c == 'u' || c == 'b' || c == 'l' || c=='d';
    }

    //Function to check validity of command character
    private static boolean checkValidDirection(char c){
        return c == 'N' || c == 'S' || c == 'E' || c == 'W' || c == 'U' || c=='D';
    }


    public static void main(String[] args) {
        input();
        Lander lander=new Lander(direction, charArray, intArray);
        lander.execute();
    }
}

class Lander{
    char face, top, bottom, left, right, opp;
    char[] commands;
    int [] position;
    
    Lander(char face, char[] commands, int[] position){
        this.face=face;
        this.commands=commands;
        this.position=position;

        if(face=='U' || face=='D'){
        top='N';
        }
        else{
            top='U';
        }
        setDirections(top, face);
    }

    void execute(){
        for(char c: commands){
            switch(c){
                case 'f': move(c); break;
                case 'b': move(c); break;
                default: turn(c); break;
            }
            System.out.println("Current Command: "+c);
            show();
        }
    }

    void show(){
        System.out.println("Face of Lander: "+face);
        System.out.println("Co-ordinates of Lander:");
        System.out.print("("+position[0]+","+position[1]+","+position[2]+")");
        System.out.println();
    }

    void move(char c){
        if(c=='f'){
            switch(face){
                case 'N': position[1]++; break;
                case 'S': position[1]--; break;
                case 'E': position[0]++; break;
                case 'W': position[0]--; break;
                case 'D': position[2]--; break;
                case 'U': position[2]++; break;
            }
        }
        else{
            switch(face){
                case 'N': position[1]--; break;
                case 'S': position[1]++; break;
                case 'E': position[0]--; break;
                case 'W': position[0]++; break;
                case 'D': position[2]++; break;
                case 'U': position[2]--; break;
            }
        }
    }

    void turn(char c){
        switch(c){
            case 'l':
                setDirections(top, left);
                break;
            case 'r': 
                setDirections(top, right);
                break;
            case 'u':
                setDirections(opp, top);;
                break;
            case 'd':
                setDirections(face, bottom);
                break;
        }
    }


    void setDirections(char top, char face){
        this.top=top;
        this.face=face;
        switch(face){
            case 'N':
                opp='S';
                switch (top) {
                    case 'U':
                        left='W';
                        right='E';
                        bottom='D';
                        break;
                    case 'D':
                        left='E';
                        right='W';
                         bottom='U';
                        break;
                    case 'W':
                        left='D';
                        right='U';
                         bottom='E';
                        break;
                    case 'E':
                        left='U';
                        right='D';
                         bottom='W';
                        break;
                    default:
                        break;
                };
                break;
            case 'S': 
                opp='N';
                switch (top) {
                    case 'D':
                        left='W';
                        right='E';
                         bottom='U';
                        break;
                    case 'U':
                        left='E';
                        right='W';
                         bottom='D';
                        break;
                    case 'E':
                        left='D';
                        right='U';
                         bottom='W';
                        break;
                    case 'W':
                        left='U';
                        right='D';
                         bottom='E';
                        break;
                    default:
                        break;
                };
                break;
            case 'E': 
            opp='W';
            switch (top) {
                    case 'U':
                        left='N';
                        right='S';
                         bottom='D';
                        break;
                    case 'D':
                        left='S';
                        right='N';
                         bottom='U';
                        break;
                    case 'N':
                        left='D';
                        right='U';
                         bottom='S';
                        break;
                    case 'S':
                        left='U';
                        right='D';
                         bottom='N';
                        break;
                    default:
                        break;
                };
                break;
            case 'W': opp='E';
            switch (top) {
                    case 'U':
                        left='S';
                        right='N';
                         bottom='D';
                        break;
                    case 'D':
                        left='N';
                        right='S';
                         bottom='U';
                        break;
                    case 'S':
                        left='D';
                        right='U';
                         bottom='N';
                        break;
                    case 'N':
                        left='U';
                        right='D';
                         bottom='S';
                        break;
                    default:
                        break;
                };
                break;
            
            case 'U': opp='D';
            switch (top) {
                    case 'S':
                        left='W';
                        right='E';
                         bottom='N';
                        break;
                    case 'N':
                        left='E';
                        right='W';
                         bottom='S';
                        break;
                    case 'W':
                        left='N';
                        right='S';
                         bottom='E';
                        break;
                    case 'E':
                        left='S';
                        right='N';
                         bottom='W';
                        break;
                    default:
                        break;
                };
                break;
            
                case 'D': opp='U';
                switch (top) {
                    case 'N':
                        left='W';
                        right='E';
                         bottom='S';
                        break;
                    case 'S':
                        left='E';
                        right='W';
                         bottom='N';
                        break;
                    case 'E':
                        left='N';
                        right='S';
                         bottom='W';
                        break;
                    case 'W':
                        left='S';
                        right='N';
                         bottom='E';
                        break;
                    default:
                        break;
                };
                break;
        }
    }
}
