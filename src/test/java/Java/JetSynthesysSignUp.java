package Java;

import comm.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class JetSynthesysSignUp {
    WebDriver driver = new ChromeDriver();

    public JetSynthesysSignUp() throws IOException {
    }

    @Test(priority = 1, enabled = true)
    public void openUrl() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver.get("https://qa.jetnft.in/");
        driver.manage().window().maximize();
    }

    @Test(priority = 2, enabled = true)
        void clickOnSignUPButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='button-style ms-2 ms-md-4']")).click();
    }

        File file = new File("C:\\Users\\user.LAPTOP-0UHFE9FH\\Downloads\\Jet.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Jet");

    @Test(priority = 3, enabled = true)
    void sendEmail() throws InterruptedException {
        Thread.sleep(2000);
        String Email = (sheet.getRow(0).getCell(0).getStringCellValue());
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Email);
        //Mobile Field
//        driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("1212287512");
    }

    @Test(priority = 4, enabled = true)
        void sendFullName() throws InterruptedException {
        Thread.sleep(2000);
        String FullName = (sheet.getRow(0).getCell(1).getStringCellValue());
        driver.findElement(By.name("fullname")).sendKeys(FullName);
    }

    @Test(priority = 5, enabled = true)
        void sendUserName() throws InterruptedException {
        Thread.sleep(2000);
        String UserName = (sheet.getRow(1).getCell(0).getStringCellValue());
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UserName);
    }

    @Test(priority = 6, enabled = true)
        void sendPassword() throws InterruptedException {
        Thread.sleep(2000);
        String Password = (sheet.getRow(1).getCell(1).getStringCellValue());
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
    }

       @Test(priority = 7, enabled = true)
           void clickOnEyeButton() throws InterruptedException {
           Thread.sleep(2000);
           driver.findElement(By.xpath("(//div[@class='ShowHideIcon'])[1]")).click();
       }

       @Test(priority = 8, enabled = true)
           void sendConfirmPassword() throws InterruptedException {
           Thread.sleep(2000);
           String ConfirmPassword = (sheet.getRow(1).getCell(2).getStringCellValue());
           driver.findElement(By.xpath("//input[@name='cpassword']")).sendKeys(ConfirmPassword);
       }
       @Test(priority = 9, enabled = true)
           void clickOnEyeButtonAgain() throws InterruptedException {
           Thread.sleep(2000);
           driver.findElement(By.xpath("(//div[@class='ShowHideIcon'])[2]")).click();
       }

       @Test(priority = 10, enabled = true)
           void clickOnTheBox() throws InterruptedException {
           Thread.sleep(2000);
           driver.findElement(By.xpath("//input[@name='vehicle1']")).click();
       }

       @Test(priority = 11, enabled = true)
           void clickOnSignUpButton() throws InterruptedException {
           Thread.sleep(2000);
           driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
       }

       @Test(priority = 12, enabled = true)
            void clickOnResendOtpButton() throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//a[text()='Resend']")).click();
        }

        @Test(priority = 13, enabled = true)
        void clickOnDoItLetterButton() throws InterruptedException {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[text()='Do it Later']")).click();
        }

        @Test(priority = 14, enabled = true)
            void clickOnResendOtpButtonAgain() throws InterruptedException {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[text()='Resend']")).click();
        }

        @Test(priority = 14, enabled = true)
            void clickOnDoItNowButton() throws InterruptedException {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[text()='Do it Now']")).click();
        }

      @Test(priority = 15, enabled = true)
          void sendOtp() throws InterruptedException {
          Thread.sleep(2000);
          driver.findElement(By.xpath("//input[@aria-label='Please enter verification code. Character 1']")).sendKeys("4");
          driver.findElement(By.xpath("//input[@aria-label='Character 2']")).sendKeys("4");
          driver.findElement(By.xpath("//input[@aria-label='Character 3']")).sendKeys("4");
          driver.findElement(By.xpath("//input[@aria-label='Character 4']")).sendKeys("4");
      }

        @Test(priority = 16, enabled = true)
        void clickOnVerifyButton() throws InterruptedException {
            Thread.sleep(5000);
            driver.findElement(By.xpath("//button[@class='button-style w-100 btn btn-primary']")).click();
        }

    @Test(priority = 2)
    public void Profile() throws InterruptedException {
//        //Click On The Cross Button
//        driver.findElement(By.xpath("//button[@class='btn-close']")).click();
//        Thread.sleep(2000);

        Thread.sleep(2000);
        //Click On The Dropdown Button
        driver.findElement(By.xpath("(//button[@id='dropdown-basic'])[1]")).click();
        Thread.sleep(2000);

        //Click On The Settings Button
        driver.findElement(By.xpath("(//a[text()='Settings'])[1]")).click();
        Thread.sleep(2000);

        //Click On The Setting Button
        driver.findElement(By.xpath("(//a[text()='Settings'])[2]")).click();
        Thread.sleep(2000);

        //Scroll
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)", "");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Admin@123");
        Thread.sleep(2000);

        //Click On The Eye Button
        driver.findElement(By.xpath("(//div[@class='ShowHideIcon'])[1]")).click();
        Thread.sleep(2000);

        //New Password
        driver.findElement(By.xpath("//input[@name='Npassword']")).sendKeys("Admin@1234");
        Thread.sleep(2000);

        //Click On The Eye Button
        driver.findElement(By.xpath("(//div[@class='ShowHideIcon'])[2]")).click();
        Thread.sleep(2000);

        //Confirm Password
        driver.findElement(By.xpath("//input[@name='cpassword']")).sendKeys("Admin@1234");
        Thread.sleep(2000);

        //Click On The Eye Button
        driver.findElement(By.xpath("(//div[@class='ShowHideIcon'])[3]")).click();
        Thread.sleep(2000);

        //Click On The Confirm Button
        driver.findElement(By.xpath("//button[text()='Change Password']")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 3)
    public void EditAccount() throws InterruptedException {
        //Click On The EditAccount Button
        driver.findElement(By.xpath("(//img[@alt='icon'])[4]")).click();
        Thread.sleep(2000);

        //ScrollDown
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)","");
        Thread.sleep(2000);

        //ScrollUp
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-500)","");
        Thread.sleep(2000);

        //Phone Number
        driver.findElement(By.xpath("//div[@class='flag in']")).click();
        Thread.sleep(2000);

        //Scroll Down
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)","");
        Thread.sleep(2000);

        //Click On The Verify Button
        driver.findElement(By.xpath("//span[text()='India']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("58858958");
        driver.findElement(By.xpath("(//div[@class='ShowHideIcon'])[2]")).click();
        Thread.sleep(2000);

        //Send The Verification Code
        driver.findElement(By.xpath("//input[@aria-label='Please enter verification code. Character 1']")).sendKeys("4");
        driver.findElement(By.xpath("//input[@aria-label='Character 2']")).sendKeys("4");
        driver.findElement(By.xpath("//input[@aria-label='Character 3']")).sendKeys("4");
        driver.findElement(By.xpath("//input[@aria-label='Character 4']")).sendKeys("4");
        Thread.sleep(2000);

        //Click On The Verify Button
        driver.findElement(By.xpath("//button[text()='Verify']")).click();
        Thread.sleep(2000);

        //ScrollDown
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)","");
        Thread.sleep(2000);

        //Click On The Save Changes Button
        driver.findElement(By.xpath("(//div[@class='col-md-6 col-12'])[8]")).click();
        Thread.sleep(2000);

        //ScrollUp
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-500)","");
        Thread.sleep(2000);

    }
    @Test(priority = 4)
    public void KYCBasicInformation() throws InterruptedException {
        //Click On The KYC Button
        driver.findElement(By.xpath("(//img[@alt='icon'])[5]")).click();
        Thread.sleep(2000);

        //Click On The Select Country Field
        driver.findElement(By.xpath("//select[@name='country']")).click();
        Thread.sleep(2000);

        //Select Country
        driver.findElement(By.xpath("//option[text()='India']")).click();
        Thread.sleep(2000);

        //Click On The Select State Field
        driver.findElement(By.xpath("//select[@name='state']")).click();
        Thread.sleep(2000);

        //Select State
        driver.findElement(By.xpath("//option[text()='Chandigarh']")).click();
        Thread.sleep(2000);

        //ScrollDown
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)","");
        Thread.sleep(2000);

        //Click On The Next Button
        driver.findElement(By.xpath("//button[@class='button-style undefined']")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 5)
    public void KYCDocument() throws InterruptedException {
        //Click On The Document Field
        driver.findElement(By.xpath("//select[@name='doc_type']")).click();
        Thread.sleep(2000);

        //Select Document
        driver.findElement(By.xpath("//option[@value='AADHAR CARD']")).click();
        Thread.sleep(2000);

        //Give The Value On The Document Number Field
        driver.findElement(By.xpath("//input[@name='doc_number']")).sendKeys("212345678912");
        Thread.sleep(2000);

        //Give The Value On The Full Name Field
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Naveen");
        Thread.sleep(2000);

        //DOB Field
        driver.findElement(By.xpath("(//button[@type= \"button\"])[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
        driver.findElement(By.xpath("//abbr[@aria-label='January 3, 2023']")).click();
        Thread.sleep(2000);

        //ScrollDown
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)","");
        Thread.sleep(2000);

        //Click On The Upload Document
//        driver.findElement(By.xpath("//input[@class='inputfile']")).click();
//        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
       // Thread.sleep(2000);

//        //ScrollDown
//        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)","");
//        Thread.sleep(2000);

        //Click On The Back Button
        driver.findElement(By.xpath("//button[@class='button-style border-btn']")).click();
        Thread.sleep(2000);

        //ScrollUp
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-300)","");
        Thread.sleep(2000);

        //ScrollDown
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)","");
        Thread.sleep(2000);

        //Click On The Next Button
        driver.findElement(By.xpath("//button[@class='button-style undefined']")).click();
        Thread.sleep(2000);

        //ScrollUp
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-300)","");
        Thread.sleep(2000);

        //ScrollDown
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)","");
        Thread.sleep(2000);

        //Click On The Next Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 6)
    public void BankDetail() throws InterruptedException {
        //ScrollUp
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-300)","");
        Thread.sleep(2000);

        //Click On The Bank Name Filed
        driver.findElement(By.xpath("//select[@name='bank_name']")).click();
        Thread.sleep(2000);

        //Select The Bank
        driver.findElement(By.xpath("//option[text()='Bank Of India']")).click();
        Thread.sleep(1000);

        //Give The Account Number
        driver.findElement(By.xpath("//input[@name='acc_number']")).sendKeys("123456789");
        Thread.sleep(2000);

        //Verify Account Number
        driver.findElement(By.xpath("//input[@name='cAccountNumber']")).sendKeys("123456789");
        Thread.sleep(2000);

        //IFSC Code Field
        driver.findElement(By.xpath("//input[@name='ifsc']")).sendKeys("ABCD0123456");
        Thread.sleep(2000);

        //Email Field
        driver.findElement(By.xpath("//input[@name='acc_email']")).sendKeys("naveen2@gmail.com");
        Thread.sleep(2000);

        //Account Holder Name Field
        driver.findElement(By.xpath("//input[@name='acc_holder']")).sendKeys("Naveen");
        Thread.sleep(2000);

        //ScrollDown
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)","");
        Thread.sleep(2000);

        //Nick Name Field
        driver.findElement(By.xpath("//input[@name='nickname']")).sendKeys("Nav");
        Thread.sleep(2000);

        //Click On The Back Button Field
        driver.findElement(By.xpath("//button[text()='Back']")).click();
        Thread.sleep(2000);

        //ScrollUp
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-300)","");
        Thread.sleep(2000);

        //ScrollDown
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)","");
        Thread.sleep(2000);

        //Click On The Back Button
        driver.findElement(By.xpath("//button[@class='button-style border-btn']")).click();
        Thread.sleep(2000);

        //ScrollUp
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-300)","");
        Thread.sleep(2000);

        //ScrollDown
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)","");
        Thread.sleep(2000);

        //Click On The Next Button
        driver.findElement(By.xpath("//button[@class='button-style undefined']")).click();
        Thread.sleep(2000);

        //ScrollUp
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-300)","");
        Thread.sleep(2000);

        //ScrollDown
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)","");
        Thread.sleep(2000);

        //Click On The Next Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        //ScrollUp
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-300)","");
        Thread.sleep(2000);

        //ScrollDown
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)","");
        Thread.sleep(2000);

        //Click On The Complete Button
        driver.findElement(By.xpath("//button[@class='button-style undefined']")).click();
        Thread.sleep(2000);

        //Click On The Cross Button
        driver.findElement(By.xpath("//button[@class='btn-close']")).click();
    }
}
