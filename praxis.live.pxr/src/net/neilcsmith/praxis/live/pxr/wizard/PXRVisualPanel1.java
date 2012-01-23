/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2011 Neil C Smith.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 3 for more details.
 *
 * You should have received a copy of the GNU General Public License version 3
 * along with this work; if not, see http://www.gnu.org/licenses/
 *
 *
 * Please visit http://neilcsmith.net if you need additional information or
 * have any questions.
 */
package net.neilcsmith.praxis.live.pxr.wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.neilcsmith.praxis.core.ComponentType;
import net.neilcsmith.praxis.live.components.api.Components;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

final class PXRVisualPanel1 extends JPanel implements DocumentListener, ActionListener {

    private PXRWizardPanel1 wizardPanel;
    private FileChooserBuilder fileChooser;
    private File location;

    PXRVisualPanel1(PXRWizardPanel1 wizardPanel) {
        this.wizardPanel = wizardPanel;
        initComponents();
        FileObject loc = wizardPanel.getTargetFolder();
        if (loc != null) {
            location = FileUtil.toFile(loc);
        }
        fileChooser = new FileChooserBuilder(PXRWizardIterator.class).setDirectoriesOnly(true).setApproveText("Select");
        if (location != null) {
            fileChooser.setDefaultWorkingDirectory(location).forceUseOfDefaultWorkingDirectory(true);
            locationField.setText(location.toString());
            fileField.setText(location.toString());
        }
        
//        Set<ComponentType> types = Components.getAllRootTypes();
//        for (ComponentType type : types) {
//            typeField.addItem(type);
//        }

        // Temporary fixed root types for EA release
        // @TODO remove temporary fixed types.
        ComponentType type = wizardPanel.type;
        if (type == null) {
            typeField.addItem(ComponentType.create("root:audio"));
            typeField.addItem(ComponentType.create("root:video"));

            typeField.addActionListener(this);
        } else {
            typeField.addItem(type);
            typeField.setEnabled(false);
        }
        
        idField.getDocument().addDocumentListener(this);
             
        autostartField.addActionListener(this);
        buildField.addActionListener(this);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        String id = initialRootID(location, wizardPanel.type);
        if (!id.isEmpty()) {
            idField.setText(id);  
        } 
    }

    
    
    private String initialRootID(File dir, ComponentType type) {
        if (dir == null || type == null) {
            return "";
        }
        String typeString = type.toString();
        if (!typeString.startsWith("root:")) {
            return "";
        }
        typeString = typeString.substring(5);
        File f = new File(dir, typeString + ".pxr");
        if (!f.exists()) {
            return typeString;
        }
        return "";
    }
    
    @Override
    public String getName() {
        return "Root File";
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idField = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        locationField = new javax.swing.JTextField();
        locationLabel = new javax.swing.JLabel();
        browseButton = new javax.swing.JButton();
        fileField = new javax.swing.JTextField();
        fileLabel = new javax.swing.JLabel();
        typeField = new javax.swing.JComboBox();
        typeLabel = new javax.swing.JLabel();
        buildField = new javax.swing.JCheckBox();
        autostartField = new javax.swing.JCheckBox();

        idField.setText(org.openide.util.NbBundle.getMessage(PXRVisualPanel1.class, "PXRVisualPanel1.idField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(idLabel, org.openide.util.NbBundle.getMessage(PXRVisualPanel1.class, "PXRVisualPanel1.idLabel.text")); // NOI18N

        locationField.setEditable(false);

        org.openide.awt.Mnemonics.setLocalizedText(locationLabel, org.openide.util.NbBundle.getMessage(PXRVisualPanel1.class, "PXRVisualPanel1.locationLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(browseButton, org.openide.util.NbBundle.getMessage(PXRVisualPanel1.class, "PXRVisualPanel1.browseButton.text")); // NOI18N
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        fileField.setEditable(false);

        org.openide.awt.Mnemonics.setLocalizedText(fileLabel, org.openide.util.NbBundle.getMessage(PXRVisualPanel1.class, "PXRVisualPanel1.fileLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(typeLabel, org.openide.util.NbBundle.getMessage(PXRVisualPanel1.class, "PXRVisualPanel1.typeLabel.text")); // NOI18N

        buildField.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(buildField, org.openide.util.NbBundle.getMessage(PXRVisualPanel1.class, "PXRVisualPanel1.buildField.text")); // NOI18N

        autostartField.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(autostartField, org.openide.util.NbBundle.getMessage(PXRVisualPanel1.class, "PXRVisualPanel1.autostartField.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(locationLabel)
                    .addComponent(idLabel)
                    .addComponent(fileLabel)
                    .addComponent(typeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(autostartField)
                    .addComponent(buildField)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(typeField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fileField)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(locationField, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(browseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton)
                    .addComponent(locationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileLabel))
                .addGap(18, 18, 18)
                .addComponent(buildField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(autostartField)
                .addContainerGap(92, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        File loc = fileChooser.showOpenDialog();
        if (loc != null) {
            location = loc;
            locationField.setText(location.toString());
        }
    }//GEN-LAST:event_browseButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox autostartField;
    private javax.swing.JButton browseButton;
    private javax.swing.JCheckBox buildField;
    private javax.swing.JTextField fileField;
    private javax.swing.JLabel fileLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField locationField;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JComboBox typeField;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables

    File getFileFolder() {
        return location;
    }

    String getRootID() {
        return idField.getText();
    }

    boolean getBuild() {
        return buildField.isSelected();
    }

    boolean getAutostart() {
        return autostartField.isSelected();
    }

    ComponentType getType() {
        return (ComponentType) typeField.getSelectedItem();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        update();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        update();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        update();
    }

    private void update() {
        if (location != null) {
            fileField.setText(locationField.getText() + "/" + idField.getText() + ".pxr");
        }
        wizardPanel.validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        wizardPanel.validate();
    }
}
