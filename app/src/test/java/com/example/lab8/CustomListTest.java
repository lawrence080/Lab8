package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        list.addCity(mockCity());
        return list;
    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity(){
        CustomList cityList = MockCityList();
        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    void testDelete(){
        CustomList cityList = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.addCity(city);
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
        assertThrows( IllegalArgumentException.class, () -> {
            cityList.delete(city); });
    }

    @Test
    void testCountCity(){
        CustomList cityList = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(city);
        assertEquals(2,cityList.countCities());
    }


}
