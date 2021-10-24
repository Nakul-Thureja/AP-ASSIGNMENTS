package APAssignment3;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Floor> Board = new ArrayList<>();

    private static void CreateBoard(){
        Board.add(new EmptyFloor(0,1));
        Board.add(new EmptyFloor(1,1));
        Board.add(new ElevatorFloor(2,4));
        Board.add(new EmptyFloor(3,1));
        Board.add(new EmptyFloor(4,1));
        Board.add(new SnakeFloor(5,2));
        Board.add(new EmptyFloor(6,1));
        Board.add(new EmptyFloor(7,1));
        Board.add(new LadderFloor(8,2));
        Board.add(new EmptyFloor(9,1));
        Board.add(new EmptyFloor(10,1));
        Board.add(new CobraFloor(11,4));
        Board.add(new EmptyFloor(4,1));
        Board.add(new EmptyFloor(4,1));
    }

    private static void play(Player player,Dice dice){
        while(player.getLevel() < 13){
            System.out.println("The game setup is ready");
            System.out.println("Hit enter to roll dice");
            
            dice.roll();
            System.out.println(dice);
            if(player.check(dice.getFaceValue())){

                Board.get(player.getLevel()).updatePoints(player);
                Board.get(player.getLevel()).updateLevel(player);

            }
            else{
                if(Board.get(player.getLevel()).getLevel() == 0) {
                    System.out.println("Game cannot start until you get 1");
                }
                else{
                    System.out.println("Player cannot move");
                }
            }
        }
        System.out.println("Game Over");
        System.out.println(player);
    }

    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to Snakes and Ladders");
        System.out.println("Enter the player name and hit enter");
        String name = reader.next();
        Player player = new Player(name);
        Dice dice = new Dice();
        play(player,dice);
    }
}
