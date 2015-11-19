package com.sunzequn.sunmysql.annotations.mapper;

import com.sunzequn.sunmysql.annotations.Column;
import com.sunzequn.sunmysql.annotations.Table;
import com.sunzequn.sunmysql.exception.AnnotationException;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sloriac on 15/11/18.
 * <p>
 * Get the EntityWrapper of a Entity by resolving it`s annotations.
 */
public class Mapping<T> {

    /**
     * Get the EntityWrapper of a Entity by resolving it`s annotations.
     *
     * @param t A entity.
     * @return the EntityWrapper of the Entity.
     */
    public EntityWrapper mapping(T t) {

        EntityWrapper entityWrapper = new EntityWrapper();
        List<PropertyWrapper> propertyWrapperList = new ArrayList<>();
        Class clazz = t.getClass();

        try {
            if (clazz.isAnnotationPresent(Table.class)) {
                Table table = (Table) clazz.getAnnotation(Table.class);
                entityWrapper.setTable(table.name());
            } else {
                throw new AnnotationException("No Table annotation found in the class:" + clazz + ".");
            }

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    PropertyWrapper propertyWrapper = new PropertyWrapper();
                    propertyWrapper.setColumn(column.name());
                    propertyWrapper.setProperty(field.getName());
                    propertyWrapper.setValue(String.valueOf(getFieldValue(t, field.getName())));
                    propertyWrapperList.add(propertyWrapper);
                }
            }

            if (propertyWrapperList.size() > 0) {
                entityWrapper.setPropertyWrapperList(propertyWrapperList);
            } else {
                throw new AnnotationException("The class:" + clazz + " must have fields annotated by @Column.");
            }

        } catch (AnnotationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get the value of a property by it`s name.
     * @param t The object from which we retrieve values.
     * @param fieldName The name of the property.
     * @return the value of the property.
     */
    public Object getFieldValue(T t, String fieldName) {
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, t.getClass());
            Method method = propertyDescriptor.getReadMethod();
            Object value = method.invoke(t, new Object[]{});
            return value;
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
