package App;

import java.text.NumberFormat;
import java.util.Objects;

public class Cbrt implements Function {

    private final Function f;
    public Cbrt(Function f) {
        this.f = f;
    }

    public double evaluate(double x) {
        return Math.cbrt(f.evaluate(x));
    }

    public Function derivative() {
        return new Product(new Pow(new Product(new Constant(3), new Pow( new Cbrt(f),2)),-1),f.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf){
        return "cbrt(" + f.toPrettyString(nf) + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cbrt cbrt = (Cbrt) o;
        return Objects.equals(f, cbrt.f);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f);
    }
}
