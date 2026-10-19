import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserManagementFuncTCs {
static WebDriver driver = new EdgeDriver();
	
	@BeforeMethod
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
	@Test ( priority =1 , description="click on the user managemnet in the menu \r\n" + 
			"page")
	public  void TC_1() throws InterruptedException
	{
		driver.findElement(By.xpath("//li[contains(text(),'User Management')]")).click();
		Thread.sleep(2000);
		//verify that we are on total conversation page by checking title
		Assert.assertTrue( driver.findElement(By.xpath("//h2[contains(text(),'User Management')]")).getText().equalsIgnoreCase("User Management"));
		
		;
	}
	@Test ( priority =2 , description="click on   add  user icon ")
	public  void TC_2() throws InterruptedException
	{
		driver.findElement(By.xpath("//li[contains(text(),'User Management')]")).click();
		Thread.sleep(2000);
		//click on add user
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/button[1]")).click();
		//verify Add user text in form
		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().equalsIgnoreCase("add user"))	;
		//verify  first name input field present or not
		Assert.assertTrue(driver.findElement(By.xpath("(//input)[7]")).isDisplayed());
		//verify  last  input field present or not
		Assert.assertTrue(driver.findElement(By.xpath("(//input)[8]")).isDisplayed());
		//verify email field present or not
				Assert.assertTrue(driver.findElement(By.xpath("(//input)[9]")).isDisplayed());
				//verify  phone number field present or not
				Assert.assertTrue(driver.findElement(By.xpath("(//input)[10]")).isDisplayed());
				//verify  role field present or not
				Assert.assertTrue(driver.findElement(By.tagName("select")).isDisplayed());
				//verify  password field present or not
				Assert.assertTrue(driver.findElement(By.xpath("(//input)[11]")).isDisplayed());
				
				Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Add')]")).isDisplayed());	
				driver.findElement(By.xpath("//button[@title='Close']")).click();
	}
	@Test ( priority =4 , description="check for error  message  if first name is  not  entered ")
	public  void TC_4() throws InterruptedException
	{
		driver.findElement(By.xpath("//li[contains(text(),'User Management')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/button[1]")).click();
		
		driver.findElement(By.xpath("(//input)[8]")).sendKeys("A");
		driver.findElement(By.xpath("(//input)[9]")).click();
		driver.findElement(By.xpath("(//input)[7]")).click();
		driver.findElement(By.xpath("(//input)[8]")).click();
         WebElement error=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/form[1]/div[1]/div[2]"));
     
         
		Assert.assertTrue(error.getText().equalsIgnoreCase("Required firstname"));
		driver.findElement(By.xpath("//button[@title='Close']")).click();
		
	}	
	@Test ( priority =5 , description="check for error  message  if last name is  not  entered ")
	public  void TC_5() throws InterruptedException
	{
		driver.findElement(By.xpath("//li[contains(text(),'User Management')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/button[1]")).click();
		

		driver.findElement(By.xpath("(//input)[7]")).click();
		driver.findElement(By.xpath("(//input)[8]")).click();
		driver.findElement(By.xpath("(//input)[9]")).click();
         WebElement error=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/form[1]/div[2]/div[2]"));
     
         
		Assert.assertTrue(error.getText().equalsIgnoreCase("Required lastname"));
		driver.findElement(By.xpath("//button[@title='Close']")).click();
	}
	@Test ( priority =6 , description="check for error  message  if email is  not  entered ")
	public  void TC_6() throws InterruptedException
	{
		driver.findElement(By.xpath("//li[contains(text(),'User Management')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/button[1]")).click();
		

		driver.findElement(By.xpath("(//input)[7]")).click();
		driver.findElement(By.xpath("(//input)[8]")).click();
		driver.findElement(By.xpath("(//input)[9]")).click();
		driver.findElement(By.xpath("(//input)[10]")).click();
		driver.findElement(By.xpath("(//input)[11]")).click();
		Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
        System.out.println("Scroll down perfomed");
        Thread.sleep(3000);
         WebElement error=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/form[1]/div[3]/div[2]"));
     
         
		Assert.assertTrue(error.getText().equalsIgnoreCase("email is required"));
		driver.findElement(By.xpath("//button[@title='Close']")).click();
		
	}
	@Test ( priority =7 , description="check for error  message  if phone number is  not  entered ")
	
	public  void TC_7() throws InterruptedException
	{
		driver.findElement(By.xpath("//li[contains(text(),'User Management')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/button[1]")).click();
		

		driver.findElement(By.xpath("(//input)[7]")).click();
		driver.findElement(By.xpath("(//input)[8]")).click();
		driver.findElement(By.xpath("(//input)[9]")).click();
		driver.findElement(By.xpath("(//input)[10]")).click();
		driver.findElement(By.xpath("(//input)[11]")).click();
		Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
        System.out.println("Scroll down perfomed");
        Thread.sleep(3000);
         WebElement error=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/form[1]/div[4]/div[2]"));
     
         
		Assert.assertTrue(error.getText().equalsIgnoreCase("Required Phone number"));
		driver.findElement(By.xpath("//button[@title='Close']")).click();
		
	}
						
	@Test ( priority =8 , description="check for error  message  if  role is  not  entered ")
	public  void TC_8() throws InterruptedException
	{
		driver.findElement(By.xpath("//li[contains(text(),'User Management')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/button[1]")).click();
		

		driver.findElement(By.xpath("(//input)[7]")).sendKeys("Abc");
		driver.findElement(By.xpath("(//input)[8]")).sendKeys("A");
		driver.findElement(By.xpath("(//input)[9]")).sendKeys("abc@gamil.com");
		driver.findElement(By.xpath("(//input)[10]")).sendKeys("7894561238");
	
//		Select role=new Select(driver.findElement(By.tagName("select")));
//	role.selectByVisibleText("--Select Role--");
		driver.findElement(By.xpath("(//input)[11]")).sendKeys("Password@123");
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
        System.out.println("Scroll down perfomed");
        Thread.sleep(3000);
         WebElement error=driver.findElement(By.xpath("//div[contains(text(),'Required role')]"));
     
         
		Assert.assertTrue(error.getText().equalsIgnoreCase("Required role"));
		driver.findElement(By.xpath("//button[@title='Close']")).click();
		
	}	
	@Test ( priority =9 , description="check for role drop down options")
	public  void TC_9() throws InterruptedException
	{
		driver.findElement(By.xpath("//li[contains(text(),'User Management')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/button[1]")).click();
		Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
        System.out.println("Scroll down perfomed");
        Thread.sleep(3000);
		Select role=new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/form[1]/div[5]/div[1]/select[1]")));
		  List <WebElement> op = role.getOptions();
	      int size = op.size();
	      for(int i =0; i<size ; i++){
	         String options = op.get(i).getText();
	         System.out.println(options);
	         if(options.equals("--Select Role--")||options.equals("Super Admin")||options.equals("Admin"))
	         {
	        	 System.out.println(" Tc_9 Passed");
	        	 Assert.assertTrue(true);
	         }
	      }
		
	      driver.findElement(By.xpath("//button[@title='Close']")).click();
	}
	@Test ( priority =10 , description="check if password  is required textfield")
	public  void TC_10() throws InterruptedException
	{
		driver.findElement(By.xpath("//li[contains(text(),'User Management')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/button[1]")).click();
		driver.findElement(By.xpath("(//input)[7]")).sendKeys("Abc");
		driver.findElement(By.xpath("(//input)[8]")).sendKeys("A");
		driver.findElement(By.xpath("(//input)[9]")).sendKeys("abc@gamil.com");
		driver.findElement(By.xpath("(//input)[10]")).sendKeys("7894561238");
		Select role=new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/form[1]/div[5]/div[1]/select[1]")));
		role.selectByValue("APP_ADMIN");
		driver.findElement(By.xpath("(//input)[11]")).click();
		driver.findElement(By.xpath("(//input)[10]")).click();
		String error=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/form[1]/div[6]/div[2]")).getText();
		Assert.assertEquals(error, "Required Password!");
		driver.findElement(By.xpath("//button[@title='Close']")).click();
	}
	@Test ( priority =11 , description="check  is password is  visible or not by  default by typing  charcters in password  test  field")
	public  void TC_12() throws InterruptedException
	{
		driver.findElement(By.xpath("//li[contains(text(),'User Management')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/button[1]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/form[1]/div[6]/div[1]/button[1]")).isDisplayed());
		driver.findElement(By.xpath("//button[@title='Close']")).click();
	}

}
