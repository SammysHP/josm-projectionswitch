// License: GPLv3, Copyright (C) 2013 Sven Karsten Greiner <sven@sammyshp.de>
package de.sammyshp.josm.projectionswitch;

import static org.openstreetmap.josm.tools.I18n.tr;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.LinkedList;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import org.openstreetmap.josm.Main;
import org.openstreetmap.josm.data.projection.Projection;
import org.openstreetmap.josm.data.projection.ProjectionChangeListener;
import org.openstreetmap.josm.gui.preferences.projection.ProjectionChoice;
import org.openstreetmap.josm.gui.preferences.projection.ProjectionPreference;
import org.openstreetmap.josm.tools.ImageProvider;
import org.openstreetmap.josm.gui.preferences.PreferenceDialog;

public class ProjectionMenu extends JMenu implements ProjectionChangeListener {
    private final List<SwitchAction> actions = new LinkedList<SwitchAction>();

    public ProjectionMenu() {
        super(tr("Projection method"));

        setIcon(ImageProvider.get("map"));

        for (ProjectionChoice pc : ProjectionPreference.getProjectionChoices()) {
            SwitchAction action = new SwitchAction(pc);
            actions.add(action);
            add(action.menuItem);
        }

        addSeparator();
        add(new LaunchProjectionPreferencesAction());

        Main.main.addProjectionChangeListener(this);
        updateState(Main.getProjection());
    }

    private void updateState(final Projection projection) {
        for (SwitchAction action : actions) {
            action.setState(projection);
        }
    }

    @Override
    public void projectionChanged(Projection oldValue, Projection newValue) {
        updateState(newValue);
    }


    public static class LaunchProjectionPreferencesAction extends AbstractAction {
        public LaunchProjectionPreferencesAction() {
            putValue(NAME, tr("Preferences"));
            putValue(SMALL_ICON, ImageProvider.get("projectionpreference"));
            putValue("toolbar", false);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            final PreferenceDialog p = new PreferenceDialog(Main.parent);
            p.selectSubPreferencesTabByClass(ProjectionPreference.class);
            p.setVisible(true);
        }
    }
}
