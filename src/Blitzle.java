public class Blitzle extends ElectricPokemon implements Evolution{
    protected Blitzle() {
        super("Blitzle", Constants.BLITZLE_MAX_HP, Constants.BLITZLE_MAX_AP, Constants.FLOP);
    }
    public boolean evolve() {
        boolean evolved = false;
        if (this.getLevel() == 1){
            this.evolving("Zebstrika", this.getLifePoints(), Constants.ZEBSTRIKA_MAX_HP,
                    this.getAttackPoints(), Constants.ZEBSTRIKA_MAX_AP,
                    this.getLevel() + 1, Constants.ZAP_KICK);
            evolved = true;
        }
        return evolved;
    }
}
