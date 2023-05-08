import App.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
public class CoshTest {
    @Test
    public void TestEvaluateCosh(){
        final double inputValue = 0;
        final double diserdValue = 1;

        final Cos Cos = new Cos(Variable.X);
        final double actualResult = Cos.evaluate(inputValue);
        Assertions.assertEquals(actualResult, diserdValue);
    }
    @Test
    public void CoshTestDerivative(){
        final Constant Constant = new Constant(0);
        final Function determine = new Cosh(Constant);
        final Function actualResult = new Product(new Sinh(Constant), Constant.derivative());
        Assertions.assertEquals(determine.derivative(), actualResult);
    }
    @Test
    public void CosTestToPrettyString(){
        final Function determine = new Cosh(Variable.X);
        final NumberFormat nf = NumberFormat.getInstance();
        final String actualResult = "Cosh(x)";
        Assertions.assertEquals(determine.toPrettyString(nf), actualResult);
    }
}
