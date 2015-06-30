package com.castrolol.hidra.datatest.helper.core;

/**
 * Created by 'Luan on 29/06/2015.
 */
public interface PropertyDefinition<T> {
    
    void set(T value);

    T get();

}
