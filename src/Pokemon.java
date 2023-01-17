public abstract class Pokemon {
    private String name;
    private int lifePoints;
    private int attackPoints;
    private int level;
    private int maxHp;
    private int maxAp;
    private String pokemonType;
    private AttackMove[] attackMoves;

     private double attackModifier;

    public double getAttackModifier() {
        return attackModifier;
    }
    public Pokemon(String name, int maxHp, int maxAp, String pokemonType, AttackMove attackMove){
        this.name = name;
        this.lifePoints = maxHp;
        this.maxHp = maxHp;
        this.maxAp = maxAp;
        this.attackPoints = ((3 * this.maxAp)/ 4);
        this.pokemonType = pokemonType;
        this.level = Constants.INITIALIZING_LEVEL;
        this.attackModifier = 1.0;
        this.attackMoves = new AttackMove[] {Constants.KICK, attackMove};
    }
    protected int getLifePoints() {
        return lifePoints;
    }
    protected int getAttackPoints(){
        return this.attackPoints;
    }
    protected void addLifePoints(int lifePoints) {
        this.lifePoints += lifePoints;
    }
    protected int getMaxHP(){
        return this.maxHp;
    }
    protected int getMaxAP(){
        return this.maxAp;
    }
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
    protected void takeDamage(int damage){
        this.lifePoints -= damage;
    }
    protected boolean isAlive(){
        return this.lifePoints <= 0;
    }
    protected void addAp(int attackPoints) {
        int max = this.getMaxAP();
        int current = this.getAttackPoints();
        if (current < max) {
            if (this.getAttackPoints() + attackPoints > max) {
                attackPoints = max - current;
            }
            this.lifePoints += attackPoints;
        }
    }
    protected void changeAttackModifier(double attackModifier){
        this.attackModifier = attackModifier;
    }
    protected int getLevel(){
        return this.level;
    }

    protected void addAttack(AttackMove attackMove){
        AttackMove[] updatedAttackMoves = new AttackMove[this.attackMoves.length + 1];
        for (int i = 0; i < this.attackMoves.length; i++){
            updatedAttackMoves[i] = this.attackMoves[i];
        }
        updatedAttackMoves[this.attackMoves.length] = attackMove;
        this.attackMoves = updatedAttackMoves;
    }
    protected AttackMove[] getAttackMoves(){
        return this.attackMoves;
    }
    protected void evolving (String name, int currentHP, int maxHp, int currentAP, int maxAp, int level, AttackMove attackMove){
        this.name = name;
        this.maxHp = maxHp;
        this.maxAp = maxAp;
        if (level == 1){
            currentHP -= 20;
            currentAP -= 25;
        } else if (level == 2) {
            currentHP -= 30;
            currentAP -= 40;
        }
        this.lifePoints = currentHP;
        this.attackPoints = currentAP;
        this.addAttack(attackMove);
    }
    protected void reduceAttackPoints(int toReduce){
        this.attackPoints -= toReduce;
    }
    protected abstract void typeEffect();
    protected abstract int typeSpecialty();
    public String toString(){
        String output = "Name: " + this.name + " (" + this.pokemonType + ") " + "\nHP: "
                + this.lifePoints + "\nAttack Points: " + this.attackPoints;
        return output;
    }
}


