public class Chandrayaan3 {
    public static void main(String[] args) {
        Input input=new Input();
        input.readInput();
        Lander lander=new Lander(Variables.direction, Variables.charArray, Variables.intArray);
        lander.execute();
    }
}