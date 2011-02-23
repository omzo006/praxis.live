/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.neilcsmith.praxis.live.core;

import net.neilcsmith.praxis.live.core.api.HubManager;
import net.neilcsmith.praxis.live.core.api.HubManager.StateException;
import org.openide.modules.ModuleInstall;
import org.openide.util.Exceptions;

/**
 * Manages a module's lifecycle. Remember that an installer is optional and
 * often not needed at all.
 */
public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        try {
            HubManager.getDefault().start();
        } catch (StateException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}