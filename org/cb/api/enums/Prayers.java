package org.cb.api.enums;

import java.awt.Rectangle;

/**
 * 
 * @author Troy
 *
 */
public enum Prayers {
	THICK_SKIN("Thick Skin", 1, new Rectangle(555, 212, 30, 32)),
	BURST_STRENGTH("Burst Strength", 4, new Rectangle(592, 212, 30, 32)), 
	CLARITY_THOUGHT("Clarity Thought", 7, new Rectangle(629, 212, 30, 32)),
	SHARP_EYE("Sharp Eye", 8, new Rectangle(666, 212, 30, 32)), 
	MYSTIC_WILL("Mystic Will", 9, new Rectangle(703, 212, 30, 32)), 
	ROCK_SKIN("Rock Skin", 10, new Rectangle(555, 248, 30, 32)), 
	SUPERHUMAN_STRENGTH("Superhuman Strength", 13, new Rectangle(592, 248, 30, 32)), 
	IMPROVED_REFLEXES("Improved Reflexes", 16, new Rectangle(629, 248, 30, 32)), 
	RAPID_RESTORE("Rapid Restore", 19, new Rectangle(666, 248, 30, 32)), 
	RAPID_HEAL("Rapid Heal", 22, new Rectangle(703, 248, 30, 32)), 
	PROTECT_ITEM("Protect Item", 25, new Rectangle(555, 284, 30, 32)), 
	HAWK_EYE("Hawk Eye", 26, new Rectangle(592, 284, 30, 32)), 
	MYSTIC_LORE("Mystic Lore", 27, new Rectangle(629, 284, 30, 32)), 
	STEEL_SKIN("Steel Skin", 28, new Rectangle(666, 284, 30, 32)), 
	ULTIMATE_STRENGTH("Ultimate Strength", 31, new Rectangle(703, 284, 30, 32)), 
	INCREDIBLE_REFLEXES("Incredible Reflexes", 34, new Rectangle(555, 321, 30, 32)), 
	PROTECT_SUMMONING("Protect from Summoning", 35, new Rectangle(592, 321, 30, 32)), 
	PROTECT_MAGIC("Protect from Magic", 37, new Rectangle(629, 321, 30, 32)), 
	PROTECT_MISSILES("Protect from Missiles", 40, new Rectangle(666, 321, 30, 32)), 
	PROTECT_MELEE("Protect from Melee", 43, new Rectangle(703, 321, 30, 32)), 
	EAGLE_EYE("Eagle Eye", 45, new Rectangle(555, 357, 30, 32)), 
	MYSTIC_MIGHT("Mystic Might", 46, new Rectangle(592, 357, 30, 32)), 
	RETRIBUTION("Retribution", 47, new Rectangle(629, 357, 30, 32)), 
	REDEMPTION("Redemption", 49, new Rectangle(666, 357, 30, 32)), 
	SMITE("Smite", 52, new Rectangle(703, 357, 30, 32)), 
	CHIVALRY("Chivalry", 60, new Rectangle(555, 392, 30, 32)),
	RAPID_RENEWAL("Rapid Renewal", 65, new Rectangle(592, 392, 30, 32)),
	PIETY("Piety", 70, new Rectangle(629, 392, 30, 32)),
	RIGOUR("Rigour", 74, new Rectangle(666, 392, 30, 32)),
	AUGURY("Augury", 77, new Rectangle(703, 392, 30, 32));

	private final String name;
	private final int required_level;
	private final Rectangle bounds;

	private Prayers(final String name, final int required_level, final Rectangle bounds) {
		this.name = name;
		this.required_level = required_level;
		this.bounds = bounds;
	}

	public String getName() throws InterruptedException{
		return name;
	}

	public int getLevel() throws InterruptedException{
		return required_level;
	}

	public Rectangle getBounds() {
		return bounds;
	}

}
