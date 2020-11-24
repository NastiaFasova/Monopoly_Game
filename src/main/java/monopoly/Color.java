package monopoly;

public enum Color{
    WHITE,
    BLUE,
    GREEN,
    PURPLE,
    YELLOW,
    ORANGE;

    @Override
    public String toString(){
        return name();
    }
}