package com.kojstarinnovations.repository.infraestructure.output.persistence.repository.impl;

import lombok.NonNull;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReflectionUtils {

    public static List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while (clazz != null) {
            Collections.addAll(fields, clazz.getDeclaredFields());
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    public static Field getField(Class<?> clazz, String fieldName) {
        while (clazz != null) {
            try {
                return clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        return null;
    }

    @SneakyThrows
    public static <T> T getObjectFromResultSet(ResultSet resultSet, Class<T> clazz)  {
        T object = clazz.getDeclaredConstructor().newInstance();
        List<Field> fields = getAllFields(clazz);
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = toSnakeCase(field.getName());
            try {
                if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {
                    field.set(object, resultSet.getInt(fieldName));
                } else if (field.getType().equals(Long.class) || field.getType().equals(long.class)) {
                    field.set(object, resultSet.getLong(fieldName));
                } else if (field.getType().equals(Double.class) || field.getType().equals(double.class)) {
                    field.set(object, resultSet.getDouble(fieldName));
                } else if (field.getType().equals(Float.class) || field.getType().equals(float.class)) {
                    field.set(object, resultSet.getFloat(fieldName));
                } else if (field.getType().equals(Boolean.class) || field.getType().equals(boolean.class)) {
                    field.set(object, resultSet.getBoolean(fieldName));
                } else if (field.getType().equals(String.class)) {
                    field.set(object, resultSet.getString(fieldName));
                } else if (field.getType().equals(LocalDate.class)) {
                    field.set(object, resultSet.getDate(fieldName).toLocalDate());
                } else if (field.getType().equals(LocalDateTime.class)) {
                    field.set(object, resultSet.getTimestamp(fieldName).toLocalDateTime());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    static String toSnakeCase(@NonNull String input) {
        StringBuilder result = new StringBuilder();
        boolean isFirstChar = true;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                if (!isFirstChar) {
                    result.append("_");
                }
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
            isFirstChar = false;
        }
        return result.toString();
    }

    public static String getMethodName() {

        // Verficamos que exista
        if (Thread.currentThread().getStackTrace().length>2) {
            return Thread.currentThread().getStackTrace()[2].getMethodName();
        } else {
            return "undefined";
        }
    }
}
