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
// on 6:22 PM


import pw.xwy.customenchants.utilities.enums.ItemSets;

public class PickMenu extends Menu {
	private static Menu menu;
	
	public PickMenu() {
		super(ItemSets.PICK);
		menu = this;
	}
	
	public static Menu get() {
		return menu;
	}
}
