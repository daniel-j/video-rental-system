//In this package
package Model;
import Model.CustomerPackage.*;
import Model.ItemPackage.*;

import java.util.Vector;


public class SearchHandler
{
	private Vector <Customer> customers;
	private Vector <Item> items;
	
	public SearchHandler(ItemHandler ItemH, CustomerHandler CustomerH)
	{
<<<<<<< HEAD
	    //Vectors
	    this.customers = new Vector<Customer>();
	    this.items = new Vector<Item>();
	    
=======
	    //Vectors	    
>>>>>>> Forcefully made updates to search handler
	    this.customers = CustomerH.getListOfCustomers();
	    this.items = ItemH.getListOfItems();
	    	   
	}
<<<<<<< HEAD
	public String[] SearchCustomer(String searchString)
=======
	public Vector<String> SearchCustomer(String searchString)
>>>>>>> Forcefully made updates to search handler
	{
		String returnString = "";
	
		Vector<String> Result;
		
		if(this.customers.size() == 0)
		{
		    Result = new Vector<String>();
		}
		else
		{
		    Result = new Vector<String>();
		}
		if(this.customers.size() < 1)
		{
		    Result.add("");
		}
		else
		{
		    for (Customer cust : customers) 
			{
			   if(cust.getName().equals(searchString))
			   {
			       returnString = cust.getName();
			       Result.add(returnString);
			   }
			   /*
			   else if(Integer.parseInt(searchString) == cust.getId())
			   {
			       	returnString = cust.toString();
			       	Result.add(returnString);
					
			   }
			   */
			   else if(cust.getSsn().equals(searchString))
			   {
				returnString = cust.getName();
				Result.add(returnString);
					
			   }
			   else if(cust.getAddress().equals(searchString))
			   {
				returnString = cust.getName();
				Result.add(returnString);
					
			   }

			}
		}
		
		Vector<String> rtrVect = new Vector<String>();
		
		try
		{		
		    	if(Result.isEmpty())
			{
		    	    rtrVect.add("");
			}
			else
			{
			    for(String str : Result)
			    {
				rtrVect.add(str);
			    }
			}
		
		}
		catch (NullPointerException | ArrayIndexOutOfBoundsException e)
		{
			e.addSuppressed(null);
		}		

		return rtrVect;
	}
	
	public Vector<String> SearchItem(String searchString)
	{    
		String returnString = "";
		int size = this.items.size();
		
		Vector<String> Result = new Vector<String>();
		
		
		if(size < 1)
		{
		    Result.add("");
		}
		else
		{
		    for(Item itm : items)
			{
				if(itm.getTitle().equals(searchString))
				{
				    returnString = itm.toString();
				    Result.add(returnString);
				}
				/*
				else if(Integer.parseInt(searchString) == itm.getId())
				{
				    returnString = itm.toString();
				    Result.add(returnString);
				}
				*/
				
			}
		}
		
		Vector<String> rtrVect = new Vector<String>();

		try
		{		
		    	if(Result.isEmpty())
			{
		    	    rtrVect.add("");
			}
			else
			{
			    for(String str : Result)
			    {
				rtrVect.add(str);
			    }
			}
		
		}
		catch (NullPointerException | ArrayIndexOutOfBoundsException e)
		{
			e.addSuppressed(null);
		}
		
		return rtrVect;
	}
	
}
