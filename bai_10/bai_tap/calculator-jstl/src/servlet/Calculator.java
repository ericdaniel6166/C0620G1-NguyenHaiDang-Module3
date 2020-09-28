package servlet;

public class Calculator {
//    public static float calculate(float firstOperand, float secondOperand, char operator ){
//        switch (operator){
//            case '+':
//                return firstOperand + secondOperand;
//            case '-':
//                return firstOperand - secondOperand;
//            case '*':
//                return firstOperand * secondOperand;
//            case '/':
//                if(secondOperand != 0)
//                    return firstOperand / secondOperand;
//                else
//                    throw new RuntimeException("Can't divide by zero");
//            default:
//                throw new RuntimeException("Invalid operation");
//        }
//    }

//    dùng String cho operator

    public static float calculate(float firstOperand, float secondOperand, String operator ){
        switch (operator){
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
//                if(secondOperand != 0)
//                    return firstOperand / secondOperand;
//                else
//                    throw new RuntimeException("Can't divide by zero");
                return firstOperand / secondOperand;
//                chia cho 0
//                0 chia 0 là NaN
//                các số khác chia 0 là Infinity

            default:
                throw new RuntimeException("Invalid operation");

        }
    }
}
