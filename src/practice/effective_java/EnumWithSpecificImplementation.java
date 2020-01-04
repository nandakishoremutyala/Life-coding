package practice.effective_java;

public class EnumWithSpecificImplementation {
    enum Operation {
        PLUS {
            double apply(double x, double y) {
                return x + y;
            }
        },

        MINNUS {
            double apply(double x, double y) {
                return x - y;
            }
        },

        TIMES {
            double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE {
            double apply(double x, double y) {
                return x / y;
            }
        };

        abstract double apply(double x, double y);
    }

    public static void main(String[] args) {
        double result= Operation.DIVIDE.apply(10,5);
        System.out.println(result);
    }
}
