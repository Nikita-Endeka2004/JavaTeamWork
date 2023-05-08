package App;

import java.text.NumberFormat;
import java.util.Objects;

public class Constant implements Function {
        private final double value;


        public Constant(double value) {
            this.value = value;
        }

        public double evaluate(double x) {
            return value;
        }

        public Function derivative() {
            return new Constant(0);
        }
    @Override
    public String toPrettyString(NumberFormat nf){
        return nf.format(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constant constant = (Constant) o;
        return Double.compare(constant.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}


