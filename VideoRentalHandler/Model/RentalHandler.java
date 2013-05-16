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
	private Vector<Customer> CustomerWithRentedItems;
	
	public RentalHandler(ItemHandler ItemHa, CustomerHandler CustomerHa)
	{
		this.CustomerH = CustomerHa;
		this.ItemH = ItemHa;
		this.TotalPrice = 0;
		this.CustomerWithRentedItems = new Vector<Customer>();
	}
	
	public double calculatePrice(double IPrice)
	{
		this.TotalPrice += IPrice;
		return this.TotalPrice;
	}
	
	public double getTotalPrice()
	{
		return this.TotalPrice;
	}
	
	public Vector<Customer> listRented()
	{
		return this.CustomerWithRentedItems;
	}
	
	//GuiRental Call function before calculatePrice
	//if return true, calculate price wont be called 
	//else add price to this rental
	public boolean specialOffers(String CustomerName)
	{
		Customer CurrentCustomer = this.getCustomer(CustomerName);
		int nrOfRented = CurrentCustomer.getTotalRented();
		if(nrOfRented >= 10){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public void setItemStatus(String ItemName, boolean rented)
	{		
		Item CurrentItem = this.getItem(ItemName);
		CurrentItem.setStatus(rented);
	}
	
	public Item getItem(String ItemName)
	{
		Item CurrentItem = this.ItemH.getItem(ItemName);
		return CurrentItem;
	}
	
	public Customer getCustomer(String CustomerName)
	{
		Customer CurrentCustomer = this.CustomerH.getCustomer(CustomerName);
		return CurrentCustomer;
	}
	
	public Vector<Item> getItemList()
	{
		return this.ItemH.getListOfItems();
	}
	
	public boolean rentToCustomer(String CustomerName, String ItemName, int nrOfDays)
	{
		//Adds the item to the customers
		Customer CurrentCustomer = this.getCustomer(CustomerName);
		Item CurrentItem = this.getItem(ItemName);
		CurrentItem.setRentalExpireDate(nrOfDays);
		CurrentCustomer.addItem(CurrentItem);
		this.calculatePrice(this.ItemH.getPrice(CurrentItem.getPriceGroup()));
		this.ItemH.setItemStatus(CurrentItem.getId(), true);
		return true;
	}
	public boolean Rent(String CustomerName){
		//Adds the Customer to the vector with customers with rented items
		Customer CurrentCustomer = this.getCustomer(CustomerName);
		for(int i = 0; i<this.CustomerWithRentedItems.size(); i++){
			if(this.CustomerWithRentedItems.elementAt(i).getName().equals(CustomerName)){
				this.CustomerWithRentedItems.remove(i);
			}
		}
		this.CustomerWithRentedItems.add(CurrentCustomer);
		this.TotalPrice = 0;
		return true;
	}
	
}
