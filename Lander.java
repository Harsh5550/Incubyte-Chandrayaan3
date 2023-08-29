public class Lander{
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
