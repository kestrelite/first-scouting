package firstscouting;

import javax.swing.UIManager;

public class FIRSTScouting {

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        FIRSTScoutingDisp display = new FIRSTScoutingDisp();
    }
}
