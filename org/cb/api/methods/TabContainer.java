package org.cb.api.methods;

import org.cb.api.ColourMethods;
import org.cb.api.methods.tabs.Attack;
import org.cb.api.methods.tabs.Clan;
import org.cb.api.methods.tabs.Equipment;
import org.cb.api.methods.tabs.Friends;
import org.cb.api.methods.tabs.Ignore;
import org.cb.api.methods.tabs.Inventory;
import org.cb.api.methods.tabs.Logout;
import org.cb.api.methods.tabs.Magic;
import org.cb.api.methods.tabs.Music;
import org.cb.api.methods.tabs.Objective;
import org.cb.api.methods.tabs.Options;
import org.cb.api.methods.tabs.Prayer;
import org.cb.api.methods.tabs.Quest;
import org.cb.api.methods.tabs.Statistics;

/**
 * 
 * @author Troy
 * 
 */
public class TabContainer {
	public Attack Attack;
	public Clan Clan;
	public Equipment Equipment;
	public Friends Friends;
	public Ignore Ignore;
	public Inventory Inventory;
	public Logout Logout;
	public Magic Magic;
	public Music Music;
	public Objective Objective;
	public Prayer Prayer;
	public Quest Quest;
	public Statistics Statistics;
	public Options Options;
	
	public TabContainer(ColourMethods cm){
		Attack = new Attack(cm);
		Clan = new Clan(cm);
		Equipment = new Equipment(cm);
		Friends = new Friends(cm);
		Ignore = new Ignore(cm);
		Inventory = new Inventory(cm);
		Logout = new Logout(cm);
		Magic = new Magic(cm);
		Music = new Music(cm);
		Objective = new Objective(cm);
		Prayer = new Prayer(cm);
		Quest = new Quest(cm);
		Statistics = new Statistics(cm);
		Options = new Options(cm);
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		Attack.cleanUp();
		Clan.cleanUp();
		Equipment.cleanUp();
		Friends.cleanUp();
		Ignore.cleanUp();
		Inventory.cleanUp();
		Logout.cleanUp();
		Magic.cleanUp();
		Music.cleanUp();
		Objective.cleanUp();
		Prayer.cleanUp();
		Quest.cleanUp();
		Statistics.cleanUp();
		Options.cleanUp();
		
		Attack = null;
		Clan = null;
		Equipment = null;
		Friends = null;
		Ignore = null;
		Inventory = null;
		Logout = null;
		Magic = null;
		Music = null;
		Objective = null;
		Prayer = null;
		Quest = null;
		Statistics = null;
		Options = null;
	}

}
