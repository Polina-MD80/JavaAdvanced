package guild;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public
class Guild {
   private String name;
   private int capacity;
   private
    List<Player> roster;

    public
    Guild (String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<> ();
    }

    public void addPlayer(Player player){
        if (capacity>roster.size ()){
            this.roster.add (player);
        }
    }
    public boolean removePlayer(String name){
       return this.roster.removeIf (player -> player.getName ().equals (name));
    }
    public void promotePlayer(String name){
        for (Player player : this.roster) {
            if (player.getName ().equals (name)&&!player.getRank ().equals ("Member")){
                player.setRank ("Member");break;
            }
        }

    }
    public void demotePlayer(String name){
        for (Player player : this.roster) {
            if (player.getName ().equals (name)&&!player.getRank ().equals ("Trial")){
                player.setRank ("Trial");break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz){
        List<Player> arr = new ArrayList<> ();
        for (Player player : this.roster) {
            if (player.getClazz ().equals (clazz)){
                arr.add (player);
            }
        }
        this.roster.removeIf (player -> player.getClazz ().equals (clazz));
        Player[] array = arr.toArray(new Player[0]);
        return array;
    }

    public int count(){
        return this.roster.size ();
    }
    public String report(){
        StringBuilder sb = new StringBuilder ("Players in the guild: " + this.name);
        for (Player player : this.roster) {
            sb.append (System.lineSeparator ()).append (player);

        }
        return sb.toString ();

    }


}
