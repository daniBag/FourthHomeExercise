import java.util.Random;

public class AttackMove {
    private String attackName;
    private int apCost;
    private int minDamage;
    private int maxDamage;

    public AttackMove(String attackName, int apCost, Integer minDamage, Integer maxDamage){
        this.attackName = attackName;
        this.apCost = apCost;
        if (validateMinMax(minDamage, maxDamage)){
            this.minDamage = minDamage;
            this.maxDamage = maxDamage;
            //TODO
        } else if (maxDamage < minDamage) {
            this.minDamage = maxDamage;
            this.maxDamage = minDamage;
        }
    }
    private boolean validateMinMax(Integer minDamage, Integer maxDamage){
        boolean valid = false;
        if (maxDamage > minDamage){
            valid = true;
        }
        return valid;
    }
    public int preformAttack(double attackModifier){
        int damage;
        Random random = new Random();
        damage = random.nextInt(minDamage, maxDamage);
        damage *= attackModifier;
        return damage;
    }
    public int getApCost(){
        return this.apCost;
    }
    public String toString(){
        String output = "Attack Name: " + this.attackName;
        output += "\nAttack Cost: " + this.apCost;
        if (this.maxDamage - 1 != this.minDamage){
            output += "\nDamage: " + this.minDamage + "-" + (this.maxDamage-1);
        }else{
            output += "\nDamage: " + this.minDamage;
        }
        return output;
    }
}
