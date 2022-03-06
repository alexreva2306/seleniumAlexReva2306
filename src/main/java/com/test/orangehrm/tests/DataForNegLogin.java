package com.test.orangehrm.tests;

import org.testng.annotations.DataProvider;

public class DataForNegLogin {
    @DataProvider(name = "pickles")
    public Object[][]getData(){
        return new Object[][]{
                {"Admin","Ahmet","Invalid credentials"},
                {"abmin","admin123","Invalid credentials"},
                {"voice","nestle","Invalid credentials"}


        };
    }
    @DataProvider (name="UserRoles")
    public Object [][] getUserRolesData(){
        return new Object[][]{
                {"Admin"},
                {"ESS"}
        };
    }
}
