package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import menelaus.model.LevelsPackage;
import menelaus.util.LevelsPackagePersistenceUtil;
import menelaus.view.game.ExtraScreen;

public class ButtonLoadLevelController implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File (System.getProperty("user.home")));
		
		int result = fc.showOpenDialog(new ExtraScreen());
		
		if(result == JFileChooser.APPROVE_OPTION);
		
		File selectedFile = fc.getSelectedFile();
		
		try {
			LevelsPackage levelsPackage = LevelsPackagePersistenceUtil.fromFile(selectedFile);
			
			ButtonLevelsController blc = new ButtonLevelsController(levelsPackage);
			blc.actionPerformed(null);
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Alert! Selected file is not valid.");
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Alert! Selected file is not valid.");
		}
		
	}

}
