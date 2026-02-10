import com.Testinium.Mobile.HookImpl;
import com.Testinium.Mobile.StepImpl;
import org.openqa.selenium.By;

public class Test extends HookImpl {

    StepImpl step= new StepImpl();

    @org.junit.jupiter.api.Test
    public void IOSBasicTestSuccess01() throws InterruptedException {

        step.waitBySecond(15);
        appiumDriver.findElement(By.xpath("//*[contains(@text, \"\")]")).click();
        step.waitBySecond(3);

    }

    @org.junit.jupiter.api.Test
    public void IOSBasicTestSuccess02() throws InterruptedException {

        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Markalar\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kategoriler\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kampanyalar\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Markalar\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kategoriler\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kampanyalar\"]")).click();
        step.waitBySecond(3);

    }

    @org.junit.jupiter.api.Test
    public void IOSBasicTestSuccess03() throws InterruptedException {

        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Markalar\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kategoriler\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kampanyalar\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Markalar\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kategoriler\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kampanyalar\"]")).click();
        step.waitBySecond(3);

    }

    @org.junit.jupiter.api.Test
    public void IOSBasicTestSuccess04() throws InterruptedException {

        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Markalar\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kategoriler\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kampanyalar\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Markalar\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kategoriler\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kampanyalar\"]")).click();
        step.waitBySecond(3);

    }

    @org.junit.jupiter.api.Test
    public void IOSBasicTestSuccess05() throws InterruptedException {

        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Markalar\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kategoriler\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kampanyalar\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Markalar\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kategoriler\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kampanyalar\"]")).click();
        step.waitBySecond(3);

    }

    @org.junit.jupiter.api.Test
    public void AndroidBasicTestSuccess01() throws InterruptedException {

        step.waitBySecond(20);
        appiumDriver.findElement(By.xpath("//*[contains(@resource-id, 'android:id/button2') and contains(@text, 'İPTAL')]")).click();
        step.waitBySecond(3);
        //appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_categories")).click();
        //step.waitBySecond(3);
        //appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_campaign")).click();
        //step.waitBySecond(3);

    }
    @org.junit.jupiter.api.Test
    public void AndroidBasicTestSuccess02() throws InterruptedException {

        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_trademarks")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_categories")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_campaign")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_trademarks")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_categories")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_campaign")).click();
        step.waitBySecond(3);

    }

    @org.junit.jupiter.api.Test
    public void AndroidBasicTestSuccess03() throws InterruptedException {

        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_trademarks")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_categories")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_campaign")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_trademarks")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_categories")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_campaign")).click();
        step.waitBySecond(3);

    }

    @org.junit.jupiter.api.Test
    public void AndroidBasicTestSuccess04() throws InterruptedException {

        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_trademarks")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_categories")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_campaign")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_trademarks")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_categories")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_campaign")).click();
        step.waitBySecond(3);

    }

    @org.junit.jupiter.api.Test
    public void AndroidBasicTestSuccess05() throws InterruptedException {

        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_trademarks")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_categories")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_campaign")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_trademarks")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_categories")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_campaign")).click();
        step.waitBySecond(3);

    }

    @org.junit.jupiter.api.Test
    public void AndroidBasicTestFail() throws InterruptedException {

        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_trademarks")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_categories")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_campaignnnnn")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_trademarks")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_categories")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.id("com.gratis.android:id/nav_graph_campaign")).click();
        step.waitBySecond(3);

    }

    @org.junit.jupiter.api.Test
    public void IOSBasicTestFail() throws InterruptedException {

        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Markalar\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kategoriler\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kampanyalarasdsadsad\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Markalar\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kategoriler\"]")).click();
        step.waitBySecond(3);
        appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Kampanyalar\"]")).click();
        step.waitBySecond(3);

    }

}
