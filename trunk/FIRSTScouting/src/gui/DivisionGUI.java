/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * @author Dasty
 */
public class DivisionGUI extends JFrame
{
    private JCheckBox addMatchBlue1DefenseCheckBox;
    private JCheckBox addMatchBlue1DisconnectCheckBox;
    private JLabel addMatchBlue1Label;
    private JTextField addMatchBlue1TextField;
    private JCheckBox addMatchBlue2DefenseCheckBox;
    private JCheckBox addMatchBlue2DisconnectCheckBox;
    private JLabel addMatchBlue2Label;
    private JTextField addMatchBlue2TextField;
    private JLabel addMatchBlueScoreLabel;
    private JTextField addMatchBlueScoreTextField;
    private JLabel addMatchLabel;
    private JLabel addMatchNumLabel;
    private JCheckBox addMatchPlayedCheckBox;
    private JCheckBox addMatchRed1DefenseCheckBox;
    private JCheckBox addMatchRed1DisconnectCheckBox;
    private JLabel addMatchRed1Label;
    private JTextField addMatchRed1TextField;
    private JCheckBox addMatchRed2DefenseCheckBox;
    private JCheckBox addMatchRed2DisconnectCheckBox;
    private JLabel addMatchRed2Label;
    private JTextField addMatchRed2TextField;
    private JLabel addMatchRedScoreLabel;
    private JButton addMatchSubmitButton;
    private JTextField addMatchredScoreTextField;
    private JCheckBox editMatchBlue1DefenseCheckBox;
    private JCheckBox editMatchBlue1DisconnectCheckBox;
    private JLabel editMatchBlue1Label;
    private JTextField editMatchBlue1TextField;
    private JCheckBox editMatchBlue2DefenseCheckBox;
    private JCheckBox editMatchBlue2DisconnectCheckBox;
    private JLabel editMatchBlue2Label;
    private JTextField editMatchBlue2TextField;
    private JLabel editMatchBlueScoreLabel;
    private JTextField editMatchBlueScoreTextField;
    private JLabel editMatchLabel;
    private JLabel editMatchNumLabel;
    private JCheckBox editMatchPlayedCheckBox;
    private JCheckBox editMatchRed1DefenseCheckBox;
    private JCheckBox editMatchRed1DisconnectCheckBox;
    private JLabel editMatchRed1Label;
    private JTextField editMatchRed1TextField;
    private JCheckBox editMatchRed2DefenseCheckBox;
    private JCheckBox editMatchRed2DisconnectCheckBox;
    private JLabel editMatchRed2Label;
    private JTextField editMatchRed2TextField;
    private JLabel editMatchRedScoreLabel;
    private JTextField editMatchRedScoreTextField;
    private JButton editMatchSubmitButton;
    private JTable teamTabel;
    private JTabbedPane mainTabPane;
    private JPanel matchTab;
    private JTable matchTabel;
    private JScrollPane matchTabelScrollPane;
    private JLabel teamCommentsLabel;
    private JLabel teamCommentsNumLabel;
    private JScrollPane teamCommentsScrollPane;
    private JButton teamCommentsSubmitButton;
    private JTextArea teamCommentsTextArea;
    private JButton teamRecalculateDataButton;
    private JScrollPane teamScrollPane;
    private JPanel teamTab;
    private JLabel tourneyNameDivNumLabel;
    
    public DivisionGUI()
    {
        initComponents();
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TournamentInterfaceFTC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TournamentInterfaceFTC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TournamentInterfaceFTC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TournamentInterfaceFTC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TournamentInterfaceFTC().setVisible(true);
            }
        });
    }
    
    private void initComponents() {

        mainTabPane = new JTabbedPane();
        matchTab = new JPanel();
        matchTabelScrollPane = new JScrollPane();
        matchTabel = new JTable();
        editMatchLabel = new JLabel();
        editMatchNumLabel = new JLabel();
        editMatchRed1Label = new JLabel();
        editMatchRed1TextField = new JTextField();
        editMatchRed2Label = new JLabel();
        editMatchRed2TextField = new JTextField();
        editMatchBlue1Label = new JLabel();
        editMatchBlue1TextField = new JTextField();
        editMatchBlue2Label = new JLabel();
        editMatchBlue2TextField = new JTextField();
        editMatchRedScoreLabel = new JLabel();
        editMatchRedScoreTextField = new JTextField();
        editMatchBlueScoreLabel = new JLabel();
        editMatchBlueScoreTextField = new JTextField();
        editMatchPlayedCheckBox = new JCheckBox();
        editMatchSubmitButton = new JButton();
        addMatchLabel = new JLabel();
        addMatchNumLabel = new JLabel();
        addMatchRed1Label = new JLabel();
        addMatchRed1TextField = new JTextField();
        addMatchRed2Label = new JLabel();
        addMatchRed2TextField = new JTextField();
        addMatchBlue1Label = new JLabel();
        addMatchBlue1TextField = new JTextField();
        addMatchBlue2Label = new JLabel();
        addMatchBlue2TextField = new JTextField();
        addMatchRedScoreLabel = new JLabel();
        addMatchredScoreTextField = new JTextField();
        addMatchBlueScoreLabel = new JLabel();
        addMatchBlueScoreTextField = new JTextField();
        addMatchPlayedCheckBox = new JCheckBox();
        addMatchSubmitButton = new JButton();
        editMatchRed1DefenseCheckBox = new JCheckBox();
        editMatchRed1DisconnectCheckBox = new JCheckBox();
        editMatchRed2DisconnectCheckBox = new JCheckBox();
        editMatchRed2DefenseCheckBox = new JCheckBox();
        editMatchBlue1DisconnectCheckBox = new JCheckBox();
        editMatchBlue1DefenseCheckBox = new JCheckBox();
        editMatchBlue2DisconnectCheckBox = new JCheckBox();
        editMatchBlue2DefenseCheckBox = new JCheckBox();
        addMatchRed1DefenseCheckBox = new JCheckBox();
        addMatchRed1DisconnectCheckBox = new JCheckBox();
        addMatchRed2DefenseCheckBox = new JCheckBox();
        addMatchRed2DisconnectCheckBox = new JCheckBox();
        addMatchBlue1DefenseCheckBox = new JCheckBox();
        addMatchBlue1DisconnectCheckBox = new JCheckBox();
        addMatchBlue2DefenseCheckBox = new JCheckBox();
        addMatchBlue2DisconnectCheckBox = new JCheckBox();
        teamTab = new JPanel();
        teamScrollPane = new JScrollPane();
        teamTabel = new JTable();
        teamCommentsLabel = new JLabel();
        teamCommentsNumLabel = new JLabel();
        teamCommentsScrollPane = new JScrollPane();
        teamCommentsTextArea = new JTextArea();
        teamCommentsSubmitButton = new JButton();
        teamRecalculateDataButton = new JButton();
        tourneyNameDivNumLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        matchTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Match #", "Red 1", "Red 2", "Blue 1", "Blue 2", "Red Score", "Blue Score", "Played"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        matchTabelScrollPane.setViewportView(matchTabel);

        editMatchLabel.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        editMatchLabel.setText("Edit Match");

        editMatchNumLabel.setText("Match Number: #");

        editMatchRed1Label.setText("Red 1: ");

        editMatchRed2Label.setText("Red 2: ");

        editMatchBlue1Label.setText("Blue 1: ");

        editMatchBlue2Label.setText("Blue 2: ");

        editMatchRedScoreLabel.setText("Red Score: ");

        editMatchBlueScoreLabel.setText("Blue Score: ");

        editMatchPlayedCheckBox.setText("Played");

        editMatchSubmitButton.setText("Edit");

        addMatchLabel.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        addMatchLabel.setText("Add Match");

        addMatchNumLabel.setText("Match Number: #");

        addMatchRed1Label.setText("Red 1: ");

        addMatchRed2Label.setText("Red 2: ");

        addMatchBlue1Label.setText("Blue 1: ");

        addMatchBlue2Label.setText("Blue 2: ");

        addMatchRedScoreLabel.setText("Red Score: ");

        addMatchBlueScoreLabel.setText("Blue Score: ");

        addMatchPlayedCheckBox.setText("Played");

        addMatchSubmitButton.setText("Add");
        addMatchSubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addMatchSubmitButtonActionPerformed(evt);
            }
        });

        editMatchRed1DefenseCheckBox.setText("DF");

        editMatchRed1DisconnectCheckBox.setText("DC");

        editMatchRed2DisconnectCheckBox.setText("DC");

        editMatchRed2DefenseCheckBox.setText("DF");

        editMatchBlue1DisconnectCheckBox.setText("DC");

        editMatchBlue1DefenseCheckBox.setText("DF");

        editMatchBlue2DisconnectCheckBox.setText("DC");

        editMatchBlue2DefenseCheckBox.setText("DF");

        addMatchRed1DefenseCheckBox.setText("DF");

        addMatchRed1DisconnectCheckBox.setText("DC");

        addMatchRed2DefenseCheckBox.setText("DF");

        addMatchRed2DisconnectCheckBox.setText("DC");

        addMatchBlue1DefenseCheckBox.setText("DF");

        addMatchBlue1DisconnectCheckBox.setText("DC");

        addMatchBlue2DefenseCheckBox.setText("DF");

        addMatchBlue2DisconnectCheckBox.setText("DC");

        GroupLayout matchTabLayout = new GroupLayout(matchTab);
        matchTab.setLayout(matchTabLayout);
        matchTabLayout.setHorizontalGroup(
            matchTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(matchTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(matchTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(matchTabelScrollPane, GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addComponent(editMatchLabel)
                    .addGroup(matchTabLayout.createSequentialGroup()
                        .addGroup(matchTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(editMatchNumLabel)
                            .addComponent(addMatchLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(matchTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(matchTabLayout.createSequentialGroup()
                                .addComponent(editMatchRed1Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchRed1TextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchRed2Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchRed2TextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchBlue1Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchBlue1TextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                            .addGroup(matchTabLayout.createSequentialGroup()
                                .addComponent(editMatchRed1DefenseCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchRed1DisconnectCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchRed2DefenseCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchRed2DisconnectCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchBlue1DefenseCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchBlue1DisconnectCheckBox)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matchTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(matchTabLayout.createSequentialGroup()
                                .addComponent(editMatchBlue2Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchBlue2TextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchRedScoreLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchRedScoreTextField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchBlueScoreLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchBlueScoreTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editMatchPlayedCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(editMatchSubmitButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                            .addGroup(matchTabLayout.createSequentialGroup()
                                .addComponent(editMatchBlue2DefenseCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMatchBlue2DisconnectCheckBox))))
                    .addGroup(matchTabLayout.createSequentialGroup()
                        .addComponent(addMatchNumLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(matchTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(matchTabLayout.createSequentialGroup()
                                .addComponent(addMatchRed1DefenseCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchRed1DisconnectCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchRed2DefenseCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchRed2DisconnectCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchBlue1DefenseCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchBlue1DisconnectCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchBlue2DefenseCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchBlue2DisconnectCheckBox))
                            .addGroup(matchTabLayout.createSequentialGroup()
                                .addComponent(addMatchRed1Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchRed1TextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchRed2Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchRed2TextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchBlue1Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchBlue1TextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMatchBlue2Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchBlue2TextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchRedScoreLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchredScoreTextField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchBlueScoreLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMatchBlueScoreTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addMatchPlayedCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(addMatchSubmitButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        matchTabLayout.setVerticalGroup(
            matchTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(matchTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(matchTabelScrollPane, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editMatchLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(matchTabLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(editMatchNumLabel)
                    .addComponent(editMatchRed1Label)
                    .addComponent(editMatchRed1TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(editMatchRed2Label)
                    .addComponent(editMatchBlue1Label)
                    .addComponent(editMatchBlue2Label)
                    .addComponent(editMatchRedScoreLabel)
                    .addComponent(editMatchBlueScoreLabel)
                    .addComponent(editMatchSubmitButton)
                    .addComponent(editMatchRed2TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(editMatchBlue1TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(editMatchBlue2TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(editMatchRedScoreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(editMatchBlueScoreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(editMatchPlayedCheckBox))
                .addGroup(matchTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(matchTabLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(addMatchLabel))
                    .addGroup(matchTabLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matchTabLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(editMatchRed1DefenseCheckBox)
                            .addComponent(editMatchRed1DisconnectCheckBox)
                            .addComponent(editMatchRed2DefenseCheckBox)
                            .addComponent(editMatchRed2DisconnectCheckBox)
                            .addComponent(editMatchBlue1DefenseCheckBox)
                            .addComponent(editMatchBlue1DisconnectCheckBox)
                            .addComponent(editMatchBlue2DefenseCheckBox)
                            .addComponent(editMatchBlue2DisconnectCheckBox))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(matchTabLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addMatchNumLabel)
                    .addComponent(addMatchRed1Label)
                    .addComponent(addMatchRed1TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMatchRed2Label)
                    .addComponent(addMatchBlue1Label)
                    .addComponent(addMatchRedScoreLabel)
                    .addComponent(addMatchBlueScoreLabel)
                    .addComponent(addMatchSubmitButton)
                    .addComponent(addMatchRed2TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMatchBlue1TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMatchBlue2TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMatchredScoreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMatchBlueScoreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMatchPlayedCheckBox)
                    .addComponent(addMatchBlue2Label))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(matchTabLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addMatchRed1DefenseCheckBox)
                    .addComponent(addMatchRed1DisconnectCheckBox)
                    .addComponent(addMatchRed2DefenseCheckBox)
                    .addComponent(addMatchRed2DisconnectCheckBox)
                    .addComponent(addMatchBlue1DefenseCheckBox)
                    .addComponent(addMatchBlue1DisconnectCheckBox)
                    .addComponent(addMatchBlue2DefenseCheckBox)
                    .addComponent(addMatchBlue2DisconnectCheckBox))
                .addContainerGap())
        );

        mainTabPane.addTab("Division Match List", matchTab);

        teamTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Team #", "Match Count", "Avg Score", "Wtd Score", "Discon %", "Defend %", "Team Comment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        teamTabel.getTableHeader().setReorderingAllowed(false);
        teamScrollPane.setViewportView(teamTabel);

        teamCommentsLabel.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        teamCommentsLabel.setText("Team Comments:");

        teamCommentsNumLabel.setText("Team Number: #");

        teamCommentsTextArea.setColumns(20);
        teamCommentsTextArea.setRows(5);
        teamCommentsScrollPane.setViewportView(teamCommentsTextArea);

        teamCommentsSubmitButton.setText("Update Comment");

        teamRecalculateDataButton.setText("Recalculate Data");

        GroupLayout teamTabLayout = new GroupLayout(teamTab);
        teamTab.setLayout(teamTabLayout);
        teamTabLayout.setHorizontalGroup(
            teamTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(teamTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(teamTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(teamScrollPane, GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, teamTabLayout.createSequentialGroup()
                        .addGroup(teamTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(teamCommentsScrollPane, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE)
                            .addGroup(teamTabLayout.createSequentialGroup()
                                .addComponent(teamCommentsLabel)
                                .addGap(18, 18, 18)
                                .addComponent(teamCommentsNumLabel)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(teamTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(teamCommentsSubmitButton)
                            .addComponent(teamRecalculateDataButton))
                        .addGap(30, 30, 30)))
                .addContainerGap())
        );
        teamTabLayout.setVerticalGroup(
            teamTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(teamTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(teamScrollPane, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(teamTabLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(teamCommentsLabel)
                    .addComponent(teamCommentsNumLabel))
                .addGap(9, 9, 9)
                .addGroup(teamTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(GroupLayout.Alignment.TRAILING, teamTabLayout.createSequentialGroup()
                        .addComponent(teamRecalculateDataButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(teamCommentsSubmitButton))
                    .addComponent(teamCommentsScrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        mainTabPane.addTab("Division Team Rankings", teamTab);

        tourneyNameDivNumLabel.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        tourneyNameDivNumLabel.setText("Tournament Name - Division #");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(mainTabPane)
                    .addComponent(tourneyNameDivNumLabel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tourneyNameDivNumLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainTabPane, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }                                     

    private void addMatchSubmitButtonActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

}   
