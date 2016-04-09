/*
 * Copyright 2015 Alexandre Terrasa <alexandre@moz-code.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package game.players;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

/**
 * A Map of Player in a Game.
 */
public class PlayerMap {

    /**
     * Internal players map.
     */
    private Map<String, Player> players = new HashMap<>();

    /**
     * Number of players in the game.
     *
     * @return the number of players in the game
     */
    public int size() {
        return players.size();
    }

    /**
     * Add a new Player in the Game.
     *
     * @param player the player to add
     *
     */
    @Requires("(player != null) && (player.getName() != null) && !playerIsInGame(player.getName())")
    @Ensures({
    	"size() == old(size()) + 1",
    	"playerIsInGame(player.getName())"
    	})
    public void add(Player player) {
        players.put(player.getName(), player);
    }

    /**
     * Add multiple players in the Game.
     *
     * @param players to add in the Game
     */
    public void addAll(Collection<Player> players) {
        for (Player player : players) {
            add(player);
        }
    }

    /**
     * Is the player with `playerName` registered in the Game?
     *
     * @param playerName name of the player to lookup
     * @return true if the player is registered in the game
     */
    public boolean playerIsInGame(String playerName) {
        return players.containsKey(playerName);
    }

    /**
     * Get the list of players.
     *
     * @return the list of players registered in the Game
     */
    public List<Player> getPlayers() {
        return new ArrayList<>(players.values());
    }

    /**
     * List all alive players in the Game.
     *
     * @return list of alive players in the Game
     */
    public List<Player> getAlivePlayers() {
        List<Player> res = new ArrayList<>();
        for (Player player : players.values()) {
            if (player.isAlive()) {
                res.add(player);
            }
        }
        return res;
    }

    /**
     * List all dead players in the Game.
     *
     * @return list of dead players in the Game
     */
    public List<Player> getDeadPlayers() {
        List<Player> res = new ArrayList<>();
        for (Player player : players.values()) {
            if (!player.isAlive()) {
                res.add(player);
            }
        }
        return res;
    }

}
