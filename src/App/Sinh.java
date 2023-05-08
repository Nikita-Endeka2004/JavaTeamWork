package App;

import java.text.NumberFormat;
import java.util.Objects;

public class Sinh implements Function {
    private final Function f;

    public Sinh(Function f) {
        this.f = f;
    }

    public double evaluate(double x) {
        return Math.sinh(f.evaluate(x));
    }

    public Function derivative() {
        return new Product(new Cosh(f), f.derivative());
    }

    public String toPrettyString(NumberFormat nf) {
        return "sinh(" + f.toPrettyString(nf) + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sinh sinh = (Sinh) o;
        return Objects.equals(f, sinh.f);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f);
    }
}
