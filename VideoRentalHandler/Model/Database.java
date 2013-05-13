//In this package
package Model;

//Import what this class use
import Model.CustomerPackage.*;
import Model.ItemPackage.*;

import java.io.Serializable;
import java.util.Vector;

public class Database implements Serializable
{
	private static final long	serialVersionUID	= 1L;
	private Vector<Item> items;
	private Vector<Customer> customers;
	/**
	 * Constructor
	 */
	public Database()
	{
		this.items = new Vector<Item>();
		this.customers = new Vector<Customer>();
	}
	
	/**
	 * Add item to "database"
	 * @param item		Item to be saved
	 */
	public void addItem(Item item)
	{
		this.items.add(item);
	}
	
	/**
	 * Add customer to "database"
	 * @param customer	Customer to be saved
	 */
	public void addCustomer(Customer customer)
	{
		this.customers.add(customer);
	}
	
	/**
	 * Add list of items to "database"
	 * @param itemList		List of items to be saved
	 */
	public void addItemList(Vector<Item> itemList)
	{
		this.items = itemList;
	}
	
	/**
	 * Add list of customers to "database"
	 * @param customerList	List of customers to be saved
	 */
	public void addCustomerList(Vector<Customer> customerList)
	{
		this.customers = customerList;
	}
	
	/**
	 * Get item
	 * @param index		Index of item
	 * @return			Item
	 */
	public Vector<Item> getItemList()
	{
		return this.items;
	}
	
	/**
	 * Get customer
	 * @param index		Index of customer
	 * @return			Customer
	 */
	public Vector<Customer> getCustomerList()
	{
		return this.customers;
	}
}
