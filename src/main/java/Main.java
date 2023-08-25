import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("На сколько персон необходимо поделить счет: ");
        Scanner scanner = new Scanner(System.in);
        int countPerson = 0;

        Calculator calc = null;

        countPerson = scanner.hasNextInt() ? scanner.nextInt() : 0;
        if (countPerson <= 0){
            System.out.println("Количество человек не может быть отрицательным или равным нулю! Либо введено слишком большое число!");
        }else if(countPerson == 1){
            System.out.println("Нет смысла в работе программы при количестве персон равном 0");
        }else {
            System.out.println("Вы планируете разделить счета на "+countPerson+" чел.");
            calc = new Calculator(countPerson);
            buildCheck(calc);

            System.out.println("Итоговый чек: ");
            calc.printCheck();
            System.out.println("К оплате итого: "+calc.sum()+" "+calc.rubRightWrite(calc.sum()));
            System.out.println("В том числе с каждого члена команды "+calc.calcPastPay()+" "+calc.rubRightWrite(calc.calcPastPay()));
        }

    }
    public static void buildCheck(Calculator calc){
        String next = "" ;
        double price ;
        Scanner scanner = new Scanner(System.in);
        while(!next.equals("завершить")){
            System.out.println("Введите наименование товара: ");
            System.out.print("-> ");
            String tmp = scanner.next();

            boolean check = false;
            String strPrice = "";
            while (!check) {
                System.out.println("Стоимость:");
                System.out.print("-> ");
                strPrice = scanner.next();
                check = verifyDouble(strPrice);
                if(!check){
                    System.out.println("Не правильный ввод. Поробуйте еще.");
                }
            }
            price = Double.parseDouble(strPrice);
            calc.add(new Product(tmp,price));
            System.out.println("Добавить еще товар? Да: любой символ + Enter, Закончить ввод: Завершить + Enter");
            next = (scanner.next().toLowerCase());
        }
    }


    public static boolean verifyDouble(String str){
        boolean rez = false;
        char[] chArr = str.toCharArray();
        int countPoint = 0;
        for(char i: chArr){
            if(Character.isDigit(i)){
                rez = true;
            }else if(i == '.'){
                countPoint++;
            }else{
                rez = false;
                return rez;
            }
        }
        if(countPoint > 1){
            rez = false;
        }
        return rez;
    }

}