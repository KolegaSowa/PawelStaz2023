package org.example.using;

import org.example.interfaces.Extractor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ListsWithValues<T> {

    public void sendValues(String extended, String path, List<T> listOfObjects, Class<T> classInList) throws Exception {
        List<Field> allFieldsInStructure = getAllFieldsInStructure(classInList);

        List<String> listOfName = getFieldName(classInList, allFieldsInStructure);

        List<String> listOfValue = getFieldsValue(listOfObjects, allFieldsInStructure);

        Extractor extractor = ProviderValuesToWrite.getInstance().chooseGenerator(extended);
        extractor.extract(path, listOfName, listOfValue);
    }

    private List<Field> getAllFieldsInStructure(Class<?> classInList) {
        List<Field> allFieldsInStructure = new ArrayList<>();
        while (classInList != null) {

            Field[] classFields = classInList.getDeclaredFields();
            List<Field> combinedListWithFields = new ArrayList<>(allFieldsInStructure);
            combinedListWithFields.addAll(List.of(classFields));
            allFieldsInStructure = combinedListWithFields;

            classInList = classInList.getSuperclass();
        }
        return allFieldsInStructure;
    }

    private List<String> getFieldName(Class<?> classInList, List<Field> allFieldsInStructure) {
        List<String> fieldsNameList = new ArrayList<>();

        while (classInList != null) {
            Field[] classFields = classInList.getDeclaredFields();
            List<Field> combinedFields = new ArrayList<>(allFieldsInStructure);
            combinedFields.addAll(List.of(classFields));
            allFieldsInStructure = combinedFields;

            for (Field field : classFields) {
                fieldsNameList.add(field.getName());
            }
            classInList = classInList.getSuperclass();
        }
        return fieldsNameList;
    }

    private List<String> getFieldsValue(List<T> listOfObjects, List<Field> allFieldsInStructure) throws IllegalAccessException {
        List<String> fieldsValue = new ArrayList<>();

        for (T obj : listOfObjects) {
            for (Field field : allFieldsInStructure) {
                field.setAccessible(true);
                Object value = field.get(obj);
                fieldsValue.add(value != null ? value.toString() : null);
            }
        }
        return fieldsValue;
    }
}