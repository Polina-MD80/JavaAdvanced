package PokemonTrainer;
//Pokemon has a name, an element and health, all values are mandatory.
public
class Pokemon {
    private String pokemonName;
    private String element;
    private int health;

    public Pokemon(String pokemonName, String element, int health){
        this.pokemonName = pokemonName;
        this.element = element;
        this.health = health;
    }

    public
    String getElement () {
        return element;
    }

    public
    int getHealth () {
        return health;
    }

    public
    void loseTenHealth(int health){
        this.health -= 10;
    }


}
