package Saving2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Calculator {
    public static void main(String[] args) {
        Main main = new Main();
        main.starting();

    }
    public void starting() {
        boolean exit = false;
        while (!exit) {
            try {
                Scanner sc = new Scanner(System.in); {
                    System.out.println("지금부터 연산을 시작하겠습니다. 연산을 중단하려면 exit," +
                            "\n계속하려면 exit을 제외한 아무거나 치고 enter를 누르세요.");
                    String exit_str = sc.nextLine();
                    if (exit_str.equals("exit")) {
                        System.out.println("연산이 종료됩니다.");
                        exit = true;
                        break;
                            }
                    System.out.println("연산할 첫 번째 숫자와 연산자, 두 번째 숫자를 차례로 입력하세요. \n이때 숫자는 모두 양의 정수여야 합니다. \n첫 번째 숫자 :");
                    int firstNumber = sc.nextInt();
                    System.out.println("연산자 : ");
                    String operator = sc.next();
                    System.out.println("두 번째 숫자 : ");
                    int secondNumber = sc.nextInt();
                    super.calculate(firstNumber, operator, secondNumber);
                    getAnswerL();
                }
            }catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 정확하게 입력해주세요");
            }
        }
    }



}
