import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * Файлы настроек
 */
public class PropertiesTest extends Assert {

    /**
     *
     */
    @Test
    public void testShowSystemProperties() {
        System.out.println("Все системные свойства:");
        Properties properties = System.getProperties();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(" " + entry.getKey() + " = " + entry.getValue());
        }
    }

    @Test
    public void testNonExistsingProperty() {
        // Получение несуществующего свойства
        assertNull(System.getProperty("NOT-EXISTING-PROPERTY"));

        String value = System.getProperty("NOT-EXISTING-PROPERTY");
        if (value != null && !value.isEmpty()) {
            fail("Нет такого свойства :)");
        }
    }

    /**
     * Свойства из файла настроек
     * <p>
     * Создать в корне D:
     * a.mydata
     * name     =   ,, Иван Иванович Иванов
     *
     * @throws IOException
     */
    @Test
    public void testConfigProperties() throws IOException {
        //InputStream input = new FileInputStream("D:\\a.mydata");
        String filename = "config.properties";
        InputStream input = getClass().getClassLoader().
                getResourceAsStream(filename);
        if (input == null) {
            System.out.println("Sorry, unable to find " + filename);
            return;
        }

        Properties properties = new Properties();
        properties.load(new InputStreamReader(input, "UTF-8"));
       /* properties.load(
                new InputStreamReader(
                        new FileInputStream("D:/a.mydata"),
                        "UTF-8"));
*/
        Enumeration<?> e = properties.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = properties.getProperty(key);
            System.out.println(key + " = " + value);
        }

        System.out.println("Вывод списке (проще):");
        for (String name : properties.stringPropertyNames()) {
            System.out.println(name + " = " +
                    properties.getProperty(name));
        }
    }
}
