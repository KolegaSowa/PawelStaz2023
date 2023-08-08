package org.example.using;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BreakListToValues<T> {

    public void sendToOtherClass(String extended, String path, List<T> listOfObjects, Class<T> classInList) throws Exception {
        Field[] allFieldsInStructure = getAllFieldsInStructure(classInList);

        String[] fieldsName = getFieldsName(classInList, allFieldsInStructure);

        int lengthFieldsValue = getLengthFieldsValue(allFieldsInStructure, listOfObjects);

        String[] fieldsValue = getFieldsValue(listOfObjects, allFieldsInStructure, lengthFieldsValue);

        int sizeOfListWithObject = getSizeOfListWithObject(lengthFieldsValue, fieldsName);


        ChooserObjectsExtractor.getInstance().chooseGenerator(extended, path, allFieldsInStructure, fieldsName, fieldsValue, lengthFieldsValue, sizeOfListWithObject);
    }

    private Field[] getAllFieldsInStructure(Class<?> classInList) {
        Field[] allFieldsInStructure = new Field[0];
        while (classInList != null) {

            Field[] classFields = classInList.getDeclaredFields();
            Field[] combinedFields = new Field[allFieldsInStructure.length + classFields.length];

            System.arraycopy(allFieldsInStructure, 0, combinedFields, 0, allFieldsInStructure.length);
            System.arraycopy(classFields, 0, combinedFields, allFieldsInStructure.length, classFields.length);
            allFieldsInStructure = combinedFields;

            classInList = classInList.getSuperclass();
        }
        return allFieldsInStructure;
    }

    private String[] getFieldsName(Class<?> classInList, Field[] allFieldsInStructure) {
        List<String> fieldsNameList = new ArrayList<>();

        while (classInList != null) {
            Field[] classFields = classInList.getDeclaredFields();
            Field[] combinedFields = new Field[allFieldsInStructure.length + classFields.length];

            System.arraycopy(allFieldsInStructure, 0, combinedFields, 0, allFieldsInStructure.length);
            System.arraycopy(classFields, 0, combinedFields, allFieldsInStructure.length, classFields.length);

            allFieldsInStructure = combinedFields;

            for (Field field : classFields) {
                fieldsNameList.add(field.getName());
            }
            classInList = classInList.getSuperclass();
        }
        String[] fieldsName = new String[fieldsNameList.size()];

        fieldsNameList.toArray(fieldsName);

        return fieldsName;
    }

    private String[] getFieldsValue(List<T> listOfObjects, Field[] allFieldsInStructure, int lengthFieldsValue) throws IllegalAccessException {
        List<Object> list = new ArrayList<>();

        for (T obj : listOfObjects) {
            for (Field field : allFieldsInStructure) {
                field.setAccessible(true);
                Object value = field.get(obj);
                list.add(value);
            }
        }

        String[] fieldsValue = new String[lengthFieldsValue];
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj != null)
                fieldsValue[i] = obj.toString();
        }
        return fieldsValue;
    }

    private Integer getLengthFieldsValue(Field[] allFieldsInStructure, List<T> listOfObject) {
        return allFieldsInStructure.length * listOfObject.size();
    }

    private Integer getSizeOfListWithObject(int lengthFieldsValue, String[] fieldsName) {
        return lengthFieldsValue / fieldsName.length;
    }
}