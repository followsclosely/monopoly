package io.github.followsclosley.monopoly.ui;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    protected final Dimension DEFAULT_MINIMUM_SIZE = new Dimension(300, 700);

    @Override
    public Dimension getPreferredSize() {
        return DEFAULT_MINIMUM_SIZE;
    }
}
