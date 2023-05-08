package App;

import java.text.NumberFormat;
import java.util.Objects;

public class Sum implements Function {
    private final Function f1;
    private final Function f2;

    public Sum(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    public double evaluate(double x) {
        return f1.evaluate(x) + f2.evaluate(x);
    }

    public Function derivative() {
        return new Sum(f1.derivative(), f2.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf){
        return "(" + f1.toPrettyString(nf) + "+" + f2.toPrettyString(nf) +  ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sum sum = (Sum) o;
        return Objects.equals(f1, sum.f1) && Objects.equals(f2, sum.f2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f1, f2);
    }
}

