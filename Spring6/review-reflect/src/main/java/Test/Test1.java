package Test;

import bean.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //利用反射机制给user里的age赋值
        /*
        需求：
        假设你现在己知以下信息：
        1.有这样一个类，类名叫做：bean.User
        2.这个类符合javabean规范。属性私有化，对外提供公开setter和getter方法。
        3.你还知道这个类当中有一个属性，属性的名字叫做age
         */

        String classpath="bean.User";
        String propertyName= "age";
        Class<?> clazz = Class.forName(classpath);

        Field filed = clazz.getDeclaredField(propertyName);

        String methodName="set"+propertyName.toUpperCase().charAt(0)+ propertyName.substring(1);
        System.out.println(methodName);

        Method age = clazz.getDeclaredMethod(methodName, filed.getType());
        Object obj = clazz.newInstance();
        age.invoke(obj, 12);

        System.out.println(obj);


    }
}
