import App.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
public class VariableTest {
    @Test
    public void TestEvaluateVariable(){
        final double inputValue = 2;
        final double diserdValue = 2;

        final Variable Variable = new Variable();
        final double actualResult = Variable.evaluate(inputValue);
        Assertions.assertEquals(actualResult, diserdValue);
    }
    @Test
    public void VariableTestDerivative(){
        final Function determine = new Variable();
        final Function actualResult = new Constant(1);;
        Assertions.assertEquals(determine.derivative(), actualResult);
    }
    @Test
    public void VariableTestToPrettyString(){
        final Function determine = new Variable();
        final NumberFormat nf = NumberFormat.getInstance();
        final String actualResult = "x";
        Assertions.assertEquals(determine.toPrettyString(nf), actualResult);
    }
}
