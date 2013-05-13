//In this package
package View;

import Model.SearchHandler;
import Model.NewsletterPackage.NewsletterHandler;

import Controller.RentalSystem;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUISystem extends JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Container contentPane;
   
    //
    private GUICustomer guiCustomer;
    private GUIItem guiItem;
    private GUINewsletter guiNewsLetter;
    private GUIRental guiRental;
    private GUISearch guiSearch;
    
    private RentalSystem MainSystemReference;
    
    public GUISystem(RentalSystem MainSystem)
	{
	    super();
	    this.MainSystemReference = MainSystem;
		initiateInstanceVariables();
		configureFrame();
		buildPanel();	
	}
    
    public class ButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) // Executes when button pressed
		{
			String buttonText = e.getActionCommand();
			
			if(buttonText.equals("New rental"))
			{
				enterRental();
			}
			else if(buttonText.equals("Costumers"))
			{
				enterCostumers();
			}
			else if(buttonText.equals("Item menu"))
			{
				enterItems();
			}
			else if(buttonText.equals("Search"))
			{
				enterSearch();
			}
			else if(buttonText.equals("Write newsletter"))
			{
				enterNewsletter();
			}
			else if(buttonText.equals("Logout"))
			{
				logout();
			}
		}

	}
    	private void logout() 
	{
    	    JOptionPane.showMessageDialog(null, "Exit the system");
    	    System.exit(0);
	}

	private void enterNewsletter() 
	{
	    guiNewsLetter.setVisible(true);
	    
	}

	private void enterSearch() 
	{
		guiSearch.setVisible(true);
	    
	}

	private void enterItems() 
	{
	    guiItem.setVisible(true);
	    
	}

	private void enterCostumers() 
	{
	    //guiCustomer.setVisible(true);
	    
	}

	private void enterRental() 
	{
	    //guiRental.setVisible(true);
	    
	}
	
	
	private void initiateInstanceVariables()
	{
		this.contentPane = this.getContentPane();
		this.contentPane.setLayout(new GridLayout(1, 2));
		
		//Handlers
		SearchHandler SearchH = this.MainSystemReference.getSerchHandler();
		NewsletterHandler newsletterH = this.MainSystemReference.getNewsletterHandler();
		
		//GUI
		this.guiNewsLetter = new GUINewsletter(newsletterH);
		this.guiSearch = new GUISearch(SearchH);
		this.guiItem = new GUIItem();
		this.guiCustomer = new GUICustomer();
		this.guiRental = new GUIRental();
	}
	
	private void configureFrame()
	{
		this.setSize(400, 400);
		this.setTitle("Rental System :: Video Rental System 1.0");
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void buildPanel()
	{
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Rental System"));
		
		buildButtonPanel(panel);
		
		this.contentPane.add(panel);
	}
	
	private void buildButtonPanel(JPanel thePanel)
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		String[] buttonTxt = {"New rental", "Costumers", "Item menu", "Search", "Write newsletter", "Logout"};
		ButtonListener buttonListener = new ButtonListener();
		
		JButton button = new JButton(buttonTxt[0]);
		Dimension dim = button.getPreferredSize();
		buttonPanel.setSize(50*dim.width + 8, 2 * dim.height + 5);
		buttonPanel.setLocation(20,70);
		
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
}
