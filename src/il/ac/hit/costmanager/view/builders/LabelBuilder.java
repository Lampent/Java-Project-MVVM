package il.ac.hit.costmanager.view.builders;

import javax.swing.*;
import java.awt.*;

public class LabelBuilder implements IBuilder<JLabel> {

    private JLabel label;

    public LabelBuilder(String text) {
        label = new JLabel();

        this.label.setText(text);
        label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12));
    }

    public LabelBuilder setHorizontalAlignment(int alignment) {
        this.label.setHorizontalAlignment(alignment);
        return this;
    }

    public LabelBuilder setFontSize(int size) {
        this.label.setFont(new java.awt.Font(this.label.getFont().getName(), this.label.getFont().getStyle(), size));
        return this;
    }

    @Override
    public JLabel build() {
        return this.label;
    }
}
