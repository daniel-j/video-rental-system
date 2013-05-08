//In this package
package Model;

import java.util.Vector;

import Model.CustomerPackage.Customer;
import Model.ItemPackage.Item;

//Import what this class use


public class RentalHandler
{
	//Constructor
	public RentalHandler()
	{
	
	}
	
	public double calculatePrice()
	{
		return 0.0;
	}
	
	public Vector<Item> listRented()
	{
		return null;
	}
	
	public boolean specialOffers()
	{
		return true;
	}
	
	public void setItemStatus(int id, boolean rented)
	{
		
	}
	
	public Item getItem(int id)
	{
		return null;
	}
	
	public Customer getCustomer(int id)
	{
		return null;
	}
	
	public boolean rentToCustomer(int customerId, int itemId)
	{
		return true;
	}
}
