//In this package
package Model.NewsletterPackage;

import java.util.Vector;

//Import what this class use

@SuppressWarnings("unused")
public class Newsletter
{
	
	private String title				= null;
	private String content				= null;
	private Vector<String> addressList	= null;
	
	public Newsletter()
	{
		super();
		this.title 	 = new String();
		this.content = new String();
		this.addressList = new Vector<String>();
	}
	
	public Newsletter(String title, String content)
	{
		super();
		this.title 	 = title;
		this.content = content;
		this.addressList = new Vector<String>();
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public String getContent()
	{
		return this.content;
	}
	
	public void setAddressList(String[] arr)
	{
		for(String addr : arr)
		{
			this.addressList.add(addr);
		}
	}
}
