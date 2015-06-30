package com.castrolol.hidra.datatest.helper.core;

/**
 * Created by 'Luan on 29/06/2015.
 */
public class Property<T> extends QueryField {

    private PropertyDefinition<T> property;

    Property(){
        this((T)null);
    }

    Property(T defaultValue){
        this(new DefaultPropertyDefinition<T>(), defaultValue);
    }

    Property(PropertyDefinition<T> definition){
        this(definition, null);
    }

    Property(PropertyDefinition<T> definition, T defaultValue){
        property = definition;
        if(defaultValue != null) {
            property.set(defaultValue);
        }
    }

    public T get(){
        return property.get();
    }

    public void set(T value){
        property.set(value);
    }

}

 class DefaultPropertyDefinition<T> implements PropertyDefinition<T> {

     private T value;

     @Override
     public void set(T value) {
        this.value = value;
     }

     @Override
     public T get() {
         return value;
     }
 }