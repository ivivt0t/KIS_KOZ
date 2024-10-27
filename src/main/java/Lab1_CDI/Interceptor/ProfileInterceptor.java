package Lab1_CDI.Interceptor;

import lombok.NoArgsConstructor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@NoArgsConstructor
public class ProfileInterceptor {

    @AroundInvoke
    public Object profile(InvocationContext ic) throws Exception {
        long initTime = System.currentTimeMillis(); // Начальное время в миллисекундах
        Object result;

        try {
            result = ic.proceed(); // Выполнение метода
        } finally {
            long diffTime = System.currentTimeMillis() - initTime; // Разница времени в миллисекундах
            System.out.println(ic.getMethod() + " took " + diffTime + " ms"); // Вывод в миллисекундах
        }

        return result; // Возврат результата метода
    }
}
