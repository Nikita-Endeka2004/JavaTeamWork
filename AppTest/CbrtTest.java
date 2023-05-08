import App.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class CbrtTest {
    @Test
    public void TestEvaluateCbrt(){
        final double inputValue = 1;
        final double diserdValue = 1;

        final Cbrt Cbrt = new Cbrt(Variable.X);
        final double actualResult = Cbrt.evaluate(inputValue);
        Assertions.assertEquals(actualResult, diserdValue);

    }
    @Test
    public void CbrtTestDerivative(){
        final Cbrt determine = new Cbrt(Variable.X);
        final Function actualResult = new Product(new Pow(new Product(new Constant(3), new Pow( new Cbrt(Variable.X),2)),-1),Variable.X.derivative());
        Assertions.assertEquals(determine.derivative(), actualResult);
    }
    @Test
    public void CbrtTestToPrettyString(){
        final Function determine = new Cbrt(Variable.X);
        final NumberFormat nf = NumberFormat.getInstance();
        final String actualResult = "cbrt(x)";
        Assertions.assertEquals(determine.toPrettyString(nf), actualResult);
    }
}
