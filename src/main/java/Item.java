/**
 *  Основной класс предмет.
 */
public class Item {

    /**
     * Имя предмета.
     */
    private String name;
    /**
     * Вес предмета.
     */
    private Double weight;
    /**
     * Плоский ли предмет.
     */
    private Boolean flatFlag;
    /**
     * Находится ли предмет в контейнере.
     */
    private Boolean placedFlag = false;
    /**
     * Высота предмета.
     */
    private Double height;
    /**
     * ширина предмета.
     */
    private Double width;
    /**
     * длина предмета.
     */
    private Double length;

    /**
     * @param nameParam имя
     */
    public Item(final String nameParam) {
        this.name = nameParam;
    }

    /**
     * проверяет число на положительность.
     * @param n проверяемое число
     * @throws ItemException обработка ошибок
     */
    protected final void check(final Double n) throws ItemException {
        if (n <= 0) {
            throw new ItemException("Предмет не может иметь не положительное значение характеристик");
        }
        }

    /**
     * @param nameParam  Имя предмета.
     * @param weightParam вес предмета.
     * @param flatFlagParam плоский ли предмет
     * @param heightParam высота предмета.
     * @param widthParam ширина предмета.
     * @param lengthParam длина предмета.
     * @throws ItemException обработка ошибок
     */
    public Item(final String nameParam, final Double weightParam,
                final Boolean flatFlagParam, final Double heightParam,
                final Double widthParam, final Double lengthParam) throws ItemException {
        this.name = nameParam;
        check(weightParam);
        this.weight = weightParam;
        this.flatFlag = flatFlagParam;
        check(heightParam);
        this.height = heightParam;
        check(widthParam);
        this.width = widthParam;
        check(lengthParam);
        this.length = lengthParam;
    }

    /**
     *
     */
    public Item() {
    }


    /**
     * @return плоский ли предмет
     */
    public final Boolean getPlacedFlag() {
        return placedFlag;
    }

    /**
     * @param placedFlagParam плоский ли предмет
     */
    public final void setPlacedFlag(final Boolean placedFlagParam) {
         this.placedFlag = placedFlagParam;
    }

    /**
     * @return возвращает имя предмета
     */
    public final String getName() {
        return name;
    }

    /**
     * задает имя предмета.
     * @param nameParam имя предмета
     */
    public final void setName(final String nameParam) {
        this.name = nameParam;
    }


    /**
     * @return вес предмета
     */
    public final Double getWeight() {
        return weight;
    }

    /**
     * @param weightParam ширина предмета
     * @throws ItemException обработка ошибок
     */
    public final void setWeight(final Double weightParam)
            throws ItemException {
        check(weightParam);
        this.weight = weightParam;
    }


    /**
     * @return плоский ли предмет
     */
    public final Boolean getFlatFlag() {
        return flatFlag;
    }

    /**
     * @param flatFlagParam плоский ли предмет
     */
    public final void setFlatFlag(final Boolean flatFlagParam) {
        this.flatFlag = flatFlagParam;
    }

    /**
     * @return высота предмета
     */
    public final Double getHeight() {
        return height;
    }

    /**
     * @param heightParam Высота предмета
     * @throws ItemException обработка ошибок
     */
    public final void setHeight(final Double heightParam)
            throws ItemException {
        check(heightParam);
        this.height = heightParam;
    }


    /**
     * @return ширина предмета
     */
    public final Double getWidth() {
        return width;
    }

    /**
     * @param widthParam ширина предмета
     * @throws ItemException обработка ошибок
     */
    public final void setWidth(final Double widthParam)
            throws ItemException {
        check(widthParam);
        this.width = widthParam;
    }


    /**
     * @return длина предмета
     */
    public final Double getLength() {
        return length;
    }

    /**
     * @param lengthParam длина предмета
     * @throws ItemException обработка ошибок
     */
    public final void setLength(final Double lengthParam)
            throws ItemException {
        check(lengthParam);
        this.length = lengthParam;
    }

    /**
     * Печать информации об объекте.
     */
    public void print() {
        System.out.println("Имя: " + name);
        System.out.println("Вес: " + weight);
        System.out.println("Предмет плоской: " + flatFlag);
        System.out.println("Высота: " + height);
        System.out.println("Ширина: " + width);
        System.out.println("Длина: " + length);
    }

    }
