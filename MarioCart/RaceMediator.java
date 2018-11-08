package lab.mediator.MarioCart;

import java.util.ArrayList;
import java.util.Collections;

public final class RaceMediator {
    ArrayList<Cart> carts;

    public RaceMediator(ArrayList<Cart> carts) {
        this.carts = carts;
    }

    public void updateScore(Cart cart, int id) {
        carts.set(id, cart);
    }

    public void displayScore() {
        this.orderScore();

        System.out.println("Score:");
        for(int i = 0; i < carts.size(); i++) {
            System.out.println(String.valueOf(i+1) + ") " + carts.get(i).getId());
        }
    }

    public void orderScore() {
        // Code found at: geeksforgeeks.org/bubble-sort/

        int n = carts.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (carts.get(j).getPos() > carts.get(j + 1).getPos()) {
                    // swap temp and arr[i]
                    Cart temp = carts.get(j);
                    carts.set(j, carts.get(j + 1));
                    carts.set(j + 1, temp);
                }
    }
}
