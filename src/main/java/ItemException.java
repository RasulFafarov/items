/**
 * Обработка ошибок.
 */
public class ItemException extends Exception {
    /**
     * предмет с которым произошла ошибка.
     */
    private Item item;
    /**
     * хранилище с которым возникла проблема.
     */
    private Pack pack;

    /**
     * @param message информация по ошибке
     */
    public ItemException(final String message) {
        super(message);
    }

    /**
     * @param messageParam информация о ошибке
     * @param itemParam предмет с которым произошла ошибка
     */
    public ItemException(final String messageParam, final Item itemParam) {
        super(messageParam);
        this.item = itemParam;
    }

    /**
     * @param messageParam информация о ошибке
     * @param itemParam предмет с которым произошла ошибка
     * @param packParam хранилище с которым возникла проблема
     */
    public ItemException(final String messageParam,
                         final Item itemParam, final Pack packParam) {
        super(messageParam);
        this.item = itemParam;
        this.pack = packParam;
    }

}
