import java.util.ArrayList;
import java.util.List;

/**
 * вспомогательный класс хранилище.
 */
public abstract class Pack extends Item {
    /**
     * хранимаые внутри предметы.
     */
    protected List<Item> inPack = new ArrayList<Item>();


    /**
     * обрабатывает дополнительные действия при помещении предмета.
     * @param item помещаемый предмет
     * @throws ItemException обработка ошибок
     */
    protected final void addItems(final Item item) throws ItemException {
        super.setPlacedFlag(true);
        inPack.add(item);
        super.setWeight(super.getWeight() + item.getWeight());
    };

    /**
     * добавление предмета внутрь.
     * @param item помещаемый предмет
     * @throws ItemException обработка ошибок
     */
    abstract public void addItem(final Item item) throws ItemException;

    /**
     * @return предмет из коллекции
     * @throws ItemException обработка ошибок
     */
    abstract public Item getItem() throws ItemException;

    /**
     * достает предмет из коллекции с указанным индексом.
     * @param i номер предмета в коллекции
     * @return предмет из коллекции
     * @throws ItemException обработка ошибок
     */
    protected final Item removeAndGetItems(int i) throws ItemException {
        if (i >= this.inPack.size() || i < 0) {
            throw new ItemException("Элемент с таким индексом не существует в контейнере");
        }
        Item item = this.inPack.get(i);
        this.inPack.remove(i);
        item.setPlacedFlag(false);
        return item;
    }


    /**
     * печать информации об объекте.
     */
    @Override
    public void print() {
        super.print();
        System.out.println("Предметы находящиеся внутри: ");
        inPack.stream().forEach(x -> System.out.println(x.getName()));
    }
}
