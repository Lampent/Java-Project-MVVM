package il.ac.hit.costmanager.view.builders;

import javax.swing.*;


/**
 * The project builder of a swing layout, more specially a title layout which is common in the different views of the application.
 * Implements the builder design pattern, saving many lines of code in the project for creating title layout.
 * Initializing the label with default values to save this lines of code in the project.
 * Implements the IBuilder interface and implements the build function.
 */
public class TitleLayoutBuilder implements IBuilder<javax.swing.GroupLayout> {

    private javax.swing.GroupLayout titleLayout;

    public TitleLayoutBuilder(JLabel titleLabel, JPanel titlePanel) {
        titleLayout = new javax.swing.GroupLayout(titlePanel);

        titlePanel.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(
                titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        );
        titleLayout.setVerticalGroup(
                titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(titleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    @Override
    public javax.swing.GroupLayout build() {
        return this.titleLayout;
    }
}
