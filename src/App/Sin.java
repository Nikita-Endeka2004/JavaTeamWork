package App;

import java.text.NumberFormat;
import java.util.Objects;

public class Sin implements Function {
    private final Function f;

    public Sin(Function f) {
        this.f = f;
    }

    public double evaluate(double x) {
        return Math.sin(f.evaluate(x));
    }

    public Function derivative() {
        return new Product(new Cos(f), f.derivative());
    }
    public String toPrettyString(NumberFormat nf){
        return "sin(" + f.toPrettyString(nf)+ ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sin sin = (Sin) o;
        return Objects.equals(f, sin.f);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f);
    }
}
