package br.devblack.task.functional;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TaskTest {

    public WebDriver acessarAplicacao(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://localhost:8001/tasks/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return  driver;
    }

    @Test
    public void testAmbiente(){

            WebDriver driver = acessarAplicacao();

            try
            {
                for(int i = 0; i < 20 ; i++)
                {
                    driver.findElement(By.id("addTodo")).click();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    driver.findElement(By.id("task")).sendKeys("Teste Automatizado "+i);
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    driver.findElement(By.id("dueDate")).sendKeys("10/10/2021");
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    driver.findElement(By.id("saveButton")).click();
                    String msg = driver.findElement(By.id("message")).getText();
                    Assert.assertEquals("Success!",  msg);
                }
            }finally {
                driver.quit();
            }
    }
}