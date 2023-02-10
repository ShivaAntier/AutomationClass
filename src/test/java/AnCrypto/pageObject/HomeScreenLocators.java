package AnCrypto.pageObject;

import AnCrypto.Helper.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeScreenLocators extends BaseClass {
    public WebElement topFirstTextHomeScreen(){
        WebElement topFirstTextHomeScreen = driver.findElement(By.xpath("//h1[text()='Experience the Power of Multi-Chain Crypto Wallet']"));
        return topFirstTextHomeScreen;
    }

    public WebElement topPlayStoreButtonHomeScreen() {
        WebElement topPlayStoreButtonHomeScreen = driver.findElement(By.xpath("//div[@class='et_pb_button_module_wrapper et_pb_button_0_wrapper et_pb_button_alignment_center et_pb_module ']/a"));
        return topPlayStoreButtonHomeScreen;
    }

    public WebElement playAnCryptoWallet(){
        WebElement playAnCryptoWallet = driver.findElement(By.xpath("//span[text()='AnCrypto Wallet']"));
        return playAnCryptoWallet;
    }
}
