import App.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
public class ConstantTest {
    @Test
    public void TestEvaluateMinusConstant(){
        final double inputValue = -1;
        final double diserdValue = -1;

        final Constant Constant = new Constant(inputValue);
        final double actualResult = Constant.evaluate(inputValue);
        Assertions.assertEquals(actualResult, diserdValue);
    }
    @Test
    public void TestEvaluatePlusConstant(){
        final double inputValue = 1;
        final double diserdValue = 1;

        final Constant Constant = new Constant(1);
        final double actualResult = Constant.evaluate(inputValue);
        Assertions.assertEquals(actualResult, diserdValue);
    }
    @Test
    public void ConstantTestDerivative(){
        final Constant Constant = new Constant(1);
        final Function actualResult =  new Constant(0);
        Assertions.assertEquals(Constant.derivative(), actualResult);
    }
    @Test
    public void ConstantTestToPrettyString(){
        final Function determine = new Constant(1);
        final NumberFormat nf = NumberFormat.getInstance();
        final String actualResult = "1";
        Assertions.assertEquals(determine.toPrettyString(nf), actualResult);
    }
}
