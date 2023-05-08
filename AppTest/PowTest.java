import App.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
public class PowTest {
    @Test
    public void TestEvaluatePow(){
        final double inputValue = 1;
        final double diserdValue = 1;

        final Pow Pow = new Pow(new Constant(1), 1);
        final double actualResult = Pow.evaluate(inputValue);
        Assertions.assertEquals(actualResult, diserdValue);
    }
    @Test
    public void PowTestDerivative(){
        final Constant Constant = new Constant(1);
        final Function determine = new Ln(Constant);
        final Function actualResult = new Product(new Pow(Constant,-1), Constant.derivative());
        Assertions.assertEquals(determine.derivative(), actualResult);
    }
    @Test
    public void PowTestToPrettyString(){
        final Function determine = new Pow(Variable.X,2);
        final NumberFormat nf = NumberFormat.getInstance();
        final String actualResult = "(x^2.0)";
        Assertions.assertEquals(determine.toPrettyString(nf), actualResult);
    }
}
