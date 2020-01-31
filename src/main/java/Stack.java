
/**
 * Стопка в которую можно складывать плоские предметы.
 */
public class Stack extends Pack {
    /**
     * Максимальное количество предметов в стопке.
     */
    private Integer maxItems;

    /**
     *
     */
    public Stack() {
        super.setFlatFlag(true);
    }


    /**
     * @param nameParam имя
     * @param weightParam вес
     * @param heightParam высота
     * @param widthParam ширина
     * @param lengthParam длина
     * @param maxItemsParam максимальное количество предметов в стопке
     * @throws ItemException обработка ошибок
     */
    public Stack(final String nameParam, final Double weightParam,
                 final Double heightParam,final Double widthParam,
                 final Double lengthParam, final Integer maxItemsParam) throws ItemException {
        super.setName(nameParam);
        check(weightParam);
        super.setWeight(weightParam);
        super.setFlatFlag(true);
        check(heightParam);
        super.setHeight(heightParam);
        check(widthParam);
        super.setWidth(widthParam);
        check(lengthParam);
        super.setLength(lengthParam);
        this.maxItems = maxItemsParam;
    }

    /**
     * @param max максимальное количество предметов в стопке
     */
    public Stack(final Integer max) {
        this.maxItems = max;

    }

    /**
     * @param nameParam имя
     * @param max максимальное количество предметов в стопке
     */
    public Stack(final String nameParam, final Integer max)  {
        super.setName(nameParam);
        this.maxItems = max;

    }

    /**
     * @return предмет из хранилища
     * @throws ItemException обработка ошибок
     */
    public final Item getItem() throws ItemException {
        if (super.inPack.size() > 0) {
            return removeAndGetItems(super.inPack.size() - 1);
        } else {
            throw new ItemException("В мешке больше нет предметов");
        }
    }


    /**
     * добавление предмета в коллекцию.
     * @param itemCurrent  помещаемый пример
     * @throws ItemException обработка ошибок
     */
     public void addItem(final Item itemCurrent)  throws ItemException {

         if (this.maxItems == null) {
             throw new ItemException("Неизвестно максимальное количество предметов в стопке", itemCurrent, this);
        } else if (itemCurrent.getFlatFlag() == false) {
             throw new ItemException("Нельзя положить не плоский предмет в стопку", itemCurrent, this);
        } else if (super.inPack.size() >= maxItems) {
             throw new ItemException("Слишком много предметов в стопке", itemCurrent, this);
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
        System.out.println("Максимальное количество:" + maxItems);

    }
}

