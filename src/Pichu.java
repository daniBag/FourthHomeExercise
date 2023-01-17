public class Pichu extends ElectricPokemon implements Evolution{
    protected Pichu() {
        super("Pichu", Constants.PICHU_MAX_HP, Constants.PICHU_MAX_AP, Constants.QUICK_ATTACK);
    }

    @Override
    public boolean evolve() {
        boolean evolved = false;
        if (this.getLevel() == 1){
            this.evolving("Pikachu", this.getLifePoints(), Constants.PIKACHU_MAX_HP,
                    this.getAttackPoints(), Constants.PIKACHU_MAX_AP,
                    this.getLevel() + 1, Constants.ELECTRO_BALL);
            evolved = true;
        } else if (this.getLevel() == 2) {
            this.evolving("Raichu", this.getLifePoints(), Constants.RAICHU_MAX_HP,
                    this.getAttackPoints(), Constants.RAICHU_MAX_AP,
                    this.getLevel() + 1, Constants.ELECTRIC_SURFER);
            evolved = true;
        }
        return evolved;
    }
}
