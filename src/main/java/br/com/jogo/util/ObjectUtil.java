package br.com.jogo.util;

public final class ObjectUtil {
    public static boolean isValidObject (Object o) {
        return o != null;
    }

    public static boolean isValidString (String s) {
        return isValidObject(s) && !"".equals(s);
    }

    public static boolean isValidNumber(Number n) {
        return isValidObject(n) && n.doubleValue() > 0;
    }
}
