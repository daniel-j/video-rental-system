//Import all models
package Controller;
import Model.*;
import Model.CustomerPackage.*;
import Model.ItemPackage.*;
import Model.NewsletterPackage.*;
import View.GUINewsletter;
import View.GUISystem;

public class RentalSystem
{
	private CustomerHandler 	CustomerH;
	private ItemHandler 		ItemH;
	private NewsletterHandler 	NewsletterH;
	private RentalHandler 		RentalH;
	private	SearchHandler 		SearchH;
	private Database 			databse;
	private GUISystem			SystemGui;
	
	//Construct
	public RentalSystem()
	{
		//Handlers and Database
		this.CustomerH 		= new CustomerHandler();
		this.ItemH 			= new ItemHandler();
		this.NewsletterH	= new NewsletterHandler();
		this.RentalH 		= new RentalHandler();
		this.SearchH 		= new SearchHandler();
		this.databse 		= new Database();
		this.SystemGui		= new GUISystem();
		//---------------------------------------
	}
	
	public CustomerHandler getCustomerHandler()
	{
		return this.CustomerH;
	}
	
	public ItemHandler getItemHandler()
	{
		return this.ItemH;
	}
	
	public NewsletterHandler getNewsletterHandler()
	{
		return this.NewsletterH;
	}
	
	public RentalHandler getRentalHandler()
	{
		return this.RentalH;
	}
	
	public SearchHandler getSerchHandler()
	{
		return this.SearchH;
	}
	
	public static void main(String[] args)
	{
		GUINewsletter test = new GUINewsletter();
	}
}
