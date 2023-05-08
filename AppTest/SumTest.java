import App.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
public class SumTest {
    @Test
    public void TestEvaluateSum(){
        final Constant inputValue = new Constant(1);
        final double diserdValue = 2;

        final Sum Sum = new Sum(inputValue,inputValue);
        final double actualResult = Sum.evaluate(2);
        Assertions.assertEquals(actualResult, diserdValue);
    }
    @Test
    public void SumTestDerivative(){
        final Constant Constant = new Constant(0);
        final Function determine = new Sum(Constant,Constant);
        final Function actualResult = new Sum(Constant.derivative(), Constant.derivative());
        Assertions.assertEquals(determine.derivative(), actualResult);
    }
    @Test
    public void SumTestToPrettyString(){
        final Function determine = new  Sum(Variable.X, Variable.X);
        final NumberFormat nf = NumberFormat.getInstance();
        final String actualResult = "(x+x)";
        Assertions.assertEquals(determine.toPrettyString(nf), actualResult);
    }
}
