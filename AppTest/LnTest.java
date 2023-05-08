import App.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
public class LnTest {
    @Test
    public void TestEvaluateLn(){
        final double inputValue = 1;
        final double diserdValue = 0;

        final Ln Ln = new Ln(Variable.X);
        final double actualResult = Ln.evaluate(inputValue);
        Assertions.assertEquals(actualResult, diserdValue);
    }
    @Test
    public void LnTestDerivative(){
        final Constant Constant = new Constant(1);
        final Function determine = new Ln(Constant);
        final Function actualResult = new Product(new Pow(Constant,-1), Constant.derivative());
        Assertions.assertEquals(determine.derivative(), actualResult);
    }
    @Test
    public void LnTestToPrettyString(){
        final Function determine = new Ln(Variable.X);
        final NumberFormat nf = NumberFormat.getInstance();
        final String actualResult = "ln(x)";
        Assertions.assertEquals(determine.toPrettyString(nf), actualResult);
    }
}
