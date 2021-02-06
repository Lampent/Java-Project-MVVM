package il.ac.hit.costmanager.view.builders;

import javax.swing.*;
import java.awt.*;


/**
 * The project builder of a swing label.
 * Implements the builder design pattern, saving many lines of code in the project for creating label.
 * Initializing the label with default values to save this lines of code in the project.
 * Exposing set functionality with validation and default value for dynamic parameters.
 * Implements the IBuilder interface and implements the build function.
 */
public class LabelBuilder implements IBuilder<JLabel> {

    // the built label instance
    private JLabel label;

    /**
     * Constructor of the label builder
     *
     * @param text the text of the label. Every labelzas most provide it,
     *             therefor we provide it in the constructor and not in setter.
     */
    public LabelBuilder(String text) {
        // initializing new swing label
        label = new JLabel();

        // set the label text with the received text and sets the default label font.
        this.label.setText(text);
        label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12));
    }

    /**
     * Sets the horizontalAlignment of the label.
     *
     * @param alignment the alignment option.
     * @return the LabelBuilder.
     */
    public LabelBuilder setHorizontalAlignment(int alignment) {
        this.label.setHorizontalAlignment(alignment);
        return this;
    }

    /**
     * Sets the label font size.
     *
     * @param size the label font size.
     * @return the LabelBuilder.
     */
    public LabelBuilder setFontSize(int size) {
        this.label.setFont(new java.awt.Font(this.label.getFont().getName(), this.label.getFont().getStyle(), size));
        return this;
    }

    /**
     * The build function returns the built label.
     *
     * @return the built label.
     */
    @Override
    public JLabel build() {
        return this.label;
    }
}
