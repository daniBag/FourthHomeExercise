import java.util.Random;

public class AttackMove {
    private String attackName;
    private String attackType;
    private int apCost;
    private int minDamage;
    private int maxDamage;
    //O(1)
    public AttackMove(String attackName, String attackType, int apCost, Integer minDamage, Integer maxDamage){
        this.attackName = attackName;
        this.attackType = attackType;
        this.apCost = apCost;
        if (validateMinMax(minDamage, maxDamage)){
            this.minDamage = minDamage;
            this.maxDamage = maxDamage;
        } else if (maxDamage < minDamage) {
            this.minDamage = maxDamage;
            this.maxDamage = minDamage;
        }
    }
    //O(1)
    public boolean isTypeEqual(String attackType){
        return this.attackType.equals(attackType);
    }
    //O(1)
    private boolean validateMinMax(Integer minDamage, Integer maxDamage){
        return maxDamage > minDamage;
    }
    //O(1)
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
    //O(n)
    public String toString(){
        String output = "Attack Name: " + this.attackName + " (" + this.attackType + ")";
        output += "\nAttack Cost: " + this.apCost;
        if (this.maxDamage - 1 != this.minDamage){
            output += "\nDamage: " + this.minDamage + "-" + (this.maxDamage - 1);
        }else{
            output += "\nDamage: " + this.minDamage;
        }
        return output;
    }
}
