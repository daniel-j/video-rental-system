//In this package
package View;

//Import what this class use
import Model.*;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUISearch extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Container contentPane;
	private JTextField searchField;
	private JList<String> resultList;
	private RentalSystem rentalSystem;
	
	public class ButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) // Executes when button pressed
		{
			String buttonText = e.getActionCommand();
			
			if(buttonText.equals("Search Costumer"))
			{
				searchCostumer();
			}
			else if(buttonText.equals("Search Item"))
			{
				searchItem();
			}
			else if(buttonText.equals("Clear"))
			{
				clearSearchField();
			}
		}
	}

		private void clearSearchField() 
		{
			this.searchField.setText("");
			
		}

		private void searchItem() 
		{
			if(this.searchField != null)
			{
				String searchString = this.searchField.getText();
				
				if(this.RentalSystem.SearchHandler.SearchItem(searchString) != null)
				{
					this.resultList.setListData(this.RentalSystem.SearchHandler.SearchItem(searchString));
				}
				else
				{
					this.resultList.clearSelection();
					JOptionPane.showMessageDialog(null, "No results were found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Please enter something to search for");
			}
			
		}

		private void searchCostumer() 
		{
			if(this.searchField != null)
			{
				String searchString = this.searchField.getText();
				RentalSystem.SearchHandler.SearchCostumer(searchString);
				
				if(this.RentalSystem.SearchHandler.SearchItem(searchString) != null)
				{
					this.resultList.setListData(this.RentalSystem.SearchHandler.SearchCostumer(searchString));
				}
				else
				{
					this.resultList.clearSelection();
					JOptionPane.showMessageDialog(null, "No results were found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Please enter something to search for");
			}
			
		}
		
		public SearchHandlerGUI() 
		{
			super();
			initiateInstanceVariables();
			configureFrame();
			buildLeftPanel();
			addListToTheRight();
			
		}
		
		private void initiateInstanceVariables()
		{
			this.contentPane = this.getContentPane();
			this.contentPane.setLayout(new GridLayout(1, 2));
			this.searchField = new JTextField();
			this.resultList = new JList<String>();
			this.RentalSystem = new RentalSystem();
		}
		
		private void configureFrame()
		{
			this.setSize(1000, 400);
			this.setTitle("Search Handler :: Video Rental System 1.0");
			this.setLocationRelativeTo(null);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	
		private void buildLeftPanel()
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(BorderFactory.createTitledBorder("Search"));
			
			this.searchField.setSize(260, 50);
			this.searchField.setBorder(BorderFactory.createTitledBorder("Enter search string here"));
			this.searchField.setLocation(20, 30);

			panel.add(searchField);
			
			buildButtonPanel(panel);
			
			this.contentPane.add(panel);
		}
		
		private void addListToTheRight()
		{
			this.resultList.setBorder(BorderFactory.createTitledBorder("Result list"));
			this.contentPane.add(resultList);
			
		}
		
		private void buildButtonPanel(JPanel thePanel)
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new GridLayout(2, 3, 5, 5)); // 2 rows, 3 columns, 5 pixels in between
			
			String[] buttonTxt = {"Search Costumer", "Search Item", "Clear"};
			ButtonListener buttonListener = new ButtonListener();
			
			JButton button = new JButton(buttonTxt[0]);
			Dimension dim = button.getPreferredSize();
			buttonPanel.setSize(3*dim.width + 8, 2 * dim.height + 5);
			buttonPanel.setLocation(20,270);
			
			// Add all buttons to button panel
			for(String str: buttonTxt)
			{
				button = new JButton(str);
				buttonPanel.add(button);	
				// connect listener
				button.addActionListener(buttonListener);
			}
			thePanel.add(buttonPanel);
		}
	
		public static void main(String[] args) 
		{
			SearchHandlerGUI gui = new SearchHandlerGUI();
			gui.setVisible(true);

		}
	
}
