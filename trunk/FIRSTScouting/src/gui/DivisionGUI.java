/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import tournamentftc.DivisionDataFTC;
import tournamentftc.MatchFTC;
import tournamentftc.QuickSort;

/**
 *
 * @author Dasty
 */
public class DivisionGUI extends JFrame {

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
    private JTextField addMatchRedScoreTextField;
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
    private JTable teamTable;
    private JTabbedPane mainTabPane;
    private JPanel matchTab;
    private JTable matchTable;
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
    private DefaultTableModel matchTableModel;
    private DefaultTableModel teamTableModel;
    private DivisionDataFTC d;

    public DivisionGUI(DivisionDataFTC div) {
        initComponents();

        d = div;
        loadTablesWithData();

        this.setVisible(true);
    }

    private void initComponents() {
        mainTabPane = new JTabbedPane();
        matchTab = new JPanel();
        matchTabelScrollPane = new JScrollPane();
        matchTable = new JTable();
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
        addMatchRedScoreTextField = new JTextField();
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
        teamTable = new JTable();
        teamCommentsLabel = new JLabel();
        teamCommentsNumLabel = new JLabel();
        teamCommentsScrollPane = new JScrollPane();
        teamCommentsTextArea = new JTextArea();
        teamCommentsSubmitButton = new JButton();
        teamRecalculateDataButton = new JButton();
        tourneyNameDivNumLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        matchTableModel = new DefaultTableModel(new String[]{"Match #", "Red 1", "Red 2", "Blue 1", "Blue 2", "Red Score", "Blue Score", "Played"}, 0) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        matchTable.setModel(matchTableModel);
        matchTable.getTableHeader().setReorderingAllowed(false);
        matchTable.getColumnModel().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                matchTableUpdated(e);
            }
        });
        matchTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                matchTableUpdated(e);
            }
        });
        
        matchTable.getTableHeader().addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e)
            {
                matchTableHeaderClicked(matchTable.getColumnModel().getColumnIndexAtX(e.getX()));
            }
        });
        matchTabelScrollPane.setViewportView(matchTable);

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
        editMatchSubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editMatchSubmitButtonActionPerformed(evt);
            }
        });

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

        editMatchRed1DefenseCheckBox.setText("DFR1");

        editMatchRed1DisconnectCheckBox.setText("DCR1");

        editMatchRed2DisconnectCheckBox.setText("DCR2");

        editMatchRed2DefenseCheckBox.setText("DFR2");

        editMatchBlue1DisconnectCheckBox.setText("DCB1");

        editMatchBlue1DefenseCheckBox.setText("DFB1");

        editMatchBlue2DisconnectCheckBox.setText("DCB2");

        editMatchBlue2DefenseCheckBox.setText("DFB2");

        addMatchRed1DefenseCheckBox.setText("DFR1");

        addMatchRed1DisconnectCheckBox.setText("DCR1");

        addMatchRed2DefenseCheckBox.setText("DFR2");

        addMatchRed2DisconnectCheckBox.setText("DCR2");

        addMatchBlue1DefenseCheckBox.setText("DFB1");

        addMatchBlue1DisconnectCheckBox.setText("DCB1");

        addMatchBlue2DefenseCheckBox.setText("DFB2");

        addMatchBlue2DisconnectCheckBox.setText("DCB2");

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
                .addComponent(addMatchRedScoreTextField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addMatchBlueScoreLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addMatchBlueScoreTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMatchPlayedCheckBox)
                .addGap(18, 18, 18)
                .addComponent(addMatchSubmitButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap()));
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
                .addComponent(addMatchRedScoreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap()));

        mainTabPane.addTab("Division Match List", matchTab);

        teamTableModel = new DefaultTableModel(new String[]{"Team #", "Match Count", "Avg Score", "Wtd Score", "Discon %", "Defend %", "QualPts", "RankPts", "Team Comment"}, 0) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        teamTable.setModel(teamTableModel);

        teamTable.getTableHeader().setReorderingAllowed(false);
        teamScrollPane.setViewportView(teamTable);
        
        teamTable.getColumnModel().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                teamTableUpdated(e);
            }
        });
        teamTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                teamTableUpdated(e);
            }
        });
        
        teamTable.getTableHeader().addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e)
            {
                teamTableHeaderClicked(teamTable.getColumnModel().getColumnIndexAtX(e.getX()));
            }
        });

        teamCommentsLabel.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        teamCommentsLabel.setText("Team Comments:");

        teamCommentsNumLabel.setText("Team Number: #");

        teamCommentsTextArea.setColumns(20);
        teamCommentsTextArea.setRows(5);
        teamCommentsScrollPane.setViewportView(teamCommentsTextArea);

        teamCommentsSubmitButton.setText("Update Comment");
        teamCommentsSubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                teamCommentsSubmitButtonActionPerformed(evt);
            }
        });

        teamRecalculateDataButton.setText("Recalculate Data");
        teamRecalculateDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                teamRecalculateDataButtonActionPerformed(evt);
            }
        });

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
                .addContainerGap()));
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
                .addContainerGap()));

        mainTabPane.addTab("Division Team Rankings", teamTab);

        tourneyNameDivNumLabel.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        tourneyNameDivNumLabel.setText("Tournament Name - Division #");
        
        tourneyNameDivNumLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==2){
                    String tName = JOptionPane.showInputDialog("Enter the Tournament Name.");
                    String divNum = JOptionPane.showInputDialog("Enter the Division Number.");
                    
                    if(tName != null & divNum != null)
                        tourneyNameDivNumLabel.setText(tName+" - Division "+divNum);
                }
            }
        });
        

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(mainTabPane)
                .addComponent(tourneyNameDivNumLabel))
                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tourneyNameDivNumLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainTabPane, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap()));

        pack();
    }

    private void loadTablesWithData() {
        clearTables();
        for (MatchFTC match : d.matchList) {
            matchTableModel.addRow(new Object[]{match.getId() + 1, match.getR1(), match.getR2(), match.getB1(), match.getB2(), match.getScoreRed(), match.getScoreBlue(), "Yes"});
        }

        for (int i = 0; i < d.sortedIndex.size(); i++) {
            teamTableModel.addRow(new Object[]{d.teamNumber.get(d.sortedIndex.get(i)), d.teamMatchCnt.get(d.sortedIndex.get(i)), d.roundTo(d.teamAvgScore.get(d.sortedIndex.get(i)).doubleValue(), 3), d.roundTo(d.teamWtdScore.get(d.sortedIndex.get(i)).doubleValue(), 3), d.teamDisconPct.get(d.sortedIndex.get(i)) + "%", d.teamDefendPct.get(d.sortedIndex.get(i)) + "%", d.teamRankingPt.get(d.sortedIndex.get(i)), d.teamQualifyPt.get(d.sortedIndex.get(i)), d.teamComment.get(d.sortedIndex.get(i))});
        }
    }

    private void clearTables() {
        for (int i = 0; i < matchTableModel.getRowCount(); i++) {
            matchTableModel.removeRow(i);
        }
        matchTableModel.setRowCount(0);
        for (int i = 0; i < teamTableModel.getRowCount(); i++) {
            teamTableModel.removeRow(i);
        }
        teamTableModel.setRowCount(0);
    }

    private void addMatchSubmitButtonActionPerformed(ActionEvent evt) {
        d.addMatch(new MatchFTC(Integer.parseInt(addMatchRed1TextField.getText()), Integer.parseInt(addMatchRed2TextField.getText()), Integer.parseInt(addMatchBlue1TextField.getText()), Integer.parseInt(addMatchBlue2TextField.getText()), Integer.parseInt(addMatchRedScoreTextField.getText()), Integer.parseInt(addMatchBlueScoreTextField.getText())));
        d.calcAll();
        this.loadTablesWithData();
    }

    private void editMatchSubmitButtonActionPerformed(ActionEvent evt) {
        if (matchTable.getSelectedRow() >= 0) {
            d.matchList.get(matchTable.getSelectedRow()).setTeams(Integer.parseInt(editMatchRed1TextField.getText()), Integer.parseInt(editMatchRed2TextField.getText()), 
                    Integer.parseInt(editMatchBlue1TextField.getText()), Integer.parseInt(editMatchBlue2TextField.getText()));
            d.matchList.get(matchTable.getSelectedRow()).setScore(Integer.parseInt(editMatchRedScoreTextField.getText()), Integer.parseInt(editMatchBlueScoreTextField.getText()));
            d.calcAll();
            this.loadTablesWithData();
        }
    }
    
    private void teamCommentsSubmitButtonActionPerformed(ActionEvent evt) {
        d.setTeamComment(Integer.parseInt(teamCommentsNumLabel.getText().substring("Team Number: ".length())), teamCommentsTextArea.getText());
        this.loadTablesWithData();
    }
    
    private void teamRecalculateDataButtonActionPerformed(ActionEvent evt) {
        d.calcAll();
        this.loadTablesWithData();
    }

    public void matchTableUpdated(ListSelectionEvent e) {
        MatchFTC match = d.matchList.get(matchTable.getSelectedRow() < 0 ? 0 : matchTable.getSelectedRow());
        editMatchNumLabel.setText("Match Number: " + (match.getId() + 1));
        editMatchRed1TextField.setText("" + match.getR1());
        editMatchRed2TextField.setText("" + match.getR2());
        editMatchBlue1TextField.setText("" + match.getB1());
        editMatchBlue2TextField.setText("" + match.getB2());
        editMatchRedScoreTextField.setText("" + match.getScoreRed());
        editMatchBlueScoreTextField.setText("" + match.getScoreBlue());
        this.editMatchRed1DefenseCheckBox.setSelected(match.getR1Def());
        this.editMatchRed1DisconnectCheckBox.setSelected(match.getR1ConFail());
        this.editMatchRed2DefenseCheckBox.setSelected(match.getR2Def());
        this.editMatchRed2DisconnectCheckBox.setSelected(match.getR2ConFail());
        this.editMatchBlue1DefenseCheckBox.setSelected(match.getB1Def());
        this.editMatchBlue1DisconnectCheckBox.setSelected(match.getB1ConFail());
        this.editMatchBlue2DefenseCheckBox.setSelected(match.getB2Def());
        this.editMatchBlue2DisconnectCheckBox.setSelected(match.getB2ConFail());
    }
    
    public void teamTableUpdated(ListSelectionEvent e) {
        int index = teamTable.getSelectedRow() < 0 ? 0 : teamTable.getSelectedRow();
        int teamNumber = d.teamNumber.get(index);
        teamCommentsNumLabel.setText("Team Number: "+teamNumber);
        teamCommentsTextArea.setText(d.teamComment.get(index));
    }
    
    public void matchTableHeaderClicked(int i)
    {
        //DO SORTING STUFF
    }
    
    public void teamTableHeaderClicked(int i)
    {
        if(i == 0)
        {
            //sort by team number
            d.sortedIndex = QuickSort.Rank(d.teamNumber);
        }
        else if(i == 1)
        {
            //sort by match count
            d.sortedIndex = QuickSort.Rank(d.teamMatchCnt);
        }
        else if(i == 2)
        {
            //sort by avg score
            d.sortedIndex = QuickSort.Rank(d.teamAvgScore);
        }
        else if(i == 3)
        {
            //sort by wtd score
            d.sortedIndex = QuickSort.Rank(d.teamWtdScore);
        }
        else if(i == 4)
        {
            //sort by dscon %
            d.sortedIndex = QuickSort.Rank(d.teamDisconPct);
        }
        else if(i == 5)
        {
            //sort by def %
            d.sortedIndex = QuickSort.Rank(d.teamDefendPct);
        }
        else if(i == 6)
        {
            //sort by qual pts
            d.sortedIndex = QuickSort.Rank(d.teamQualifyPt);
        }
        else if(i == 7)
        {
            //sort by rank pts
            d.sortedIndex = QuickSort.Rank(d.teamRankingPt);
        }
        this.loadTablesWithData();
    }
}
