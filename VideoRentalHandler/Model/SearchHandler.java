//In this package
package Model;
import Model.CustomerPackage.*;
import Model.ItemPackage.*;

import java.util.Vector;



/**
 * The Class SearchHandler.
 */
public class SearchHandler
{
	
	/** The customers. */
	private Vector <Customer> customers;
	
	/** The items. */
	private Vector <Item> items;
	
	/**
	 * Instantiates a new search handler.
	 *
	 * @param ItemH the item h
	 * @param CustomerH the customer h
	 */
	public SearchHandler(ItemHandler ItemH, CustomerHandler CustomerH)
	{
	    //Vectors for local storage	 
	    this.customers = CustomerH.getListOfCustomers();
	    this.items = ItemH.getListOfItems();
	    	   
	}
	
	/**
	 * Search customer.
	 *
	 * @param searchString the search string
	 * @return the vector
	 */
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
			   else if(searchString.equals(cust.getSsn()))
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
	
	/**
	 * Search item.
	 *
	 * @param searchString the search string
	 * @return the vector
	 */
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
	
	/**
	 * Checks if is integer.
	 *
	 * @param s the s
	 * @return true, if is integer
	 */
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