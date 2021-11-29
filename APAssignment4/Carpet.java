package APAssignment4;

import java.util.ArrayList;

public class Carpet{
    private ArrayList<Tile> list;

    public Carpet(){
        list = new ArrayList<>();
        list.add(new Tile(new Toy1_Teddy()));
        list.add(new Tile(new Toy2_Duck()));
        list.add(new Tile(new Toy3_Dog()));
        list.add(new Tile(new Toy4_Mickey()));
        list.add(new Tile(new Toy5_Jerry()));
        list.add(new Tile(new Toy6_Tom()));
        list.add(new Tile(new Toy7_Panda()));
        list.add(new Tile(new Toy8_Ball()));
        list.add(new Tile(new Toy9_Football()));
        list.add(new Tile(new Toy10_Minion()));
        list.add(new Tile(new Toy11_Monkey()));
        list.add(new Tile(new Toy12_Dino()));
        list.add(new Tile(new Toy13_Elephant()));
        list.add(new Tile(new Toy14_Platypus()));
        list.add(new Tile(new Toy15_Turtle()));
        list.add(new Tile(new Toy16_Shark()));
        list.add(new Tile(new Toy17_Giraffe()));
        list.add(new Tile(new Toy18_Unicorn()));
        list.add(new Tile(new Toy19_Pikachu()));
        list.add(new Tile(new Toy20_Parrot()));
    }
    public Tile getTile(int i){
        return list.get(i-1);
    }
}
