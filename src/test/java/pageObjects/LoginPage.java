package pageObjects;

import env.Constant;
import locators.LoginLocators;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class LoginPage extends LoginLocators {

    public LoginPage() {
        super();
    }

    public void checkDisableButton() {
        Assert.assertFalse(Login_button.isEnabled());
    }

    public void enterCredentials(String Username, String Password) {
        textBox_Username.sendKeys(Username);
        textBox_Password.sendKeys(Password);
    }

    public void displayLoginDateTimeBasicInfo() {

//        DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy, h:mm a");
//        Date date = new Date();
//        System.out.println(date);
//        String systemDate = dateFormat.format(date);
//        System.out.println(systemDate);

        dropDown.click();
        String UserDesignation = display_Designation.getText();
        String UserRole = display_Role.getText();
        System.out.println(UserDesignation);
        System.out.println(UserRole);
        Assert.assertEquals(Constant.designation, UserDesignation);
        Assert.assertEquals(Constant.role, UserRole);
    }

    public void staticSearchParameters() {
        String parameters = display_Parameters.getText();
        Assert.assertEquals(parameters, Constant.SearchParameters);
    }

    public void logOut() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dropDown.click();
        Logout_button.click();
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertEquals(Constant.URL, currentUrl);
    }

    public void validateFormat() throws ParseException {
        String strDate = display_LastLogin.getText();
        strDate = strDate.replaceAll("Last Login: ", "");
        SimpleDateFormat sdfrmt = new SimpleDateFormat("MMM dd, yyyy, h:mm a");
        sdfrmt.setLenient(false);
        sdfrmt.parse(strDate);
//        System.out.println(strDate + " is valid date format");
    }
}
