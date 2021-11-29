package APAssignment4;

import java.util.Random;

public class OddTile extends Tile{

    public OddTile(SoftToy myToy){
        super(myToy);
    }

    private boolean generateQuestion() {
        while (true) {
            try {
                FastReader Reader = new FastReader();
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

    @Override
    public boolean play() {
        if(generateQuestion()){
            System.out.println("Correct answer");
            System.out.println("You won a " + this.getToyName() + " soft toy\n");
            return true;
        }
        else{
            System.out.println("Incorrect answer\nYou did not win any soft toy\n");
            return false;
        }
    }

}
