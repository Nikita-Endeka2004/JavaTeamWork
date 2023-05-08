import App.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
public class SinhTest {
    @Test
    public void TestEvaluateSinh(){
        final Constant inputValue = new Constant(0);
        final double diserdValue = 0;

        final Sinh Sinh = new Sinh(inputValue);
        final double actualResult = Sinh.evaluate(0);
        Assertions.assertEquals(actualResult, diserdValue);
    }
    @Test
    public void SinhTestDerivative(){
        final Constant Constant = new Constant(0);
        final Function determine = new Sinh(Constant);
        final Function actualResult = new Product(new Cosh(Constant), Constant.derivative());
        Assertions.assertEquals(determine.derivative(), actualResult);
    }
    @Test
    public void SinhTestToPrettyString(){
        final Function determine = new Sinh(Variable.X);
        final NumberFormat nf = NumberFormat.getInstance();
        final String actualResult = "sinh(x)";
        Assertions.assertEquals(determine.toPrettyString(nf), actualResult);
    }
}
