/*
 * DemoFrame.java
 *
 * Created on 2007��6��24��, ����12:24
 */

package clickingeffect.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import clickingeffect.ClickingEffectPane;
import clickingeffect.GhostEffectAnimator;
import clickingeffect.SimpleAnimator;

/**
 */
public class DemoFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates new form DemoFrame */
	public DemoFrame() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {
		buttonGroup1 = new ButtonGroup();
		clickingEffectPane1 = new ClickingEffectPane();
		jLabel1 = new JLabel();
		jButton1 = new JButton();
		jToggleButton1 = new JToggleButton();
		jCheckBox1 = new JCheckBox();
		jRadioButton1 = new JRadioButton();
		jTextField1 = new JTextField();
		jScrollPane1 = new JScrollPane();
		jTextArea1 = new JTextArea();
		jProgressBar1 = new JProgressBar();
		jSlider1 = new JSlider();
		jRadioButton2 = new JRadioButton();
		jRadioButton3 = new JRadioButton();
		jButton2 = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		clickingEffectPane1.setBorder(BorderFactory.createEtchedBorder());
		jLabel1
				.setText("<html> <body> <h4>Welcome to swing demo program!</h4> <ul> <li>Click any where of the panel to see the clicking effect.</li> <li>You can also click any subcomponents of the panel.</li> \n<li>You can change the clicking effect to any <p>other effect by implementing Animator interface.</li>\n</ul> <em><strong>Enjoy swing programming!</strong></em> </body> </html>");

		jButton1.setText("Click me");
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(123);
			}
		});

		jToggleButton1.setText("Toggle me");

		jCheckBox1.setText("Check me");
		jCheckBox1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jCheckBox1.setMargin(new java.awt.Insets(0, 0, 0, 0));

		jRadioButton1.setText("Select me");
		jRadioButton1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jRadioButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));

		jTextField1.setText("Click here to enter some text");

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jTextArea1
				.setText("Click here!\n\nIn fact you can even \nget the clicking \neffect when you add \nthe ClickingEffectPane\nto your netbeans \npallete and use it in\nthe designing.");
		jScrollPane1.setViewportView(jTextArea1);

		jProgressBar1.setValue(60);

		GroupLayout clickingEffectPane1Layout = new GroupLayout(
				clickingEffectPane1);
		clickingEffectPane1.setLayout(clickingEffectPane1Layout);
		clickingEffectPane1Layout
				.setHorizontalGroup(clickingEffectPane1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								clickingEffectPane1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												clickingEffectPane1Layout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(jLabel1)
														.addGroup(
																clickingEffectPane1Layout
																		.createSequentialGroup()
																		.addGroup(
																				clickingEffectPane1Layout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jTextField1,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								clickingEffectPane1Layout
																										.createSequentialGroup()
																										.addGroup(
																												clickingEffectPane1Layout
																														.createParallelGroup(
																																GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jButton1)
																														.addComponent(
																																jCheckBox1))
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												clickingEffectPane1Layout
																														.createParallelGroup(
																																GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jRadioButton1)
																														.addComponent(
																																jToggleButton1)))
																						.addGroup(
																								clickingEffectPane1Layout
																										.createParallelGroup(
																												GroupLayout.Alignment.TRAILING,
																												false)
																										.addComponent(
																												jSlider1,
																												GroupLayout.Alignment.LEADING,
																												0,
																												0,
																												Short.MAX_VALUE)
																										.addComponent(
																												jProgressBar1,
																												GroupLayout.Alignment.LEADING,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jScrollPane1,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		clickingEffectPane1Layout
				.setVerticalGroup(clickingEffectPane1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								clickingEffectPane1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel1)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												clickingEffectPane1Layout
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addGroup(
																clickingEffectPane1Layout
																		.createSequentialGroup()
																		.addGroup(
																				clickingEffectPane1Layout
																						.createParallelGroup(
																								GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jButton1)
																						.addComponent(
																								jToggleButton1))
																		.addGap(
																				13,
																				13,
																				13)
																		.addGroup(
																				clickingEffectPane1Layout
																						.createParallelGroup(
																								GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jCheckBox1)
																						.addComponent(
																								jRadioButton1))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextField1,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jProgressBar1,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jSlider1,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																jScrollPane1,
																GroupLayout.DEFAULT_SIZE,
																133,
																Short.MAX_VALUE))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		buttonGroup1.add(jRadioButton2);
		jRadioButton2.setSelected(true);
		jRadioButton2.setText("Rainbow Effect");
		jRadioButton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jRadioButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
		jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton2ActionPerformed(evt);
			}
		});

		buttonGroup1.add(jRadioButton3);
		jRadioButton3.setText("Ghost Effect");
		jRadioButton3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jRadioButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
		jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton3ActionPerformed(evt);
			}
		});

		jButton2.setText("Exit");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																clickingEffectPane1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jRadioButton2)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jRadioButton3)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED,
																				126,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButton2)))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(clickingEffectPane1,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createParallelGroup(
																				GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jRadioButton2)
																		.addComponent(
																				jRadioButton3))
														.addComponent(jButton2))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jRadioButton3ActionPerformed
		changeEffect();
	}// GEN-LAST:event_jRadioButton3ActionPerformed

	private void changeEffect() {
		if (jRadioButton2.isSelected())
			clickingEffectPane1.setAnimator(new SimpleAnimator());
		else
			clickingEffectPane1.setAnimator(new GhostEffectAnimator());
	}

	private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jRadioButton2ActionPerformed
		changeEffect();
	}// GEN-LAST:event_jRadioButton2ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		System.exit(0);
	}// GEN-LAST:event_jButton2ActionPerformed

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
	private ButtonGroup buttonGroup1;
	private ClickingEffectPane clickingEffectPane1;
	private JButton jButton1;
	private JButton jButton2;
	private JCheckBox jCheckBox1;
	private JLabel jLabel1;
	private JProgressBar jProgressBar1;
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton3;
	private JScrollPane jScrollPane1;
	private JSlider jSlider1;
	private JTextArea jTextArea1;
	private JTextField jTextField1;
	private JToggleButton jToggleButton1;
	// End of variables declaration//GEN-END:variables

}
