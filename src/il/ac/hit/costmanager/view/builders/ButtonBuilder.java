package il.ac.hit.costmanager.view.builders;


import java.awt.*;

public class ButtonBuilder implements IBuilder<javax.swing.JButton> {

    private javax.swing.JButton button;

    public ButtonBuilder(String buttonText) {
        button = new javax.swing.JButton();
        button.setBackground(new java.awt.Color(102, 102, 255));
        button.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12));
        this.setButtonText(buttonText);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setMaximumSize(new java.awt.Dimension(119, 23));
        button.setOpaque(true);
    }

    public void setButtonText(String text) {
        if (text != null) {
            button.setText(text);
        } else {
            button.setText("");
        }
    }

    public javax.swing.JButton build() {
        return button;
    }
}
