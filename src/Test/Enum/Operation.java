package Test.Enum;

public enum Operation{
    PLUS{
        double apply(double x, double y){
            return x + y;
        }
    },
    MINUS {
        double apply(double x, double y){
            return x - y;
        }
    },
    TIMES{
        double apply(double x, double y){
            return x * y;
        }
    },
    DIVIDE{
        double apply(double x, double y){
            return x / y;
        }
    };
    abstract double apply(double x, double y);

    public static void main(String[] args){
        double x = 1.1;
        double y = 1.2;
        double plusResult = Operation.PLUS.apply(x, y);
        System.out.println(plusResult);
    }
}
