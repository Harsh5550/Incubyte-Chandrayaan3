import org.junit.Test;
import org.junit.experimental.theories.ParametersSuppliedBy;

public class TestFile {

    @Test
    public void testCommandInput(){
        Chandrayaan3.readCommands();
    }

    @Test
    public void testInitialCoordinates(){
        Chandrayaan3.readInitialCoordinates();
    }

    @Test
    public void testDirection(){
        Chandrayaan3.readDirection();
    }

    @Test
    public void testConstructor(){
        char arr[]={'f', 'r', 'u', 'b', 'l'};
        int intArr[]={0,0,0};
        Lander lander= new Lander('N', arr, intArr);
        System.out.println(lander.commands);
        System.out.println(lander.face);
        System.out.println(lander.position);
        System.out.println(lander.top);
    }

}
