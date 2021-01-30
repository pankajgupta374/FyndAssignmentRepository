package StepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.messages.internal.com.google.protobuf.Value;
import pages.GooglePage;
import pages.GoogleSearchResult;

public class GoogleSearch {

	WebDriver driver=null;
	GooglePage googlePage;
	GoogleSearchResult googleSearchResult;
	ArrayList<Integer> gumTreelinks=new ArrayList<Integer>();

	@Before
	public void browserSetUp() {

		String systemPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", systemPath+"/Drivers/chromedriver.exe");

		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Given("user in on Google site")
	public void user_in_on_google_site() {
		driver.get("https://www.google.com");
	}

	@When("^user search (.*)$")
	public void user_search_cars_in_london(String SearchText) throws InterruptedException {
		googlePage=new GooglePage(driver);
		googlePage.enterSearchText(SearchText);
		Thread.sleep(3000);
	}

	@And("click on Enter")
	public void click_on_enter() {
		googlePage.clickEnter();
	}

	@Then("user validate number of gumtree links available in search result")
	public void user_validate_how_many_gumtree_links_are_available() throws InterruptedException {
		googleSearchResult=new GoogleSearchResult(driver);
		Thread.sleep(2000);
		List<WebElement> links=googleSearchResult.getLinks();

		int count=0;
		int i=0;
		for(WebElement result: links) {
			if(result.getText().contains("gumtree")) {
				System.out.println(result.getText()+" Index value =  "+i);
				gumTreelinks.add(i);
				count++;
			}
			i++;
		}
		System.out.println("Total number of Gumtree links available = "+count);
	}

	@When("user navigate to each gumtree link and validate title and NoOfresult")
	public void user_navigate_to_each_gumtree_link_and_validate_title_and_NoOfresult() {
		try {
			for(int i=0;i<=gumTreelinks.size()-1;i++) {
				int index=gumTreelinks.get(i);
				System.out.println(index);
				googleSearchResult.clickOnGumtreeLink(index);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	@After
	public void teardown() {
		driver.close();
	}
}
