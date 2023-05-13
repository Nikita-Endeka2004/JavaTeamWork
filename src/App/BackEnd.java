package App;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;

public class BackEnd  {
    private Function current;
    private ArrayList<Function> functionsList;

    private NumberFormat nf = NumberFormat.getInstance();

    public BackEnd(){
        functionsList.add(new Sum(
                new Cos(
                        new Ln(
                                new Abs(
                                        new Tg(
                                                new Product(
                                                        new Constant(0.1),
                                                        new Variable())
                                        )
                                )
                        )
                ),
                new Product(
                        new Pow(
                                new Ln(
                                        new Abs(
                                                new Sum(
                                                        new Product(
                                                                new Constant(-0.5),
                                                                new Variable()
                                                        ),
                                                        new Product(
                                                                new Constant(0.1),
                                                                new Constant(-1)
                                                        )
                                                )
                                        )
                                ), 2
                        ),
                        new Constant(-1)
                )
        ));
        functionsList.add(new Product(
                new Variable(),
                new Pow(
                        new Sinh(
                                new Abs(
                                        new Product(
                                                new Constant(0.1),
                                                new Cbrt(
                                                        new Cos(
                                                                new Product(
                                                                        new Constant(-0.5),
                                                                        new Variable()
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                        , 2
                )
        ));

        chooseCurrent(0);
    }

    public boolean chooseCurrent(int index){
        if(index > functionsList.size()){
            return false;
        }
        current = functionsList.get(index);
        return true;
    }

    public String getCurrent() {
        return current.toPrettyString(nf);
    }

    public String evaluateDerivative(){
        current = current.derivative();
        return current.toPrettyString(nf);
    }

    public String[] getFunctionsList() {
        String[] result = new String[functionsList.size()];
        for(int i = 0; i < functionsList.size(); i++){
            result[i] = functionsList.get(i).toPrettyString(nf);
        }
        return result;
    }

    public double evaluateCurrentAtPoint(double x) {
        return current.evaluate(x);
    }

    public double[] evaluateCurrent(double[] range){
        int size = range.length;
        double[] result = new double[size];
        for (int i = 0; i < size; i++){
            result[i] = evaluateCurrentAtPoint(range[i]);
        }
        return result;
    }

    public double[] evaluateRange(double left, double right, double delta){
        int size = (int) ((right - left) / delta);
        double[] result = new double[size];
        for (int i = 0; i < size; i++){
            result[i] = left;
            left += delta;
        }
        return result;
    }

}
