package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.RentalSystem;

import Model.ItemPackage.*;

public class GUIItem extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private RentalSystem rentalSystem;
	private Container contentPane;
	private JList<String> output;
	private JTextField title;
	
	private JComboBox<String> priceGroup;
	private JComboBox<String> genre;
	private JComboBox<String> releaseYear;
	private JComboBox<String> platform;
	private JComboBox<String> medium;
	
	private JButton video;
	private JButton game;
	private ButtonListener buttonListener;
	private JButton[] buttons;
	
	private int itemToHandle;
	
	private String[] buttonText;
	private String[] genres;
	private String[] gameGenres;
	private String[] platforms;
	private String[] mediums;
	private String[] priceGroups;
	private String[] releaseYears;
	private String selectedItem;
	
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event)  
		{
			
			String buttonText = event.getActionCommand();
			selectedItem = output.getSelectedValue();
			
			output.setEnabled(true);
			
			if(buttonText.equals("Video"))
			{
				video.setEnabled(false);
				game.setEnabled(true);
				platform.setEnabled(false);
				medium.setEnabled(true);
				
				genre.removeAllItems();
				
				for(String str : genres)
				{
					genre.addItem(str);
				}
				
				itemToHandle = 1;
			}
			
			if(buttonText.equals("Game"))
			{
				game.setEnabled(false);
				video.setEnabled(true);
				medium.setEnabled(false);
				platform.setEnabled(true);
				genre.removeAllItems();
				
				for(String str : gameGenres)
				{
					genre.addItem(str);
				}
				
				itemToHandle = 2;
			}
			
			if(buttonText.equals("Add item"))
			{
				if(!checkInput())
				{
					JOptionPane.showMessageDialog(null, "You must select all input!");
				}
				else
				{
					addItem();
					output.setListData(rentalSystem.getItemHandler().getAllItemsAsStrings());
					clearFields();
				}
			}
			
			if(buttonText.equals("Current in stock"))
			{
				int id = -1;
				String input = JOptionPane.showInputDialog("ID:");
				
				if(input != null)
				{
					id = Integer.parseInt(input);
					if(rentalSystem.getItemHandler().getItemId(id) == -1)
					{
						JOptionPane.showMessageDialog(null, "No item with that ID, or the list is empty!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "There are: " + rentalSystem.getItemHandler().getItemId(id) + " items with ID: " + id + ".");
					}
				}
				else
				{
					return;
				}
				
			}
			if(buttonText.equals("Get list of all"))
			{
				output.setListData(rentalSystem.getItemHandler().getAllItemsAsStrings());
			}
			if(buttonText.equals("Get all videos"))
			{
				output.setListData(rentalSystem.getItemHandler().getAllVideos());
			}
			if(buttonText.equals("Get all games"))
			{
				output.setListData(rentalSystem.getItemHandler().getAllGames());
			}
			if(buttonText.equals("Show item info"))
			{
				output.setListData(rentalSystem.getItemHandler().getItemInfo(selectedItem));
				output.setEnabled(false);
			}
			if(buttonText.equals("Remove item"))
			{
				if(selectedItem != null)
				{
					int answer = JOptionPane.showConfirmDialog(null, "You are about to delete: " + selectedItem + "! \n Are you sure?");
					if(answer == 0)
					{
						rentalSystem.getItemHandler().removeItem(selectedItem);
						output.setListData(rentalSystem.getItemHandler().getAllItemsAsStrings());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No item selected!");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No item selected!");
				}
			}
			if(buttonText.equals("Edit item"))
			{
				if(selectedItem == null)
				{
					JOptionPane.showMessageDialog(null, "No item selected!");
				}
				else
				{
					String itemToEdit = output.getSelectedValue();
					editItem(itemToEdit);
					buttons[8].setEnabled(true);
				}
			}
			if(buttonText.equals("Change input"))
			{
				String itemToChange = output.getSelectedValue();
				changeItem(itemToChange);
				output.setListData(rentalSystem.getItemHandler().getItemInfo(selectedItem));
				clearFields();
				buttons[8].setEnabled(false);
				output.setEnabled(false);
			}
			if(buttonText.equals("Edit pricegroup"))
			{
				output.setListData(rentalSystem.getItemHandler().listPriceGroups());
				output.setEnabled(false);
				String input = JOptionPane.showInputDialog("Wich pricegroup do you want to change?");
				int pg = -1;
				Double price = null;
				if(input != null)
				{
					pg = Integer.parseInt(input);
					String input2 = JOptionPane.showInputDialog("New price?");
					if(input2 != null)
					{
						price = Double.valueOf(input2);
						rentalSystem.getItemHandler().editPricegroup(pg,  price);
						output.setListData(rentalSystem.getItemHandler().listPriceGroups());
					}
					else
					{
						return;
					}
					
				}
				else
				{
					return;
				}
			}
		}
	}
	// ADD ITEM
	private void addItem()
	{
		String newTitle = this.title.getText();
		int newPriceGroup = this.priceGroup.getSelectedIndex();
		String newGenre = String.valueOf(this.genre.getSelectedItem());
		int newReleaseYear = Integer.parseInt((String) this.releaseYear.getSelectedItem());
		String newPlatform = String.valueOf(this.platform.getSelectedItem());
		String newMedium = String.valueOf(this.medium.getSelectedItem());
		
		int nrOf = Integer.parseInt(JOptionPane.showInputDialog("How many copies?"));
		
		if(itemToHandle == 1)
		{
			this.rentalSystem.getItemHandler().addItem(itemToHandle, newTitle, newPriceGroup, newGenre, newReleaseYear, newMedium, nrOf);
		}
		else
		{
			this.rentalSystem.getItemHandler().addItem(newTitle, newPriceGroup, newGenre, newReleaseYear, newPlatform, nrOf);
		}
	}
	// CHANGE ITEM
	private void changeItem(String itemToChange)
	{
		Item newItem = rentalSystem.getItemHandler().getItem(itemToChange);
		
		if(newItem instanceof Video)
		{
			newItem.setTitle(this.title.getText());
			newItem.setPriceGroup(this.priceGroup.getSelectedIndex());
			((Video) newItem).setGenre(String.valueOf(this.genre.getSelectedItem()));
			((Video) newItem).setReleaseYear(Integer.parseInt((String) this.releaseYear.getSelectedItem()));
			((Video) newItem).setMedium(String.valueOf(this.medium.getSelectedItem()));
		}
		else
		{
			newItem.setTitle(this.title.getText());
			newItem.setPriceGroup(this.priceGroup.getSelectedIndex());
			((Game) newItem).setGenre(String.valueOf(this.genre.getSelectedItem()));
			((Game) newItem).setReleaseYear(Integer.parseInt((String) this.releaseYear.getSelectedItem()));
			((Game) newItem).setPlatform(String.valueOf(this.platform.getSelectedItem()));
		}
		// curr in stock
		int currInStock = Integer.parseInt(JOptionPane.showInputDialog("How many copies?" + "\nPrevious stockcount was: " + newItem.getInStock()));
		newItem.setInStock(currInStock);
	}
	// EDIT ITEM
	private void editItem(String itemToEdit)
	{
		Item newItem = rentalSystem.getItemHandler().getItem(itemToEdit);
		
		String newTitle = newItem.getTitle();
		int priceGroupPos = -1;
		int genrePos = -1;
		int mediumPos = -1;
		int platformPos = -1;
		int releaseYearPos = -1;
		int counter = 0;
		
		// Pricegroup check  (Both)
		for(String price : priceGroups)
		{
			if(price.equals(String.valueOf(newItem.getPriceGroup())))
			{
				priceGroupPos = counter;
			}
			counter++;
		}
		
		counter = 0;
		
		// Video spec
		if(newItem instanceof Video)
		{
			for(String g : genres)
			{
				if(g.equals(((Video) newItem).getGenre()))
				{
					genrePos = counter;
				}
				counter++;
			}
			
			counter = 0;
			
			for(String m : mediums)
			{
				if(m.equals(((Video) newItem).getMedium()))
				{
					mediumPos = counter;
				}
				counter++;
			}
			
			counter = 0;
			
			for(String r : releaseYears)
			{
				if(r.equals(String.valueOf(((Video) newItem).getReleaseYear())))
				{
					releaseYearPos = counter;
				}
				counter++;
			}
		}
		counter = 0;
		// Game spec
		if(newItem instanceof Game)
		{
			for(String g : gameGenres)
			{
				if(g.equals(((Game) newItem).getGenre()))
				{
					genrePos = counter;
				}
				counter++;
			}
			
			counter = 0;
			
			for(String p : platforms)
			{
				if(p.equals(((Game) newItem).getPlatform()))
				{
					platformPos = counter;
				}
				counter++;
			}
			
			counter = 0;
			for(String r : releaseYears)
			{
				if(r.equals(String.valueOf(((Game) newItem).getReleaseYear())))
				{
					releaseYearPos = counter;
				}
				counter++;
			}
		}
		if(newItem instanceof Video)
		{
			video.setEnabled(false);
			game.setEnabled(true);
			platform.setSelectedIndex(0);
			platform.setEnabled(false);
			medium.setEnabled(true);
			
			genre.removeAllItems();
			
			for(String str : genres)
			{
				genre.addItem(str);
			}
			
			
			this.title.setText(newTitle);
			this.priceGroup.setSelectedIndex(priceGroupPos);
			this.genre.setSelectedIndex(genrePos);
			this.releaseYear.setSelectedIndex(releaseYearPos);
			this.medium.setSelectedIndex(mediumPos);
		}
		else
		{
			genre.removeAllItems();
			
			for(String str : gameGenres)
			{
				genre.addItem(str);
			}
			
			game.setEnabled(false);
			video.setEnabled(true);
			medium.setSelectedIndex(0);
			medium.setEnabled(false);
			platform.setEnabled(true);
			
			this.title.setText(newTitle);
			this.priceGroup.setSelectedIndex(priceGroupPos);
			this.genre.setSelectedIndex(genrePos);
			this.releaseYear.setSelectedIndex(releaseYearPos);
			this.platform.setSelectedIndex(platformPos);
		}
	}
	// CHECK INPUT
	private boolean checkInput()
	{
		boolean goodToGo = false;
		
		if(this.itemToHandle == 1)
		{
			if(this.priceGroup.getSelectedIndex() != 0 && this.genre.getSelectedIndex() != 0 && this.releaseYear.getSelectedIndex() != 0 && this.medium.getSelectedIndex() != 0)
			{
				goodToGo = true;
			}
		}
		else
		{
			if(this.priceGroup.getSelectedIndex() != 0 && this.genre.getSelectedIndex() != 0 && this.releaseYear.getSelectedIndex() != 0 && this.platform.getSelectedIndex() != 0)
			{
				goodToGo = true;
			}
		}
		return goodToGo;
	}
	// CLEAR ALL FIELDS
	private void clearFields()
	{
		this.title.setText("");
		this.priceGroup.setSelectedIndex(0);
		this.genre.setSelectedIndex(0);
		this.releaseYear.setSelectedIndex(0);
		this.platform.setSelectedIndex(0);
		this.medium.setSelectedIndex(0);
	}
	// INITIATE INSTANCE VARIABLES
	private void initiateInstanceVariables()
	{
		this.contentPane = this.getContentPane();
		this.contentPane.setLayout(new GridLayout(1, 2));
		
		this.buttons = new JButton[10];
		this.buttonText = new String[]{"Add item", "Edit item", "Remove item", "Current in stock", "Get list of all", "Get all videos", "Get all games", "Show item info", "Change input", "Edit pricegroup"};
		
		this.genres = new String[]{"Select genre...", "Action", "Comedy", "Horror", "Romance", "Thriller", "Adventure", "Sci-fi", "Documentary"};
		this.platforms = new String[]{"Select platform...", "Xbox", "Playstation", "PC", "Mac"};
		this.mediums = new String[]{"Select medium...", "DVD", "Blu-ray", "VHS"};
		this.priceGroups = new String[]{"Select price group...", "1","2","3"};
		this.releaseYears = new String[116];
		this.gameGenres = new String[]{"Select genre...", "RPG", "Adventure", "Sport", "Strategy", "FPS"};
		
		this.title = new JTextField("Enter title...");
		
		this.priceGroup = new JComboBox<String>();
		for(String str : priceGroups)
		{
			this.priceGroup.addItem(str);
		}
		
		this.genre = new JComboBox<String>();
		for(String str : this.genres)
		{
			genre.addItem(str);
		}
		
		this.releaseYear = new JComboBox<String>();
		this.releaseYears[0] = ("Select releaseYear...");
		int j = 1;
		
		for(int i = 2014; i > 1899; i--)
		{
			this.releaseYears[j] = (String.valueOf(i));
			j++;
		}
		for(String str : this.releaseYears)
		{
			this.releaseYear.addItem(str);
		}
		
		this.platform = new JComboBox<String>();
		for(String str : this.platforms)
		{
			platform.addItem(str);
		}
		
		this.medium = new JComboBox<String>();
		for(String str : this.mediums)
		{
			this.medium.addItem(str);
		}

		this.video = new JButton("Video");
		this.video.setEnabled(false);
		this.platform.setEnabled(false);
		this.game = new JButton("Game");
		
		this.buttonListener = new ButtonListener(); // automat genererarade konstruktor
		
		this.itemToHandle = 1;
		this.selectedItem = new String("");
		
		this.output = new JList<String>();

		this.rentalSystem = new RentalSystem();
	}
	// CONFIGURE FRAME
	private void configureFrame()
	{
		this.setSize(600, 600);
		this.setTitle("ItemHandler GUI");
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
	}
	// BUILD LEFT PANEL
	private void buildLeftPanel()
	{
		JPanel left = new JPanel();
		left.setLayout(new GridLayout(2, 1));
		
		buildForm(left);
		buildButtonPanel(left);
		this.contentPane.add(left);
	}
	// BUILD FORM
	private void buildForm(JPanel left)
	{
		JPanel form = new JPanel();
		form.setLayout(new GridLayout(7, 1));
		form.setBorder(BorderFactory.createTitledBorder("Input"));
		
		JPanel topButtons = new JPanel();
		topButtons.setLayout(new BoxLayout(topButtons, BoxLayout.X_AXIS));
		
		this.video.addActionListener(this.buttonListener);
		this.game.addActionListener(this.buttonListener);
		
		topButtons.add(this.video);
		topButtons.add(this.game);
		
		form.add(topButtons);
		form.add(this.title);
		form.add(this.priceGroup);
		form.add(this.genre);
		form.add(this.releaseYear);
		form.add(this.platform);
		form.add(this.medium);
		
		left.add(form);
	}
	// BUILD BUTTONPANEL
	private void buildButtonPanel(JPanel left)
	{
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new GridLayout(5, 2));
		
		buttonPanel.setBorder(BorderFactory.createTitledBorder("Choose"));
		
		int counter = 0;
		
		for(String str : buttonText)
		{
			this.buttons[counter] = new JButton(str);
			this.buttons[counter].setSize(new Dimension(100, 200));
			this.buttons[counter].addActionListener(this.buttonListener);
			
			buttonPanel.add(this.buttons[counter]);
			counter++;
		}
		this.buttons[8].setEnabled(false);
		left.add(buttonPanel);
	}
	// ADD LIST TO THE RIGHT
	private void addListToTheRight()
	{
		this.output.setBorder(BorderFactory.createTitledBorder("Output"));
		this.contentPane.add(this.output);
	}
	// GUI CONSTRUCTOR
	public GUIItem ()
	{
		super();
		initiateInstanceVariables();
		configureFrame();
		buildLeftPanel();
		addListToTheRight();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	// MAIN
//	public static void main(String[] args) 
//	{
//		ItemHandlerGUI gui = new ItemHandlerGUI();
//		gui.setVisible(true);
//	}
}
