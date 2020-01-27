import java.util.Random;

public class Bag extends Pack {
    private Double maxWeight;
    private Double freeWeight;

    public Bag(double maxWeight) {
        this.freeWeight = maxWeight;
    }

    public Bag() {
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }
    public Item getItem(){
        Random randNumber = new Random();
        int iNumber = randNumber.nextInt(super.inPack.size()-1);
        return removeAndGetItems(iNumber);
    }

    public Item getItem(String name){

        // не сделано
        Item item = super.inPack.get(super.inPack.size()-1);
        super.inPack.remove(super.inPack.size()-1);
        return item;
    }

    public void addItem(Item item){
        if (this.maxWeight == null) {
            throw new IllegalArgumentException("Неизвестен максимальный вес мешка");

        }
        else if (item.getWeight() == null) {
            throw new IllegalArgumentException("Нельзя положить в мешок предмет без веса");

        }
        else if (freeWeight< item.getWeight()) {
            throw new IllegalArgumentException("Превышение веса в мешке");
        }
        else{
            super.inPack.add(item);

            freeWeight-=item.getWeight();
        }
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Максимальный вес:" + maxWeight);
        System.out.println("Свободно места:" + freeWeight);

    }

}
