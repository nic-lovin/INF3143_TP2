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
 * A Player race.
 *
 * Because races are only used to set base statistics they are all used as
 * singleton.
 */
public interface Race {

    /**
     * Base strength given by this Race to a Player instance.
     *
     * @return base strength
     */
    abstract public int baseStrength();

    /**
     * Base endurance given by this Race to a Player instance.
     *
     * @return base endurance
     */
    abstract public int baseEndurance();

    /**
     * Base intelligence given by this Race to a Player instance.
     *
     * @return base intelligence
     */
    abstract public int baseIntelligence();

}
