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

import game.Logger;
import races.Race;

/**
 * A Player can attack other players by hand or by casting spells.
 */
public class Player {

    /**
     * Player name.
     */
    private String name;

    /**
     * Player race.
     */
    private Race race;

    /**
     * Player level.
     *
     * Starts at 1.
     */
    private int level = 1;

    /**
     * Player experience.
     *
     * Starts at 0.
     */
    private int xp = 0;

    /**
     * Player life amount.
     */
    private int life;

    /**
     * Player mana amount.
     */
    private int mana;

    /**
     * Player strength.
     *
     * Used to compute hand attack damages.
     */
    private int strength;

    /**
     * Player intelligence.
     *
     * Used to compute spell damages.
     */
    private int intelligence;

    /**
     * Player endurance.
     *
     * Used to lower the amount of damages received.
     */
    private int endurance;

    /**
     * Initialize a new Player instance.
     *
     * @param name player name
     * @param race player race
     */
    public Player(String name, Race race) {
        super();
        this.name = name;
        this.race = race;
        initStats();
    }

    /**
     * Initializes player statistics.
     */
    private void initStats() {
        strength = race.baseStrength();
        intelligence = race.baseIntelligence();
        endurance = race.baseEndurance();

        life = 10 * race.baseEndurance();
        mana = 10 * race.baseIntelligence();
    }

    /**
     * Attack another player.
     *
     * @param target player to attack
     */
    public void attack(Player target) {
        int dmg = 20 + this.getStrength() - target.getEndurance();
        Logger.getLogger().log("Player " + this + " attacks " + target);
        target.hurt(dmg);
        this.gainXp(dmg * 2);
    }

    /**
     * Hurt this Player.
     *
     * @param damages to inflict to this
     */
    public void hurt(int damages) {
        Logger.getLogger().log("Player " + this + " looses " + damages + " life points");
        life -= damages;
        if (life <= 0) {
            Logger.getLogger().log("Player " + this + " is dead");
            life = 0;
        }
    }

    /**
     * Is Player still alive?
     *
     * @return true if Player.life > 0
     */
    public boolean isAlive() {
        return life > 0;
    }

    /**
     * Instantaneously kill this Player.
     *
     * Should not be used directly. Mostly used for testing purpose.
     */
    public void kill() {
        life = 0;
    }

    /**
     * Cast a spell to hurt another Player.
     *
     * @param target player to attack
     */
    public void castSpell(Player target) {
        int power = 5 * this.getIntelligence() - target.getEndurance();
        if (canCast(power)) {
            Logger.getLogger().log("Player " + this + " casts a spell to " + target);
            target.hurt(power);
            this.looseMana(power);
            this.gainXp(power * 2);
        } else {
            Logger.getLogger().log("Player " + this + " cannot cast spell (out of mana)");
        }
    }

    /**
     * Consume Player mana.
     *
     * @param mana to consume.
     */
    public void looseMana(int mana) {
        Logger.getLogger().log("Player " + this + " looses " + mana + " mana points");
        this.mana -= mana;
    }

    /**
     * Does player can cast a spell of a specific amount of mana.
     *
     * @param mana used to cast the spell
     * @return true if Player is able to cast the spell
     */
    public boolean canCast(int mana) {
        return this.mana >= mana;
    }

    /**
     * Give some XP to this Player
     *
     * @param xpGain to gain
     */
    public void gainXp(int xpGain) {
        Logger.getLogger().log(name + " gains " + xpGain + " xp");
        while (willLevelUp(xpGain)) {
            xpGain = levelUp(xpGain);
        }
        this.xp += xpGain;
    }

    /**
     * Will this Player level up considering the amount of XP gained?
     *
     * @param xp to gain
     * @return true is the Player will level up
     */
    private boolean willLevelUp(int xp) {
        return this.xp + xp >= nextLevelXp();
    }

    /**
     * Give a level to this Player.
     *
     * @param xp to gain.
     * @return xp remaining after level up.
     */
    public int levelUp(int xp) {
        int rest = this.xp + xp - nextLevelXp();
        this.xp = nextLevelXp();
        this.level += 1;
        Logger.getLogger().log(name + " reaches level " + level);
        return rest;
    }

    /**
     * XP required so this Player can reach the next level.
     *
     * @return XP required to reach the next level
     */
    public int nextLevelXp() {
        return level * (int) Math.pow(10.0, (double) level + 1);
    }

    public String getStatus() {
        return this + " (level: " + getLevel() + ", xp: " + getXp() + ", life: " + getLife() + ", mana: " + getMana() + ")";
    }

    @Override
    public String toString() {
        return getName();
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public int getLife() {
        return life;
    }

    public int getMana() {
        return mana;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getEndurance() {
        return endurance;
    }

}
