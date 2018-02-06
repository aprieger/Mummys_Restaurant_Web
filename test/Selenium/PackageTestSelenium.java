package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class PackageTestSelenium {
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Drivers\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
        String driverPath = "drivers\\";
	System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
        InternetExplorerDriver  driver = new InternetExplorerDriver();

        Thread.sleep(5000);
        //>>Launch the Online Store Website
        driver.get("http://localhost:8080/Project_MummysRestaurantSpring3/menu.htm"); 

        //>>Print a Log In message to the screen
        System.out.println("Loaded Menu page");
        WebElement row = driver.findElement(By.xpath("//*[@id=\"packageTable\"]/tbody/tr[1]"));
        row.click();
        System.out.println("Navigated to Package Page");
        driver.navigate().back();
        System.out.println("Navigated back to menu");
        WebElement toCart = driver.findElement(By.xpath("//*[@id=\"cartBtn\"]"));
        toCart.click();
        System.out.println("Navigated to cart page");
        driver.navigate().back();
        System.out.println("Navigated back to menu");
        WebElement toCheckout = driver.findElement(By.xpath("//*[@id=\"checkoutBtn\"]"));
        toCheckout.click();
        System.out.println("Navigated to checkout page");
        driver.navigate().back();
        System.out.println("Navigated back to menu");
        
        //>>Wait for 5 Sec
        Thread.sleep(5000);

        //>>Close the driver
        driver.close();
    }
}
