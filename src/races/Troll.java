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
package races;

import java.util.Random;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;

/**
 * Trolls are good fighters.
 */
public class Troll implements Race {

    private static Troll trollInstance;

    /**
     * Get the singleton instance of Troll.
     *
     * @return the unique Troll instance.
     */
    public static Troll getRace() {
        if (trollInstance == null) {
            trollInstance = new Troll();
        }
        return trollInstance;
    }

    @Override
    public int baseEndurance() {
        return 12;
    }

    @Override
    public int baseIntelligence() {
        Random rand = new Random();
        return rand.nextInt(9 - 5 + 1) + 5;
    }

    @Override
    public int baseStrength() {
        return 12;
    }

    @Override
    public String toString() {
        return "troll";
    }
}
