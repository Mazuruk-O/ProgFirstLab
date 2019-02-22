package ClassesFunc.UnarFunc;

import AbstractFunc.UnarFunc;
import ClassesFunc.BinarFunc.Multiply;
import ClassesFunc.OtherFunc.X;
import InterfaceFunc.Function;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Exp")
@XmlRootElement
public class Exp extends UnarFunc {
    public Exp(){
        super(new X());
        return;
    }

    public Exp(Function subFunction){
        super(subFunction);
        return;
    }

    @Override
    public double calcFunc(double x) {
        return Math.exp(subFunction.calcFunc(x));
    }

    @Override
    public Function diff() {
        if(subFunction instanceof X)
            return this;

        return new Multiply(new Exp(new X()),new Multiply(new Exp(), subFunction.diff()));
    }
}
