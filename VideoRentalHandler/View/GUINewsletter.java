package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUINewsletter extends JFrame
{
	private static final long	serialVersionUID	= 1L;
	private Container contentPane;
	
	public GUINewsletter()
	{
		super();
		initiateInstanceVariables();
		configureFrame();
		buildLeftPanel();
		buildRightPanel();
	}
	
	private void configureFrame()
	{
		this.setSize(800, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Newsletter");
		this.setLocationRelativeTo(null);
	}
	
	private void initiateInstanceVariables()
	{
		this.contentPane = this.getContentPane();
		this.contentPane.setLayout(new GridLayout(1, 2));
	}
	
	private void buildLeftPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		//panel.setBorder(BorderFactory.createTitledBorder("Write letter"));
		
		JLabel label1 = new JLabel("Title");
		label1.setLocation(25, 15);
		Dimension dim = label1.getPreferredSize();
		label1.setSize(dim);
		
		JTextField textField = new JTextField();
		textField.setLocation(25, 35);
		textField.setSize(150, 25);
		
		JLabel label2 = new JLabel("Content");
		label2.setLocation(25, 95);
		dim = label2.getPreferredSize();
		label2.setSize(dim);
		
		JTextArea textArea = new JTextArea ();
		JScrollPane jsp = new JScrollPane (textArea);
		jsp.setSize(300, 200);
		jsp.setLocation(25, 120);
		
		panel.add(label1);
		panel.add(textField);
		panel.add(label2);
		panel.add(jsp);
		
		this.contentPane.add(panel);
	}
	
	private void buildRightPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		//panel.setBorder(BorderFactory.createTitledBorder("Send"));

		JLabel label1 = new JLabel("Choose preference");
		label1.setLocation(25, 15);
		Dimension dim = label1.getPreferredSize();
		label1.setSize(dim);
		
		JComboBox<String> c = new JComboBox<String>();
		c.addItem("Drama");
		c.addItem("Action");
		c.addItem("Comedy");
		
		c.setLocation(25, 40);
		dim = c.getPreferredSize();
		c.setSize(dim);
		
		JButton button1 = new JButton("Get addresslist");
		button1.setLocation(125, 40);
		dim = button1.getPreferredSize();
		button1.setSize(dim);
		
		JLabel label2 = new JLabel("Address list");
		label2.setLocation(25, 95);
		dim = label2.getPreferredSize();
		label2.setSize(dim);
		
		JList<String> list = new JList<String>();
		JScrollPane jsp = new JScrollPane(list);
		jsp.setSize(300, 140);
		jsp.setLocation(25, 120);
		
		JButton button2 = new JButton("Send");
		
		button2.setLocation(25, 280);
		dim = button2.getPreferredSize();
		button2.setSize(dim);

		panel.add(label1);
		panel.add(c);
		panel.add(button1);
		panel.add(label2);
		panel.add(jsp);
		panel.add(button2);
		
		this.contentPane.add(panel);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		GUINewsletter nl = new GUINewsletter();
		nl.setVisible(true);
	}

}
