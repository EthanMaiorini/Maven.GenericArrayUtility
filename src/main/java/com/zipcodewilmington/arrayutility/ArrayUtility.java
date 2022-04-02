package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<ObjectType> {

    public ObjectType[] intArray;


    public ArrayUtility(ObjectType[] intArray) {
        this.intArray = Arrays.copyOf(intArray,intArray.length);
    }

    public Integer getNumberOfOccurrences(Object objectToCount) {
        int count = 0;
        for(ObjectType s:this.intArray){
            if(s.equals(objectToCount)){
                count++;
            }
        }
        return count;
    }

    public ObjectType[] removeValue( Object objectToRemove) {
        int count = getNumberOfOccurrences(objectToRemove);
        ObjectType[] newArr = Arrays.copyOf(intArray,intArray.length-count);
        int x = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (!(intArray[i].equals(objectToRemove))) {
                newArr[x] = intArray[i];
                x++;
            }
        }
        return newArr;
    }

    public ObjectType getMostCommonFromMerge(ObjectType[] arrayToMerge) {
        int count = 0;
        int maxCount =0;
        ObjectType mostCommon = null;
           ObjectType[] newArr = mergeArrays(intArray,arrayToMerge);
           for(int x =0; x<newArr.length;x++){
               count = getNumberOfOccurrences(newArr[x]);
               if(count>maxCount){
                   mostCommon = newArr[x];
                   maxCount = count;
               }
           }
           return mostCommon;
    }

    public ObjectType[] mergeArrays(ObjectType[] objectArray, ObjectType[] objectArrayToAdd) {
        int size = objectArray.length + objectArrayToAdd.length;
        ObjectType[] mergedArray = Arrays.copyOf(objectArray,size);
        int curr =0;
        for(int x=0;x<objectArray.length;x++){
            mergedArray[curr] =objectArray[x];
            curr++;
        }
        for(int x=0;x<objectArrayToAdd.length;x++){
            mergedArray[curr] = objectArrayToAdd[x];
            curr++;
        }
        return mergedArray;
    }

}
