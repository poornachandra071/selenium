package jenkin.jenkinTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class mavenCommand {
	// nedd to set maven home and path
	// need to add maven plugin to pom.xml
	// need to create profile in pom.xml to rum miltiple xml file
	// mvn comand mvn test -PRegeseeion "resression is profile name"
	// download jenkins.war
	// navigate to jenkein.war directory
	// enter comand java -jar jenkins.war -http:9090
	// once it is opened oen new tab and localhost:9090
	// login and cteate jab
	// id code is in git select git and provide git url
	// if code is in local provide laction for project
	// if need to parameterized select is project parameterized and choose coise
	// parameter
	// click on biuld with parameteres(test -P"$testSuit" -Dbrowser="$browser")

	@Test
	public void initiateBrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//jenkin//jenkinTest//GlobalData.properties");
		prop.load(fis);
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		System.out.println(browserName);
		ChromeOptions options = new ChromeOptions();
		
		if (browserName.contains("headless")) {
			options.addArguments("headless");
		}
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
