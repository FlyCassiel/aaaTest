package Test;

import java.util.Objects;

public class Apple {
    private String color;

    public Apple(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Objects.equals(color, apple.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(color);
    }
}
