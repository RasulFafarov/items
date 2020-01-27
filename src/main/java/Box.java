public class Box extends Pack {
    private Double maxVolume;
    private Double freeVolume;

    public Double getFreeVolume() {
        return freeVolume;
    }

    public Double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(Double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public Item getItem(){
        Item item = super.inPack.get(super.inPack.size()-1);
        super.inPack.remove(super.inPack.size()-1);
        return item;
    }

    public void addItem(Item item){
        if (this.getHeight() == null || this.getLength() ==null || this.getWidth() ==null ) {
            throw new IllegalArgumentException("Не известна ширина высота или длина коробки");
        }
        else if (item.getHeight() == null || item.getLength() ==null || item.getWidth() ==null ) {
            throw new IllegalArgumentException("Не известна ширина высота или длина предмета");
        }
        else if (super.getHeight()< item.getHeight() || super.getLength() < item.getLength() || super.getWidth() < item.getWidth()) {
            throw new IllegalArgumentException("Предмет слишком большой для этой коробки");
        }
        else if (freeVolume< item.getHeight() * item.getLength() * item.getWidth()) {
            throw new IllegalArgumentException("Не хватает места в коробке");
        }
        else{
            super.inPack.add(item);
            freeVolume-=item.getHeight() * item.getLength() * item.getWidth();
        }
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Максимальный вес:" + maxVolume);
        System.out.println("Свободно места:" + freeVolume);

    }
}
