import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFile {

    // @Test
    // public void testCommandInput(){
    //     char [] expected={'f', 'b', 'r', 'l', 'u', 'd'};
    //     Chandrayaan3.readCommands();
    //     assertArrayEquals(Chandrayaan3.charArray, expected);
    // }

    // @Test
    // public void testInitialCoordinates(){
    //     Chandrayaan3.readInitialCoordinates();
    // }

    // @Test
    // public void testDirection(){
    //     Chandrayaan3.readDirection();
    // }

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
        char[] commands = {'f', 'r', 'f', 'b', 'l'};
        int[] position = {0, 0, 0};
        Lander lander = new Lander('N', commands, position);
        lander.execute();
        int[] expectedPosition = {1, 1, 1};
        assertEquals(expectedPosition[0], lander.position[0]);
        assertEquals(expectedPosition[1], lander.position[1]);
        assertEquals(expectedPosition[2], lander.position[2]);
        assertEquals('E', lander.face);
    }

}
