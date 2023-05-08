package App;

import java.text.NumberFormat;
import java.util.Objects;

public class Cosh implements Function {
    private final Function f;

    public Cosh(Function f) {
        this.f = f;
    }

    public double evaluate(double x) {
        return Math.cosh(f.evaluate(x));
    }

    public Function derivative() {
        return new Product(new Sinh(f), f.derivative());
    }

    public String toPrettyString(NumberFormat nf) {
        return "Cosh(" + f.toPrettyString(nf) + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cosh cosh = (Cosh) o;
        return Objects.equals(f, cosh.f);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f);
    }
}
