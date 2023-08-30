import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.junit.Test;

public class TestFile {

    private static Input input=new Input();
    private static ByteArrayOutputStream outputStream= new ByteArrayOutputStream();

    //Testing if direction is read successfully
    @Test
    public void testReadDirection() {
        String simulatedInput = "N\n"; // Provide a valid direction
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        
        Input input = new Input();
        input.readDirection();

        // Verify that the direction was set correctly
        assertEquals('N', Variables.direction);
    }

    //Testing if direction is invalid
    @Test
    public void testInvalidDirection() {
        String simulatedInput = "X\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        input.readDirection();

        // Capture the output and assert the expected error message
        String output = outputStream.toString().trim();
        assertEquals("Invalid Direction", output);
    }

    //Testing if initial coordinates are valid
    @Test
    public void testValidInitialCoordinates() {
        // Simulate valid input for readInitialCoordinates
        String simulatedInput = "1\n2\n3\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        input.readInitialCoordinates();
        assertArrayEquals(new int[]{1, 2, 3}, Variables.intArray);
    }

    //Testing if commands are valid
    @Test
    public void testValidCommands() {
        // Simulate valid input for readCommands
        String simulatedInput = "4\nf\nr\nu\nb\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        input.readCommands();
        assertArrayEquals(new char[]{'f', 'r', 'u', 'b'}, Variables.charArray);
    }

    //Testing if commands are invalid
    @Test
    public void testInvalidCommand() {
        String simulatedInput = "5\nX\nf\nr\nu\nb\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        input.readCommands();
        String output = outputStream.toString().trim();
        assertEquals("Invalid Command", output);
    }


    //Testing constructor for Lander Class
    @Test
    public void testConstructor(){
        char arr[]={'f', 'r', 'u', 'b', 'l'};
        int intArr[]={0,0,0};
        Lander lander= new Lander('N', arr, intArr);

        //Testing if values has been set properly
        assertEquals(lander.face, 'N');
        assertArrayEquals(lander.position, intArr);
        assertArrayEquals(lander.commands, arr);
        assertEquals(lander.top, 'U');
    }

    //Testing if directions are set properly or not
    @Test
    public void testDirection(){
        char arr[]={'f', 'r', 'u', 'b', 'l'};
        int intArr[]={0,0,0};
        Lander lander=new Lander('N', arr, intArr);

        lander.setDirections('U', 'N');

        assertEquals(lander.opp, 'S');
        assertEquals(lander.left, 'W');
        assertEquals(lander.right, 'E');
        assertEquals(lander.bottom, 'D');
    }

    //Test Move function with Forward configuration
    @Test
    public void testMoveForwardSouth() {
        char[] commands = {'f', 'f', 'f'};
        int[] position = {0, 0, 0};
        Lander lander = new Lander('S', commands, position);
        lander.execute();
        int[] expectedPosition = {0, -3, 0};
        assertArrayEquals(expectedPosition, lander.position);
    }

    //Test Move Function with backword configuration
    @Test
    public void testMoveBackwardSouth() {
        char[] commands = {'b', 'b', 'b'};
        int[] position = {0, 0, 0};
        Lander lander = new Lander('S', commands, position);
        lander.execute();
        int[] expectedPosition = {0, 3, 0};
        assertArrayEquals(expectedPosition, lander.position);
    }

    //Test turn function with left configuration
    @Test
    public void testTurnLeftFromNorth() {
        char[] commands = {'l'};
        int[] position = {0, 0, 0};
        Lander lander = new Lander('N', commands, position);
        lander.execute();
        assertEquals('W', lander.face);
    }

    //Test turn function with right configuration
    @Test
    public void testTurnRightFromSouth() {
        char[] commands = {'r'};
        int[] position = {0, 0, 0};
        Lander lander = new Lander('S', commands, position);
        lander.execute();
        assertEquals('W', lander.face);
    }

    //Test turn function with up configuration
    @Test
    public void testTurnUpFromWest() {
        char[] commands = {'u'};
        int[] position = {0, 0, 0};
        Lander lander = new Lander('W', commands, position);
        lander.execute();
        assertEquals('U', lander.face);
    }

    //Test turn function with down configuration
    @Test
    public void testTurnDownFromNorth() {
        char[] commands = {'d'};
        int[] position = {0, 0, 0};
        Lander lander = new Lander('N', commands, position);
        lander.setDirections('W', 'N');
        lander.execute();
        assertEquals('E', lander.face);
    }

    //Testing full execution of Lander Class
    @Test
    public void testFullExecution() {
        char[] commands = {'f', 'r', 'u', 'b', 'l'};
        int[] position = {0, 0, 0};
        Lander lander = new Lander('N', commands, position);
        lander.execute();
        int[] expectedPosition = {0, 1, -1};
        assertEquals(expectedPosition[0], lander.position[0]);
        assertEquals(expectedPosition[1], lander.position[1]);
        assertEquals(expectedPosition[2], lander.position[2]);
        assertEquals('N', lander.face);
    }

}
