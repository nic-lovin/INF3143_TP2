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

/**
 * A Game is separated in multiple rounds.
 */
public class Round {

    /**
     * Each round has a unique round number.
     */
    private int roundNumber;

    /**
     * Create a new Round instance.
     *
     * @param roundNumber round number to set of the new Round instance
     */
    private Round(int roundNumber) {
        this.roundNumber = roundNumber;
        if (roundNumber == 1) {
            Logger.getLogger().log("Game Started");
        }
        Logger.getLogger().log("New round " + this);
    }

    /**
     * Get a new round instance.
     *
     * @param round previous round or null if first round
     * @return the new Round instance
     */
    public static Round getRound(Round round) {
        if (round == null) {
            return new Round(1);
        } else {
            return new Round(round.roundNumber + 1);
        }

    }

    @Override
    public String toString() {
        return "#" + getRoundNumber();
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
