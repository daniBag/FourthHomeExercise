import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Pokemon firstPokemon;
    private Pokemon secondPokemon;
    private boolean firstPlayer;
    //O(1)
    public Pokemon getFirstPokemon() {
        return firstPokemon;
    }
    //O(1)
    public Pokemon getSecondPokemon() {
        return secondPokemon;
    }
    //O(1)
    public boolean isFirstPlayer() {
        return firstPlayer;
    }
    //O(1)
    public Battle(){
        this.setPokemons();
        this.firstPlayer = false;
    }
    //O(1)
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
    //O(1)
    private void setPokemons (){
        Random random = new Random();
        int randomizedPokemon = random.nextInt(Constants.POSSIBLE_STARTING_POKEMON);
        this.firstPokemon = this.generatePokemon(randomizedPokemon);
        randomizedPokemon = random.nextInt(Constants.POSSIBLE_STARTING_POKEMON);
        this.secondPokemon = this.generatePokemon(randomizedPokemon);
    }
    //O(1)
    private void autoAdd(Pokemon player){
        Random random = new Random();
        int toAdd = random.nextInt(Constants.AUTO_BONUS_RANDOM_BOUND);
        player.addHp(toAdd);
        toAdd = random.nextInt(Constants.AUTO_BONUS_RANDOM_BOUND);
        player.addAp(toAdd);
    }
    //O(n)
    public int turnManagement(Pokemon player, Pokemon other){
        int winner = Constants.NO_WINNER_YET;
        Scanner scanner = new Scanner(System.in);
        this.autoAdd(player);
        if (player.typeEqual(Constants.ELECTRIC_TYPE)){
            player.typeEffect();
        }
        if (player.isPowerBonus()){
            player.changeAttackModifier(player.getAttackModifier() * Constants.POWER_BONUS);
            player.setPowerBonus();
        }
        System.out.println(player);
        int menuSelection;
        boolean actionMade = false;
        do {
            System.out.println("Please insert your selection number: " +
                    "\n1. Preforming an attack." +
                    "\n2. Wait." +
                    "\n3. Evolve." +
                    "\n4. Special Move.");
            menuSelection = scanner.nextInt();
            switch (menuSelection){
                case Constants.MENU_FIRST_OPTION -> actionMade = this.attack(player, other);
                case Constants.MENU_SECOND_OPTION -> {
                    this.wait(player);
                    actionMade = true;
                }
                case Constants.MENU_THIRD_OPTION -> {
                    actionMade = player.evolve();
                    if (!actionMade){
                        System.out.println("This Pokemon can't evolve!");
                    }
                }
                case Constants.MENU_FOURTH_OPTION -> {
                    int special = player.typeSpecialty();
                    if (special == Constants.INVALID){
                        System.out.println("This Pokemon can't preform it's special attack!");
                    } else if (special == Constants.SUCCESS) {
                        actionMade = true;
                    }else{
                        other.takeDamage(special);
                        actionMade = true;
                    }
                }
            }
        }while (!actionMade);
        if (player.getAttackModifier() > Constants.MAX_ATTACK_MODIFIER){
            player.changeAttackModifier(player.getAttackModifier() / Constants.POWER_BONUS);
        }
        if (other.isDead()){
            winner = Constants.CURRENT_PLAYER;
        }else if (player.isDead()){
            winner = Constants.OTHER_PLAYER;
        }
        return winner;
    }
    //O(n)
    private boolean attack (Pokemon player, Pokemon other){
        Scanner scanner = new Scanner(System.in);
        boolean hasAttacked = false;
        int menuSelection;
        AttackMove[] attackMoves = player.getAttackMoves();
        for (int i = 0; i < attackMoves.length; i++){
            System.out.println((i + 1 + ". ") + attackMoves[i]);
            System.out.println("**************");
        }
        System.out.println("Please insert the number of the desired attack: ");
        boolean validChoice = true;
        do{
            menuSelection = scanner.nextInt();
            if (menuSelection > attackMoves.length){
                validChoice = false;
                System.out.println("Please re-enter your selection: ");
            }
        }while (!validChoice);
        menuSelection--;
        if (attackMoves[menuSelection].getApCost() <= player.getAttackPoints()){
            int damage = attackMoves[menuSelection].preformAttack(player.getAttackModifier());
            player.reduceAttackPoints(attackMoves[menuSelection].getApCost());
            other.takeDamage(damage);
            if (attackMoves[menuSelection].isTypeEqual(Constants.FIRE_TYPE)){
                player.typeEffect();
            }
            System.out.println(damage + " damage was dealt to opponent.");
            hasAttacked = true;
        }else{
            System.out.println("You don't have enough attack points.");
        }
        return hasAttacked;
    }
    //O(1)
    private void wait (Pokemon player) {
        Random random = new Random();
        int bonus = random.nextInt(Constants.BONUS_RANDOM) + 1;
        switch (bonus) {
            case Constants.HP_BONUS -> {
                bonus = random.nextInt(Constants.HP_BONUS_MIN, Constants.HP_BONUS_MAX);
                player.addHp(bonus);
            }
            case Constants.AP_BONUS -> {
                bonus = random.nextInt(Constants.AP_BONUS_MAX);
                player.addAp(bonus);
            }
            case Constants.POWER_BONUS -> {
                player.setPowerBonus();
            }
        }
    }
    //O(1)
    public void setFirstPlayer(){
        this.firstPlayer = !this.firstPlayer;
    }
}


