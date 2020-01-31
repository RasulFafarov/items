import org.junit.jupiter.api.Test;
import sun.tools.jstack.JStack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void getItem() throws  ItemException{
        Stack stack = new Stack("Стопка", 5.0,  4.0, 3.0, 2.0, 20);
        Item[] items = new Item[10];
        for (int i=0; i<4; i++){
            items[i] = new Item("Предмет", 5.0, true, 4.0, 3.0, 2.0);
            stack.addItem(items[i]);
        }
        stack.getItem();

        Throwable thrown = assertThrows(ItemException.class, () -> {
            for (int i=0; i<4; i++){
                stack.getItem();
            }
        });
        assertEquals("В мешке больше нет предметов", thrown.getMessage());
    }

    @Test
    void addItem() throws ItemException{
        Stack stack = new Stack("Стопка", 5.0,  4.0, 3.0, 2.0, 26);
        Item[] items = new Item[10];
        for (int i=0; i<4; i++){
            items[i] = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0);
            stack.addItem(items[i]);
        }
        Throwable thrown = assertThrows(ItemException.class, () -> {
            Stack stack1 = new Stack("Стопка", 5.0,  4.0, 3.0, 2.0, 6);
            for (int i=0; i<10; i++){
                items[i] = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0);
                stack1.addItem(items[i]);
            }
        });
        assertEquals("Слишком много предметов в стопке", thrown.getMessage());

        Stack stack2 = new Stack("Стопка", 5.0,  4.0, 3.0, 2.0, 26);
        thrown = assertThrows(ItemException.class, () -> {
            Item item =new Item();
            item.setFlatFlag(false);
            stack2.addItem(item);
        });
        assertEquals("Нельзя положить не плоский предмет в стопку", thrown.getMessage());
        thrown = assertThrows(ItemException.class, () -> {
            Stack stack3 = new Stack();
            Item item = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0);
            stack3.addItem(item);
        });
        assertEquals("Неизвестно максимальное количество предметов в стопке", thrown.getMessage());

    }

    @Test
    void print()  throws ItemException {
        Stack stack = new Stack("Стопка", 5.0,  4.0, 3.0, 2.0, 26);
        stack.print();

    }
}