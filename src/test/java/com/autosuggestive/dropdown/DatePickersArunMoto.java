package com.autosuggestive.dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickersArunMoto {
    static WebDriver driver;
    public static void selectDateInCalender(String Date,String month,String year)
    {
        if(Integer.parseInt(Date)>31)
        {
            System.out.println("invalid date provoded"+Date+"/"+month+"/"+year);
            return;
        }
        else
        if(Integer.parseInt(Date)>28&&month=="February")
        {
            System.out.println("invalid date");
            return;
        }

        while(!(month.equals("February")&&year.equals("2025")))
        {

            String monthyear=driver.findElement(By.className("ui-datepicker-title")).getText();//selecting month and year
            // calender[]=monthyear.split(" ");
            month=monthyear.split(" ")[0];//feb
            year=monthyear.split(" ")[1];//2024
            driver.findElement(By.xpath("//a[@title='Next']")).click();//clicking in next
        }
        try
        {
            driver.findElement(By.xpath("//tr//td[@data-handler ='selectDay']/a[text()=\'"+Date+"\']")).click();//selecting date
        }
        catch(Exception e)
        {
            System.out.println(Date );
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        WebElement calendarFieldElement=driver.findElement(By.id("datepicker"));
        //Thread.sleep(2000);
        calendarFieldElement.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));//for clicking on text box
        String monthyear=driver.findElement(By.className("ui-datepicker-title")).getText();//for gettingmonth and year
        System.out.println(monthyear);//feb 2024
//	String df="abc 123";String h[]=df.split(" ");
// System.out.println(Arrays.toString(h));
        //System.out.println(h[0]);
//System.out.println(h[1]);

        String calender[]=monthyear.split(" ");
//System.out.println(calender.length);
//System.out.println(calender[0]);
//System.out.println(calender[1]);
        String month=monthyear.split(" ")[0];//feb
        String year=monthyear.split(" ")[1];//2024
//driver.findElement(By.xpath("//a[@title='Next']")).click();// for clicking on next button

        selectDateInCalender("28","February" , "2025");
    }
}
