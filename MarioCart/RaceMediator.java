package lab.mediator.MarioCart;

import java.util.ArrayList;

public final class RaceMediator {
    static ArrayList<Cart> carts;
    static ArrayList<Cart> scoreBoard;
    static int raceLength;
    static int cartsCounter;

    public RaceMediator(ArrayList<Cart> carts, int raceLength) {
        this.carts = carts;
        this.raceLength = raceLength;
        scoreBoard = new ArrayList();
        cartsCounter = carts.size();
    }

    /**
     * @Description: trigger Cart drive()
     * Ctrl if Cart finish the race
     * trigger displayScore
     * @see: displayScore()
     */
    public static void startRace() {
        while(scoreBoard.size() < cartsCounter) {
            for(int i = 0; i < carts.size(); i++) {
                if(carts.get(i).getPos() >= raceLength) {
                    scoreBoard.add(carts.get(i));
                    carts.remove(i);
                } else {
                    carts.get(i).drive(i);
                }
            }
            displayScore();
        }
    }

    public static void updateScore(Cart cart, int index) {
        carts.set(index, cart);
    }

    /**
     * @see: startRace()
     * @Description: Order score
     * Ctrl if cart finish
     * output in function of that response
     */
    public static void displayScore() {
        orderScore();

        if(scoreBoard.size() >= cartsCounter) {
            System.out.println("\nRace is finish: ");
            for(int i = 0; i < scoreBoard.size(); i++) {
                System.out.println(String.valueOf(i+1) + ") " + scoreBoard.get(i).getName() + " - " + scoreBoard.get(i).getPos());
            }
        } else {
            System.out.println("\nScore:");
            for(int i = 0; i < carts.size(); i++) {
                System.out.println(String.valueOf(i+1) + ") " + carts.get(i).getName() + " - " + carts.get(i).getPos());
            }
        }

    }

    public static void orderScore() {
        // Code found at: geeksforgeeks.org/bubble-sort/

        int n = carts.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++){
                if (carts.get(j).getPos() < carts.get(j + 1).getPos()) {
                    // swap temp and arr[i]
                    Cart temp = carts.get(j);
                    carts.set(j, carts.get(j + 1));
                    carts.set((j + 1), temp);
                }
            }
    }
}
