package com.melsheikh.hotelreservation.helpers;

public class EnumHelper {
    public EnumHelper() {}

    public static <T extends Enum<T>> T getEnumConstant(Class<T> enumClass, int ordinal) {
        T[] enumConstants = enumClass.getEnumConstants();
        if (ordinal < 0 || ordinal >= enumConstants.length) {
            throw new IllegalArgumentException("Invalid ordinal for " + enumClass.getSimpleName());
        }

        return enumConstants[ordinal];
    }
}
