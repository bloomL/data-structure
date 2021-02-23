package leetcodewrite.circulardependency;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : liguo
 * @Description : 循环依赖
 * @data : 2020/12/16
 */
public class Demo {

    /**
     * key: className
     * value: object instance
     */
    static Map<String, Object> nameMappingObjectInstance = new HashMap<>();

    public static void main(String[] args) throws Exception {
        A a = new A();
        B b = new B();
        a.innerB = b;
        b.innerA = a;
        A bean = getBean(A.class);
        System.out.println("循环依赖");
    }

    /**
     * 获取对象实例
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T getBean(Class<T> clazz) throws Exception{
        String className = clazz.getName();
        // 容器中直接获取
        if (nameMappingObjectInstance.containsKey(className)) {
            return (T) nameMappingObjectInstance.get(className);
        }
        // 容器中不存在，手动创建
        // 无参构造创建
        T objectInstance = clazz.getDeclaredConstructor().newInstance();
        nameMappingObjectInstance.put(className,objectInstance);
        // 设置对象数据
        setProperty(objectInstance);
        return objectInstance;
    }

    /**
     * 设置属性
     * @param objectInstance
     * @param <T>
     * @throws Exception
     */
    private static <T> void setProperty(T objectInstance) throws Exception{
        Field[] Fields = objectInstance.getClass().getDeclaredFields();
        for (Field field: Fields) {
            field.setAccessible(true);
            // 属性类型
            Class<?> fieldType = field.getType();
            String fieldName = field.getName();
            Object cache = nameMappingObjectInstance.get(fieldName);
            if (cache != null) {
                field.set(objectInstance,cache);
            }else {
                // 手动创建
                Object bean = getBean(fieldType);
                field.set(objectInstance,bean);
            }
        }
    }

}

class A {
    public B innerB;
}

class B {
    public A innerA;
}
