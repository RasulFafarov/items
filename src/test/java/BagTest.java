import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void setMaxWeight() throws ItemException {
        Bag bag = new Bag();
        bag.setMaxWeight(5.5);
        assertEquals( (Double)5.5, bag.getMaxWeight());
        Throwable thrown = assertThrows(ItemException.class, () -> {
            bag.setMaxWeight(-5.5);
        });
        assertNotNull(thrown.getMessage());
        thrown = assertThrows(ItemException.class, () -> {
            bag.setMaxWeight(0.0);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void getMaxWeight() throws ItemException {
        Bag bag = new Bag("Предмет", 5.0, true,  4.0, 3.0, 2.0, 5.4 );
        assertEquals( (Double)5.4, bag.getMaxWeight());


    }

    @Test
    void getItem() throws ItemException {
        Bag bag = new Bag("Мешок", 5.0, true,  4.0, 3.0, 2.0, 50.0);
        Item[] items = new Item[10];
        for (int i=0; i<4; i++){
            items[i] = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0);
            bag.addItem(items[i]);
        }
        bag.getItem();

        Throwable thrown = assertThrows(ItemException.class, () -> {
           for (int i=0; i<4; i++){
                bag.getItem();
            }
        });
        assertEquals("В мешке больше нет предметов", thrown.getMessage());
    }


    @Test
    void addItem() throws ItemException {
        Bag bag = new Bag("Мешок", 5.0, true,  4.0, 3.0, 2.0, 26.0);
        Item[] items = new Item[10];
        for (int i=0; i<4; i++){
            items[i] = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0);
            bag.addItem(items[i]);
        }
        Throwable thrown = assertThrows(ItemException.class, () -> {
            Bag bag2 = new Bag("Мешок", 5.0, true,  4.0, 3.0, 2.0, 26.0);
            for (int i=0; i<10; i++){
                items[i] = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0);
                bag2.addItem(items[i]);
            }
        });
        assertEquals("Превышение веса в мешке", thrown.getMessage());

        Bag bag2 = new Bag("Мешок", 5.0, true,  4.0, 3.0, 2.0, 26.0);
        thrown = assertThrows(ItemException.class, () -> {
            Item item =new Item();
            bag.addItem(item);
        });
        assertEquals("Нельзя положить в мешок предмет без веса", thrown.getMessage());
        thrown = assertThrows(ItemException.class, () -> {
            Bag bag3 = new Bag();
            Item item = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0);
            bag3.addItem(item);
        });
        assertEquals("Неизвестен максимальный или текущий вес мешка", thrown.getMessage());

    }




    @Test
    void print() throws  Exception {
        Bag bag = new Bag("Мешок", 5.0, true,  4.0, 3.0, 2.0, 5.4 );
        bag.print();
    }

}