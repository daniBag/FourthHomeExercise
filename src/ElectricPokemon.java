public abstract class ElectricPokemon extends Pokemon{
    private int electricityCharge;
    private int specialAttackCount;

    protected ElectricPokemon(String name, int maxHp ,int maxAp, AttackMove attackMove) {
        super(name, maxHp, maxAp, Constants.ELECTRIC_TYPE, attackMove);
        this.electricityCharge = 0;
        this.specialAttackCount = 0;
    }
    protected void typeEffect (){
        int currentHp = this.getLifePoints();
        if ((currentHp / this.getMaxHP()) * 100 >= 20){
            this.electricityCharge += 5;
        }else {
            this.electricityCharge = 0;
        }
    }
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
