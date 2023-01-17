import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Pokemon firstPlayer;
    private Pokemon secondPlayer;

    private Pokemon generatePokemon (int random){
        Pokemon pokemon = null;
        switch (random){
            case Constants.CHARMANDER -> pokemon = new Charmander();
            case Constants.SALANDIT -> pokemon = new Salandit();
            case Constants.MOLTRES -> pokemon = new Moltres();
            case Constants.PICHU -> pokemon = new Pichu();
            case Constants.BLITZLE -> pokemon = new Blitzle();
            case Constants.ELECTABUZZ -> pokemon = new Electabuzz();
        }
        return pokemon;
    }
    public void setPokemons (){
        Random random = new Random();
        int randomizedPokemon = random.nextInt(Constants.POSSIBLE_STARTING_POKEMON);
        this.firstPlayer = this.generatePokemon(randomizedPokemon);
        randomizedPokemon = random.nextInt(Constants.POSSIBLE_STARTING_POKEMON);
        this.secondPlayer = this.generatePokemon(randomizedPokemon);
    }
    private void autoAdd(Pokemon player){
        Random random = new Random();
        int toAdd = random.nextInt(5);
        player.addHp(toAdd);
        toAdd = random.nextInt(5);
        player.addAp(toAdd);
    }
    public void turnManagement(Pokemon player, Pokemon other){
        Scanner scanner = new Scanner(System.in);
        this.autoAdd(player);
        System.out.println(player);
        System.out.println("Please insert your selection number: " +
                "\n1. Preforming an attack." +
                "\n2. Wait." +
                "\n3. Evolve." +
                "\n4. Special Move.");
        int menuSelection;
        boolean actionMade = false;
        do {
            menuSelection = scanner.nextInt();
            switch (menuSelection){
                case 1 -> {
                    AttackMove[] attackMoves = player.getAttackMoves();
                    for (int i =0; i < attackMoves.length; i++){
                        System.out.println((i+1 + ". ") + attackMoves[i]);
                        System.out.println("**************");
                    }
                    System.out.println("Please insert the number of the desired attack: ");
                    menuSelection = scanner.nextInt();
                    if (attackMoves[menuSelection -1].getApCost() <= player.getAttackPoints()){
                        int damage = attackMoves[menuSelection - 1].preformAttack(player.getAttackModifier());
                        player.reduceAttackPoints(attackMoves[menuSelection -1].getApCost());
                        other.takeDamage(damage);
                        actionMade = true;
                    }
                }
                case 2 -> {

                }
            }
        }while (!actionMade);
    }
}


