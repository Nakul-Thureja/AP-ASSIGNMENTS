package APAssignment4;

import java.util.*;

public class Game {
    private static Player myPlayer;
    private static Carpet myCarpet;
    private static Jump jumper;
    private static FastReader Reader = new FastReader();
    private static Scanner sc = new Scanner(System.in);
    private static HashMap<Integer,String> map = new HashMap<>();

    private static void play(){
        map.put(0,"First");
        map.put(1,"Second");
        map.put(2,"Third");
        map.put(3,"Fourth");
        map.put(4,"Fifth");
        System.out.println("Game is ready\n");
        try{
            for(int i=0;i<5;i++){
                boolean flag = true;
                while(flag) {
                    try {
                        System.out.print("Hit enter for your " + map.get(i) + " hop");
                        sc.nextLine();
                        jumper.jump();
                        int j = jumper.getJumpValue();
                        if (j <= 20) {
                            Tile tile = myCarpet.getTile(j);
                            System.out.println(tile);
                            if (tile.play()) {
                                myPlayer.AwardToy(tile.getMyToyClone());
                            }
                        } else {
                            System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!\n");
                        }
                        flag = false;
                    }
                    catch(IndexOutOfBoundsException e){
                        System.out.println("ArrayIndex out of bound");
                    }
                }
            }
            System.out.println("Game Over\n" + "Soft toys won by you are:");
            myPlayer.printSoftToys();
        }
        catch(CloneNotSupportedException e){
            System.out.println("Clone Not Supported for this soft toy");
        }
    }

    public static void main(String args[]){
        System.out.print("Hit enter to initialize the game");
        sc.nextLine();
        myPlayer = new Player();
        myCarpet = new Carpet();
        jumper = new Jump();
        play();
    }
}
