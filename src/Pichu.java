public class Pichu extends ElectricPokemon {
    //O(1)
    protected Pichu() {
        super("Pichu", Constants.PICHU_MAX_HP, Constants.PICHU_MAX_AP, Constants.QUICK_ATTACK);
    }
    //O(n)
    public boolean evolve() {
        boolean evolved = false;
        if (this.getLevel() == 1){
            if (this.getLifePoints() >= Constants.HP_LEVEL_1 && this.getAttackPoints() >= Constants.AP_LEVEL_1){
                this.evolving("Pikachu", this.getLifePoints(), Constants.PIKACHU_MAX_HP,
                        this.getAttackPoints(), Constants.PIKACHU_MAX_AP, Constants.ELECTRO_BALL);
                evolved = true;
            }
        } else if (this.getLevel() == 2) {
            if (this.getLifePoints() >= Constants.HP_LEVEL_2 && this.getAttackPoints() >= Constants.AP_LEVEL_2){
                this.evolving("Raichu", this.getLifePoints(), Constants.RAICHU_MAX_HP,
                        this.getAttackPoints(), Constants.RAICHU_MAX_AP, Constants.ELECTRIC_SURFER);
                evolved = true;
            }
        }
        return evolved;
    }
}
