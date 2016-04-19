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

import com.google.java.contract.Ensures;

/**
 * The Race factory is used to get all Race instances.
 */
public class RaceFactory {

    /**
     * Get the Race instance corresponding to `raceName`.
     *
     * @param raceName the name of the race to get instance from. Can be either
     * `elf`, `troll` or `human`
     * @return the Race singleton instance
     */
	//Tout client qui appelle RaceFactory::getRace(raceName) avec elf, troll ou human comme argument à la certitude de recevoir une instance de Race non nulle.
	@Ensures("raceName == null ? true :"
			+ "raceName.equals(\"elf\") ? result != null :"
			+ "raceName.equals(\"troll\") ? result != null :"
			+ "raceName.equals(\"human\") ? result != null : true")
	public static Race getRace(String raceName) {
        switch (raceName) {
            case "elf":
                return Elf.getRace();
            case "troll":
                return Troll.getRace();
            case "human":
                return Human.getRace();
            default:
                throw new IllegalArgumentException("Unknown race name: " + raceName);
        }
    }
}
