package App;

import java.text.NumberFormat;
import java.util.Objects;

public class Cos implements Function {
    private final Function f;

    public Cos(Function f) {
        this.f = f;
    }

    public double evaluate(double x) {
        return Math.cos(f.evaluate(x));
    }

    public Function derivative() {
        return new Product(new Constant(-1), new Product(new Sin(f), f.derivative()));
    }
    @Override
    public String toPrettyString(NumberFormat nf){
        return "cos(" + f.toPrettyString(nf)+ ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cos cos = (Cos) o;
        return Objects.equals(f, cos.f);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f);
    }
}