/**
 * класс коробка для хранения вещей.
 * Имеет ограничение по весу и размеру хранимых предметов
 */
public class Box extends Bag {
    /**
     * максимальный объем вмещаемых вещей.
     */
    private Double maxVolume;
    /**
     * свободное место внутри.
     */
    private Double freeVolume;

    /**
     *
     */
    public Box() {
    }

    /**
     * @return свободный объем
     */
    public final Double getFreeVolume() {
        return freeVolume;
    }

    /**
     * @return максимальный вмещаемый объем
     */
    public final Double getMaxVolume() {
        return maxVolume;
    }

    /**
     * @param maxVolumeParam максимальный вмещаемый объем
     */
    public final void setMaxVolume(final Double maxVolumeParam)
            throws ItemException {
        super.check(maxVolumeParam);
        this.maxVolume = maxVolumeParam;
    }


    /**
     * @param nameParam имя
     * @param weightParam вес
     * @param flatFlagParam плоский ли предмет
     * @param heightParam высота
     * @param widthParam ширина
     * @param lengthParam длина
     * @param maxVolumeParam максимальный вмещаемый объем
     * @throws ItemException обработка ошибок
     */
    public Box(final String nameParam, final Double weightParam,
               final Boolean flatFlagParam, final Double heightParam,
               final Double widthParam, final Double lengthParam,
               final Double maxVolumeParam) throws ItemException {
        super.setName(nameParam);
        check(weightParam);
        super.setWeight(weightParam);
        super.setFlatFlag(flatFlagParam);
        check(heightParam);
        super.setHeight(heightParam);
        check(widthParam);
        super.setWidth(widthParam);
        check(lengthParam);
        super.setLength(lengthParam);
        check(maxVolumeParam);
        this.maxVolume = maxVolumeParam;
        this.freeVolume = lengthParam * widthParam * heightParam;
    }

    /**
     * помещает предмет в эту коробку.
     * @param item помещаемый предмет
     * @throws ItemException обработка ошибок
     */
    @Override
    public void addItem(final Item item) throws ItemException {
        if (this.getHeight() == null || this.getLength() == null
                || this.getWidth() == null) {
            throw new ItemException("Не известна ширина высота или длина коробки",
                    item, this);
        } else if (item.getHeight() == null || item.getLength() == null
                || item.getWidth() == null) {
            throw new ItemException("Не известна ширина высота или длина предмета",
                    item, this);
        } else if (super.getHeight() < item.getHeight() ||
                super.getLength() < item.getLength() ||
                super.getWidth() < item.getWidth()) {
            throw new ItemException("Предмет слишком большой для этой коробки",
                    item, this);
        } else if (freeVolume < item.getHeight() * item.getLength() * item.getWidth()) {
            throw new ItemException("Не хватает места в коробке", item, this);
        } else {
            super.addItems(item);
            freeVolume -= item.getHeight() * item.getLength() * item.getWidth();
        }
    }

    /**
     * печать информации об объекте.
     */
    @Override
    public void print() {
        super.print();
        System.out.println("Максимальный вес:" + maxVolume);
        System.out.println("Свободно места:" + freeVolume);

    }
}
