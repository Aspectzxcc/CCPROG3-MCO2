package View;

import javax.swing.*;
import java.awt.*;

public class CreateSpecialVendingMachinePanel extends JPanel{
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public CreateSpecialVendingMachinePanel(CardLayout cardLayout, JPanel mainPanel){
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
    }
    
}
