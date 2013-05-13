//In this package
package Model;

import java.util.Vector;

import Controller.RentalSystem;
import Model.CustomerPackage.Customer;
import Model.ItemPackage.Item;

//Import what this class use

public class SearchHandler
{
	private Vector <Customer> customers;
	private Vector <Item> items;
	private RentalSystem rs;
	
	public SearchHandler()
	{
	    rs = new RentalSystem(); 
	    this.customers = new Vector<Customer>();
	    this.items = new Vector<Item>();
	    
	    this.customers = rs.getCustomerHandler().getListOfCustomers();
	    this.items = rs.getItemHandler().getListOfItems();
	   
	}
	public String SearchCostumer(String searchString)
	{
		String returnString = null;
		
		for (Customer cust : customers) 
		{
		   if(cust.getName().equals(searchString))
		   {
		       returnString = cust.toString();
		   }
		   else if(cust.getId() == (Integer.parseInt(searchString)))
		   {
			returnString = cust.toString();
		   }
		   else if(cust.getSsn().equals(searchString))
		   {
			returnString = cust.toString();
		   }
		   else if(cust.getAddress().equals(searchString))
		   {
			returnString = cust.toString();
		   }
		}
		
		return returnString;
	}
	
	public String SearchItem(String searchString)
	{
		String returnString = null;
		
		for(Item itm : items)
		{
			if(itm.getTitle().equals(searchString))
			{
			    returnString = itm.toString();
			}
			else if(itm.getId() == (Integer.parseInt(searchString)))
			{
			    returnString = itm.toString();
			}
		}
		
		return returnString;
	}
	
}
