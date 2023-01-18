public abstract class Pokemon{
    private String name;
    private int lifePoints;
    private int attackPoints;
    private int level;
    private int maxHp;
    private int maxAp;
    private boolean powerBonus;
    private String pokemonType;
    private AttackMove[] attackMoves;
     private double attackModifier;
    //O(1)
     public double getAttackModifier() {
        return attackModifier;
    }
    //O(1)
    public Pokemon(String name, int maxHp, int maxAp, String pokemonType, AttackMove attackMove){
        this.name = name;
        this.lifePoints = maxHp;
        this.maxHp = maxHp;
        this.maxAp = maxAp;
        this.powerBonus = false;
        this.attackPoints = ((3 * this.maxAp)/ 4);
        this.pokemonType = pokemonType;
        this.level = Constants.INITIALIZING_LEVEL;
        this.attackModifier = 1.0;
        this.attackMoves = new AttackMove[] {Constants.KICK, attackMove};
    }
    //O(1)
    protected int getLifePoints() {
        return lifePoints;
    }
    //O(1)
    protected int getAttackPoints(){
        return this.attackPoints;
    }
    //O(1)
    protected void addLifePoints(int lifePoints) {
        this.lifePoints += lifePoints;
    }
    //O(1)
    protected int getMaxHP(){
        return this.maxHp;
    }
    //O(1)
    protected int getMaxAP(){
        return this.maxAp;
    }
    //O(1)
    protected void addHp(int hp) {
        int max = this.getMaxHP();
        int current = this.getLifePoints();
        if (current < max) {
            if (this.getLifePoints() + hp > max) {
                hp = max - current;
            }
            this.lifePoints += hp;
        }
    }
    //O(1)
    protected void takeDamage(int damage){
        this.lifePoints -= damage;
    }
    //O(1)
    protected boolean isDead(){
        return this.lifePoints <= 0;
    }
    //O(1)
    protected void addAp(int attackPoints) {
        int max = this.getMaxAP();
        int current = this.getAttackPoints();
        if (current < max) {
            if (current + attackPoints > max) {
                attackPoints = max - current;
            }
            this.attackPoints += attackPoints;
        }
    }
    //O(1)
    protected void setPowerBonus(){
        this.powerBonus = !powerBonus;
    }
    //O(1)
    protected boolean isPowerBonus(){
        return this.powerBonus;
    }
    //O(1)
    protected boolean typeEqual(String pokemonType){
        return this.pokemonType.equals(pokemonType);
    }
    //O(1)
    protected void changeAttackModifier(double attackModifier){
        this.attackModifier = attackModifier;
    }
    //O(1)
    protected int getLevel(){
        return this.level;
    }
    //O(n)
    protected void addAttack(AttackMove attackMove){
        AttackMove[] updatedAttackMoves = new AttackMove[this.attackMoves.length + 1];
        for (int i = 0; i < this.attackMoves.length; i++){
            updatedAttackMoves[i] = this.attackMoves[i];
        }
        updatedAttackMoves[this.attackMoves.length] = attackMove;
        this.attackMoves = updatedAttackMoves;
    }
    //O(1)
    protected AttackMove[] getAttackMoves(){
        return this.attackMoves;
    }
    //O(n)
    protected void evolving (String name, int currentHP, int maxHp, int currentAP, int maxAp, AttackMove attackMove){
        this.name = name;
        this.maxHp = maxHp;
        this.maxAp = maxAp;
        if (this.level == 2) {
            currentHP -= Constants.HP_LEVEL_2;
            currentAP -= Constants.AP_LEVEL_2;
        } else if (this.level == 1){
            currentHP -= Constants.HP_LEVEL_1;
            currentAP -= Constants.AP_LEVEL_1;
        }
        this.lifePoints = currentHP;
        this.attackPoints = currentAP;
        this.addAttack(attackMove);
        this.level++;
        System.out.println(this.toString());
    }
    //O(1)
    protected void reduceAttackPoints(int toReduce){
        if (this.attackPoints - toReduce < 0){
            this.attackPoints = 0;
        }else{
            this.attackPoints -= toReduce;
        }
    }
    protected abstract void typeEffect();
    protected abstract boolean evolve();
    //O(1)
    protected String getName(){return this.name;}
    protected abstract int typeSpecialty();
    //O(1)
    public String toString(){
        String output = "Name: " + this.name + " (" + this.pokemonType + ") " + "\nHP: "
                + this.lifePoints + "\nAttack Points: " + this.attackPoints;
        output += "\n**********";
        return output;
    }
}


