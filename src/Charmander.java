public class Charmander extends FirePokemon implements Evolution {

    public Charmander() {
        super("Charmander", Constants.CHARMANDER_MAX_HP, Constants.CHARMANDER_MAX_AP, Constants.SCRATCH);
    }
    public boolean evolve() {
        boolean evolved = false;
        if (this.getLevel() == 1){
            this.evolving("Charmeleon", this.getLifePoints(), Constants.CHARMELEON_MAX_HP,
                    this.getAttackPoints(), Constants.CHARMELEON_MAX_AP,
                    this.getLevel() + 1, Constants.FLAME_TAIL);
            evolved = true;
        } else if (this.getLevel() == 2) {
            this.evolving("Charizard", this.getLifePoints(), Constants.CHARIZARD_MAX_HP,
                    this.getAttackPoints(), Constants.CHARIZARD_MAX_AP,
                    this.getLevel() + 1, Constants.FIERY_BLAST);
            evolved = true;
        }
        return evolved;
    }
}

