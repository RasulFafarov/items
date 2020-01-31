import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
  
    @Test
    public void check() throws ItemException {
        Item item = new Item();
        Throwable thrown = assertThrows(ItemException.class, () -> {
            item.check(-5.5);
        });
        assertNotNull(thrown.getMessage());
        thrown = assertThrows(ItemException.class, () -> {
            item.check(0.0);
        });
        assertNotNull(thrown.getMessage());
        item.check(1.22);



    }

    @Test
    public void getPlacedFlag() {
        Item item = new Item();
        assertEquals( false, item.getPlacedFlag());
        item.setPlacedFlag(true);
        assertEquals( true, item.getPlacedFlag());

    }

    @Test
    public void setPlacedFlag() {
        Item item = new Item();
        item.setPlacedFlag(true);
        assertEquals( true, item.getPlacedFlag());
        item.setPlacedFlag(false);
        assertEquals( false, item.getPlacedFlag());
    }

    @Test
    public void getName() throws ItemException {
        Item item1 = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0 );
        assertEquals( "Предмет", item1.getName());
    }

    @Test
    public void setName() {
        Item item = new Item();
        item.setName("Предмет");
        assertEquals( "Предмет", item.getName());

    }

    @Test
    public void getWeight() throws ItemException {
        Item item1 = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0 );
        assertEquals( (Double)5.0, item1.getWeight());
    }

    @Test
    public void setWeight()  throws ItemException{
        Item item = new Item();
        item.setWeight(5.5);
        assertEquals( (Double)5.5, item.getWeight());
        Throwable thrown = assertThrows(ItemException.class, () -> {
            item.setWeight(-5.5);
        });
        assertNotNull(thrown.getMessage());
        thrown = assertThrows(ItemException.class, () -> {
            item.setWeight(0.0);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    public void getFlatFlag() throws ItemException {
        Item item1 = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0 );
        assertEquals( true, item1.getFlatFlag());
        Item item2 = new Item("Предмет", 5.0, false,  4.0, 3.0, 2.0 );
        assertEquals( false, item2.getFlatFlag());
    }

    @Test
    public void setFlatFlag() {
        Item item = new Item( );
        item.setFlatFlag(true);
        assertEquals( true, item.getFlatFlag());
        item.setFlatFlag(false);
        assertEquals( false, item.getFlatFlag());
    }

    @Test
    public void getHeight() throws ItemException {
        Item item1 = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0 );
        assertEquals( (Double)4.0, item1.getHeight());
    }

    @Test
    public void setHeight() throws ItemException {
        Item item = new Item();
        item.setHeight(5.5);
        assertEquals( (Double)5.5, item.getHeight());
        Throwable thrown = assertThrows(ItemException.class, () -> {
            item.setHeight(-5.5);
        });
        assertNotNull(thrown.getMessage());
        thrown = assertThrows(ItemException.class, () -> {
            item.setHeight(0.0);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    public void getWidth() throws ItemException {
        Item item1 = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0 );
        assertEquals( (Double)3.0, item1.getWidth());
    }

    @Test
    public void setWidth() throws Exception {
        Item item = new Item();
        item.setWidth(5.5);
        assertEquals( (Double)5.5, item.getWidth());
        Throwable thrown = assertThrows(ItemException.class, () -> {
            item.setWidth(-5.5);
        });
        assertNotNull(thrown.getMessage());
        thrown = assertThrows(ItemException.class, () -> {
            item.setWidth(0.0);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    public void getLength() throws ItemException {
        Item item1 = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0 );
        assertEquals( (Double)2.0, item1.getLength());
    }

    @Test
    public void setLength() throws Exception{
        Item item = new Item();
        item.setLength(5.5);
        assertEquals( (Double)5.5, item.getLength());
        Throwable thrown = assertThrows(ItemException.class, () -> {
            item.setLength(-5.5);
        });
        assertNotNull(thrown.getMessage());
        thrown = assertThrows(ItemException.class, () -> {
            item.setLength(0.0);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    public void print() throws Exception {
        Item item = new Item("Предмет", 5.0, true,  4.0, 3.0, 2.0 );
        item.print();
    }

    @org.junit.jupiter.api.Test
    void testCheck() {
    }

    @org.junit.jupiter.api.Test
    void testGetPlacedFlag() {
    }

    @org.junit.jupiter.api.Test
    void testSetPlacedFlag() {
    }

    @org.junit.jupiter.api.Test
    void testGetName() {
    }

    @org.junit.jupiter.api.Test
    void testSetName() {
    }

    @org.junit.jupiter.api.Test
    void testGetWeight() {
    }

    @org.junit.jupiter.api.Test
    void testSetWeight() {
    }

    @org.junit.jupiter.api.Test
    void testGetFlatFlag() {
    }

    @org.junit.jupiter.api.Test
    void testSetFlatFlag() {
    }

    @org.junit.jupiter.api.Test
    void testGetHeight() {
    }

    @org.junit.jupiter.api.Test
    void testSetHeight() {
    }

    @org.junit.jupiter.api.Test
    void testGetWidth() {
    }

    @org.junit.jupiter.api.Test
    void testSetWidth() {
    }

    @org.junit.jupiter.api.Test
    void testGetLength() {
    }

    @org.junit.jupiter.api.Test
    void testSetLength() {
    }

    @org.junit.jupiter.api.Test
    void testPrint() {
    }
}