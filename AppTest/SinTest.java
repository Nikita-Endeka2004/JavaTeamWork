import App.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
public class SinTest {
    @Test
    public void TestEvaluateSin(){
        final Constant inputValue = new Constant(0);
        final double diserdValue = 0;

        final Sin Sin = new Sin(inputValue);
        final double actualResult = Sin.evaluate(0);
        Assertions.assertEquals(actualResult, diserdValue);
    }
    @Test
    public void SinTestDerivative(){
        final Constant Constant = new Constant(0);
        final Function determine = new Sin(Constant);
        final Function actualResult = new Product(new Cos(Constant), Constant.derivative());
        Assertions.assertEquals(determine.derivative(), actualResult);
    }
    @Test
    public void SinTestToPrettyString(){
        final Function determine = new Sin(Variable.X);
        final NumberFormat nf = NumberFormat.getInstance();
        final String actualResult = "sin(x)";
        Assertions.assertEquals(determine.toPrettyString(nf), actualResult);
    }
}
