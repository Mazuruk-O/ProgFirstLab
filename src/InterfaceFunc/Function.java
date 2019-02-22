package InterfaceFunc;

import ClassesFunc.BinarFunc.*;
import ClassesFunc.OtherFunc.*;
import ClassesFunc.UnarFunc.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

/**
 *
 * @author: Oleg Mazuruk
 * Time: 30.01.2019 21-40
 * Інтерфейс для реалізації арифметичних унарних функцій
 * First method: double calcFunc(double x) - result Arithmetic operations for two unary functions
 * Second methot: Function diff() - result derivative for two unary functions
 *
 **/

public abstract class Function {

    /**
     *
     * @param x - змінна для обчислення унарної функції у точці "х"
     * @return - результат обчислення поточної функції у заданій точці
     *
     */
    public abstract double calcFunc(double x);

    /**
     * Функція знаходить похідну для заданих функцій з урахуванням арифметичної операції
     * @return Function - результат диференціювання
     */
    public abstract Function diff();

    /**
     *
     * @param file - ім*я файлу
     * @param function - функція яка буде записана
     *
     */
    public static void WriteToXML(String file, Function function){
        try(FileOutputStream fos = new FileOutputStream(file)) {
            WriteToXML(fos,function);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param fos - файл формату XML, в який буде записано дану функцію
     * @param function - фукнкція, яка буде записана в файл
     * @throws IOException
     * @throws JAXBException
     *
     */
    public static void WriteToXML(FileOutputStream fos, Function function) throws IOException, JAXBException {
        //створення об'єкта Marshaller, який виконає серіалізацію
        JAXBContext context = JAXBContext.newInstance(Add.class, Multiply.class, Divide.class, Subtract.class, Cos.class, Sin.class, Tg.class, Exp.class, X.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // сама серіалізація
        marshaller.marshal(function, fos);
    }
}
