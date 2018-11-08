package lab.mediator.MarioCart;

public class Cart {
    private int pos;
    private String name;
    private boolean finished;

    public Cart(String name) {
        pos = 0;
        this.name = name;
        finished = false;
    }

    public void setPos() {
        pos += (int) (10 + Math.random() * 11);
    }

    public int getPos() {
        return pos;
    }

    public String getName() {
        return name;
    }

    /**
     * @param index: index from "ArrayList<Cart> carts"
     * @see RaceMediator -> startRace()
     */
    public void drive(int index) {
        setPos();
        RaceMediator.updateScore(this, index);
    }

    public String toString() {
        return "name: " + this.name + " / pos: " + this.pos;
    }
}
