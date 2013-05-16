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
	    //Vectors for local storage	 
	    this.customers = CustomerH.getListOfCustomers();
	    this.items = ItemH.getListOfItems();
	    	   
	}
	public Vector<String> SearchCustomer(String searchString)
	{
	    	String srcStr = searchString.toUpperCase();
		String returnString = "";
	
		Vector<String> Result = new Vector<String>();
	
		    for (Customer cust : customers) 
			{
			   if(cust.getName().toUpperCase().equals(srcStr))
			   {
			       returnString = cust.toString();
			       Result.add(returnString);
			   }		   
			   else if(isInteger(searchString))
			   {
			       if(Integer.parseInt(searchString) == cust.getId())
			       {
				   returnString = cust.toString();
				   Result.add(returnString);
			       }
					
			   }	   
			   else if(cust.getSsn().equals(searchString))
			   {
				returnString = cust.toString();
				Result.add(returnString);
					
			   }
			   else if(cust.getAddress().toUpperCase().equals(srcStr))
			   {
				returnString = cust.toString();
				Result.add(returnString);
					
			   }

			}
		
		Vector<String> rtrVect = new Vector<String>();
		
		try
		{
		    if(!Result.isEmpty())
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
	    	String srcStr = searchString.toUpperCase();
		String returnString = "";
		
		Vector<String> Result = new Vector<String>();
		
		
		    for(Item itm : items)
			{
				if(itm.getTitle().toUpperCase().equals(srcStr))
				{
				    returnString = itm.toString();
				    Result.add(returnString);
				}
				
				 else if(isInteger(searchString))
				 {
				     if(Integer.parseInt(searchString) == itm.getId())
				     {
					 returnString = itm.toString();
					 Result.add(returnString);
				     }
						
				 }
				
			}
		
		
		Vector<String> rtrVect = new Vector<String>();

		try
		{ 
		    if(!Result.isEmpty())
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
	
	private boolean isInteger(String s) 
	{
	    try 
	    { 
	        Integer.parseInt(s); 
	    } 
	    catch(NumberFormatException e) 
	    { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
}