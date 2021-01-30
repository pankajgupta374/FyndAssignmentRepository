package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@class='gLFyf gsfi']")
	WebElement googleSearchBox;
	
	
	public GooglePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterSearchText(String Searchtext) {
		googleSearchBox.sendKeys(Searchtext);
	}
	
	public void clickEnter() {
		googleSearchBox.sendKeys(Keys.ENTER);
	}
}
