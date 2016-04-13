package menelaus.view.builder;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;

public class SplashScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public SplashScreen() {
		setBounds(100, 100, 1000, 750);
		
		JLabel lblMenelausKabasujiBuilder = new JLabel("Menelaus KabaSuji Builder");
		lblMenelausKabasujiBuilder.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		
		JLabel lblObaDimitarFrank = new JLabel("Oba, Dimitar, Frank, Sanjay & Matt");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(246)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMenelausKabasujiBuilder)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(167)
							.addComponent(lblObaDimitarFrank)))
					.addContainerGap(245, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(334)
					.addComponent(lblMenelausKabasujiBuilder)
					.addGap(18)
					.addComponent(lblObaDimitarFrank)
					.addContainerGap(334, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

}
