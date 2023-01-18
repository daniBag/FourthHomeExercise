public class Charmander extends FirePokemon{
    //O(1)
    public Charmander() {
        super("Charmander", Constants.CHARMANDER_MAX_HP, Constants.CHARMANDER_MAX_AP, Constants.SCRATCH);
    }
    //O(n)
    public boolean evolve() {
        boolean evolved = false;
        if (this.getLevel() == 1){
            if (this.getLifePoints() >= Constants.HP_LEVEL_1 && this.getAttackPoints() >= Constants.AP_LEVEL_1){
                this.evolving("Charmeleon", this.getLifePoints(), Constants.CHARMELEON_MAX_HP,
                        this.getAttackPoints(), Constants.CHARMELEON_MAX_AP, Constants.FLAME_TAIL);
                evolved = true;
            }
        } else if (this.getLevel() == 2) {
            if (this.getLifePoints() >= Constants.HP_LEVEL_2 && this.getAttackPoints() >= Constants.AP_LEVEL_2){
                this.evolving("Charizard", this.getLifePoints(), Constants.CHARIZARD_MAX_HP,
                        this.getAttackPoints(), Constants.CHARIZARD_MAX_AP, Constants.FIERY_BLAST);
                evolved = true;
            }
        }
        return evolved;
    }
}

