/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Main.java
 *
 * Created on 03.02.2010, 17:29:59
 */
package worldclock;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import swinglayout.GroupLayout;

/**
 */
public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates new form Main */
	public Main() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		backgroundPanel1 = new BackgroundPanel();
		clockPanel1 = new ClockPanel();
		clockPanel2 = new ClockPanel();
		clockPanel3 = new ClockPanel();
		clockPanel4 = new ClockPanel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		backgroundPanel1.setName("backgroundPanel1"); // NOI18N

		clockPanel1.setCity(City.HongKong);
		clockPanel1.setName("clockPanel1"); // NOI18N

		clockPanel2.setName("clockPanel2"); // NOI18N

		clockPanel3.setCity(City.NewYork);
		clockPanel3.setName("clockPanel3"); // NOI18N

		clockPanel4.setCity(City.SanFrancisco);
		clockPanel4.setName("clockPanel4"); // NOI18N

		GroupLayout backgroundPanel1Layout = new GroupLayout(backgroundPanel1);
		backgroundPanel1.setLayout(backgroundPanel1Layout);
		backgroundPanel1Layout
				.setHorizontalGroup(backgroundPanel1Layout
						.createParallelGroup(GroupLayout.LEADING)
						.add(
								backgroundPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												backgroundPanel1Layout
														.createParallelGroup(
																GroupLayout.LEADING)
														.add(
																clockPanel2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.add(
																clockPanel1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.add(
																clockPanel3,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.add(
																clockPanel4,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		backgroundPanel1Layout.setVerticalGroup(backgroundPanel1Layout
				.createParallelGroup(GroupLayout.LEADING).add(
						backgroundPanel1Layout.createSequentialGroup().add(20,
								20, 20).add(clockPanel1,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).add(18, 18, 18)
								.add(clockPanel2, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE).add(18, 18,
										18).add(clockPanel3,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE).add(18, 18,
										18).add(clockPanel4,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(21, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.LEADING).add(backgroundPanel1,
				GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.LEADING)
				.add(backgroundPanel1, GroupLayout.PREFERRED_SIZE, 391,
						GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Main app = new Main();
				app.setLocationRelativeTo(null);
				app.setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private BackgroundPanel backgroundPanel1;
	private ClockPanel clockPanel1;
	private ClockPanel clockPanel2;
	private ClockPanel clockPanel3;
	private ClockPanel clockPanel4;
	// End of variables declaration//GEN-END:variables
}
