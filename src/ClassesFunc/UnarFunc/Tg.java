package ClassesFunc.UnarFunc;
import AbstractFunc.UnarFunc;
import ClassesFunc.BinarFunc.*;
import ClassesFunc.OtherFunc.*;
import InterfaceFunc.Function;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "Tg")
@XmlRootElement
public class Tg extends UnarFunc {

    public Tg(){
        super(new X());
        return;
    }

    public Tg(Function subFunction){
        super(subFunction);
        return;
    }

    @Override
    public double calcFunc(double x) {
        return Math.tan(subFunction.calcFunc(x));
    }

    @Override
    public Function diff() {
        if(subFunction instanceof X)
            return new Divide(new Const(1.0), new Multiply(new Cos(),new Cos()));

        return new Multiply(new Ctg(new X()),new Multiply(new Divide(new Const(1.0), new Multiply(new Cos(),new Cos())), subFunction.diff()));

    }

}