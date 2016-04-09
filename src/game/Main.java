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

import game.players.Player;
import races.Elf;
import races.Troll;

public class Main {

    public static void main(String[] args) {
        Game game = Game.getInstance();
        Logger logger = Logger.getLogger();

        Player p1 = new Player("p1", new Troll());
        Player p2 = new Player("p2", new Elf());

        game.players.add(p1);
        game.players.add(p2);
        
        game.players.add(new Player("p2dds", new Troll()));

        while (game.players.getAlivePlayers().size() > 1) {
            game.newRound();

            if (p1.isAlive()) {
                p1.attack(p2);
            }
            if (p2.isAlive()) {
                p2.castSpell(p1);
            }
        }

        logger.log("Game Ended");

        logger.log(p2.getStatus());
        logger.log(p1.getStatus());

        logger.showLogs();
    }

}
