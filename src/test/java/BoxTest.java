import org.junit.jupiter.api.Test;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;


class BoxTest {

    @Test
    void getFreeVolume() throws ItemException{
        Box box = new Box("Коробка", 5.0, true, 4.0, 3.0, 2.0, 26.0);
        assertEquals((Double)24.0, box.getFreeVolume());

    }

    @Test
    void getMaxVolume()  throws ItemException{
        Box box = new Box("Коробка", 5.0, true, 4.0, 3.0, 2.0, 26.0);
        assertEquals((Double)26.0, box.getMaxVolume());

    }

    @Test
    void setMaxVolume() throws ItemException{
        Box box = new Box();
        box.setMaxVolume(5.0);
        assertEquals((Double)5.0, box.getMaxVolume());

        Throwable thrown = assertThrows(ItemException.class, () -> {
            box.setMaxVolume(-5.0);

        });
        assertEquals("Предмет не может иметь не положительное значение характеристик", thrown.getMessage());
    }

    @Test
    void addItem() throws ItemException{
        Box box = new Box("Коробка", 5.0, true,  4.0, 30.0, 2.0, 26.0);
        Item[] items = new Item[10];
        for (int i=0; i<4; i++){
            items[i] = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0);
            box.addItem(items[i]);
        }
        Throwable thrown = assertThrows(ItemException.class, () -> {
            Box box1 = new Box("Коробка", 5.0, true,  4.0, 3.0, 2.0, 26.0);
            for (int i=0; i<10; i++){
                items[i] = new Item("Предмет", 5.0, true,  5.0, 3.0, 2.0);
                box1.addItem(items[i]);
            }
        });
        assertEquals("Предмет слишком большой для этой коробки", thrown.getMessage());

        Box box2 = new Box("Коробка", 5.0, true,  4.0, 3.0, 2.0, 26.0);
        thrown = assertThrows(ItemException.class, () -> {
            Item item =new Item();
            item.setFlatFlag(false);
            box2.addItem(item);
        });
        assertEquals("Не известна ширина высота или длина предмета", thrown.getMessage());
        thrown = assertThrows(ItemException.class, () -> {
            Box box3 = new Box();
            Item item = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0);
            box3.addItem(item);
        });
        assertEquals("Не известна ширина высота или длина коробки", thrown.getMessage());

    }

    @Test
    void print()  throws ItemException{
        Box box = new Box("Коробка", 5.0, true, 4.0, 3.0, 2.0, 26.0);
        box.print();
    }
}