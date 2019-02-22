package ClassesFunc.UnarFunc;

import AbstractFunc.UnarFunc;
import ClassesFunc.BinarFunc.Multiply;
import ClassesFunc.OtherFunc.Const;
import ClassesFunc.OtherFunc.X;
import InterfaceFunc.Function;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AtoPowX")
@XmlRootElement
public class AtoPowX extends UnarFunc {
    public AtoPowX(){
        super(new Const(1.0));
        return;
    }

    public AtoPowX(Function subFunction){
        super(subFunction);
        return;
    }

    @Override
    public double calcFunc(double x) {
        return calcFunc(1,x);
    }

    public double calcFunc(double a,double x) {
        return Math.pow(a,subFunction.calcFunc(x));
    }

    @Override
    public Function diff() {
        if(subFunction instanceof X)
            return new Multiply(new AtoPowX(),new Ln());

        return new Multiply(new AtoPowX(),new Multiply(new AtoPowX(), subFunction.diff()));
    }

}
