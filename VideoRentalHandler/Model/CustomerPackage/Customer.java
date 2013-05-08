//In this package
package Model.CustomerPackage;
import java.util.Vector;

//Import what this class use
import Model.ItemPackage.*;

public class Customer 
{
	private static int id;
	private String name;
	private String ssn;
	private Vector<Item> rentedItems;
	private String address;
	private String preference;
	
	public Customer() 
	{
		super();
		this.id++;
		this.name = "";
		this.ssn = "";
		this.rentedItems = new Vector<Item>();
		this.address = "";
		this.preference = "";
	}

	public Customer(String name, String ssn, String address, String preference) 
	{
		super();
		this.id++;
		this.name = name;
		this.ssn = ssn;
		this.rentedItems = new Vector<Item>();
		this.address = address;
		this.preference = preference;
	}
	
	public void changeInfo(String name, String ssn, Vector<Item> rentedItems, String address, String preference)
	{
		this.name = name;
		this.ssn = ssn;
		this.rentedItems = rentedItems;
		this.address = address;
		this.preference = preference;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSsn()
	{
		return ssn;
	}

	public void setSsn(String ssn)
	{
		this.ssn = ssn;
	}

	public Vector<Item> getRentedItems()
	{
		return rentedItems;
	}

	public void setRentedItems(Vector<Item> rentedItems)
	{
		this.rentedItems = rentedItems;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPreference()
	{
		return preference;
	}

	public void setPreference(String preference)
	{
		this.preference = preference;
	}
	
	public void addItem(Item item)
	{
		this.rentedItems.add(item);
	}
}
