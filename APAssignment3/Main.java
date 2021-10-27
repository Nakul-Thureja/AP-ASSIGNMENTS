package APAssignment3;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static ArrayList<Floor> Board = new ArrayList<>();
    private static HashMap<Player,Integer> moves = new HashMap<>();

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

    private static void play(Dice dice){
        Scanner sc = new Scanner(System.in);
        FastReader reader = new FastReader();
        System.out.println("The game setup is ready");
        System.out.println("Enter number of players: ");
        int n = reader.nextInt();
        for(int i = 0;i<n;i++){
            System.out.println("-------------------------------------");
            System.out.println("Enter the player name and hit enter");
            String name = reader.nextLine();
            Player player = new Player(name);
            int move  = 0;      
            while(player.getLevel() < 13){
                System.out.println("Hit enter to roll dice");
                sc.nextLine();
                move++;
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
                        System.out.println("Game cannot start until you get 1\n");
                    }
                    else{
                        System.out.println("Player cannot move\n");
                    }
                }
            }
            moves.put(player,move);
            System.out.println("Game Over");
            System.out.println(player + "in " + moves.get(player) + " Moves");
        }
        System.out.println("-------------------------------------");
        int max_points = 0;
        int min_moves = Integer.MAX_VALUE;
        System.out.println("Final Performance: ");
        for(Player player : moves.keySet()){
            if(player.getPoints()>max_points){
                max_points = player.getPoints();
            }
            System.out.println(player + "in " + moves.get(player) + " Moves");
        }
        ArrayList<Player> players = new ArrayList<>();
        for(Player player : moves.keySet()){
            if(player.getPoints() == max_points){
                players.add(player);
                if(min_moves > moves.get(player)){
                    min_moves = moves.get(player);
                }
            }
        }
       
        System.out.println("\nWinner/Winners:");
        System.out.println("-------------------");
        int id = 1;
        for(int i=0;i<players.size();i++){
            if(moves.get(players.get(i))==min_moves){
                System.out.println(id + ". " + players.get(i) + "in " + moves.get(players.get(i)) + " Moves");
                id++;
            }
        }
    }

    public static void main(String args[]){
        System.out.println("Welcome to Snakes and Ladders");
        Dice dice = new Dice();
        CreateBoard();
        play(dice);
    }
}
