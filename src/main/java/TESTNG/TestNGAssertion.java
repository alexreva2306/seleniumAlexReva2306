package TESTNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {
    //create one method that takes two parameter and return the
    //multiplication of these numbers


    public double gettingMulti(double num1, double num2){
        return num1*num2;
    }
    @Test
    public  void validMultipl() {
        double actualResult = gettingMulti(5, 6);
        double expectedResult = 30;
//        if(actualResult==expectedResult){
//            System.out.println("passed");
//        }
        Assert.assertEquals(actualResult, expectedResult, "my numbers are 5 and 6");//message will show up
    }                                                                       //when it fails
        public double getDivision(double num1, double num2){
            if(num1>=num2){
                return num1/num2;
            }
            return num2/num1;
        }

    public int subsrtact(int num1, int num2){
        if(num1>=num2){
            return num1-num2;
        }
        return num2-num1;
    }
    @Test
    public void validateDiv(){
        double actRes = getDivision(8,2);
        double expRes =4;
        Assert.assertEquals(actRes,expRes);
    }
    @Test
    public void validateSub(){
        int actRes = subsrtact(65,43);
        int expRes = 22;
        Assert.assertEquals(actRes,expRes);
        double actResDiv = getDivision(6,3);
        double expResDiv = 2;
        Assert.assertEquals(actResDiv,expResDiv);
    }
}
