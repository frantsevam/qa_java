package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline mockFeline;

    @Test
    public void getKittens() throws Exception {

        Lion lion = new Lion("Самец", mockFeline);
        Mockito.when(mockFeline.getKittens()).thenReturn(3);
        int result = lion.getKittens();
        Assert.assertEquals("Не соответствует ожидаемому результату!",3, result);
    }

    @Test
    public void doesHaveManeMale() throws Exception {

        Lion lion = new Lion("Самец", mockFeline);
        boolean result = lion.doesHaveMane();
        Assert.assertEquals("Не соответствует ожидаемому результату!",true, result);
    }

    @Test
    public void doesHaveManeFemale() throws Exception {

        Lion lion = new Lion("Самка", mockFeline);
        boolean result = lion.doesHaveMane();
        Assert.assertEquals("Не соответствует ожидаемому результату!",false, result);
    }

    @Test
    public void getFood() throws Exception {

        Lion lion = new Lion("Самец", mockFeline);
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(List.of("Мясо"));
        List<String> result = lion.getFood();
        Assert.assertEquals("Не соответствует ожидаемому результату!",List.of("Мясо"), result);
    }

    @Test
    public void incorrectGenderException() throws Exception {

        String expected = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = null;
        try {
            Lion lion = new Lion("Лев", mockFeline);
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals(expected, exception.getMessage());

    }
}
