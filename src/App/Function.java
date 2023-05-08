package App;

import java.text.NumberFormat;
public interface Function {

        double evaluate(double x);
        String toPrettyString(NumberFormat nf);
        Function derivative();

}
