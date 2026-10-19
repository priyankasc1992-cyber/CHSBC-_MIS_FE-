import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SameWeekRepeateFuncTC {
	static WebDriver driver=new EdgeDriver();
	@Test(priority =1)
	public void tc_1()
	{
		
		driver.get("https://visualivrmis.simpragma.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		//1.login with valid credentials
		driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.tagName("button")).click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//li[contains(text(),'Same Week Repeat')]")).click();
		
		
		// get from date field value
		String fromDate=driver.findElement(By.xpath("(//input[@type='date'])[1]")).getAttribute("value");
		System.out.println(fromDate);
		
		// get to date field value
		String toDate=driver.findElement(By.xpath("(//input[@type='date'])[2]")).getAttribute("value");
		System.out.println(toDate);
		
		// get current date
		LocalDate todaysdate=java.time.LocalDate.now();
		String currentDate="";
		currentDate+=todaysdate;
		System.out.println(currentDate);
		
		//verify  todate  is equal to current date
		Assert.assertTrue(toDate.equals(currentDate));
		
		//retive 1 week post value from todate/currentdate
	
		
		//get day
		String[] a=currentDate.split("-");
		String fromDay=a[2];
		int t=Integer.parseInt(fromDay);
		t=t-6;
		String tt="";
		tt+=t;
		String postweek=currentDate;
		System.out.println("tt="+tt);
		String str=postweek.substring(0,8);
				System.out.println(str+"   str1");

		str+=tt;
		System.out.println(str+"   str2");
		
		System.out.println(fromDate+" ==From Date");
		//verify  fromdate  is equal to  postweek
		Assert.assertTrue(fromDate.equals(str));
	}

}
