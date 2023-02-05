package Class;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Calculator {

    private String _HELP = "Что бы закрыть калькулятор введите в консоль 'Q' или 'q'\nДля обнуления результатов используйте 'c' или 'C' ";
    private String _ERRORINPUT = "Ошибка ввода";
    private String _ERRORNULL = "Деление на 0";
    private Scanner _input = new Scanner(System.in);
    private QueueList<Double> _operations;
    private boolean _working = true;

    public Calculator(){

        _operations = new QueueList<Double>(new LinkedList<>());

    }

    public void startCalc() throws IOException {

        System.out.println("Калькулятор запущен");
        System.out.println(_HELP);
        _operations.enqueue(inputNumber());
        _operations.print();

        while (_working) {

            switch (operatorChoice()) {

                case sum:

                    _operations.enqueue(inputNumber());
                    _operations.enqueue(sum(_operations.dequeue(), _operations.dequeue()));
                    break;

                case sub:

                    _operations.enqueue(inputNumber());
                    _operations.enqueue(sub(_operations.dequeue(), _operations.dequeue()));
                    break;

                case mult:

                    _operations.enqueue(inputNumber());
                    _operations.enqueue(mult(_operations.dequeue(), _operations.dequeue()));
                    break;

                case div:

                    _operations.enqueue(inputNumber());

                    if (_operations.last() == 0) {

                        System.out.println(_ERRORNULL);
                        break;

                    }

                    _operations.enqueue(div(_operations.dequeue(), _operations.dequeue()));
                    break;

                case deg:

                    _operations.enqueue(inputNumber());
                    _operations.enqueue(deg(_operations.dequeue(), _operations.dequeue()));
                    break;

                case clear:

                    _operations.clear();
                    _operations.enqueue(0D);
                    break;

                case exit:
                    _working = false;
                    break;

                case err:
                default:

                    System.out.println(_ERRORINPUT);

            }

            if (!_working) {

                continue;

            }

            System.out.println("Результат: " + _operations.first());

        }

        System.out.println("Калькулятор закрыт");

    }

    private Double inputNumber() {

        Double result;

        while (_working) {

            System.out.println("Ввод числа: ");

            if (_input.hasNext()) {

                var flag = _input.hasNextDouble();

                if (!flag) {

                    typeOfOperation operation = operatorChoice(_input.next().charAt(0));

                    if (operation == typeOfOperation.exit) {
                        _working = false;
                    }

                    if (operation == typeOfOperation.clear) {
                        result = 0D;
                        return result;
                    }

                    if (_working)

                        System.out.println(_ERRORINPUT);

                    continue;

                }

            }

            result = _input.nextDouble();
            return result;

        }

        return 0D;

    }

    private typeOfOperation operatorChoice() {

        char oper;

        while (_working) {

            System.out.println("Введите оператор: ");

            if (_input.hasNext()) {

                oper = _input.next().charAt(0);

                switch (oper) {

                    case '+':

                        return typeOfOperation.sum;

                    case '-':

                        return typeOfOperation.sub;

                    case '*':

                        return typeOfOperation.mult;

                    case '/':

                        return typeOfOperation.div;

                    case '^':

                        return typeOfOperation.deg;

                    case 'c':
                    case 'C':

                        return typeOfOperation.clear;

                    case 'q':
                    case 'Q':

                        return typeOfOperation.exit;

                    default:

                        _working = false;

                        continue;

                }

            } else {

                System.out.println(_ERRORINPUT);

            }
        }

        return typeOfOperation.err;
    }

    private typeOfOperation operatorChoice(char oper) {

        while (_working) {

            switch (oper) {

                case '+':

                    return typeOfOperation.sum;

                case '-':

                    return typeOfOperation.sub;

                case '*':

                    return typeOfOperation.mult;

                case '/':

                    return typeOfOperation.div;

                case '^':

                    return typeOfOperation.deg;

                case 'c':
                case 'C':

                    return typeOfOperation.clear;

                case 'q':
                case 'Q':

                    return typeOfOperation.exit;

                default:

                    _working = false;

                    continue;

            }

        }

        return typeOfOperation.err;
    }

    private Double sum(double firstValue, double secondValue) {
        return firstValue + secondValue;
    }

    private Double sub(double firstValue, double secondValue) {
        return firstValue - secondValue;
    }

    private Double mult(double firstValue, double secondValue) {
        return firstValue * secondValue;
    }

    private Double div(double firstValue, double secondValue) {
        return firstValue / secondValue;
    }

    private Double deg(double firstValue, double secondValue) {
        if (secondValue == 0)
            return 1D;
        return firstValue * deg(firstValue, secondValue - 1);
    }

    private enum typeOfOperation {
        sum,
        sub,
        mult,
        div,
        deg,
        err,
        exit,
        clear
    }

}