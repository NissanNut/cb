package org.cb.api.enums;

import org.cb.api.Constants;

/**
 * 
 * @author Troy
 *
 */
public enum Spells {
	HOME_TELEPORT("Home Teleport", 0, null,null, 0),
	VARROCK_TELEPORT("Varrock Teleport", 25, new int[]{3,1,1}, new int[]{0,3,9}, 17),
	LUMBRIDGE_TELEPORT("Lumbridge Teleport", 31, new int[]{3,1,1}, new int[]{0,2,9}, 20),
	FALADOR_TELEPORT("Falador Teleport", 37, new int[]{3,1,1}, new int[]{0,1,9}, 23),
	CAMELOT_TELEPORT("Camelot Teleport", 45, new int[]{5,1}, new int[]{0,9}, 28),
	ARDOUGNE_TELEPORT("Ardounge Teleport", 51, new int[]{2,2}, new int[]{2,9}, 34),
	TROLLHEIM_TELEPORT("Trollheim Teleport", 61, new int[]{2,2}, new int[]{3,9}, 46),
	WATCHTOWER_TELEPORT("Watchtower", 58, new int[]{2,2}, new int[]{2,9}, 39),
	MOBILISING_ARMIES_TELEPORT("Mobilising Armies Teleport", 10, new int[]{1,1,1}, new int[]{9,1,0}, 8),
	TELEPORT_TO_HOUSE("Teleport To House", 40, new int[]{1,1,1}, new int[]{0,2,9}, 25),
	TELEPORT_TO_APE_ATOLL("Teleport To Ape Atoll", 64, new int[]{2,2,2}, new int[]{3,2,9}, 49),
	TELEOTHER_LUMBRIDGE("Teleother Lumbridge", 74, new int[]{1,1,1}, new int[]{13,9,2}, 56),
	TELEOTHER_FALADOR("Teleother Falador", 82, new int[]{1,1,1}, new int[]{13,9,1}, 62),
	TELEOTHER_CAMELOT("Teleother Camelot", 90, new int[]{2,1}, new int[]{13,9}, 67),
	TELEBLOCK("Teleblock", 85, new int[]{1,1,1}, new int[]{6,9,7}, 64),
	
	BONES_TO_BANANAS("Bones To Bananas", 15, new int[]{2,2,1}, new int[]{2,1,10}, 11),
	BONES_TO_PEACHES("Bones To Peaches", 60, new int[]{4,4,2}, new int[]{2,1,10}, 45),
	LOW_LEVEL_ALCHEMY("Low Level Alchemy", 21, new int[]{3,1}, new int[]{3,10}, 15),
	HIGH_LEVEL_ALCHEMY("High Level Alchemy", 55, new int[]{5,1}, new int[]{3,10}, 36),
	TELEKINETIC_GRAB("Telekinetic Grab", 33, new int[]{1,1}, new int[]{0,9}, 21),
	CHARGE("Charge", 80, new int[]{3,3,3}, new int[]{0,3,12}, 60),
	
	LVL1_ENCHANT("Lvl-1 Enchant", 7, new int[]{1,1}, new int[]{1,8}, 5),
	LVL2_ENCHANT("Lvl-2 Enchant", 27, new int[]{3,1}, new int[]{0,8}, 18),
	LVL3_ENCHANT("Lvl-3 Enchant", 49, new int[]{5,1}, new int[]{3,8}, 30),
	LVL4_ENCHANT("Lvl-4 Enchant", 57, new int[]{10,1}, new int[]{2,8}, 38),
	LVL5_ENCHANT("Lvl-5 Enchant", 68, new int[]{15,15,1}, new int[]{2,1,8}, 53),
	LVL6_ENCHANT("Lvl-6 Enchant", 87, new int[]{1,20,20}, new int[]{8,2,3}, 65),
	BOLT_ENCHANTMENT("Bolt Enchantment", 4, null, null, 6),
	CHARGE_WATER_ORB("Charge Water Orb", 56, new int[]{30,3}, new int[]{1,8}, 37),
	CHARGE_EARTH_ORB("Charge Earth Orb", 60, new int[]{30,3}, new int[]{2,8}, 44),
	CHARGE_FIRE_ORB("Charge Fire Orb", 63, new int[]{30,3}, new int[]{3,8}, 48),
	CHARGE_AIR_ORB("Charge Air Orb", 66, new int[]{30,3}, new int[]{0,8}, 51),
	SUPERHEAT_ITEM("Superheat Item", 43, new int[]{4,1}, new int[]{3,10}, 27),
	
	WIND_RUSH("Wind Rush", 1, new int[]{2}, new int[]{0}, 1),
	WIND_STRIKE("Wind Strike", 1, new int[]{1,1}, new int[]{0,4}, 2),
	WATER_STRIKE("Water Strike", 5, new int[]{1,1,1}, new int[]{1,0,4}, 4),
	EARTH_STRIKE("Earth Strike", 9, new int[]{2,1,1}, new int[]{2,0,4}, 7),
	FIRE_STRIKE("Fire Strike", 13, new int[]{2,3,1}, new int[]{0,3,4}, 10),
	WIND_BOLT("Wind Bolt", 17, new int[]{2,1}, new int[]{0,6}, 12),
	WATER_BOLT("Water Bolt", 23, new int[]{2,2,1}, new int[]{0,2,6}, 16),
	EARTH_BOLT("Earth Bolt", 29, new int[]{2,3,1}, new int[]{0,2,6}, 19),
	FIRE_BOLT("Fire Bolt", 35, new int[]{3,4,1}, new int[]{0,3,6}, 22),
	WIND_BLAST("Wind Blast", 41, new int[]{3,1}, new int[]{0,7}, 26),
	WATER_BLAST("Water Blast", 47, new int[]{3,3,1}, new int[]{0,1,7}, 29),
	EARTH_BLAST("Earth Blast", 53, new int[]{3,4,1}, new int[]{0,2,7}, 35),
	FIRE_BLAST("Fire Blast", 59, new int[]{4,5,1}, new int[]{0,3,7}, 40),
	WIND_WAVE("Wind Wave", 62, new int[]{5,1}, new int[]{0,12}, 47),
	WATER_WAVE("Water Wave", 65, new int[]{7,5,1}, new int[]{1,0,12}, 50),
	EARTH_WAVE("Earth Wave", 70, new int[]{7,5,1}, new int[]{2,0,12}, 54),
	FIRE_WAVE("Fire Wave", 75, new int[]{7,5,1}, new int[]{3,0,12}, 57),
	WIND_SURGE("Wind surge", 81, new int[]{7,1,1}, new int[]{0,7,12}, 61),
	WATER_SURGE("Water surge", 85, new int[]{10,7,1,1}, new int[]{1,0,7,12}, 63),
	EARTH_SURGE("Earth surge", 90, new int[]{10,7,1,1}, new int[]{2,0,7,12}, 66),
	FIRE_SURGE("Fire surge", 95, new int[]{10,7,1,1}, new int[]{3,0,7,12}, 68),
	
	CONFUSE("Confuse", 3, new int[]{3,2,1}, new int[]{1,2,5}, 3),
	WEAKEN("Weaken", 11, new int[]{3,2,1}, new int[]{1,2,5}, 9),
	CURSE("Curse", 19, new int[]{2,3,1}, new int[]{1,2,5}, 13),
	CRUMBLE_UNDEAD("Crumble Undead", 39, new int[]{2,2,1}, new int[]{0,2,6}, 24),
	VULNERABILITY("Vulnerability", 66, new int[]{5,5,1}, new int[]{2,1,13}, 52),
	ENFEEBLE("Enfeeble", 73, new int[]{8,8,1}, new int[]{2,1,13}, 55),
	STUN("Stun", 80, new int[]{12,12,1}, new int[]{2,1,13}, 59),
	
	BIND("Bind", 20, new int[]{3,3,2}, new int[]{2,1,10}, 14),
	SNARE("Snare", 50, new int[]{4,4,3}, new int[]{2,1,10}, 32),
	ENTANGLE("Entangle", 79, new int[]{5,5,4}, new int[]{2,1,10}, 58),
	
	IBAN_BLAST("Iban Blast", 50, new int[]{5,1}, new int[]{3,7}, 31),
	MAGIC_DART("Magic Dart", 50, new int[]{1,4}, new int[]{7,4}, 33),
	CLAWS_OF_GUTHIX("Claws of Guthix", 60, new int[]{4,1,2}, new int[]{0,3,12}, 41),
	SARADOMIN_STRIKE("Saradomin Strike", 60, new int[]{4,2,2}, new int[]{0,3,12}, 42),
	FLAMES_OF_ZAMORAK("Flames of Zamorak", 60, new int[]{1,4,2}, new int[]{0,3,12}, 43),
	STORM_OF_ARMADYL("Storm of Armadyl", 77, new int[]{1}, new int[]{14}, 69);
	
	private final String name;
	private final int required_level;
	private final int[] requiredRuneAmounts;
	private final int[] requiredRunes;
	private final int image;

	private Spells(final String name, final int required_level, int[] requiredRuneAmounts, int[] requiredRunes, int image) {
		this.name = name;
		this.required_level = required_level;
		this.requiredRuneAmounts = requiredRuneAmounts;
		this.requiredRunes = requiredRunes;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public int getRequired_level() {
		return required_level;
	}

	public int[] getRequiredRuneAmounts() {
		return requiredRuneAmounts;
	}

	public String[] getRequiredRunes() {
		String[] runestring = new String[requiredRunes.length];
		
		for(int i = 0; i < requiredRunes.length; i++)
			runestring[i] = Constants.getRunes()[requiredRunes[i]];
		
		return runestring;
	}

	public int getImage() {
		return image;
	}

}
