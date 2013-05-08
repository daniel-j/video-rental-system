//In this package
package Model.NewsletterPackage;

import Model.CustomerPackage.CustomerHandler;

//Import what this class use
public class NewsletterHandler
{	
	private Newsletter newsletter = null;
	
	/**
	 * Constructor
	 */
	public NewsletterHandler()
	{
		super();
		this.newsletter = new Newsletter();
	}
	
	/**
	 * Constructor
	 * @param title		Title of newsletter
	 * @param content	Content of newsletter
	 */
	public NewsletterHandler(String title, String content)
	{
		super();
		this.newsletter = new Newsletter(title, content);
	}
	
	/**
	 * Set title of newsletter
	 * @param title		Title of newsletter
	 */
	public void setTitle(String title)
	{
		this.newsletter.setTitle(title);
	}
	
	/**
	 * Set content of newsletter
	 * @param content	Content of newsletter
	 */
	public void setContent(String content)
	{
		this.newsletter.setContent(content);
	}
	
	/**
	 * Get addresslist of customers
	 * @param preference	Preference of customers
	 */
	public void getAddressList(String preference)
	{
		CustomerHandler temp = new CustomerHandler();
		this.newsletter.setAddressList(temp.getCustomersWithPreferences(preference));
	}
	
	/**
	 * Send newsletter
	 */
	public void send()
	{
		System.out.println(this.newsletter.getTitle());
		System.out.println(this.newsletter.getContent());
	}
}
