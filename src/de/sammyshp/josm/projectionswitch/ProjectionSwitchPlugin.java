// License: GPLv3, Copyright (C) 2013 Sven Karsten Greiner <sven@sammyshp.de>
package de.sammyshp.josm.projectionswitch;

import javax.swing.JMenu;
import org.openstreetmap.josm.Main;
import org.openstreetmap.josm.gui.MainMenu;
import org.openstreetmap.josm.plugins.Plugin;
import org.openstreetmap.josm.plugins.PluginInformation;

public class ProjectionSwitchPlugin extends Plugin {
    public ProjectionSwitchPlugin(PluginInformation info) {
        super(info);

        JMenu menu = Main.main.menu.viewMenu;
        int index;

        // find end of first group
        for (index = 0; index < menu.getItemCount(); index++) {
            if (menu.getItem(index) == null) {
                break;
            }
        }

        menu.insert(new ProjectionMenu(), index);
    }
}
