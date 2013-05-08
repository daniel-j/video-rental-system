//In this package
package Model;

import java.util.Vector;

import Controller.RentalSystem;
import Model.CustomerPackage.Customer;
import Model.ItemPackage.Item;

//Import what this class use

public class SearchHandler
{
	private Vector <Customer> customers = RentalSystem.getCustomerHandler().getListOfCustomers();
	private Vector <Item> items = RentalSystem.getItemHandler().getListOfItems();
	
	public String SearchCostumer(String searchString)
	{
		String returnString = null;
		
		for (Customer cust : customers) 
		{
		   if(cust.getName().equals(searchString))
		   {
		       returnString = cust.toString();
		   }
		   else if(cust.getId().equals(searchString))
		   {
			returnString = cust.toString();
		   }
		   else if(cust.getSsn().equals(searchString))
		   {
			returnString = cust.toString();
		   }
		   else if(cost.getAddress().equals(searchString))
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
			else if(itm.getId().equals(searchString))
			{
			    returnString = itm.toString();
			}
		}
		
		return returnString;
	}
	
}
