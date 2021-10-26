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
        Board.add(new EmptyFloor(12,1));
        Board.add(new EmptyFloor(13,1));
    }

    private static void play(Player player,Dice dice){
        Scanner sc = new Scanner(System.in);
        System.out.println("The game setup is ready");
        while(player.getLevel() < 13){
            System.out.println("Hit enter to roll dice");
            sc.nextLine();
            dice.roll();
            System.out.println(dice);
            if(player.check(dice.getFaceValue())){
                if(player.getLevel() == -1){
                    player.setLevel(player.getLevel()+ dice.getFaceValue());
                    Board.get(player.getLevel()).updatePoints(player);
                }
                else {
                    player.setLevel(player.getLevel() + dice.getFaceValue());
                    Board.get(player.getLevel()).updatePoints(player);
                }
                System.out.println(Board.get(player.getLevel()).toString(player));
                if(!(Board.get(player.getLevel()) instanceof EmptyFloor)) {
                    Board.get(player.getLevel()).updateLevel(player);
                    Board.get(player.getLevel()).updatePoints(player);
                    System.out.println(Board.get(player.getLevel()).toString(player));
                }
            }
            else{
                if(player.getLevel() == -1) {
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
        FastReader reader = new FastReader();
        System.out.println("Welcome to Snakes and Ladders");
        System.out.println("Enter the player name and hit enter");
        String name = reader.nextLine();
        Player player = new Player(name);
        Dice dice = new Dice();
        CreateBoard();
        play(player,dice);
    }
}
