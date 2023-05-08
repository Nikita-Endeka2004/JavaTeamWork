package App;

import gui.swing.MainFrame;
import javax.swing.*;
import java.text.NumberFormat;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of x: ");
        double x = scanner.nextDouble();
        final Function expression =
                new Sum(
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
                );

        final Function expression2 =
                new Product(
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
                );

        JFrame frame = new MainFrame("Frame", expression, expression2);
        frame.setVisible(true);

        final NumberFormat nf = NumberFormat.getInstance();
        System.out.format("f1(x) = %s", expression.toPrettyString(nf)).println();
        System.out.format("f1'(x) = %s", expression.derivative().toPrettyString(nf)).println();
        System.out.format("f1(" + x +") = %f", expression.evaluate(x)).println();
        System.out.format("f1'(" + x + ") = %f", expression.derivative().evaluate(x)).println();
        System.out.format("f2(x) = %s", expression2.toPrettyString(nf)).println();
        System.out.format("f2'(x) = %s", expression2.derivative().toPrettyString(nf)).println();
        System.out.format("f2(" + x +") = %f", expression2.evaluate(x)).println();
        System.out.format("f2'(" + x + ") = %f", expression2.derivative().evaluate(x)).println();
    }

}