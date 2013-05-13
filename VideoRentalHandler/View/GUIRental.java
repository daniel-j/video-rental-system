//In this package
package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Model.CustomerPackage.*;
import Model.ItemPackage.*;

//Import what this class use

public class GUIRental extends JFrame
{
	private static final long	serialVersionUID	= 1L;
	private Container contentPane;
	
	private JTextField nameField		 = null;
	private JTextField daysField		 = null;
	private JTextField itemField 		 = null;
	private JTextField priceField		 = null;
	private JList<String> rentedList 	 = null;
	private JList<String> newRentList 	 = null;
	
	private CustomerHandler CustomerHandlerReference;
	private ItemHandler ItemHandlerReference;
	
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			String buttonText = event.getActionCommand();
			
			if(buttonText.equals("List rented"))
			{
				listRented();
			}
			else if(buttonText.equals("Add"))
			{
				add();
			}
			else if(buttonText.equals("Rent"))
			{
				rent();
			}
		}
	}
	
	private void listRented()
	{
		
	}
	
	private void add()
	{
		if(this.nameField.getText().equals("") || this.daysField.getText().equals("")
				|| this.itemField.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "You can't have empty fields!", "ERROR",
				    JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			
		}
		
	}
	
	private void rent()
	{
		if(this.newRentList.getModel().getSize() == 0)
		{
			JOptionPane.showMessageDialog(null, "You can't have empty fields!", "ERROR",
				    JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			
		}
	}
	
	public GUIRental(CustomerHandler CustomerH, ItemHandler ItemH)
	{
		super();
		
		this.ItemHandlerReference = ItemH;
		this.CustomerHandlerReference = CustomerH;
		
		initiateInstanceVariables();
		buildLeftPanel();
		buildRightPanel();
		configureFrame();
	}
	
	/**
	 * Configure frame
	 */
	private void configureFrame()
	{
		this.setSize(650, 350);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Rental");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/**
	 * Initiate instance variables
	 */
	private void initiateInstanceVariables()
	{
		this.contentPane = this.getContentPane();
		this.contentPane.setLayout(new GridLayout(1, 2));
		
		this.nameField = new JTextField();
		this.daysField = new JTextField();
		this.itemField = new JTextField();
		this.priceField = new JTextField();
		this.rentedList = new JList<String>();
		this.newRentList = new JList<String>();
	}
	
	/**
	 * Build left panel with misc components
	 */
	private void buildLeftPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		ButtonListener bListener = new ButtonListener();
		
		JButton button1 = new JButton("List rented");
		button1.addActionListener(bListener);
		button1.setLocation(25, 25);
		Dimension dim = button1.getPreferredSize();
		button1.setSize(dim);
		
		JScrollPane jsp = new JScrollPane(this.rentedList);
		jsp.setSize(250, 200);
		jsp.setLocation(25, 60);
		
		panel.add(button1);
		panel.add(jsp);
		
		this.contentPane.add(panel);
	}
	
	/**
	 * Build right panel with misc components
	 */
	private void buildRightPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Rent new items"));
		
		ButtonListener bListener = new ButtonListener();
		
		JLabel label1 = new JLabel("Name:");
		label1.setLocation(25, 25);
		Dimension dim = label1.getPreferredSize();
		label1.setSize(dim);
		
		JLabel label2 = new JLabel("Days:");
		label2.setLocation(25, 50);
		dim = label2.getPreferredSize();
		label2.setSize(dim);
		
		JLabel label3 = new JLabel("Item:");
		label3.setLocation(25, 75);
		dim = label3.getPreferredSize();
		label3.setSize(dim);
		
		JLabel label4 = new JLabel("Total price:");
		label4.setLocation(25, 100);
		dim = label4.getPreferredSize();
		label4.setSize(dim);
		
		this.nameField.setLocation(100, 25);
		this.nameField.setSize(150, 25);
		
		this.daysField.setLocation(100, 50);
		this.daysField.setSize(150, 25);
		
		this.itemField.setLocation(100, 75);
		this.itemField.setSize(150, 25);
		
		this.priceField.setLocation(100, 100);
		this.priceField.setSize(150, 25);
		this.priceField.setEditable(false);
		
		JButton button1 = new JButton("Add");
		button1.addActionListener(bListener);
		button1.setLocation(25, 275);
		dim = button1.getPreferredSize();
		button1.setSize(dim);
		
		JButton button2 = new JButton("Rent");
		button2.addActionListener(bListener);
		button2.setLocation(100, 275);
		dim = button2.getPreferredSize();
		button2.setSize(dim);
		
		JScrollPane jsp = new JScrollPane(this.newRentList);
		jsp.setSize(250, 125);
		jsp.setLocation(25, 135);

		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(this.nameField);
		panel.add(this.daysField);
		panel.add(this.itemField);
		panel.add(this.priceField);
		panel.add(button1);
		panel.add(button2);
		panel.add(jsp);
		
		this.contentPane.add(panel);
	}
}
