package AbstractFunc;

import InterfaceFunc.Function;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author: Oleg Mazuruk
 * Time: 30.01.2019 21-40
 * Абстрактний клас для двох унарних функцій
 * First method: double calcLeftFunc(double x) - result Arithmetic operations for left unary functions
 * Second method: double calcRightFunc(double x) - result Arithmetic operations for right unary functions
 *
 **/

public abstract class BinarFunc extends Function {
    @XmlElement(name = "leftFunc")
    protected Function leftFunc;
    @XmlElement(name = "rightFunc")
    protected Function rightFunc;

    public BinarFunc(){
        this.leftFunc = null;
        this.rightFunc = null;
    }

    /**
     *
     * @param leftFunc - унарна ф-ція, ліворуч від арифметичної операції
     * @param rightFunc - унарна ф-ція, праворуч від арифметичної операції
     *
     */
    public BinarFunc(Function leftFunc,Function rightFunc){
        this.leftFunc = leftFunc;
        this.rightFunc = rightFunc;
        return;
    }

    public abstract Function diff();
}
