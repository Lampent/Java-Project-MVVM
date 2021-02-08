/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.builders;

import java.awt.*;

/**
 * The project builder of a swing button.
 * Implements the builder design pattern, saving many lines of code in the project for creating button.
 * Initializing the button with default values to save this lines of code in the project.
 * Exposing set functionality with validation and default value for dynamic parameters.
 */
public class ButtonBuilder implements IBuilder<javax.swing.JButton> {

    // the built button instance
    private javax.swing.JButton button;

    /**
     * Constructor of the button builder.
     *
     * @param buttonText The text of the button. Every button most provide it,
     *                   therefor we provide it in the constructor and not in setter.
     */
    public ButtonBuilder(String buttonText) {
        // Initializing the swing button and setting all default values plus button text with the received buttonText
        button = new javax.swing.JButton();
        button.setBackground(new java.awt.Color(102, 102, 255));
        button.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12));
        this.setButtonText(buttonText);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setMaximumSize(new java.awt.Dimension(119, 23));
        button.setOpaque(true);
    }

    /**
     * Sets the button text with validation.
     * If the text provided is null then sets the button text with empty string.
     *
     * @param text the button text.
     * @return the ButtonBuilder.
     */
    public ButtonBuilder setButtonText(String text) {
        if (text != null) {
            button.setText(text);
        } else {
            button.setText("");
        }
        return this;
    }

    /**
     * Sets the default capable of the button.
     *
     * @param capable boolean value represents the capable.
     * @return the ButtonBuilder.
     */
    public ButtonBuilder setDefaultCapable(boolean capable) {
        this.button.setDefaultCapable(capable);
        return this;
    }

    /**
     * Returned the built button.
     *
     * @return the built button.
     */
    public javax.swing.JButton build() {
        return button;
    }
}
