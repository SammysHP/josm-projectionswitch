// License: GPLv3, Copyright (C) 2013 Sven Karsten Greiner <sven@sammyshp.de>
package de.sammyshp.josm.projectionswitch;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JCheckBoxMenuItem;
import org.openstreetmap.josm.Main;
import org.openstreetmap.josm.data.projection.Projection;
import org.openstreetmap.josm.gui.preferences.projection.ProjectionChoice;

public class SwitchAction extends AbstractAction {
    public final ProjectionChoice projectionChoice;
    public final JCheckBoxMenuItem menuItem;

    public SwitchAction(final ProjectionChoice projectionChoice) {
        super(projectionChoice.toString());

        this.projectionChoice = projectionChoice;
        this.menuItem = new JCheckBoxMenuItem(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Main.setProjection(projectionChoice.getProjection());
    }

    public void setState(final Projection projection) {
        try {
            menuItem.setState(projectionChoice.getProjection().toCode().equals(projection.toCode()));
        } catch (Exception e) {
        }
    }
}
