package menelaus.view.builder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menelaus.model.BuilderManager;
import menelaus.view.BoardView;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class MainView extends JFrame {
	private JTextField txtLevelName;
	
	BuilderManager manager;
	
	BoardView panelBoardView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView(new BuilderManager());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public MainView(BuilderManager manager) {
		this.manager = manager;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 1000);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(251, 14, 34, 14);
		
		txtLevelName = new JTextField();
		txtLevelName.setBounds(295, 11, 131, 20);
		txtLevelName.setColumns(10);
		
		panelBoardView = new BoardView(manager.getLevel().getBoard(), manager.getLevel());
		panelBoardView.setBounds(363, 105, 700, 700);
		
		JPanel panelAllPiecesView = new JPanel();
		panelAllPiecesView.setBounds(6, 105, 233, 449);
		
		JPanel panelBullpenView = new JPanel();
		panelBullpenView.setBounds(251, 105, 108, 449);
		
		JLabel lblBullpen = new JLabel("Bullpen");
		lblBullpen.setBounds(289, 80, 34, 14);
		
		JLabel lblAllPieces = new JLabel("All Pieces");
		lblAllPieces.setBounds(100, 80, 44, 14);
		getContentPane().setLayout(null);
		getContentPane().add(panelAllPiecesView);
		getContentPane().add(panelBullpenView);
		getContentPane().add(txtLevelName);
		getContentPane().add(lblName);
		getContentPane().add(panelBoardView);
		getContentPane().add(lblAllPieces);
		getContentPane().add(lblBullpen);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(363, 38, 61, 23);
		getContentPane().add(btnReset);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDone.setBounds(434, 38, 61, 23);
		getContentPane().add(btnDone);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUndo.setBounds(505, 38, 61, 23);
		getContentPane().add(btnUndo);
		
		JButton btnRedo = new JButton("Redo");
		btnRedo.setBounds(576, 38, 61, 23);
		getContentPane().add(btnRedo);
		
		JButton btnMakePiece = new JButton("Make Piece");
		btnMakePiece.setBounds(479, 72, 108, 23);
		getContentPane().add(btnMakePiece);
		
		JButton btnMakeHint = new JButton("Make Hint");
		btnMakeHint.setBounds(597, 72, 108, 23);
		getContentPane().add(btnMakeHint);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(644, 38, 61, 23);
		getContentPane().add(btnExit);
		
		JLabel lblMaximum = new JLabel("Maximum Moves");
		lblMaximum.setBounds(489, 14, 91, 14);
		getContentPane().add(lblMaximum);
		
		JSpinner spinnerMax = new JSpinner();
		spinnerMax.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinnerMax.setBounds(590, 11, 44, 20);
		getContentPane().add(spinnerMax);
		
		JSpinner spinnerMax2 = new JSpinner();
		spinnerMax2.setBounds(644, 11, 44, 20);
		getContentPane().add(spinnerMax2);
		
		JLabel lblMaxMiddle = new JLabel(":");
		lblMaxMiddle.setBounds(637, 14, 7, 14);
		getContentPane().add(lblMaxMiddle);
		
		JButton btnSelectAll = new JButton("Select All");
		btnSelectAll.setBounds(6, 76, 89, 23);
		getContentPane().add(btnSelectAll);
		
		JButton btnDeselectAll = new JButton("Deselect All");
		btnDeselectAll.setBounds(150, 76, 89, 23);
		getContentPane().add(btnDeselectAll);
		
		JPanel panelPuzzleNums = new JPanel();
		panelPuzzleNums.setBounds(6, 11, 233, 62);
		getContentPane().add(panelPuzzleNums);
		
		JButton btnRandoms = new JButton("Random #s");
		btnRandoms.setBounds(363, 72, 108, 23);
		getContentPane().add(btnRandoms);
	}
}
