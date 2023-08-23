import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Product>list = new ArrayList<>();
    private int person = 0;
    Calculator(int person){
        this.person = person;
    }

    public List<Product> getList() {
        return list;
    }
    public void add(Product product){
        list.add(product);
    }
    public double sum(){
        double sum = 0.0;
        for(Product p : list){
            sum += p.getPrice();
        }
        return ((double)Math.round(sum * 100)) / 100;
    }
    public double calcPastPay(){
        if(this.person > 0)
            return ((double)Math.round(sum() / this.person * 100)) / 100;
        else
            return 0.0;
    }
    public void printCheck(){
        for(Product p: getList()){
            System.out.println(p.toString());
        }
    }
    public String rubRightWrite(double sum){
        int dec = (((int) sum) / 10) % 10;
        if(dec == 1){
            return "рублей";
        }else {
            int delta = ((int) sum) % 10;
            switch (delta) {
                case 1:
                    return "рубль";
                case 2:
                case 3:
                case 4:
                    return "рубля";
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return "рублей";
            }
        }
        return "руб.";
    }
}
