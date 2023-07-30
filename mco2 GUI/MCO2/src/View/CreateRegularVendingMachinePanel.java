package View;

import javax.swing.*;
import java.awt.*;

public class CreateRegularVendingMachinePanel extends JPanel{
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public CreateRegularVendingMachinePanel(CardLayout cardLayout, JPanel mainPanel){
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
    }
    
}
