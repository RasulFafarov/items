import java.util.Random;

/**
 * Класс Мешок, может хранить в себе любые вещи.
 * если ограничение на максимальный вес не нарушено.
 */
public class Bag extends Pack {
    /**
     * максимальный вес вмещаемых объектов.
     */
    private Double maxWeight;

    /**
     * Пустой конструктор.
     */
    public Bag() {
    }

    /**
     * @param maxWeightParam  Максимальный  хранимый вес
     */
    public  Bag(final Double  maxWeightParam) {
        this.maxWeight = maxWeightParam;
    }


    /**
     * @param nameParam Имя
     * @param weightParam Вес
     * @param flatFlagParam Плоский ли предмет
     * @param heightParam Высота
     * @param widthParam ширина
     * @param lengthParam длина
     * @param maxWeightParam максимальный вес
     * @throws ItemException обработка ошибок
     */
    public Bag(final String nameParam, final Double weightParam,
               final Boolean flatFlagParam, final Double heightParam,
               final Double widthParam, final Double lengthParam,
               final Double maxWeightParam) throws ItemException {
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
        this.maxWeight = maxWeightParam;
    }


    /**
     * @param maxWeightParam максимальный хранимый вес
     * @throws ItemException обработка ошибок
     */
    public final void setMaxWeight(final Double maxWeightParam)
            throws ItemException {
        super.check(maxWeightParam);
        this.maxWeight = maxWeightParam;
    }


    /**
     * @param maxWeightParam максимальный суммарный вес вмещаемых объектов
     * @throws ItemException обработка ошибок
     */
    public Bag(final double maxWeightParam) throws ItemException {
        super.check(maxWeightParam);
        this.maxWeight = maxWeightParam;
    }

    /**
     * @return возврщает максимальный суммарный вес вмещаемых объектов
     */
    public final Double getMaxWeight() {
        return maxWeight;
    }

    /**
     * @return возвращает один из хранимых предметов
     * @throws ItemException обработка ошибок
     */
    public final Item getItem() throws ItemException {
        if (super.inPack.size() > 0) {
            Random randNumber = new Random();
            int iNumber = randNumber.nextInt(super.inPack.size());
            return removeAndGetItems(iNumber);
        } else {
            throw new ItemException("В мешке больше нет предметов");
        }
    }

    /**
     * @param nameParam имя возвращаемого объекта
     * @return   возвращает предмет с указанным именем
     * @throws ItemException обработка ошибок
     */
    public final Item getItem(final String nameParam) throws ItemException {
        for (Item item :inPack) {
            if (item.getName() == nameParam) {
                return item;
            }
        }
        throw new ItemException("Предмета с таким именем не найден");
    }

    /**
     * добавление предмета в мешок.
     * @param itemCurrent помещаемый предмет
     * @throws ItemException обработка ошибок
     */
    public void addItem(final Item itemCurrent) throws ItemException {
        if (this.maxWeight == null || this.getWeight() == null) {
            throw new ItemException("Неизвестен максимальный или текущий " +
                    "вес мешка",
                    itemCurrent, this);

        } else if (itemCurrent.getWeight() == null) {
            throw new ItemException("Нельзя положить в мешок предмет без веса",
                    itemCurrent, this);

        } else if (this.maxWeight - super.getWeight() < itemCurrent.getWeight()) {
            throw new ItemException("Превышение веса в мешке",
                    itemCurrent, this);
        } else {
            super.addItems(itemCurrent);
        }
    }

    /**
     * печать информации об объекте.
     */
    @Override
    public void print() {
        super.print();
        System.out.println("Максимальный вес:" + maxWeight);


    }

}
