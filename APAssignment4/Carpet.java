package APAssignment4;

import java.util.ArrayList;

public class Carpet{
    private ArrayList<Tile> list;

    public Carpet(){
        this.list = new ArrayList<>();
        this.list.add(new OddTile(new Toy1_Teddy()));
        this.list.add(new EvenTile(new Toy2_Duck()));
        this.list.add(new OddTile(new Toy3_Dog()));
        this.list.add(new EvenTile(new Toy4_Mickey()));
        this.list.add(new OddTile(new Toy5_Jerry()));
        this.list.add(new EvenTile(new Toy6_Tom()));
        this.list.add(new OddTile(new Toy7_Panda()));
        this.list.add(new EvenTile(new Toy8_Ball()));
        this.list.add(new OddTile(new Toy9_Football()));
        this.list.add(new EvenTile(new Toy10_Minion()));
        this.list.add(new OddTile(new Toy11_Monkey()));
        this.list.add(new EvenTile(new Toy12_Dino()));
        this.list.add(new OddTile(new Toy13_Elephant()));
        this.list.add(new EvenTile(new Toy14_Platypus()));
        this.list.add(new OddTile(new Toy15_Turtle()));
        this.list.add(new EvenTile(new Toy16_Shark()));
        this.list.add(new OddTile(new Toy17_Giraffe()));
        this.list.add(new EvenTile(new Toy18_Unicorn()));
        this.list.add(new OddTile(new Toy19_Pikachu()));
        this.list.add(new EvenTile(new Toy20_Parrot()));
    }
    public Tile getTile(int i){
        return list.get(i-1);
    }
}
