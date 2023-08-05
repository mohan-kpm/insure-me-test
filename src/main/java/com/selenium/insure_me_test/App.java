package com.selenium.insure_me_test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

/**
 * Hello world!
 *
 */

public class App 
{

    public static void main( String[] args ) throws InterruptedException, IOException
    {
      //System.setProperty("webdriver.chrome.driver","C:\\Users\\mohan\\devops\\chromedriver.exe");
    
      System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        
        
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        
        //driver.get("http://localhost:8084/contact.html");

        System.out.println("Script Started");
       
        driver.get("http://192.168.2.22:8081/contact.html");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        
        driver.findElement(By.id("inputName")).sendKeys("Mohan");
        driver.findElement(By.id("inputNumber")).sendKeys("9999999999");
        driver.findElement(By.id("inputMail")).sendKeys("mohan@gmail.com");
        driver.findElement(By.id("inputMessage")).sendKeys("Welcome to the DevOps");
        
        driver.findElement(By.id("my-button")).click();
        
        String message = driver.findElement(By.id("response")).getText();
        if(message.equals("Message Sent")) {
        	System.out.println("Script executed Successfully");
        }
        else {
        	System.out.println("Script failed");
        }
        
        System.out.println("Taking Screenshot as proof");
        //Take  screenshot of testcase
 
		    TakesScreenshot scrShot = ((TakesScreenshot)driver);
		    File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		    File destFile = new File("screenshot.png");
		    FileUtils.copyFile(screenShot, destFile);
		    System.out.println("Screenshot stored at : " + destFile.getAbsolutePath().toString());
        Thread.sleep(3000);
        driver.quit();
    
    }
}
