package videoRentalHandlerGUI;

import java.io.Serializable;
import java.util.Vector;


public class ItemHandler implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Vector<Item> arrayOfItems;
	private Vector<Double> priceGroup;
	private int id;
	
	public ItemHandler()
	{
		
		this.arrayOfItems = new Vector<Item>();
		this.priceGroup = new Vector<Double>(3);
		this.priceGroup.add((double) 50);
		this.priceGroup.add((double) 100);
		this.priceGroup.add((double) 150);
		this.id = 1;
	}
	
	
	public boolean addItem(int video, String title, int priceGroup, String genre, int releaseYear, String medium, int inStock)
	{
		boolean added = false;
		this.arrayOfItems.add(new Video(title, priceGroup, genre, releaseYear, medium, this.id, inStock));
		added = true;
		this.id++;
		return added;
	}
	public boolean addItem(String title, int priceGroup, String genre, int releaseYear, String platform, int inStock)
	{
		boolean added = false;
		this.arrayOfItems.add(new Game(title, priceGroup, genre, releaseYear, platform, this.id, inStock));
		added = true;
		this.id++;
		return added;
	}
	public boolean editItem(int itemToEdit, String title, int id, int priceGroup, String genre, int releaseYear, String platform, String medium)
	{
		boolean edited = false;
		
		if(itemToEdit == 1)	// Video
		{
			for(int i = 0; i < this.arrayOfItems.size(); i++)
			{
				if(this.arrayOfItems.get(i).getId() == id)
				{
					this.arrayOfItems.get(i).setPriceGroup(priceGroup);
					this.arrayOfItems.get(i).setTitle(title);
					((Video) this.arrayOfItems.get(i)).setGenre(genre);
					((Video) this.arrayOfItems.get(i)).setReleaseYear(releaseYear);
					((Video) this.arrayOfItems.get(i)).setMedium(medium);
					edited = true;
				}
			}
		}
		else
		{
			for(int i = 0; i < this.arrayOfItems.size(); i++)
			{
				if(this.arrayOfItems.get(i).getId() == id)
				{
					this.arrayOfItems.get(i).setPriceGroup(priceGroup);
					this.arrayOfItems.get(i).setTitle(title);
					((Game) this.arrayOfItems.get(i)).setGenre(genre);
					((Game) this.arrayOfItems.get(i)).setReleaseYear(releaseYear);
					((Game) this.arrayOfItems.get(i)).setPlatform(platform);
					edited = true;
				}
			}
		}
		return edited;
	}
	
	public boolean removeItem(String title)
	{
		boolean removed = false;
		
		for(int i = 0; i < this.arrayOfItems.size(); i++)
		{
			if(this.arrayOfItems.get(i).getTitle() == title)
			{
				this.arrayOfItems.remove(i);
				removed = true;
			}
		}
		return removed;
	}
	
	public int currentInStock(int id)
	{
		int currInStock = 0;
		boolean found = false;
		if(this.arrayOfItems.isEmpty())
		{
			currInStock = -1;
		}
		else
		{
			for(int i = 0; i < this.arrayOfItems.size(); i++)
			{
				if(this.arrayOfItems.get(i).getId() == id)
				{
					found = true;
					currInStock = this.arrayOfItems.get(i).getInStock();
				}
			}
			if(found == false)
			{
				currInStock = -2;
			}
		}
		
		return currInStock;
	}
	
	public Item getItem(String title)
	{
		Item temp = null;
		
		for(int i = 0; i < this.arrayOfItems.size(); i++)
		{
			if(this.arrayOfItems.get(i).getTitle().equals(title))
			{
				temp = this.arrayOfItems.get(i);
			}
		}
		return temp;
	}
	
	public boolean setItemStatus(int id, boolean rented)
	{
		boolean changed = false;
		
		for(int i = 0; i < this.arrayOfItems.size(); i++)
		{
			if(this.arrayOfItems.get(i).getId() == id)
			{
				this.arrayOfItems.get(i).setStatus(rented);
				changed = true;
			}
		}
		return changed;
	}
	
	public boolean editPricegroup(int priceGroup, Double price)
	{
		
		this.priceGroup.remove(priceGroup-1);
		this.priceGroup.add(priceGroup-1, price);
		return true;
	}
	
	public Vector<Item> getListOfItems()
	{
		return this.arrayOfItems;
	}
	public String[] getAllItemsAsStrings()
	{
		String[] str = new String[this.arrayOfItems.size()];
		int counter = 0;
		if(this.arrayOfItems.isEmpty())
		{
			String[] empty = new String[]{"Empty List.."};
			return empty;
		}
		else
		{
			for(Item item : this.arrayOfItems)
			{
				str[counter] = item.getTitle();
				counter++;
			}
		}
		return str;
	}
	public String[] getAllVideos()
	{
		String[] str = new String[this.arrayOfItems.size()];
		int counter = 0;
		
		if(this.arrayOfItems.isEmpty())
		{
			String[] empty = new String[]{"Empty List.."};
			return empty;
		}
		else
		{
			for(Item item : this.arrayOfItems)
			{
				if(item instanceof Video)
				{
					str[counter] = item.getTitle();
				}
			}
		}
		return str;
	}
	public String[] getAllGames()
	{
		String[] str = new String[this.arrayOfItems.size()];
		int counter = 0;
		
		if(this.arrayOfItems.isEmpty())
		{
			String[] empty = new String[]{"Empty List.."};
			return empty;
		}
		else
		{
			for(Item item : this.arrayOfItems)
			{
				if(item instanceof Game)
				{
					str[counter] = item.getTitle();
				}
			}
		}
		return str;
	}
	public int getItemId(int id)
	{
		int inStock = 0;
		
		if(this.arrayOfItems.isEmpty())
		{
			inStock = -1;
		}
		else
		{
			for(Item item : this.arrayOfItems)
			{
				if(item.getId() == id)
				{
					inStock = item.getInStock();
				}
			}
			
		}
		return inStock;
		
	}
	public String[] getItemInfo(String title)
	{
		String[] str = new String[1];
		
		if(this.arrayOfItems.isEmpty())
		{
			String[] empty = new String[]{"Empty List.."};
			return empty;
		}
		else
		{
			for(Item item : this.arrayOfItems)
			{
				if(item.getTitle().equals(title))
				{
					str[0] = item.toString();
				}
			}
		}
		return str;
	}
	public String[] listPriceGroups()
	{
		String[] pgs = new String[this.priceGroup.size()];
		int i = 0;
		
		for(Double price : this.priceGroup)
		{
			pgs[i] = "Pricegroup " + (i+1) + " = " + String.valueOf(price) + "kr\n";
			i++;
		}
		return pgs;
	}
}