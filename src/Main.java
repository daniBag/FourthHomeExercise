import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();
        int winner;
        do {
            battle.setFirstPlayer();
            if (battle.isFirstPlayer()){
                winner = battle.turnManagement(battle.getFirstPokemon(), battle.getSecondPokemon());
            }else {
                winner = battle.turnManagement(battle.getSecondPokemon(), battle.getFirstPokemon());
            }
        }while (winner == Constants.NO_WINNER_YET);
        if (battle.isFirstPlayer()){
            if (winner == Constants.CURRENT_PLAYER){
                System.out.println("Player 1 wins!");
            }else{
                System.out.println("Player 2 wins!");
            }
        }else{
            if (winner == Constants.CURRENT_PLAYER){
                System.out.println("Player 2 wins!");
            }else{
                System.out.println("Player 1 wins!");
            }
        }
    }
}
