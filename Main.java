package JavaLabH7TurtleProje;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        TurtleGraphics t = new TurtleGraphics();
        int selection = 0;
        String entry[];

        while (selection != 9){
            System.out.println("\n---Turtle Project---\n 1  : Pen Up \n 2  : Pen Down \n 3  : Turn Right \n 4  : Turn Left \n 5,x: Move x \n 6  : Display \n 9  : End ");
            System.out.print(" Selection: ");
            entry=input.nextLine().split(","); // split fonx diziyi istedigimiz sekilde boler. Biz "," ile bolduk.
            // Kullanici 5,6 dediginde 5 sayisi hareket ettirir. 6 ise gidecegi miktari belirtir.
            selection = Integer.parseInt(entry[0]);
            switch (selection){
                case 1: t.penUp();
                    break;
                case 2: t.penDown();
                    break;
                case 3: t.turnRight();
                    break;
                case 4: t.turnLeft();
                    break;
                case 5: t.move(Integer.parseInt(entry[1]));
                    break;
                case 6: t.display();
                    break;
                case 9: t.display();
                    break;
                default:
                    System.out.println("Unknow Selection !");
            }
        }


    }
}

