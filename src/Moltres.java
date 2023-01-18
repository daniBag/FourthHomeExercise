public class Moltres extends FirePokemon{
    //O(n)
    public Moltres(){
        super("Moltres", Constants.MOLTRES_MAX_HP,Constants.MOLTRES_MAX_AP, Constants.ASSISTING_HEATER);
        this.addAttack(Constants.FIRE_WING);
    }
    //O(1)
    public boolean evolve() {
        return false;
    }
}

