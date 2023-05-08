package App;

import java.text.NumberFormat;
import java.util.Objects;

public class Pow implements Function {
    private final Function base;
    private final double exponent;

    public Pow(Function base, double exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    public double evaluate(double x) {
        return Math.pow(base.evaluate(x), exponent);
    }

    public Function derivative() {
        return new Product(
                new Constant(exponent),
                new Product(
                new Pow(base, exponent - 1),
                base.derivative())
        );
    }

    @Override
    public String toPrettyString(NumberFormat nf){
        return "(" + base.toPrettyString(nf) + "^" + exponent + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pow pow = (Pow) o;
        return Double.compare(pow.exponent, exponent) == 0 && Objects.equals(base, pow.base);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, exponent);
    }
}
