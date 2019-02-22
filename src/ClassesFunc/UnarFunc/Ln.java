package ClassesFunc.UnarFunc;

import AbstractFunc.UnarFunc;
import ClassesFunc.BinarFunc.Divide;
import ClassesFunc.BinarFunc.Multiply;
import ClassesFunc.OtherFunc.Const;
import ClassesFunc.OtherFunc.X;
import InterfaceFunc.Function;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Ln")
@XmlRootElement
public class Ln extends UnarFunc {

    public Ln(){
        super(new X());
        return;
    }

    public Ln(Function subFunction){
        super(subFunction);
        return;
    }

    @Override
    public double calcFunc(double x) {
        return Math.log(subFunction.calcFunc(x));
    }

    @Override
    public Function diff() {
        if(subFunction instanceof X)
            return new Divide(new Const(1.0),new X());

        return new Multiply(new Ln(new X()),new Multiply(new Divide(new Const(1.0),new X()), subFunction.diff()));
    }
}
