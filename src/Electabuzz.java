public class Electabuzz extends ElectricPokemon{
    //O(1)
    protected Electabuzz() {
        super("Electabuzz", Constants.ELECTABUZZ_MAX_HP, Constants.ELECTABUZZ_MAX_AP, Constants.THUNDER);
    }
    //O(n)
    public boolean evolve() {
        boolean evolved = false;
        if (this.getLevel() == 1){
            if (this.getLifePoints() >= Constants.HP_LEVEL_1 && this.getAttackPoints() >= Constants.AP_LEVEL_1){
                this.evolving("Electivire", this.getLifePoints(), Constants.ELECTIVIRE_MAX_HP,
                        this.getAttackPoints(), Constants.ELECTIVIRE_MAX_AP, Constants.THUNDER_PUNCH);
                evolved = true;
            }
        }
        return evolved;    }
}
