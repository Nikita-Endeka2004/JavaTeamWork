package App;

import java.text.NumberFormat;
import java.util.Objects;

public class Abs implements Function {
    private final Function f;

    public Abs(Function f) {
        this.f = f;
    }

    public double evaluate(double x) {
        return Math.abs(f.evaluate(x));
    }

    public Function derivative() {
        return new Product(f.derivative(), new Product(f, new Pow(this, -1)));
    }
    public String toPrettyString(NumberFormat nf){
        return "| " + f.toPrettyString(nf) + " |";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abs abs = (Abs) o;
        return Objects.equals(f, abs.f);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f);
    }
}