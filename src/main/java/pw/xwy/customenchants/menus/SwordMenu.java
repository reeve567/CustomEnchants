////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.menus;

import pw.xwy.customenchants.enums.ItemSets;

public class SwordMenu extends Menu {
	private static Menu menu;
	
	public SwordMenu() {
		super(ItemSets.SWORD);
		menu = this;
	}
	public static Menu get() {
		return menu;
	}
}