import App.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
public class TgTest {
    @Test
    public void TestEvaluateTg(){
        final Constant inputValue = new Constant(0);
        final double diserdValue = 0;

        final Tg Tg = new Tg(inputValue);
        final double actualResult = Tg.evaluate(0);
        Assertions.assertEquals(actualResult, diserdValue);
    }
    @Test
    public void TgTestDerivative(){
        final Constant Constant = new Constant(0);
        final Function determine = new Tg(Constant);
        final Function actualResult = new Product((new Pow(new Cos(Constant), -2)), Constant.derivative());
        Assertions.assertEquals(determine.derivative(), actualResult);
    }
    @Test
    public void TgTestToPrettyString(){
        final Function determine = new Tg(Variable.X);
        final NumberFormat nf = NumberFormat.getInstance();
        final String actualResult = "tan(x)";
        Assertions.assertEquals(determine.toPrettyString(nf), actualResult);
    }
}
