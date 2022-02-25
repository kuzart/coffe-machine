
public class MakeCoffee {

    public static void main(String[] args) {
            CoffeeMachine cm = new CoffeeMachine(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
            cm.start();
    }
}
