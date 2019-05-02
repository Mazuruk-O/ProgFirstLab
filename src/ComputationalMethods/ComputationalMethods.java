package ComputationalMethods;
import InterfaceFunc.Function;

public class ComputationalMethods {

    public static double MethodNewton(double x, double eps, Function function)
    {
        Function diffFunc = function.diff();
        double f=0.0, df=0.0; int iter = 0;
        do {
            f = function.calcFunc(x);
            df = diffFunc.calcFunc(x);
            x = x - f / df;
            iter++;
        } while (Math.abs(f) > eps && iter < 20000);
        return x;
    }

}
