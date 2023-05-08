import App.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
public class ProductTest {
    @Test
    public void TestEvaluateProduct(){
        final double inputValue1 = 1;
        final Constant inputValue3 = new Constant(1);
        final Constant inputValue4 = new Constant(-1);
        final double diserdValue = -1;

        final Product Product = new Product(inputValue3, inputValue4);
        final double actualResult = Product.evaluate(inputValue1);
        Assertions.assertEquals(actualResult, diserdValue);
    }
    @Test
    public void ProductTestDerivative(){
        final Function determine = new Product(Variable.X, Variable.X);
        final Function actualResult = new Sum(new Product(Variable.X.derivative(), Variable.X), new Product(Variable.X, Variable.X.derivative()));
        Assertions.assertEquals(determine.derivative(), actualResult);
    }
    @Test
    public void ProductTestToPrettyString(){
        final Function determine = new Product(Variable.X,Variable.X);
        final NumberFormat nf = NumberFormat.getInstance();
        final String actualResult = "(x * x)";
        Assertions.assertEquals(determine.toPrettyString(nf), actualResult);
    }
}
