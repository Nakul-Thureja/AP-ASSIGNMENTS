package APAssignment4;

public abstract class SoftToy implements Cloneable {
    private String name;
    public SoftToy(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public SoftToy clone() {
        try {
            SoftToy clone = (SoftToy) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
