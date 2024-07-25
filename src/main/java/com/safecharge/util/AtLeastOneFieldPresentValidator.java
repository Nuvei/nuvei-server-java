package com.safecharge.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AtLeastOneFieldPresentValidator implements ConstraintValidator<AtLeastOneFieldPresent, Object> {

    private String[] fieldNames;

    @Override
    public void initialize(AtLeastOneFieldPresent constraintAnnotation) {
        this.fieldNames = constraintAnnotation.fields();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            for (String fieldName : fieldNames) {
                Object fieldValue = getFieldValue(value, fieldName);
                if (fieldValue != null) {
                    if (fieldValue instanceof String) {
                        if (!((String) fieldValue).isEmpty()) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            //not stopping the request in case there is a bug here
            return true;
        }
    }

    private Object getFieldValue(Object object, String fieldName) throws Exception {
        Class<?> clazz = object.getClass();

        // Try to find a getter method for the field
        Method getter = findGetter(clazz, fieldName);
        if (getter != null) {
            return getter.invoke(object);
        }

        // Try to find the field in the class hierarchy
        Field field = findField(clazz, fieldName);
        if (field != null) {
            field.setAccessible(true);
            return field.get(object);
        }

        return null;
    }

    private Method findGetter(Class<?> clazz, String fieldName) {
        String capitalizedFieldName = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
        String getterName = "get" + capitalizedFieldName;
        String booleanGetterName = "is" + capitalizedFieldName;
        try {
            return clazz.getMethod(getterName);
        } catch (NoSuchMethodException e) {
            // Try boolean getter
            try {
                return clazz.getMethod(booleanGetterName);
            } catch (NoSuchMethodException ignored) {
                // No getter found
            }
        }
        return null;
    }

    private Field findField(Class<?> clazz, String fieldName) {
        while (clazz != null) {
            try {
                return clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        return null;
    }
}
