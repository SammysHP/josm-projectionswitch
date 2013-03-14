// License: GPLv3, Copyright (C) 2013 Sven Karsten Greiner <sven@sammyshp.de>
package de.sammyshp.josm.projectionswitch;

import org.openstreetmap.josm.Main;
import org.openstreetmap.josm.gui.MainMenu;
import org.openstreetmap.josm.plugins.Plugin;
import org.openstreetmap.josm.plugins.PluginInformation;

public class ProjectionSwitchPlugin extends Plugin {
    public ProjectionSwitchPlugin(PluginInformation info) {
        super(info);

        Main.main.menu.viewMenu.insert(new ProjectionMenu(), 2);
    }
}
