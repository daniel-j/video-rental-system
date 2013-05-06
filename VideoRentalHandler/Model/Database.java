import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;

public class Database implements Serializable
{
	private Vector<Item> items;
	private Vector<Customer> customers;
	
	public Database()
	{
		this.items = new Vector<Item>();
		this.customers = new Vector<Customer>();
	}
	
	public void addItem(Item item)
	{
		this.items.add(item);
	}
	
	public void addCustomer(Customer customer)
	{
		this.customers.add(customer);
	}
	
	public Item getItem(int i)
	{
		return this.items.get(i);
	}
	
	public Customer getCustomer(int i)
	{
		return this.customers.get(i);
	}
}
