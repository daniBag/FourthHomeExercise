import java.util.Random;

public abstract class FirePokemon extends Pokemon{
    protected FirePokemon(String name, int maxHp ,int maxAp, AttackMove attackMove) {
        super(name, maxHp, maxAp, Constants.FIRE_TYPE, attackMove);
    }
    public void typeEffect(){
        Random random = new Random();
        int randomPercent = random.nextInt(Constants.PERCENTAGE_MIN_RANDOM, Constants.PERCENTAGE_MAX_RANDOM);
        int randomLoseOfLifePoints = random.nextInt(Constants.FIRE_EFFECT_MIN_DAMAGE, Constants.FIRE_EFFECT_MAX_DAMAGE);
        if (randomPercent <= Constants.FIRE_EFFECT_CHANCE){
           this.takeDamage(randomLoseOfLifePoints);
        }
    }
    public int typeSpecialty(){
        AttackMove[] attackMoves = this.getAttackMoves();
        Random random = new Random();
        int firstAttack = random.nextInt(attackMoves.length);
        int secondAttack = random.nextInt(attackMoves.length);
        int damage = attackMoves[firstAttack].preformAttack(this.getAttackModifier());
        damage += attackMoves[secondAttack].preformAttack(this.getAttackModifier());
        return damage;
    }


}
