package ClassesFunc.UnarFunc;

import AbstractFunc.UnarFunc;
import ClassesFunc.BinarFunc.Multiply;
import ClassesFunc.OtherFunc.X;
import InterfaceFunc.Function;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Sin")
@XmlRootElement
public class Sin extends UnarFunc {

    public Sin(){
        super(new X());
        return;
    }

    public Sin(Function subFunction){
        super(subFunction);
        return;
    }

    @Override
    public double calcFunc(double x) {
        return Math.sin(subFunction.calcFunc(x));
    }

    @Override
    public Function diff() {
        if(subFunction instanceof X)
            return new Cos(new X());

        return new Multiply(new Sin(new X()),new Multiply(new Cos(), subFunction.diff()));
    }
}