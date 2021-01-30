package pages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResult {

	int count=0;
	WebDriver driver;

	@FindBy(xpath = "//h1[@class='h1-responsive srp-desktop-title']")
	WebElement resultValue1;
	
	@FindBy(id = "result-stats")
	WebElement resultValue2;

	@FindBys(@FindBy(tagName = "a"))
	private List<WebElement> links;

	public GoogleSearchResult(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//	int a=links.size();
	public List<WebElement> getLinks() {
		return links;
	}

	public void clickOnGumtreeLink(int index) throws InterruptedException{
		Thread.sleep(3000);
		try{
			links.get(index).click();
			Thread.sleep(5000);
			validateTitle(count);

			driver.navigate().back();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		count++;
	}

	public void validateTitle(int count) throws InterruptedException {
		try {
		if(count==0) {
			String expectedtitle=driver.getTitle();
			String actualTitle="Used Cars for Sale in London | Great Local Deals | Gumtree";
			Assert.assertEquals(expectedtitle, actualTitle);
			
			Thread.sleep(3000);
			String text1=resultValue1.getText();
			String text2=text1.replaceAll("\\D+","");
			System.out.println(text2);
			int num1=Integer.parseInt(text2);
			if(num1>0) {
				System.out.println("Result displayed is greater than 0");
			}
			else {
				System.out.println("Result displayed is not greater than 0");
			}
		}
		else if(count==1) 
		{
			String expectedtitle=driver.getTitle();
			System.out.println("main title "+expectedtitle);
			String actualTitle="cheap cars for sale london - Google Search";
			Assert.assertEquals(expectedtitle, actualTitle);
			
			Thread.sleep(3000);
			String text3=resultValue2.getText();
			String text4=text3.replaceAll("\\D+","");
			System.out.println(text4);
			int num2=Integer.parseInt(text4);
			if(num2>0) {
				System.out.println("Result displayed is greater than 0");
			}
			else {
				System.out.println("Result displayed is not greater than 0");
			}
		}	
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
