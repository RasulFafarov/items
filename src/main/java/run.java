public class run {
    public static void main(String[] args) {
        System.out.println("2");
        Stack stack1 = new Stack(500);
        Box box1 = new Box();
        Item book = new Item("книжечка");
        book.setFlatFlag(true);

        box1.print();
        stack1.addItem(book);
        stack1.print();

    }
}
