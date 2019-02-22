package ClassesFunc.BinarFunc;

import AbstractFunc.BinarFunc;
import InterfaceFunc.Function;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * Додавання
 *
 * @author: Oleg Mazuruk
 * Time: 30.01.2019 21-40
 * Арифметичні операції для двох унарних функцій
 * Arithmetic operations for two unary functions
 * First method: double calcFunc(double x) - result Arithmetic operations for two unary functions
 * Second methot: Function diff() - result derivative for two unary functions
 *
 **/

@XmlType(name = "Add")
@XmlRootElement
public class Add extends BinarFunc {

    public Add(){
        super();
        return;
    }

    /**
     *
     * @param leftFunc - унарна ф-ція, ліворуч від арифметичної операції
     * @param rightFunc - унарна ф-ція, праворуч від арифметичної операції
     *
     */
    public Add(Function leftFunc,Function rightFunc){
        super(leftFunc,rightFunc);
        return;
    }

    /**
     *
     * @param x - змінна для обчислення унарної функції у точці "х"
     * @return - результат обчислення LefFunc(x) + RightFunc(x)
     *
     */
    @Override
    public double calcFunc(double x) {
        return this.leftFunc.calcFunc(x) + this.rightFunc.calcFunc(x);
    }

    @Override
    public Function diff() {
        return new Add(this.leftFunc.diff(),this.rightFunc.diff());
    }

    @Override
    public String toString(){
        return this.leftFunc.toString() + " + " + this.rightFunc.toString();
    }
}
