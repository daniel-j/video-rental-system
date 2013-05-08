//In this package
package Model.CustomerPackage;

import java.util.Vector;

import Model.ItemPackage.Item;

//Import what this class use

public class CustomerHandler
{	
	private Vector<Customer> customers;
	
	//Constructor
	public CustomerHandler()
	{
		this.customers = new Vector<Customer>();
	}
	
	public boolean addCustomer(String name, String ssn, String address, String preference)
	{
		this.customers.add(new Customer(name, ssn, address, preference));
		
		return true;
	}
	
	public boolean editCustomer(int id, String name, String ssn, Vector<Item> rentedItems, String address, String preference)
	{
		this.customers.elementAt(id).changeInfo(name, ssn, rentedItems, address, preference);
		
		return true;
	}
	
	public boolean removeCustomer(int id)
	{
		this.customers.remove(id);
		
		return true;
	}
	
	public Customer getCustomer(int id)
	{
		return this.customers.elementAt(id);
	}
	
	public boolean setItemToCustomer(int id, Item item)
	{
		this.customers.elementAt(id).addItem(item);
		
		return true;
	}
	
	public Vector<String> getCustomersWithPreferences(String preference)
	{
		Vector<String> addressList = new Vector<String>();
		
		for(Customer temp : this.customers)
		{
			if(temp.getPreference().equals(preference))
			{
				addressList.add(temp.getAddress());
			}
		}
		
		return addressList;
	}
	
	public Vector<Customer> getListOfCustomers()
	{
		return this.customers;
	}
	
}
