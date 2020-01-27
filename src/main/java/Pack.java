import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Pack extends Item {
    List<Item> inPack = new ArrayList<Item>();
    ;

    abstract public void addItem(Item item);

    abstract public Item getItem();

    protected Item removeAndGetItems(int i) {
        if (i >= this.inPack.size() || i < 0) {
            throw new IllegalArgumentException("Элемент с таким индексом не существует в контейнере");
        }
        Item item = this.inPack.get(i);
        this.inPack.remove(i);
        item.setPlacedFlag(false);
        return item;
    }


    @Override
    public void print() {
        super.print();
        for (Item item :inPack){
            System.out.println(item.getName());
        }
    }
}
