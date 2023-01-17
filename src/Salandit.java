public class Salandit extends FirePokemon implements Evolution {
    public Salandit(){
        super("Salandit", Constants.SALANDIT_MAX_HP,Constants.SALANDIT_MAX_AP, Constants.LIVE_COAL);
    }
    public boolean evolve() {
        boolean evolved = false;
        if (this.getLevel() == 1){
            this.evolving("Salazzle", this.getLifePoints(), Constants.SALAZZLE_MAX_HP,
                    this.getAttackPoints(), Constants.SALAZZLE_MAX_AP,
                    this.getLevel() + 1, Constants.FIRE_CLAWS);
            evolved = true;
        }
        return evolved;
    }
}

