//In this package
package Model;

import java.util.Vector;

import Model.CustomerPackage.*;
import Model.ItemPackage.*;

//Import what this class use


public class RentalHandler
{
	private CustomerHandler CustomerH;
	private ItemHandler ItemH;
	private double TotalPrice;
	
	public RentalHandler(ItemHandler ItemHa, CustomerHandler CustomerHa)
	{
		this.CustomerH = CustomerHa;
		this.ItemH = ItemHa;
		this.TotalPrice = 0;
	}
	
	public double calculatePrice(double IPrice)
	{
		this.TotalPrice += IPrice;
		return this.TotalPrice;
	}
	
	public Vector<Item> listRented()
	{
		return null;
	}
	
	//GuiRental Call function before calculatePrice
	//if return true, calculate price wont be called 
	//else add price to this rental
	public boolean specialOffers(String CustomerName)
	{
		Customer CurrentCustomer = this.CustomerH.getCustomer(CustomerName);
		int nrOfRented = CurrentCustomer.getTotalRented();
		if(nrOfRented >= 10){
			return true;
		}
		else{
			return false;
		}
		
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
