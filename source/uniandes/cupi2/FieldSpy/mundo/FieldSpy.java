package uniandes.cupi2.FieldSpy.mundo;

import java.lang.reflect.Field;
import java.util.List;

public class FieldSpy<T> {
	static boolean[][] b = {{ false, false }, { true, true } };
	static boolean bool = true;
    static String name  = "Alice";
    static List<Integer> list;

	static Object a[] = { b, bool, name, list };

	public static void main(String... args) {
		try {
			Class<?> c = Class.forName(a);
	    Field f = c.getField(args[1]);
	    System.out.format("Type: %s%n", f.getType());
	    System.out.format("GenericType: %s%n", f.getGenericType());

        // production code should handle these exceptions more gracefully
	} catch (ClassNotFoundException x) {
	    x.printStackTrace();
	} catch (NoSuchFieldException x) {
	    x.printStackTrace();
	}
    }
}