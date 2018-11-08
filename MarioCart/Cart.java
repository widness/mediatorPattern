package lab.mediator.MarioCart;

public class Cart {
    private int id;
    private int pos;
    private String name;

    public Cart(int id, String name) {
        pos = 0;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setPos() {
        pos += (int) (10 + Math.random() * 11);
    }

    public int getPos() {
        return pos;
    }

    public void drive() {
        setPos();
        RaceMediator.updateScore(this, id);
    }
}
