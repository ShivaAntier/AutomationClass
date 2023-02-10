package AnCrypto.testCase;

import AnCrypto.Helper.BaseClass;
import AnCrypto.pageObject.HomeScreenLocators;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HomeScreen extends BaseClass {
    HomeScreenLocators hs = new HomeScreenLocators();
    @BeforeMethod
    void createSession(){
        OpenBrowser();
    }
    @AfterMethod
    void quitSession(){
        quitBrowser();
    }
    @Test
    void checkIfLandingScreenIsOpeningSuccessfully(){
        String a = hs.topFirstTextHomeScreen().getText();
        System.out.println("This is value of a : "+a);
        Assert.assertEquals(a,"Experience the Power of Multi-Chain Crypto Wallet", "Landing Screen Is not Opening Successfully");
    }

    @Test
    void checkIfTopGooglePlayButtonIsWorkingFIne(){
        hs.topPlayStoreButtonHomeScreen().click();
        ArrayList<String> arr = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(arr.get(1));
        String a = driver.getCurrentUrl(), b = hs.playAnCryptoWallet().getText();
        Assert.assertEquals(a,"https://play.google.com/store/apps/details?id=com.ancryptoWallet");
        Assert.assertEquals(b,"AnCrypto Wallet");
    }
}
