package JavaLabH7TurtleProje;

import java.awt.Point; //koordinat icin gereken bir class

public class TurtleGraphics {
/*
  & English
     -Let's imagine that a turtle is walking around the room and holding a pencil in its hand.If the position of the pen is above, the turtle is below
     we think he didn't leave a trace, he left a trace below.
     -This application shows where the turtle travels in the old places. he will show.
     -Create a 20x20 matrix room for this.The turtle will start at the (0,0) point.The commands are:
 & Turkish
     -Bir kaplumbaganin odada gezdigini ve bir de elinde bir kalem tuttugunu dusunelim.Kalemin pozisyonu yukaridaysa kaplumbaganin asagiya
     iz birakmadigini, asagidaysa iz biraktigini dusunuyoruz.
     -Bu uygulama kaplumbaganin gezdigi yerlerde nerelerin cizilmis old. gosterecektir.
     -Bunun icin 20x20 matrix odasi olusturun.Kaplumbaga (0,0) noktasinda baslayacaktir.Komutlar sunlardir:

        1    --> Pen Up
        2    --> Pen Down
        3    --> Turn Right
        4    --> Turn Left
        5,10 --> Move forward 10 spaces //hareket ettir
        6    --> Display the 20x20 array //yazdir
        9    --> End
*/

    int room[][];
    enum PenStates {UP,DOWN};
    PenStates penStates;
    Point currentPos;
    enum Directions{UP,DOWN,RIGHT,LEFT};
    Directions currentDirections;

    public TurtleGraphics(){
        room = new int[20][20];
        penStates = PenStates.UP; // baslangictaki kalemin durumu
        currentPos = new Point(0,0); // baslangic konumu
        currentDirections = Directions.RIGHT; // baslangic durumu sagda
    }

    public void penUp(){
        penStates = PenStates.UP;
    }
    public void penDown(){
        penStates = PenStates.DOWN;
        room[currentPos.y][currentPos.x]=1; // 1 old. cizer 0 old. cizmez!
    }

    public void turnRight(){
        if(currentDirections == Directions.UP)
            currentDirections = Directions.RIGHT;
        else if(currentDirections == Directions.RIGHT)
            currentDirections = Directions.DOWN;
        else if(currentDirections == Directions.DOWN)
            currentDirections = Directions.LEFT;
        else
            currentDirections = Directions.UP;
    }

    public void turnLeft(){
        if(currentDirections == Directions.DOWN)
            currentDirections = Directions.RIGHT;
        else if(currentDirections == Directions.LEFT)
            currentDirections = Directions.DOWN;
        else if(currentDirections == Directions.UP)
            currentDirections = Directions.LEFT;
        else
            currentDirections = Directions.UP;
    }

    public void move(int space){//parametre gidecegi birimi ifade ediyor.
        if(currentDirections == Directions.RIGHT){
            if(penStates == PenStates.DOWN)
                for(int i=1; i<=space; i++)
                    room[currentPos.y][currentPos.x + i] = 1;
            currentPos.x += space ;
        }
        else if (currentDirections == Directions.LEFT){
            if(penStates == PenStates.DOWN)
                for(int i=1; i<=space; i++)
                    room[currentPos.y][currentPos.x - i] = 1;
            currentPos.x -= space ;
        }
        else if(currentDirections == Directions.UP){
            if(penStates == PenStates.DOWN)
                for(int i=1; i<=space; i++)
                    room[currentPos.y - i][currentPos.x] = 1;
            currentPos.y -=space;
        }
        else if(currentDirections == Directions.DOWN){
            if(penStates == PenStates.DOWN)
                for (int i=1; i<=space; i++)
                    room[currentPos.y + i][currentPos.x] = 1;
            currentPos.y +=space;
        }
    }

    public void display(){
        //top line
        for(int i=0; i< room.length; i++){
            System.out.print("___");
        }
        System.out.println();

        for(int i=0; i< room.length; i++){
            System.out.print("|");
            for(int j=0; j< room.length; j++){
                if(room[i][j]==1){
                    System.out.print(" * ");
                }
                else
                    System.out.print("   ");
            }
            System.out.println("|");
        }

        //bottom line
        for (int i=0; i< room.length; i++)
            System.out.print("---");
        System.out.println();
    }

}
