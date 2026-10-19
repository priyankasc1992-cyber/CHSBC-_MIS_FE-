import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SameWeekRepeat{
	static WebDriver driver = new EdgeDriver();
	@BeforeTest
	public void init() throws InterruptedException
	{
		driver.get("http://visualivrmis.simpragma.com/");
		Thread.sleep(5000);

		//1.login with valid credentials
		driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(6000);
		
	
	}
	@Test ( priority =2 , description="click on the Same Week Repeat \r\n" + 
			"in menu page")
	public  void TC_2() throws InterruptedException
	{
		//click on Same Week Repeat
		driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
		Thread.sleep(2000);
		//verify that we are on Same Week Repeat by checking title
		Assert.assertTrue( driver.findElement(By.tagName("h4")).getText().equalsIgnoreCase("Same Week Repeat"));
		
	}
	
	@Test( priority=5, description ="check the size of the Same Day \r\n" + 
			"Repeat page title bar")
	public void Tc_5() throws InterruptedException
	{
		//click on Same Week Repeat
		driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
		Thread.sleep(2000);
		int height=driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]")).getSize().getHeight();
		
		System.out.println("\n height of  tSame Week Repeat page  title bar: "+height);
		Assert.assertEquals(height,30);	
		
	}
	@Test ( priority =6 , description="check the distance between header and title bar on Same Week Repeat page")
	public  void TC_6() throws InterruptedException
	{
		//click on Same Week Repeat
				driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
				Thread.sleep(2000);
		
		//distance between header and title bar
		String distance=driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]")).getCssValue("margin-top").toString();
		System.out.println("check the distance between header and title bar on  Same Week Repeat: "+distance);
		Assert.assertEquals(distance,"48px");	
	}
	@Test ( priority =7 , description="check the title of the Same Week Repeat page")
	public  void TC_7() throws InterruptedException
	{
		//click on Same Week Repeat
				driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
				Thread.sleep(2000);
				String title=driver.findElement(By.tagName("h4")).getText();
				System.out.println("Title of Same Week Repeatt page :"+title);
				
				Assert.assertEquals(title, "Same Week Repeat");
	}
	@Test ( priority =8 , description="check the size of the Same Day \r\n" + 
			"Repeat title")
	public void TC_8() throws InterruptedException
	{
		//click on Same Week Repeat
		driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
		Thread.sleep(2000);
		
		int height=driver.findElement(By.tagName("h4")).getSize().getHeight();
		System.out.println("size of the  Same Week Repeat page title  :"+ height);	
		
		Assert.assertEquals(height,29);
	}
	@Test ( priority = 9 , description="check the size of the Same Week Repeat icon")
	public void TC_9() throws InterruptedException
	{

		//click on Same Week Repeat
				driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
				Thread.sleep(2000);
		
		// get size of Same Week Repeat icon
		String iconSize=driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).getSize().toString();
		
		System.out.println(iconSize);
		
		Assert.assertEquals(iconSize,"(30, 30)");
		
		
	}
	@Test( priority =10 , description="check the background colour Same Day Repea icon")
	public void tc_10() throws InterruptedException
	{	//click on Same Week Repeat
		driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
		Thread.sleep(2000);
		String iconBackgroundColor=driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).getCssValue("background-color").toString();
		System.out.println(iconBackgroundColor);
		Assert.assertEquals(iconBackgroundColor, "rgba(100, 181, 246, 1)");
	}
	
	@Test (priority=11, description="check the alignment of title  \r\n" + 
			"and icon in Same Week Repeat\r\n" + 
			"page")
	public void tc_11() throws InterruptedException
	{

		//click on Same Week Repeat
		driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
		Thread.sleep(2000);
		// verically center and horizhontally left/start
		String verticalAlign=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]")).getCssValue("align-items");
		String horizhontalAlign=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]")).getCssValue("text-align");
		System.out.println("Vertical align of Same Week Repeat text: "+verticalAlign);
		System.out.println("Horizhonatal align of Same Week Repeat text : "+horizhontalAlign);
		Assert.assertEquals(verticalAlign, "center");
		Assert.assertEquals(horizhontalAlign, "start");
		
	}
	@Test( priority =12, description="check the font size and font \r\n" + 
			"type of the Same Week Repeat \r\n" + 
			"title")
	public void tc_12() throws InterruptedException
	{
		//click on Same Week Repeat
				driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
				Thread.sleep(2000);
				String fontsize=driver.findElement(By.tagName("h4")).getCssValue("font-size");
				String fontFamily=driver.findElement(By.tagName("h4")).getCssValue("font-family");
				
				System.out.println(" font size of Same Week Repeat text : "+fontsize);
				System.out.println(" font family of Same Week Repeat text : "+fontFamily);
				
				Assert.assertEquals(fontsize, "24px");
				Assert.assertEquals(fontFamily, "\"Nunito Sans\"");
		
				
	}
	@Test ( priority =13, description="check that text colour of the \r\n" + 
			"Total Conversation title")
	public void tc_13() throws InterruptedException
	{
		//click on total conversation
				driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
				Thread.sleep(2000);
		String color=driver.findElement(By.tagName("h4")).getCssValue("color");
		System.out.println("Total Conversation  font color : "+color);
		Assert.assertEquals(color, "rgba(52, 52, 52, 1)");
	}
	@Test( priority =14, description="check that export icon is present \r\n" + 
			"or not in title bar of the Total \r\n" + 
			"Conversations page")
	public void Tc_14() throws InterruptedException
	{
		//click on total conversation
				driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
				Thread.sleep(2000);
			WebElement baseCard=driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]"));
			By exportIcon= By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/a[1]/*[1]");
			
			// verify if  export icon is present or not within  base card
			Assert.assertTrue(baseCard.findElement(exportIcon).isDisplayed());
	}
	@Test( priority =15, description="check that alignment of the \r\n" + 
			"export icon in title bar of the \r\n" + 
			"Same Week Repeat page")
	public void Tc_15() throws InterruptedException
	{

		//click on total conversation
				driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
				Thread.sleep(2000);
		WebElement  exportIcon= driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/a[1]/*[1]"));
		String vertical_align=exportIcon.getCssValue("vertical-align");
		String text_align=exportIcon.getCssValue("text-align");
		String  width=driver.findElement( By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]")).getCssValue("width");
		System.out.println("TC_15 vertiacl align : "+vertical_align);
		System.out.println("TC_15 text align : "+text_align);
		System.out.println("Tc_15 width : "+ width);
		
		Assert.assertEquals(vertical_align, "middle");
		Assert.assertEquals(text_align, "start");
		Assert.assertEquals(width, "164px");
		
	}
	@Test( priority =16, description="check that size of the export \r\n" + 
			"icon ")
	public void Tc_16() throws InterruptedException
	{
		//click on total conversation
		driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
		Thread.sleep(2000);
				WebElement  exportIcon= driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/a[1]/*[1]"));
				String size=exportIcon.getSize().toString();
				System.out.println(size);
				Assert.assertEquals(size, "(28, 28)");
				
				
				
	}
	@Test( priority =17, description="check the colour of the \r\n" + 
			"export icon")
	public void Tc_17() throws InterruptedException
	{
					//click on total conversation
			driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
			Thread.sleep(2000);
				WebElement  exportIcon= driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/a[1]/*[1]"));
				String color=exportIcon.getCssValue("color");
				System.out.println(color);
				Assert.assertEquals(color, "rgba(0, 128, 0, 1)");
			
	}
	@Test( priority =19 , description="check that export icon is \r\n" + 
			"clickable or not")
	public void Tc_19() throws InterruptedException
	{
		//click on total conversation
		driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
		Thread.sleep(2000);
		WebElement  exportIcon= driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/a[1]/*[1]"));
		Assert.assertTrue(exportIcon.isEnabled());
	}
	@Test( priority =22, description="check the size of the base card \r\n" + 
			"in Same Week Repeat page")
	public void Tc_22() throws InterruptedException
	{
		
		//click on total conversation
				driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
				Thread.sleep(2000);
		WebElement baseCard=driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]"));
		String size=baseCard.getSize().toString();
		System.out.println("Size  Of BaseCard : "+size);
		Assert.assertEquals(size, "(696, 501)");
	}
	@Test ( priority =23, description="check the size of the date filter \r\n" + 
	 		"row")
	 public void TC_23()throws InterruptedException
	{
		//click on total conversation
		driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
		Thread.sleep(2000);
				 String row = driver.findElement(By.className("row")).getSize().toString();
				 System.out.println(row);
				 Assert.assertEquals(row, "(656, 63)");
	}
	@Test (  priority =24 , description="check that From date and To \r\n" + 
			"date labels are presented or not" + 
			"row")
	public void Tc_24()throws InterruptedException
	{
		//click on total conversation
				driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
				Thread.sleep(2000);
				String from= driver.findElement(By.xpath("//label[contains(text(),'From Date')]")).getText();
				String to=driver.findElement(By.xpath("//label[contains(text(),'To Date')]")).getText();
		Assert.assertEquals(from, "From Date");
		Assert.assertEquals(to, "To Date");	
	}
	@Test (  priority =27 , description="check that size of the from date and to date fields")
	public void Tc_27()throws InterruptedException
	{
		//click on total conversation
				driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
				Thread.sleep(2000);
		String from= driver.findElement(By.xpath("(//input)[1]")).getSize().toString();
		String to=driver.findElement(By.xpath("(//input)[2]")).getSize().toString();
		System.out.println(" size of the  from date filter :" +from);
		System.out.println(" size of the  to date filter :" +to);
		Assert.assertEquals(from, "(140, 40)");
		Assert.assertEquals(to, "(140, 40)");	
	}
	 @Test ( priority =29, description="check that text colour of the \r\n" + 
		 		"from date and to date fields")
				 public void TC_29()throws InterruptedException
				{
		//click on total conversation
			driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
			Thread.sleep(2000);
						String from= driver.findElement(By.xpath("(//input)[1]")).getCssValue("color").toString();
						String to=driver.findElement(By.xpath("(//input)[2]")).getCssValue("color").toString();
						System.out.println(" text colour of the from date :" + from);
						System.out.println(" text colour of the to date :" + to);
						Assert.assertEquals(from, "rgba(42, 48, 57, 1)");
						Assert.assertEquals(to, "rgba(42, 48, 57, 1)");
				}
	 
	 
}
