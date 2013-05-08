//In this package
package Model.NewsletterPackage;

//Import what this class use
@SuppressWarnings("unused")
public class NewsletterHandler
{	
	private Newsletter newsletter = null;
	
	//Constructor
	public NewsletterHandler()
	{
		super();
		this.newsletter = new Newsletter();
	}
	
	public NewsletterHandler(String title, String content)
	{
		super();
		this.newsletter = new Newsletter(title, content);
	}
	
	public void setTitle(String title)
	{
		this.newsletter.setTitle(title);
	}
	
	public void setContent(String content)
	{
		this.newsletter.setContent(content);
	}
	
	public void getAddressList(String preference)
	{
		//getAddressList from Customerhandler
	}
	
	public void send()
	{
		System.out.println(this.newsletter.getTitle());
		System.out.println(this.newsletter.getContent());
	}
}
