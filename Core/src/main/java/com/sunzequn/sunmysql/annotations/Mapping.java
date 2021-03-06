package com.sunzequn.sunmysql.annotations;

import com.sunzequn.sunmysql.bean.Entity;
import com.sunzequn.sunmysql.bean.Property;
import com.sunzequn.sunmysql.exception.AnnotationException;
import com.sunzequn.sunmysql.utils.StringUtil;

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
 * The class for getting the the wrapper of a entity by resolving it`s annotations.
 */
public class Mapping<T> {

    /**
     * Get the the wrapper of a entity by resolving it`s annotations.
     * It`s allowable if a property has no annotation
     * and the property`s name is the default name of it`s corresponding column.
     *
     * @param t A entity.
     * @return the wrapper of the entity.
     */
    public Entity mapping(T t) {

        Entity entity = new Entity();
        List<Property> propertyList = new ArrayList<>();
        Class clazz = t.getClass();

        try {
            if (clazz.isAnnotationPresent(Table.class)) {
                Table table = (Table) clazz.getAnnotation(Table.class);
                entity.setTable(table.name());
            } else {
                throw new AnnotationException("No Table annotation found in the class:" + clazz + ".");
            }

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                Property property = new Property();
                String columnName = null;
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    columnName = column.name();
                }
                if (StringUtil.isEmpty(columnName)) {
                    columnName = field.getName();
                }
                property.setColumn(columnName);
                property.setProperty(field.getName());
                property.setValue(getFieldValue(t, field.getName()));
                propertyList.add(property);
            }

            if (propertyList.size() > 0) {
                entity.setPropertyList(propertyList);
            } else {
                throw new AnnotationException("The class:" + clazz + " must have fields.");
            }

        } catch (AnnotationException e) {
            e.printStackTrace();
        }
        return entity;
    }

    /**
     * Get the value of a property by it`s name.
     *
     * @param t         The object from which we retrieve values.
     * @param fieldName The name of the property.
     * @return the value of the property.
     */
    public Object getFieldValue(T t, String fieldName) {
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, t.getClass());
            Method method = propertyDescriptor.getReadMethod();
            if (method == null) {
                throw new RuntimeException("No read method for bean property "
                        + t.getClass() + " " + fieldName);
            }
            return method.invoke(t, new Object[]{});
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
