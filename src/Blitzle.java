public class Blitzle extends ElectricPokemon{
    //O(1)
    protected Blitzle() {
        super("Blitzle", Constants.BLITZLE_MAX_HP, Constants.BLITZLE_MAX_AP, Constants.FLOP);
    }
    //O(n)
    public boolean evolve() {
        boolean evolved = false;
        if (this.getLevel() == 1){
            if (this.getLifePoints() >= Constants.HP_LEVEL_1 && this.getAttackPoints() >= Constants.AP_LEVEL_1){
                this.evolving("Zebstrika", this.getLifePoints(), Constants.ZEBSTRIKA_MAX_HP,
                        this.getAttackPoints(), Constants.ZEBSTRIKA_MAX_AP, Constants.ZAP_KICK);
                evolved = true;

            }
        }
        return evolved;
    }
}
