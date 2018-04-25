

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;



public class Selenium2Example {
    public static void main(String[] args) {
        def file = new File('news.txt')
        Scanner sc = new Scanner(file);
        int y = 0

        System.setProperty("webdriver.edge.driver", "C:\\Users\\Влад\\Downloads\\MicrosoftWebDriver.exe");
        WebDriver driver =  new EdgeDriver();
        driver.get("https://www.facebook.com/");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("vladvkdaviduk@gmail.com");
        email.submit();
        WebElement pass = driver.findElement(By.name("pass"));
        pass.sendKeys("***********");
        pass.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_5pbx userContent _3576")));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        while(y < 777) {
        jse.executeScript("window.scrollBy(0, 250)", "");
        y++;
        }

        List<WebElement> elements = driver.findElements(By.className("_5pbx userContent _3576" ));


        FileWriter writer = new FileWriter(file, true)

        Set<String> lines = new HashSet<>();
        while (sc.hasNextLine())
            lines.add(sc.nextLine());

        for (WebElement i : elements) {
            String str = i.getText();
            if (str.length() > 30) {
                str = str.substring(0, 30).replaceAll("\n", "");
                if (!lines.contains(str))
                    writer.write("\n${str}");
            }
        }
        driver.quit();
        writer.close();
    }
}