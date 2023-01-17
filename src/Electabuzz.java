public class Electabuzz extends ElectricPokemon implements Evolution{
    protected Electabuzz() {
        super("Electabuzz", Constants.ELECTABUZZ_MAX_HP, Constants.ELECTABUZZ_MAX_AP, Constants.THUNDER);
    }

    @Override
    public boolean evolve() {
        boolean evolved = false;
        if (this.getLevel() == 1){
            this.evolving("Electivire", this.getLifePoints(), Constants.ELECTIVIRE_MAX_HP,
                    this.getAttackPoints(), Constants.ELECTIVIRE_MAX_AP,
                    this.getLevel() + 1, Constants.THUNDER_PUNCH);
            evolved = true;
        }
        return evolved;    }
}
