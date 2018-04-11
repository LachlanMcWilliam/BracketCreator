package Application;

import java.util.ArrayList;

class PlayersStorage{

    private ArrayList<Player> players = new ArrayList<>();
    private int arraySizeCounter = 0;

    public void addPlayer(Player player){
        players.add(player);
        arraySizeCounter++;
    }

    public void removePlayer(String name){

        for (int i = 0; i < players.size(); i++){
            if (name.equals(players.get(i).get_name())){
                players.remove(i);
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Player player : players) {
            output.append(player.get_name()).append(",");
        }
        return "PlayersStorage{" + output +'}';
    }


    public ArrayList<Player> getPlayers() {
        return players;
    }


    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
