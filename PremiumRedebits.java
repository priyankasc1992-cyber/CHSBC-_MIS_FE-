import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PremiumRedebits {
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
   @Test( priority=1, description="check that Forms menu item \r\n" + 
   		"contains the following submenu \r\n" + 
   		"items or not, in menu page\r\n"
   		+ "Callback Requests,\r\n" + 
   		"Callback Requests,\r\n" + 
   		"Policy Redebit")
   public void tc_1()
   {
	   List<WebElement> formList= driver.findElements(By.className("subMenuItem"));

	   System.out.println(" outside if1 Tc1");
	   for(WebElement e: formList)
	   {
		   String text=e.getText();
		   System.out.println(text);
		   if(text.contains("Callback Requests")||
			  text.contains("Callback Requests")||
			 text.contains("Policy Redebit Requests"))
		   {
			   System.out.println(" inside if1 Tc1");
			   Assert.assertTrue(true);
			  
		   }
	   }
   }
	   
		 @Test ( priority =2 , description="click on the Callback Requests \r\n" + 
				"in menu page")
		public  void  TC_2() throws InterruptedException
		{
			//click on Callback Requests
			driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
			Thread.sleep(2000);
			//verify that we are on Callback Requests by checking title
			Assert.assertTrue( driver.findElement(By.tagName("h4")).getText().equalsIgnoreCase("Callback Requests"));
			
		}
  
	@Test (  priority =3 , description="check that size of the from date and to date fields")
	public void Tc_3()throws InterruptedException
	{
		//click on Callback Requests
				driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
				Thread.sleep(2000);
		int from= driver.findElement(By.xpath("(//input)[2]")).getSize().getHeight();
		int to=driver.findElement(By.xpath("(//input)[2]")).getSize().getHeight();
		System.out.println(" size of the  from date filter :" +from);
		System.out.println(" size of the  to date filter :" +to);
		Assert.assertEquals(from,40);
		Assert.assertEquals(to, 40);	
	}
	@Test( priority=5, description ="check the size of the Callback Requests page title bar")
	public void Tc_5() throws InterruptedException
	{
		//click on Callback Requests
		driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
		Thread.sleep(2000);
		int height=driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]")).getSize().getHeight();
		
		System.out.println("\n height of  Callback Requests  title bar: "+height);
		Assert.assertEquals(height,30);	
		
	}
	
	@Test ( priority =6 , description="check the distance between header and title bar on page")
	public  void TC_6() throws InterruptedException
	{
		//click on Callback Requests
				driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
				Thread.sleep(2000);
		
		//distance between header and title bar
		String distance=driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]")).getCssValue("margin-top").toString();
		System.out.println("check the distance between header and title bar : "+distance);
		Assert.assertEquals(distance,"48px");	
	}
	@Test ( priority =7 , description="check the title ")
	public  void TC_7() throws InterruptedException
	{
		//click on Callback Requests
				driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
				Thread.sleep(2000);
				String title=driver.findElement(By.tagName("h4")).getText();
				System.out.println("Title  :"+title);
				
				Assert.assertEquals(title, "Callback Requests");
	}
	@Test ( priority =8 , description="check the size of  title")
	public void TC_8() throws InterruptedException
	{
		//click on Callback Requests
		driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
		Thread.sleep(2000);
		
		int height=driver.findElement(By.tagName("h4")).getSize().getHeight();
		System.out.println("size of the  Callback Requests page title  :"+ height);	
		
		Assert.assertEquals(height,29);
	}
	@Test ( priority = 9 , description="check the size of the  icon")
	public void TC_9() throws InterruptedException
	{

		//click on Callback Requests
				driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
				Thread.sleep(2000);
		
		// get size of Callback Requests icon
		String iconSize=driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).getSize().toString();
		
		System.out.println(iconSize);
		
		Assert.assertEquals(iconSize,"(30, 30)");
		
		
	}
	@Test( priority =10 , description="check the background colour of  icon")
	public void tc_10() throws InterruptedException
	{	//click on Callback Requests
		driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
		Thread.sleep(2000);
		String iconBackgroundColor=driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).getCssValue("background-color").toString();
		System.out.println(iconBackgroundColor);
		Assert.assertEquals(iconBackgroundColor, "rgba(100, 181, 246, 1)");
	}
	@Test (priority=11, description="check the alignment of title")
	public void tc_11() throws InterruptedException
	{

		//click on Callback Requests
		driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
		Thread.sleep(2000);
		// verically center and horizhontally left/start
		String verticalAlign=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]")).getCssValue("align-items");
		String horizhontalAlign=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]")).getCssValue("text-align");
		System.out.println("Vertical align of Callback Requests text: "+verticalAlign);
		System.out.println("Horizhonatal align of Callback Requests text : "+horizhontalAlign);
		Assert.assertEquals(verticalAlign, "center");
		Assert.assertEquals(horizhontalAlign, "start");
		
	}
	@Test( priority =12, description="check the font size and font \r\n" + 
			"type of title")
	public void tc_12() throws InterruptedException
	{
		//click on Callback Requests
				driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
				Thread.sleep(2000);
				String fontsize=driver.findElement(By.tagName("h4")).getCssValue("font-size");
				String fontFamily=driver.findElement(By.tagName("h4")).getCssValue("font-family");
				
				System.out.println(" font size of Callback Requests text : "+fontsize);
				System.out.println(" font family of Callback Requests text : "+fontFamily);
				
				Assert.assertEquals(fontsize, "24px");
				Assert.assertEquals(fontFamily, "\"Nunito Sans\"");
		
				
	}
	@Test ( priority =13, description="check that text colour of the  title")
	public void tc_13() throws InterruptedException
	{
		//click on Callback Requests
				driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
				Thread.sleep(2000);
		String color=driver.findElement(By.tagName("h4")).getCssValue("color");
		System.out.println("Callback Requests  font color : "+color);
		Assert.assertEquals(color, "rgba(52, 52, 52, 1)");
	}
	@Test( priority =14, description="check that export icon is present \r\n" + 
			"or not  ")
	public void Tc_14() throws InterruptedException
	{
		//click on Callback Requests
				driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
				Thread.sleep(2000);
			
			By exportIcon= By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/*[1]");
			
			// verify if  export icon is present or not 
			Assert.assertTrue(driver.findElement(exportIcon).isDisplayed());
	}
	@Test( priority =15, description="check that alignment of the \r\n" + 
			"export icon in title bar ")
	public void Tc_15() throws InterruptedException
	{

		//click on Callback Requests
				driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
				Thread.sleep(2000);
		WebElement  exportIcon= driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/*[1]"));
		String vertical_align=exportIcon.getCssValue("vertical-align");
		String text_align=exportIcon.getCssValue("text-align");
		String  width=exportIcon.getCssValue("width");
		System.out.println("TC_15 vertiacl align : "+vertical_align);
		System.out.println("TC_15 text align : "+text_align);
		System.out.println("Tc_15 width : "+ width);
		
		Assert.assertEquals(vertical_align, "middle");
		Assert.assertEquals(text_align, "start");
		Assert.assertEquals(width, "28px");
		
	}
	@Test( priority =16, description="check that size of the export \r\n" + 
			"icon ")
	public void Tc_16() throws InterruptedException
	{
		//click on Callback Requests
		driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
		Thread.sleep(2000);
				WebElement  exportIcon= driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/*[1]"));
				String size=exportIcon.getSize().toString();
				System.out.println(size);
				Assert.assertEquals(size, "(28, 28)");
				
				
				
	}
	@Test( priority =17, description="check the colour of the \r\n" + 
			"export icon")
	public void Tc_17() throws InterruptedException
	{
					//click on Callback Requests
			driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
			Thread.sleep(2000);
				WebElement  exportIcon= driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/*[1]"));
				String color=exportIcon.getCssValue("color");
				System.out.println(color);
				Assert.assertEquals(color, "rgba(0, 128, 0, 1)");
			
	}
	@Test( priority =19 , description="check that export icon is \r\n" + 
			"clickable or not")
	public void Tc_19() throws InterruptedException
	{
		//click on Callback Requests
		driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
		Thread.sleep(2000);
		WebElement  exportIcon= driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/*[1]"));
		Assert.assertTrue(exportIcon.isEnabled());
	}@Test( priority =22, description="check the size of the base card \r\n" + 
			"in Callback Requests page")
	public void Tc_22() throws InterruptedException
	{
		
		//click on Callback Requests
				driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
				Thread.sleep(2000);
		WebElement baseCard=driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]"));
		String size=baseCard.getSize().toString();
		System.out.println("Size  Of BaseCard : "+size);
		Assert.assertEquals(size, "(720, 95)");
	}
	@Test ( priority =23, description="check the size of the date filter \r\n" + 
	 		"row")
	 public void TC_23()throws InterruptedException
	{
		//click on Callback Requests
		driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
		Thread.sleep(2000);
				 String row = driver.findElement(By.className("row")).getSize().toString();
				 System.out.println(row);
				 Assert.assertEquals(row, "(720, 95)");
	}
	@Test (  priority =24 , description="check that From date and To \r\n" + 
			"date labels are presented or not" + 
			"row")
	public void Tc_24()throws InterruptedException
	{
		//click on Callback Requests
				driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
				Thread.sleep(2000);
				String from= driver.findElement(By.xpath("//label[contains(text(),'From Date')]")).getText();
				String to=driver.findElement(By.xpath("//label[contains(text(),'To Date')]")).getText();
		Assert.assertEquals(from, "From Date");
		Assert.assertEquals(to, "To Date");	
	}
	@Test (  priority =27 , description="check that size of the from date and to date fields")
	public void Tc_27()throws InterruptedException
	{
		//click on Callback Requests
				driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
				Thread.sleep(2000);
		String from= driver.findElement(By.xpath("(//input)[1]")).getSize().toString();
		String to=driver.findElement(By.xpath("(//input)[2]")).getSize().toString();
		System.out.println(" size of the  from date filter :" +from);
		System.out.println(" size of the  to date filter :" +to);
		Assert.assertEquals(from, "(148, 40)");
		Assert.assertEquals(to, "(148, 40)");	
	}
	 @Test ( priority =29, description="check that text colour of the \r\n" + 
		 		"from date and to date fields")
				 public void TC_29()throws InterruptedException
				{
		//click on Callback Requests
			driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
			Thread.sleep(2000);
						String from= driver.findElement(By.xpath("(//input)[1]")).getCssValue("color").toString();
						String to=driver.findElement(By.xpath("(//input)[2]")).getCssValue("color").toString();
						System.out.println(" text colour of the from date :" + from);
						System.out.println(" text colour of the to date :" + to);
						Assert.assertEquals(from, "rgba(42, 48, 57, 1)");
						Assert.assertEquals(to, "rgba(42, 48, 57, 1)");
				}
	 @Test (  priority =30 , description="check that size of the from date and to date fields")
		public void Tc_30()throws InterruptedException
		{
			
				//click on Callback Requests
					driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
					Thread.sleep(2000);
			int fromHeight= driver.findElement(By.xpath("(//input)[1]")).getSize().getHeight();
			
			int toHeight=driver.findElement(By.xpath("(//input)[2]")).getSize().getHeight();


			System.out.println(" size of the  from date filter :" +fromHeight);
			System.out.println(" size of the  to date filter :" +toHeight);
			Assert.assertEquals(fromHeight, 40);
			Assert.assertEquals(toHeight, 40);	
		}
	 @Test (  priority =31 , description="check that font size and font \r\n" + 
	 		"type of the from date and to \r\n" + 
	 		"date")
		public void Tc_31()throws InterruptedException
		{
			
				//click on Callback Requests
					driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
					Thread.sleep(2000);
			String fromFontSize= driver.findElement(By.xpath("(//input)[1]")).getCssValue("font-size").toString();
			String fromFontFamily= driver.findElement(By.xpath("(//input)[1]")).getCssValue("font-family").toString();
			String toFontSize= driver.findElement(By.xpath("(//input)[1]")).getCssValue("font-size").toString();
			String toFontFamily= driver.findElement(By.xpath("(//input)[1]")).getCssValue("font-family").toString();

			System.out.println("  from date  font size and family:" +fromFontSize+" "+fromFontFamily);
			System.out.println("  to date  font size and family:" +toFontSize+" "+toFontFamily);
			Assert.assertEquals(fromFontSize, "16px");
			Assert.assertEquals(fromFontFamily, "Nunito");	
			Assert.assertEquals(toFontSize, "16px");
			Assert.assertEquals(toFontFamily, "Nunito");	
		}
	 @Test(priority=32,description="check that text colour of the \r\n" + 
	 		"from date and to date fields")
		public void tc_32() throws InterruptedException
		{
		//click on Callback Requests
		 driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
			Thread.sleep(2000);
			WebElement fromDate=driver.findElement(By.xpath("(//input)[1]"));
			String fromdatecolor=fromDate.getCssValue("color").toString();
			System.out.println("from date color "+fromdatecolor);
			Assert.assertEquals(fromdatecolor,"rgba(42, 48, 57, 1)");
			WebElement toDate=driver.findElement(By.xpath("(//input)[2]"));
			String todatecolor=fromDate.getCssValue("color").toString();
			System.out.println("to  date  color:"+todatecolor);
			Assert.assertEquals(todatecolor,"rgba(42, 48, 57, 1)");	
		}
		@Test(priority=33,description="check that alignment of the \r\n" + 
				"from date and to date fields")
		public void tc_33() throws InterruptedException
		{
			//click on Callback Requests
			 driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
				Thread.sleep(2000);
			WebElement fromDate=driver.findElement(By.xpath("(//input)[1]"));
			WebElement todate=driver.findElement(By.xpath("(//input)[2]"));
			
			String fromdatealign=fromDate.getCssValue("align-items").toString();
			System.out.println("from date field alignment  "+fromdatealign);
			Assert.assertEquals(fromdatealign,"center");
			
			String todatealign=todate.getCssValue("align-items").toString();
			System.out.println("to  date field alignment:"+todatealign);
			Assert.assertEquals(todatealign,"center");	
		}
	 @Test( priority =34, description="when we click on the from date and to date fields check whether the fields are highlighted in blue colour ")
	 public void tc_34() throws InterruptedException
	 {
		//click on Callback Requests
			driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
			Thread.sleep(2000);
			//clcik on from date 

			WebElement fromDate=driver.findElement(By.xpath("(//input)[1]"));
			fromDate.click();
			//get border color of top left right and bottom
			String ftop=fromDate.getCssValue("border-top-color");
			String fleft=fromDate.getCssValue("border-top-color");
			String fright=fromDate.getCssValue("border-top-color");
			String fbottom=fromDate.getCssValue("border-top-color");
			System.out.println(ftop+" "+fleft+" "+fright+" "+fbottom);
			//verify that all border colors are same
			Assert.assertTrue(ftop.equals(fleft));
			Assert.assertTrue(ftop.equals(fright));
			Assert.assertTrue(ftop.equals(fbottom));
			Assert.assertTrue(fleft.equals(fright));
			Assert.assertTrue(fleft.equals(fbottom));
			Assert.assertTrue(fbottom.equals(fright));
			//Verify eo and  ao
			Assert.assertEquals(ftop, "rgba(1, 182, 245, 1)");
			
			WebElement todate=driver.findElement(By.xpath("(//input)[2]"));
			//clcik on to date 
		
					todate.click();
					Thread.sleep(5000);
					//get border color of top left right and bottom
					String top=todate.getCssValue("border-top-color");
					String left=todate.getCssValue("border-top-color");
					String right=todate.getCssValue("border-top-color");
					String bottom=todate.getCssValue("border-top-color");
					System.out.println(top+" "+left+" "+right+" "+bottom);
					//verify that all border colors are same
					Assert.assertTrue(top.equals(left));
					Assert.assertTrue(top.equals(right));
					Assert.assertTrue(top.equals(bottom));
					Assert.assertTrue(left.equals(right));
					Assert.assertTrue(left.equals(bottom));
					
					Assert.assertTrue(bottom.equals(right));
					String eo ="rgba(1, 182, 245, 1)";
					//Verify eo and  ao
					Assert.assertEquals(top,eo );
	 }
	 @Test( priority =38, description="check the size of the data \r\n" + 
	 		"table ")
	 public void tc_38() throws InterruptedException
	 {
		 //click on Callback Requests
		driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
		Thread.sleep(2000);
		 WebElement table= driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[2]/section[1]/div[1]/div[2]/div[1]/div[1]"));
		 int height=table.getSize().height;
		 int width=table.getSize().width;
		
		 Assert.assertEquals("914", height);
		 Assert.assertEquals("466", width);
	 }
	 @Test( priority =39, description="check that data table header \r\n" + 
	 		"contains the following items or not")
		 public void tc_39() throws InterruptedException
		 {
			 //click on Callback Requests
			driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
			Thread.sleep(2000);
			 List<WebElement> tableHeader= driver.findElements(By.xpath("//th[@scope='col']/div/div"));
			 ArrayList<String> al=new ArrayList<String>();
			 for(WebElement e:tableHeader)
			 {
				al.add( e.getText());
			 }
			 System.out.println(al);
			 Assert.assertEquals(al.get(0), "DATE");
			 Assert.assertEquals(al.get(1), "CUSTOMER");
			 Assert.assertEquals(al.get(2), "MOBILE NUMBER");
			
			 
		 }
	 @Test(priority=41,description="check that font size and font \r\n" + 
	 		"type of the table header content")
				public void tc_41() throws InterruptedException
				{
			 		//click on Callback Requests
					driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
					Thread.sleep(2000);
					List<WebElement> tableHeader= driver.findElements(By.xpath("//th[@scope='col']/div/div"));
					for(WebElement e:tableHeader)
					 {
						Assert.assertEquals(e.getCssValue("font-size"),"14px");
						Assert.assertEquals(e.getCssValue("font-family"), "Nunito");
					 }
				}
	 @Test(priority=42,description="check that color \r\n" + 
		 		"type of the table header content")
					public void tc_42() throws InterruptedException
					{
				 		//click on Callback Requests
						driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
						Thread.sleep(2000);
						List<WebElement> tableHeader= driver.findElements(By.xpath("//th[@scope='col']/div/div"));
						for(WebElement e:tableHeader)
						 {
							Assert.assertEquals(e.getCssValue("color"),"rgba(63, 73, 84, 1)");
						 }
					}
	 @Test(priority=43,description="check that  size of the table header content")
					public void tc_43() throws InterruptedException
					{
				 		//click on Callback Requests
						driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
						Thread.sleep(2000);
						List<WebElement> tableHeader= driver.findElements(By.xpath("//th[@scope='col']/div"));
						for(WebElement e:tableHeader)
						 {
							int h=e.getSize().getHeight();
							Assert.assertEquals(h,44);
							
						 }
					}
	

	
	@Test(priority=46,description="check the size of the each \r\n" + 
	 		"gridcell in the table")
			public void tc_46() throws InterruptedException
			{

					//click on Callback Requests
					driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
					Thread.sleep(2000);
					int eoheight=42;
					List<WebElement> td= driver.findElements(By.tagName("td"));
					for(WebElement e:td)
					{
						int height=e.getSize().getHeight();
						Assert.assertEquals(eoheight, height);
						
						
					}
					
			}
	 @Test(priority=47,description="check that data is at left \r\n" + 
	 		"aligned or not in the table")
				public void tc_47() throws InterruptedException
				{

						//click on Callback Requests
						driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
						Thread.sleep(2000);
						List<WebElement> td= driver.findElements(By.tagName("td"));
						for(WebElement e:td)
						{
							Assert.assertTrue(e.getCssValue("text-align").equals("left"));
							
						}
						
				}
	 @Test ( priority=49 ,description="In CUSTOMER column check \r\n" + 
				"that customer name is \r\n" + 
				"displayed in uppercase or not")
		public void TC_49() throws InterruptedException
		{
			int i=0;

			//click on Callback Requests
			driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
			Thread.sleep(2000);
		 List<WebElement> customerColumnData=driver.findElements(By.xpath("(//td/div/span)[1]"));
		 for(WebElement e: customerColumnData)
		 {
			
			 String name=e.getText();
			 System.out.println(name);
			 String  UC_name=name.toUpperCase();
			 Assert.assertTrue(name.equals(UC_name));
			
			
			 
		 }
		}
	 @Test ( priority=50,description="In MOBILE NUMBER column \r\n" + 
	 		"check that displayed data is only \r\n" + 
	 		"10 digits number or not")
		public void TC_46() throws InterruptedException
		{
			int i=0;
			//click on Callback Requests
			driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
			Thread.sleep(2000);
			String mobile=driver.findElement(By.xpath("(//td/div/span)[2]")).getText();
			System.out.println(mobile);
			Assert.assertEquals(mobile.length(), 10);	
		 }
	 @Test ( priority=55,description="check the size of the Goto page \r\n" + 
		 		"buttons",enabled=false)
					public void TC_55() throws InterruptedException
					{
				
						//click on Callback Requests
						driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
						Thread.sleep(2000);
						//check if goto btns are present or not
						int i=0;
					
							List<WebElement>gotobtns=driver.findElements(By.className("sc-dPNhBE.kqZRAX"));
							for(WebElement e:gotobtns)
							{
								
								int height=gotobtns.get(i).getSize().getHeight();
								int width=gotobtns.get(i).getSize().getWidth();
								System.out.println(" size of goto button  "+i+ " is "+ height+" X "+width);
								Assert.assertEquals(height,32);
								Assert.assertEquals(width,32);
							}
						}
	 @Test ( priority=56,description="check the size of the Goto page clickable or not",enabled=false)
		public void TC_56() throws InterruptedException
		{
	
			//click on Callback Requests
			driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
			Thread.sleep(2000);
			//check if goto btns are present or not
			int i=0;
		
				List<WebElement>gotobtns=driver.findElements(By.className("sc-dPNhBE.kqZRAX"));
				for(WebElement e:gotobtns)
				{
					String align=e.getCssValue("align-items");
					Assert.assertEquals(align,"center");
				}
			}
		 @Test ( priority=57,description="check the size of the Goto page clickable or not",enabled=false)
						public void TC_57() throws InterruptedException
						{
					
							//click on Callback Requests
							driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
							Thread.sleep(2000);
							//check if goto btns are present or not
							int i=0;
						
								List<WebElement>gotobtns=driver.findElements(By.className("sc-dPNhBE.kqZRAX"));
								for(WebElement e:gotobtns)
								{
									
									Assert.assertTrue(e.isEnabled());
								}
							}
		 @Test ( priority=58,description="check that text colour of Goto page buttons",enabled=false)
			public void TC_58() throws InterruptedException
			{
		
				//click on Callback Requests
				driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
				Thread.sleep(2000);
				//check if goto btns are present or not
				int i=0;
			
					List<WebElement>gotobtns=driver.findElements(By.className("sc-dPNhBE.kqZRAX"));
					for(WebElement e:gotobtns)
					{
						
						Assert.assertTrue(e.getCssValue("color").equals("rgba(63, 73, 84, 1)"));
					}
					
			}
//		 @Test ( priority=62,description="check that vertical scroll bar is\r\n" + 
//	 		"scrollable or not, in New Policy \r\n" + 
//	 		"Requests page")
//		public void TC_62() throws InterruptedException
//		{
//	
//			//click on Callback Requests
//			driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
//			Thread.sleep(2000);
//			Actions act = new Actions(driver);
//         act.sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
//         System.out.println("Scroll down perfomed");
//         Thread.sleep(3000);
//         act.sendKeys(Keys.PAGE_UP).build().perform();       //Page Up
//         System.out.println("Scroll up perfomed");
//         Thread.sleep(3000);
//		}
//	 @Test ( priority=63,description="check that horizhontal scroll bar is\r\n" + 
//		 		"scrollable or not, in New Policy \r\n" + 
//		 		"Requests page")
//			public void TC_63() throws InterruptedException
//			{
//		
//				//click on Callback Requests
//				driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
//				Thread.sleep(2000); 
//				// scroll horizontally in the right direction, use the following JavaScript.
//				((JavascriptExecutor)
//
//						driver).executeScript("window.scrollBy(2000,0)");
//				//scroll horizontally in the left direction, use the following JavaScript.
//				((JavascriptExecutor)
//
//						driver).executeScript("window.scrollBy(-2000,0)");
//			}

}
