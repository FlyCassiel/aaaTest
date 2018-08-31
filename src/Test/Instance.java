package Test;

import java.io.Serializable;

/**
 * 序列化单例对象
 */
public class Instance implements Serializable {
    
    private static final Instance obj = new Instance();

    public Instance() {
    }
   public static Instance getInstance() {
       return obj;
    }
    private Object readResolve(){
        return obj;
    }
}
