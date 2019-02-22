package ClassesFunc.BinarFunc;

import AbstractFunc.BinarFunc;
import ClassesFunc.OtherFunc.Const;
import InterfaceFunc.Function;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * Ділення
 *
 * @author: Oleg Mazuruk
 * Time: 30.01.2019 21-40
 * Арифметичні операції для двох унарних функцій
 * Arithmetic operations for two unary functions
 * First method: double calcFunc(double x) - result Arithmetic operations for two unary functions
 * Second methot: Function diff() - result derivative for two unary functions
 *
 **/

@XmlType(name = "Divide")
@XmlRootElement
public class Divide extends BinarFunc {

    public Divide(){
        super();
        return;
    }

    /**
     *
     * @param leftFunc - унарна ф-ція, ліворуч від арифметичної операції
     * @param rightFunc - унарна ф-ція, праворуч від арифметичної операції
     *
     */
    public Divide(Function leftFunc, Function rightFunc){
        super(leftFunc,rightFunc);
        return;
    }

    /**
     *
     * @param x - змінна для обчислення унарної функції у точці "х"
     * @return - результат обчислення LefFunc(x) / RightFunc(x)
     *
     */
    @Override
    public double calcFunc(double x) {
        if(this.rightFunc instanceof Const && this.rightFunc.calcFunc(0) == 0){
            System.out.println("Error, denominator is zero. Return 0.0d");
            return 0.0;
        }
        return this.leftFunc.calcFunc(x) / this.rightFunc.calcFunc(x);
    }

    @Override
    public Function diff() {
       return new Subtract(new Divide(new Multiply(this.leftFunc.diff(),this.rightFunc), new Multiply(this.leftFunc,this.rightFunc.diff())),new Multiply(this.rightFunc,this.rightFunc));
    }

    @Override
    public String toString(){
        return this.leftFunc.toString() + " / " + this.rightFunc.toString();
    }
}