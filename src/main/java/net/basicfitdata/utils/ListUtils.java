package net.basicfitdata.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListUtils{

    public static  <T> List<T> iteratorToList(Iterator<T> iterator){
        final List<T> list = new ArrayList<T>();
        iterator.forEachRemaining(list::add);
        return list;
    }

}
