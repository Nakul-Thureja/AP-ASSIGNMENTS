package APAssignment4;

import java.util.*;

public class Game {
    private static Player myPlayer;
    private static Carpet myCarpet;
    private static Jump jumper;
    private static FastReader Reader = new FastReader();
    private static Scanner sc = new Scanner(System.in);
    private static HashMap<Integer,String> map = new HashMap<>();

    private static boolean generateQuestion() {
        while (true) {
            try {
                System.out.println("Question answer round. Integer or String?(Enter lowercase)");
                String choice = Reader.nextLine();
                Random rand = new Random();
                if (choice.equals("string")) {
                    String Characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    String part1 = "";
                    String part2 = "";
                    for(int j=0;j<4;j++){
                        part1 += Characters.charAt(rand.nextInt(52));
                    }
                    for(int j=0;j<4;j++){
                        part2 += Characters.charAt(rand.nextInt(52));
                    }
                    System.out.println("Calculate the concatenation of strings " + part1 + " and " + part2 );
                    String answer = Reader.nextLine();
                    Calculator<String> calculator = new Calculator<String>(part1,part2);
                    return calculator.check(answer);
                }
                else if (choice.equals("integer")) {
                    boolean flag = true;
                    while(flag) {
                        try {
                            int part1 = rand.nextInt();
                            int part2 = rand.nextInt();
                            System.out.println("Calculate the result of " + part1 + " divided by " + part2);
                            int answer = Reader.nextInt();
                            Calculator<Integer> calculator = new Calculator<Integer>(part1, part2);
                            return calculator.check(answer);

                        }
                        catch (NumberFormatException e){
                            System.out.println("Please Enter an Integer Value\nNew Question will be generated");
                        }
                        catch (ArithmeticException e){
                            System.out.println("Divide by Zero Error\nNew Question will be generated");
                        }
                    }
                }
                else {
                    throw new InvalidTypeException("Invalid Type Entered");
                }

            }
            catch (InvalidTypeException e) {
                System.out.println("Please Enter Valid Type for Question Round");
            }
        }
    }

    private static void play(){
        map.put(0,"First");
        map.put(1,"Second");
        map.put(2,"Third");
        map.put(3,"Fourth");
        map.put(4,"Fifth");
        System.out.println("Game is ready\n");
        try{
            for(int i=0;i<5;i++){
                System.out.print("Hit enter for your " + map.get(i) + " hop");
                sc.nextLine();
                jumper.jump();
                int j = jumper.getJumpValue();
                if(j <= 20) {
                    Tile tile = myCarpet.getTile(j);
                    System.out.println(tile);
                    if(tile.getFlag()){
                        if(generateQuestion()){
                            System.out.println("Correct answer");
                            System.out.println("You won a " + tile.getToyName() + " soft toy\n");
                            myPlayer.AwardToy(tile.getMyToyClone());
                        }
                        else{
                            System.out.println("Incorrect answer\nYou did not win any soft toy\n");
                        }
                    }
                    else{
                        System.out.println("You won a " + tile.getToyName() + " soft toy\n");
                        myPlayer.AwardToy(tile.getMyToyClone());
                    }
                }
                else{
                    System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!\n");
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
