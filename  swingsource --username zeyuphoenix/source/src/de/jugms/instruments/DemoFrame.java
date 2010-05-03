/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DemoFrame.java
 *
 * Created on 22.12.2009, 12:27:52
 */

package de.jugms.instruments;

import swinglayout.GroupLayout;

/**
 * 
 * @author hansolo
 */
public class DemoFrame extends javax.swing.JFrame {

	/** Creates new form DemoFrame */
	public DemoFrame() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		gauge1 = new de.jugms.instruments.Gauge();
		ledDisplay1 = new de.jugms.instruments.LedDisplay();
		backgroundPanel1 = new de.jugms.instruments.BackgroundPanel();
		valueDisplay1 = new de.jugms.instruments.ValueDisplay();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(0, 0, 0));

		gauge1.setName("gauge1"); // NOI18N

		GroupLayout gauge1Layout = new GroupLayout(gauge1);
		gauge1.setLayout(gauge1Layout);
		gauge1Layout.setHorizontalGroup(gauge1Layout.createParallelGroup(
				GroupLayout.LEADING).add(0, 256, Short.MAX_VALUE));
		gauge1Layout.setVerticalGroup(gauge1Layout.createParallelGroup(
				GroupLayout.LEADING).add(0, 256, Short.MAX_VALUE));

		ledDisplay1.setName("ledDisplay1"); // NOI18N

		GroupLayout ledDisplay1Layout = new GroupLayout(ledDisplay1);
		ledDisplay1.setLayout(ledDisplay1Layout);
		ledDisplay1Layout.setHorizontalGroup(ledDisplay1Layout
				.createParallelGroup(GroupLayout.LEADING).add(0, 255,
						Short.MAX_VALUE));
		ledDisplay1Layout.setVerticalGroup(ledDisplay1Layout
				.createParallelGroup(GroupLayout.LEADING).add(0, 10,
						Short.MAX_VALUE));

		backgroundPanel1.setName("backgroundPanel1"); // NOI18N

		valueDisplay1.setColor(de.jugms.instruments.ValueDisplay.COLOR.BLUE);
		valueDisplay1.setName("valueDisplay1"); // NOI18N

		GroupLayout valueDisplay1Layout = new GroupLayout(valueDisplay1);
		valueDisplay1.setLayout(valueDisplay1Layout);
		valueDisplay1Layout.setHorizontalGroup(valueDisplay1Layout
				.createParallelGroup(GroupLayout.LEADING).add(0, 216,
						Short.MAX_VALUE));
		valueDisplay1Layout.setVerticalGroup(valueDisplay1Layout
				.createParallelGroup(GroupLayout.LEADING).add(0, 48,
						Short.MAX_VALUE));

		GroupLayout backgroundPanel1Layout = new GroupLayout(backgroundPanel1);
		backgroundPanel1.setLayout(backgroundPanel1Layout);
		backgroundPanel1Layout.setHorizontalGroup(backgroundPanel1Layout
				.createParallelGroup(GroupLayout.LEADING).add(
						backgroundPanel1Layout.createSequentialGroup()
								.addContainerGap().add(valueDisplay1,
										GroupLayout.DEFAULT_SIZE, 216,
										Short.MAX_VALUE).addContainerGap()));
		backgroundPanel1Layout.setVerticalGroup(backgroundPanel1Layout
				.createParallelGroup(GroupLayout.LEADING).add(
						backgroundPanel1Layout.createSequentialGroup()
								.addContainerGap().add(valueDisplay1,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												layout
														.createParallelGroup(
																GroupLayout.TRAILING)
														.add(
																GroupLayout.LEADING,
																backgroundPanel1,
																GroupLayout.DEFAULT_SIZE,
																256,
																Short.MAX_VALUE)
														.add(
																GroupLayout.LEADING,
																layout
																		.createParallelGroup(
																				GroupLayout.TRAILING,
																				false)
																		.add(
																				ledDisplay1,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.add(
																				GroupLayout.LEADING,
																				gauge1,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.LEADING)
				.add(
						layout.createSequentialGroup().add(gauge1,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).add(18, 18, 18)
								.add(ledDisplay1, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE).add(18, 18,
										18).add(backgroundPanel1,
										GroupLayout.DEFAULT_SIZE, 88,
										Short.MAX_VALUE).addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DemoFrame().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private de.jugms.instruments.BackgroundPanel backgroundPanel1;
	private de.jugms.instruments.Gauge gauge1;
	private de.jugms.instruments.LedDisplay ledDisplay1;
	private de.jugms.instruments.ValueDisplay valueDisplay1;
	// End of variables declaration//GEN-END:variables

}
