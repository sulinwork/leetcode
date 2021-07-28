package code;

import java.lang.reflect.Field;

public class BeanUtil {

    public static <T, F> F copy(T bean, Class<F> cla) throws IllegalAccessException, InstantiationException {
        F instance = cla.newInstance();
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            try {
                Field targetField = cla.getDeclaredField(declaredField.getName());
                targetField.setAccessible(true);
                targetField.set(instance, declaredField.get(bean));
            } catch (NoSuchFieldException e) {
                continue;
            }
        }
        return instance;
    }
}
