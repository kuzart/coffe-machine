
import java.util.Scanner;

class CoffeeMachine {

    static Scanner scan = new Scanner(System.in);
    private final int coffee_R;
    private final int milk_R;
    private final int water_R;
    private int coffee, milk, water;

    public CoffeeMachine(int coffee_R, int water_R, int milk_R) {
        this.coffee_R = coffee_R;
        this.water_R = water_R;
        this.milk_R = milk_R;
    }

    private void water(int waterVolume) {
        if (waterVolume <= this.water_R) {
            this.water = waterVolume;
        } else {
            System.out.println("Объем резервуара для воды кофемашины (мл) " +  this.water_R);
            System.out.println("Введите меньшее значение ");
        }
    }

    private void milk(int milkVolume) {
        if (milkVolume <= this.milk_R) {
            this.milk = milkVolume;
        } else {
            System.out.println("Объем резервуара для молока кофемашины (мл) " +  this.milk_R);
            System.out.println("Введите меньшее значение ");
        }
    }

    private void coffee(int coffeeVolume) {
        if (coffeeVolume <= this.coffee_R) {
            this.coffee = coffeeVolume;
        } else {
            System.out.println("Объем резервуара для кофе кофемашины (мл) " +  this.coffee_R);
            System.out.println("Введите меньшее значение ");
        }
    }

    private void latte(int lateVolume){
        if(lateVolume < 10) return;
        int quoCoffee = (int)Math.round(0.1 * lateVolume);
        int quoWater = (int)(Math.round(0.3 * lateVolume));
        int quoMilk = (int)(Math.round(0.6 * lateVolume));
        if(coffee >= quoCoffee && water >= quoWater && milk >= quoMilk){
            coffee -= quoCoffee;
            water -= quoWater;
            milk -= quoMilk;
            getStatus();

        }else {
            System.out.println("Недостаточное количество ингридиентов");
            getStatus();
        }
    }

    private void cappuccino(int capVolume){
        if(capVolume < 10) return;
        int quoCoffee = (int)Math.round(0.15 * capVolume);
        int quoWater = (int)(Math.round(0.4 * capVolume));
        int quoMilk = (int)(Math.round(0.45 * capVolume));
        if(coffee >= quoCoffee && water >= quoWater && milk >= quoMilk){
            coffee -= quoCoffee;
            water -= quoWater;
            milk -= quoMilk;
            getStatus();
        }else {
            System.out.println("Недостаточное количество ингридиентов");
            getStatus();
        }
    }

    private void ristretto(int risVolume){
        if(risVolume < 10) return;

        int quoCoffee = (int)Math.round(0.5 * risVolume);
        int quoWater = (int)(Math.round(0.5 * risVolume));
        if(coffee >= quoCoffee && water >= quoWater){
            coffee -= quoCoffee;
            water -= quoWater;
            getStatus();

        }else {
            System.out.println("Недостаточное количество ингридиентов");
            getStatus();
        }
    }

    private void lungo(int lungoVolume){
        if(lungoVolume < 10) return;
        int quoCoffee = (int)Math.round(0.15 * lungoVolume);
        int quoWater = (int)(Math.round(0.85 * lungoVolume));
        if(coffee >= quoCoffee && water >= quoWater){
            coffee -= quoCoffee;
            water -= quoWater;
            getStatus();

        }else {
            System.out.println("Недостаточное количество ингридиентов");
            getStatus();
        }
    }

    private void espresso(int espVolume){
        if(espVolume < 10) return;
        int quoCoffee = (int)Math.round(0.3 * espVolume);
        int quoWater = (int)(Math.round(0.7 * espVolume));
        if(coffee >= quoCoffee && water >= quoWater){
            coffee -= quoCoffee;
            water -= quoWater;
            getStatus();

        }else {
            System.out.println("Недостаточное количество ингридиентов");
            getStatus();
        }
    }

    private void getStatus(){
        System.out.println( this.coffee + " " +  this.water + " " + this.milk);

    }

    public void start() {

        while (true) {
               String input = scan.nextLine();
               if(input.equalsIgnoreCase("turn off")){
                   System.out.println("Отключение...");
                   break;
               }
               String [] ar = input.split(" ");

            switch (ar[0]) {
                case "water":
                    water(Integer.parseInt(ar[1]));
                    break;
                case "milk":
                    milk(Integer.parseInt(ar[1]));
                    break;
                case "coffee":
                    coffee(Integer.parseInt(ar[1]));
                    break;
                case "latte":
                    latte(Integer.parseInt(ar[1]));
                    break;
                case "cappuccino":
                    cappuccino(Integer.parseInt(ar[1]));
                    break;
                case "ristretto":
                    ristretto(Integer.parseInt(ar[1]));
                    break;
                case "lungo":
                    lungo(Integer.parseInt(ar[1]));
                    break;
                case "espresso":
                    espresso(Integer.parseInt(ar[1]));
                    break;

            }
        }
    }
}