package App;

import java.text.NumberFormat;

public class Variable implements Function {
    public static final Variable X = new Variable();
    public double evaluate(double x) {
        return x;
    }

    public Function derivative() {
        return new Constant(1);
    }

    @Override
    public String toPrettyString(NumberFormat nf){
        return "x";
    }

}