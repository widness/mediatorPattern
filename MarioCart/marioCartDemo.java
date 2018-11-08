package lab.mediator.MarioCart;

import java.util.ArrayList;

public class MarioCartDemo {

    public static void main(String[] args) {

        ArrayList<Cart> carts = new ArrayList();
        String[] participants = new String[]{"Mario", "Toad", "Luigi"};

        for(int i = 0; i < participants.length; i++) {
            carts.add(new Cart(participants[i]));
        }

        RaceMediator rainbowRoad = new RaceMediator(carts, 100);

        rainbowRoad.startRace();
    }
}
