package ClassesFunc.UnarFunc;

import AbstractFunc.UnarFunc;
import ClassesFunc.BinarFunc.Multiply;
import ClassesFunc.OtherFunc.X;
import InterfaceFunc.Function;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Cos")
@XmlRootElement
public class Cos extends UnarFunc {

    public Cos(){
        super(new X());
        return;
    }

    public Cos(Function subFunction){
        super(subFunction);
        return;
    }

    @Override
    public double calcFunc(double x) {
        return Math.cos(subFunction.calcFunc(x));
    }

    @Override
    public Function diff() {
        if(subFunction instanceof X)
            return new Sin(new X());

        return new Multiply(new Cos(new X()),new Multiply(new Sin(), subFunction.diff()));
    }
}
