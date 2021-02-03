package il.ac.hit.costmanager.view.builders;

import javax.swing.*;
import java.awt.*;

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
