////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.utilities.menu;
// made by reeve
// on 7:17 PM


import pw.xwy.customenchants.utilities.enums.ItemSets;

public class ChestMenu extends Menu {
	
	private static Menu menu;
	
	public ChestMenu() {
		super(ItemSets.CHEST);
		menu = this;
	}
	
	public static Menu get() {
		return menu;
	}
	
}
