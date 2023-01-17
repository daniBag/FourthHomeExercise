public class Moltres extends FirePokemon implements Evolution{
    public Moltres(){
        super("Moltres", Constants.MOLTRES_MAX_HP,Constants.MOLTRES_MAX_AP, Constants.ASSISTING_HEATER);
        this.addAttack(Constants.FIRE_WING);
    }
    public boolean evolve() {
        return false;
    }
}

