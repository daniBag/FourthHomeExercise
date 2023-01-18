import java.util.Random;

public abstract class FirePokemon extends Pokemon{
    //O(1)
    protected FirePokemon(String name, int maxHp ,int maxAp, AttackMove attackMove) {
        super(name, maxHp, maxAp, Constants.FIRE_TYPE, attackMove);
    }
    //O(1)
    public void typeEffect(){
        Random random = new Random();
        int randomPercent = random.nextInt(Constants.PERCENTAGE_MIN_RANDOM, Constants.PERCENTAGE_MAX_RANDOM);
        int randomLoseOfLifePoints = random.nextInt(Constants.FIRE_EFFECT_MIN_DAMAGE, Constants.FIRE_EFFECT_MAX_DAMAGE);
        if (randomPercent <= Constants.FIRE_EFFECT_CHANCE){
           this.takeDamage(randomLoseOfLifePoints);
        }
        System.out.println(this.getName() + " was dealt " + randomLoseOfLifePoints + " of self-damage.");
    }
    //O(1)
    public int typeSpecialty(){
        int damage = Constants.INVALID;
        if (this.getAttackPoints() != 0){
            AttackMove[] attackMoves = this.getAttackMoves();
            Random random = new Random();
            int firstAttack = random.nextInt(attackMoves.length);
            int secondAttack = random.nextInt(attackMoves.length);
            damage = attackMoves[firstAttack].preformAttack(this.getAttackModifier());
            damage += attackMoves[secondAttack].preformAttack(this.getAttackModifier());
            if (attackMoves[firstAttack].isTypeEqual(Constants.FIRE_TYPE)){
                this.typeEffect();
            }
            if (attackMoves[secondAttack].isTypeEqual(Constants.FIRE_TYPE)){
                this.typeEffect();
            }
            System.out.println(damage + " damage was dealt to opponent.");
            this.takeDamage(this.getLifePoints() / 2);
            this.reduceAttackPoints(this.getAttackPoints());
        }
        return damage;
    }


}
