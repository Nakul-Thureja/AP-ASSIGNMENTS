package APAssignment4;

public class Calculator<T>{
    private T part1;
    private T part2;

    public Calculator(T part_1,T part_2){
        if((part_1 instanceof Integer) && (part_2 instanceof Integer)){
            this.part1 = part_1;
            this.part2 = part_2;
        }
        else if((part_1 instanceof String) && (part_2 instanceof String)){
            this.part1 = part_1;
            this.part2 = part_2;
        }
        else{
            throw new InvalidTypeException("Invalid Type Entered");
        }
    }

    public boolean check(T answer){
        if((answer instanceof Integer) && (this.part1 instanceof Integer) && (this.part2 instanceof Integer)){
            int ans = (Integer)part1/(Integer)part2;
            return (Integer)answer == ans;
        }
        else if((answer instanceof String) && (this.part1 instanceof String) && (this.part2 instanceof String)){
            String ans = (String)part1 + (String)part2;
            return ans.equals((String)answer);
        }
        else{
            throw new InvalidTypeException("Invalid Answer Type Entered");
        }
    }
}
