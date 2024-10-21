package webUITesting;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

	
public class UserActionsTest extends BaseTestClass {

    	    @Test(priority = 1)
    	    public void testSignUpSuccess() {
    	    	driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]")).click();
    	        
    	    	 // Fill the form with Valid email
    	        driver.findElement(By.xpath("//label[contains(text(),\"E-Mail\")]/../div/input"))
    	              .sendKeys("shreepada1231@gmail.com");
    	        driver.findElement(By.xpath("(//label[contains(text(),\"Password\")]/..//input[@type=\"password\"])[1]"))
    	              .sendKeys("1234567xX!");
    	        driver.findElement(By.xpath("(//label[contains(text(),\"Password\")]/..//input[@type=\"password\"])[2]"))
    	              .sendKeys("1234567xX!");

    	        // Click the Sign Up button and Verify Sign Up button is Enabled
    	        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),\"Sign Up\")]"));
    	        if(submitButton.isEnabled()) {
    	        	submitButton.click();
    	        	System.out.println("Valid Details Entered and successfully signed up");
    	        } 
    	    }

    	    @Test(priority = 2)
    	    public void testSignUpFailure() {
    	    	driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]")).click();
    	        
	   	    	 // Fill the form with Invalid email
	   	        driver.findElement(By.xpath("//label[contains(text(),\"E-Mail\")]/../div/input"))
	   	              .sendKeys("shreepada1231.com");
	   	        driver.findElement(By.xpath("(//label[contains(text(),\"Password\")]/..//input[@type=\"password\"])[1]"))
	   	              .sendKeys("1234567xX!");
	   	        driver.findElement(By.xpath("(//label[contains(text(),\"Password\")]/..//input[@type=\"password\"])[2]"))
	   	              .sendKeys("1234567xX!");

	   	        //Verify Sign Up button is Disabled
    	        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),\"Sign Up\")]"));
    	        if(!submitButton.isEnabled()) {
    	        	System.out.println("InValid details entered and Sign Up is disabled");
    	        }
    	    }

    	    @Test(priority = 3)
    	    public void testSignInSuccess() {
    	    	driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]")).click();
    	    	Thread.sleep(1000);
    	    	
    	    	//Click on Already have an account
    	    	driver.findElement(By.xpath("//button[contains(text(),\"Already have an account? Click here to sign in.\")]")).click();
    	        
    	    	// Fill the form with valid email
	   	        driver.findElement(By.xpath("//label[contains(text(),\"E-Mail\")]/../div/input"))
	   	              .sendKeys("shreepada1231@gmail.com");
	   	        driver.findElement(By.xpath("(//label[contains(text(),\"Password\")]/..//input[@type=\"password\"])[1]"))
	   	              .sendKeys("1234567xX!");
	   	        
	   	        //Verify Sign In button is Enabled and Sign Out button is displayed after siging in
    	        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]"));
    	        WebElement signOutButton = driver.findElement(By.xpath("//button[contains(text(),\"Sign Out\")]"));
    	        if(signInButton.isEnabled()) {
    	        	signInButton.click();
    	        	if( signOutButton.isDisplayed())
    	        		System.out.println("Valid Credentials entered and sucessfully signed in");
    	        	else 
    	        		System.out.println("Something went wrong");
    	        }
    	    }

    	    @Test(priority = 4)
    	    public void testSignInFailure() {
    	    	driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]")).click();
    	    	Thread.sleep(1000);
    	    	
    	    	//Click on Already have an account
    	    	driver.findElement(By.xpath("//button[contains(text(),\"Already have an account? Click here to sign in.\")]")).click();
    	        
    	    	// Fill the form with Invalid email
	   	        driver.findElement(By.xpath("//label[contains(text(),\"E-Mail\")]/../div/input"))
	   	              .sendKeys("shreepada123145@gmail.com");
	   	        driver.findElement(By.xpath("(//label[contains(text(),\"Password\")]/..//input[@type=\"password\"])[1]"))
	   	              .sendKeys("1234567xX!");

	   	        //Verify Sign In button is Enabled and Click
	   	        driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]")).click();;
    	        
    	        // Wait for the pop-up to appear
    	        WebDriverWait wait = new WebDriverWait(driver, 10);
    	        wait.until(ExpectedConditions.alertIsPresent());

    	        // Switch to the alert and get the text
    	        Alert alert = driver.switchTo().alert();
    	        String alertMessage = alert.getText();
    	        
    	        // Print the alert message
    	        System.out.println("Pop-up Message: " + alertMessage);
    	        
    	        // Validate the alert message
    	        if (alertMessage.equals("User not found")) {
    	            System.out.println("Validation Passed: Correct error message displayed.");
    	        } else {
    	            System.out.println("Validation Failed: Incorrect error message.");
    	        }

    	        // Accept the alert
    	        alert.accept();
    	    }

    	    @Test(priority = 5)
    	    public void testSignOut() {
    	        testSignInSuccess(); // Call to ensure user is signed in

    	        // Click on Sign Out button
    	        driver.findElement(By.xpath("//button[contains(text(),\"Sign Out\")]")).click();

    	        // Verify that Sign In button displayed after sign out
    	        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]"));
    	        if(signInButton.isDisplayed()) {
    	        	System.out.println("Successfully Signed Out");
    	        }
    	        else {
    	        	System.out.println("Error while Signing Out");
    	        }
    	    }
}


