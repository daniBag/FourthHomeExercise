public abstract class ElectricPokemon extends Pokemon{
    private int electricityCharge;
    private int specialAttackCount;
    //O(1)
    protected ElectricPokemon(String name, int maxHp ,int maxAp, AttackMove attackMove) {
        super(name, maxHp, maxAp, Constants.ELECTRIC_TYPE, attackMove);
        this.electricityCharge = 0;
        this.specialAttackCount = 0;
    }
    //O(1)
    protected void typeEffect (){
        int currentHp = this.getLifePoints();
        if ((currentHp / this.getMaxHP()) * 100 >= Constants.HP_PERCENTAGE){
            this.electricityCharge += Constants.ELECTRICITY_ADDITION;
            this.changeAttackModifier(this.getAttackModifier() + (Constants.ELECTRICITY_ADDITION / 100));
        }else {
            this.changeAttackModifier(this.getAttackModifier() - this.electricityCharge / 100);
            this.electricityCharge = 0;
        }
    }
    //O(1)
    protected int typeSpecialty(){
        int success = Constants.INVALID;
        if (this.specialAttackCount == 0){
            this.addHp(this.getMaxHP());
            this.addAp(this.getMaxAP());
            this.specialAttackCount++;
            success = Constants.SUCCESS;
        }
        return success;
    }
}
