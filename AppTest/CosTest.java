import App.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
public class CosTest {
    @Test
    public void TestEvaluateCos(){
        final double inputValue = 0;
        final double diserdValue = 1;

        final Cos Cos = new Cos(Variable.X);
        final double actualResult = Cos.evaluate(inputValue);
        Assertions.assertEquals(actualResult, diserdValue);
    }
    @Test
    public void CoshTestDerivative(){
        final Constant Constant = new Constant(0);
        final Function determine = new Cos(Constant);
        final Function actualResult = new Product(new Constant(-1), new Product(new Sin(Constant), Constant.derivative()));
        Assertions.assertEquals(determine.derivative(), actualResult);
    }
    @Test
    public void CoshTestToPrettyString(){
        final Function determine = new Cosh(Variable.X);
        final NumberFormat nf = NumberFormat.getInstance();
        final String actualResult = "Cosh(x)";
        Assertions.assertEquals(determine.toPrettyString(nf), actualResult);
    }

}
