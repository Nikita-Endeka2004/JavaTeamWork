package App;

import java.text.NumberFormat;
import java.util.Objects;

public class Tg implements Function {
    private final Function f;

    public Tg(Function f) {
        this.f = f;
    }

    public double evaluate(double x) {
        return Math.tan(f.evaluate(x));
    }

    public Function derivative() {
        return new Product((new Pow(new Cos(f), -2)), f.derivative());
    }

    public String toPrettyString(NumberFormat nf){
        return "tan(" + f.toPrettyString(nf)+ ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tg tg = (Tg) o;
        return Objects.equals(f, tg.f);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f);
    }
}
