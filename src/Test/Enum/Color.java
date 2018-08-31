package Test.Enum;

public enum Color {
    RED,GREEN,BLUE;

    public static void main(String[] args){
        Color color = RED;
        int counter = 10;
        while (counter-- > 0)
            switch (color){
                case RED:
                    System.out.println("Red");
                    color = BLUE;
                    break;
                case BLUE:
                    System.out.println("Blue");
                    color = GREEN;
                    break;
                case GREEN:
                    System.out.println("Green");
                    color = RED;
                    break;
            }
    }
}
