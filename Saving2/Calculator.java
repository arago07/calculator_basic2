package Saving2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
        private ArrayList<Object> answerL = new ArrayList<>();

    public void setAnswerL(double answer) {
        answerL.add(answer);
    }
    public void getAnswerL() {
        boolean exit1 = false;
        while (!exit1) {
            System.out.println("저장된 연산 결과 : " + answerL);
            System.out.println("저장된 값들 중 첫 번째 값을 지우시겠습니까? Y or N");
            Scanner erase = new Scanner(System.in);
            String erasor = erase.next();
            try {
                if (erasor.equals("Y")) {
                    answerL.remove(0);
                    exit1 = true;
                    break;
                }
                else if (erasor.equals("N")) {
                    System.out.println("그대로 진행합니다.");
                    exit1 = true;
                    break;
                }
                else {
                    System.out.println("잘못 입력하셨습니다. Y or N 둘 중 하나로 다시 입력하세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다. 문자를 입력해 주세요.");
            }

        }
    }
        public void calculate(int firstNumber, String operator,int secondNumber) {
            if (firstNumber >= 0 && secondNumber >= 0) {
                double answer = 0;
                switch (operator) {
                    case "+":
                        answer = firstNumber + secondNumber;
                        setAnswerL(answer);
                        break;
                    case "-":
                        answer = firstNumber - secondNumber;
                        setAnswerL(answer);
                        break;
                    case "*":
                        answer = firstNumber * secondNumber;
                        setAnswerL(answer);
                        break;
                    case "/":
                        if (secondNumber != 0) {
                            answer = (double) firstNumber / secondNumber;
                            setAnswerL(answer);
                        } else {
                            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                            calculate(firstNumber, operator, secondNumber);
                        }
                        break;
                    case "%":
                        if (secondNumber != 0) {
                            answer = firstNumber % secondNumber;
                            setAnswerL(answer);
                        } else {
                            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                            calculate(firstNumber, operator, secondNumber);
                        }
                        break;
                    default:
                        System.out.println("잘못된 입력. 연산자를 넣어주세요");
                        calculate(firstNumber, operator, secondNumber);

                }
                System.out.println("결과값 : " + answer);
            } else {
                System.out.println("양의 정수를 입력해주세요.");
                calculate(firstNumber, operator, secondNumber);
            }
        }
    }