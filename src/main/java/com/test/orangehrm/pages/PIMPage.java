package com.test.orangehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/*
    1)Click PIM on the mainpage
    2)Click Add button under PIM
    3)Fill the boxes
    4)Click Save Button
    5)Wait for the next direction
     */
public class PIMPage {

    public PIMPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement addBut;
    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='employeeId']")
    WebElement emplId;
    @FindBy(xpath = "//input[@id='photofile']")
    WebElement chooseFile;
    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement saveBut;
    @FindBy(name = "personal[txtEmpFirstName]")
    WebElement validationName;
    @FindBy(name = "personal[txtEmpLastName]")
    WebElement validationLastName;
    @FindBy(name = "personal[txtEmployeeId]")
    WebElement validationEmployeeId;

    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement editbutton;
    @FindBy(id = "personal_optGender_1")
    WebElement gender;
    @FindBy(id = "personal_cmbNation")
    WebElement nationality;
    @FindBy(id = "personal_cmbMarital")
    WebElement marriageStatus;
    @FindBy(id = "personal_DOB")
    WebElement dateOfBirth;
    public void addEmployeeForPIM(String name,String lastName,String emplId,String chooseFile) throws InterruptedException{
        addBut.click();
        this.firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        this.emplId.sendKeys(emplId);
        this.chooseFile.sendKeys(chooseFile);Thread.sleep(1000);
        saveBut.click();Thread.sleep(1000);
    }

    public String validateFirstName(){
        return validationName.getAttribute("value");
    }
    public String validateLastName(){
return validationLastName.getAttribute("value");
    }
    public boolean validateEmployeeId(String emplId){
        return validationEmployeeId.getAttribute("value").endsWith(emplId);
    }
    public void editPersonalDetails(String nation, String dateOfBirths,String maritualStatus){
        editbutton.click();
        gender.click();
        BrowserUtils.selectBy(nationality,nation,"text");
        dateOfBirth.clear();
        this.dateOfBirth.sendKeys(dateOfBirths);
        BrowserUtils.selectBy(this.marriageStatus,maritualStatus,"text");
        saveBut.click();
    }

    public String validateTheNationality(){
        Select select=new Select(nationality);
        return select.getFirstSelectedOption().getText().trim();
    }
}
