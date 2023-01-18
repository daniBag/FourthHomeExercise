public class Salandit extends FirePokemon{
    //O(1)
    public Salandit(){
        super("Salandit", Constants.SALANDIT_MAX_HP,Constants.SALANDIT_MAX_AP, Constants.LIVE_COAL);
    }
    //O(n)
    public boolean evolve() {
        boolean evolved = false;
        if (this.getLevel() == 1){
            if (this.getLifePoints() >= Constants.HP_LEVEL_1 && this.getAttackPoints() >= Constants.AP_LEVEL_1){
                this.evolving("Salazzle", this.getLifePoints(), Constants.SALAZZLE_MAX_HP,
                        this.getAttackPoints(), Constants.SALAZZLE_MAX_AP, Constants.FIRE_CLAWS);
                evolved = true;
            }
        }
        return evolved;
    }
}

