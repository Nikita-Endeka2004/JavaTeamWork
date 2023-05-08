import App.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class AbsTest {
    @Test
    public void AbsTestMinus(){
        final double inputMinusValue = -1;
        final double diserdValue = 1;

        final Abs abs = new Abs(Variable.X);
        final double actualResult = abs.evaluate(inputMinusValue);
        Assertions.assertEquals(actualResult, diserdValue);

    }
    @Test
    public void AbsTestPlus(){
        final double inputPlusValue = 1;
        final double diserdValue = 1;

        final Abs abs = new Abs(Variable.X);
        final double actualResult = abs.evaluate(inputPlusValue);
        Assertions.assertEquals(actualResult, diserdValue);

    }
    @Test
    public void AbsTestDerivative(){
        final Function determine = new Abs(Variable.X);
        final Function actualResult = new Product( new Constant(1), new Product( Variable.X, new Pow(new Abs(Variable.X), -1)));
        Assertions.assertEquals(determine.derivative(), actualResult);
    }

    @Test
    public void AbsTestToPrettyString(){
        final Function determine = new Abs(Variable.X);
        final NumberFormat nf = NumberFormat.getInstance();
        final String actualResult = "| x |";
        Assertions.assertEquals(determine.toPrettyString(nf), actualResult);
    }

}
