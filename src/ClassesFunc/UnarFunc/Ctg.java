package ClassesFunc.UnarFunc;

import AbstractFunc.UnarFunc;
import ClassesFunc.BinarFunc.Divide;
import ClassesFunc.BinarFunc.Multiply;
import ClassesFunc.OtherFunc.Const;
import ClassesFunc.OtherFunc.X;
import InterfaceFunc.Function;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Ctg")
@XmlRootElement
public class Ctg extends UnarFunc {

    public Ctg(){
        super(new X());
        return;
    }

    public Ctg(Function subFunction){
        super(subFunction);
        return;
    }

    @Override
    public Function diff() {
        if(subFunction instanceof X)
            return new Divide(new Const(1.0), new Multiply(new Sin(),new Sin()));

        return new Multiply(new Ctg(new X()),new Multiply(new Divide(new Const(1.0), new Multiply(new Sin(),new Sin())), subFunction.diff()));
    }
}
