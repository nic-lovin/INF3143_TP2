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

/**
 * Humans are good to do anything but with no specialization.
 */
public class Human implements Race {

    private static Human humanInstance;

    /**
     * Get the singleton instance of Human.
     *
     * @return the unique Human instance.
     */
    public static Human getRace() {
        if (humanInstance == null) {
            humanInstance = new Human();
        }
        return humanInstance;
    }

    @Override
    public int baseEndurance() {
        return 10;
    }

    @Override
    public int baseIntelligence() {
        return 10;
    }

    @Override
    public int baseStrength() {
        return 10;
    }

    @Override
    public String toString() {
        return "human";
    }

}
