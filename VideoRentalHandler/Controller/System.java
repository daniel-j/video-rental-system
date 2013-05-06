//Import all models
import Model;

public class System
{
	CustomerHandler CustomerH;
	ItemHandler ItemH;
	NewsletterHandler NewsletterH;
	RentalHandler RentalH;
	SearchHandler SearchH;
	Database databse;
	
	//Construct
	public System(){
		//Init Handlers and Database
		this.CustomerH 		= new CustomerHandler;
		this.ItemH 			= new ItemHandler;
		this.NewsletterH	= new NewsletterHandler;
		this.RentalH 		= new RentalHandler;
		this.SearchH 		= new SearchHandler;
		this.databse 		= new Database;
		//---------------------------------------
	}
	
	}
	public static void main(String[] args)
	{
		

	}

}
