package com.dsmanioto.registrations.functional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashMap;
import java.util.Map;

//@ExtendWith(SpringExtension.class)
//@DataJpaTest
@SpringBootTest
@ActiveProfiles("local")
public class CrudallTest {

    private ChromeDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @Test
    public void crudall() {
        driver.get("https://dsmanioto-registera.herokuapp.com/login");
        //driver.manage().window().setSize(new Dimension(1850, 1053));
        driver.findElement(By.id("username")).sendKeys("daniel");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("daniela");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.className(".btn")).click();
        driver.findElement(By.id("username")).sendKeys("daniel");
        driver.findElement(By.id("password")).sendKeys("daniel");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.className(".btn")).click();
        driver.findElement(By.id("username")).sendKeys("daniel");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.className(".btn")).click();
        driver.findElement(By.className("li:nth-child(1) > .active-menu")).click();
        driver.findElement(By.className(".fa-user-plus")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("martelo");
        driver.findElement(By.id("price")).sendKeys("2.98");
        driver.findElement(By.className(".btn")).click();
        driver.findElement(By.className("tr:nth-child(2) .fas")).click();
        driver.findElement(By.linkText("Voltar para home")).click();
        driver.findElement(By.className("li:nth-child(2) > .active-menu")).click();
        driver.findElement(By.className(".fa-user-plus")).click();
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).sendKeys("durvalino");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.className(".btn")).click();
        driver.findElement(By.className("tr:nth-child(3) > td:nth-child(3) > .btn")).click();
        driver.findElement(By.className("tr:nth-child(3) > td:nth-child(4) > .btn")).click();
        driver.findElement(By.linkText("Voltar para home")).click();
        driver.findElement(By.linkText("Salesman")).click();
        driver.findElement(By.className(".fas")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("carol");
        driver.findElement(By.id("email")).sendKeys("carollinecalixto@gmail.com");
        driver.findElement(By.className(".btn")).click();
        driver.findElement(By.className(".fa-user-times")).click();
        driver.findElement(By.linkText("Voltar para home")).click();
        driver.findElement(By.linkText("Add Customer")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("o cara");
        driver.findElement(By.id("email")).sendKeys("testss@askdkjlkajsd.com");
        driver.findElement(By.className(".btn")).click();
        driver.findElement(By.linkText("Voltar para home")).click();
        driver.findElement(By.id("username")).sendKeys("carol");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.className(".btn")).click();
        driver.findElement(By.className("li:nth-child(2) > .active-menu")).click();
        driver.findElement(By.className(".fa-user-plus")).click();
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).sendKeys("dino");
        driver.findElement(By.id("password")).sendKeys("11111");
        driver.findElement(By.className(".btn")).click();
        driver.findElement(By.className("tr:nth-child(3) > td:nth-child(3) > .btn")).click();
        driver.findElement(By.id("username")).sendKeys("dino");
        driver.findElement(By.id("password")).sendKeys("change-me");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.className("li:nth-child(2) > .active-menu")).click();
        driver.findElement(By.className("tr:nth-child(3) .fa-user-times")).click();
    }
}
