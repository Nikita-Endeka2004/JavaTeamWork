package App;

import java.text.NumberFormat;
import java.util.Objects;

public class Ln implements Function {
    private final Function f;

    public Ln(Function f) {
        this.f = f;
    }

    public double evaluate(double x) {
        return Math.log(f.evaluate(x));
    }

    public Function derivative() {
        return new Product(new Pow(f,-1), f.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf){
        return "ln(" + f.toPrettyString(nf) + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ln ln = (Ln) o;
        return Objects.equals(f, ln.f);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f);
    }
}