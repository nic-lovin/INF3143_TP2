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
package game;

import game.players.PlayerMap;

/**
 * Game manager.
 */
public class Game {

    /**
     * Static instance used for singleton behavior.
     */
    private static Game gameInstance;

    /**
     * Get the unique Game instance.
     *
     * @return the Game instance.
     */
    public static Game getInstance() {
        if (gameInstance == null) {
            gameInstance = new Game();
        }
        return gameInstance;
    }

    /**
     * Force reset the Game instance.
     *
     * Mostly useful for testing.
     */
    static void forceReset() {
        gameInstance = null;
    }

    /**
     * Game players list.
     */
    public PlayerMap players = new PlayerMap();

    /**
     * Current Round of the Game.
     */
    private Round currentRound;

    /**
     * Initialize a new Game instance.
     */
    private Game() {
    }

    /**
     * Create a new round in this Game.
     */
    public void newRound() {
        currentRound = Round.getRound(currentRound);
    }

    public Round getCurrentRound() {
        return currentRound;
    }
}
