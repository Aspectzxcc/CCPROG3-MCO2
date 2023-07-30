package View;

import javax.swing.*;
import java.awt.*;

public class TestVendingMachinePanel extends JPanel{
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public TestVendingMachinePanel(CardLayout cardLayout, JPanel mainPanel){
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
    }
    
}
