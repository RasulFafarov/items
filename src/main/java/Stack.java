import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Stack extends Pack {
    private Integer maxItems;

    public Stack(){

    }

    public Stack(Integer max){

        this.maxItems = max;

    }
    public Stack(String name, Integer max){
        super.setName(name);
        this.maxItems = max;

    }

    public Item getItem(){
        return removeAndGetItems(super.inPack.size()-1);
    }

     public void addItem(Item item){

         if (this.maxItems == null) {
             throw new IllegalArgumentException("Неизвестно максимальное количество предметов в стопке");
        }
        else if (item.getFlatFlag() != true){
             throw new IllegalArgumentException("Нельзя положить не плоский предмет в стопку");
        }
        else if (super.inPack.size() >= maxItems){
             throw new IllegalArgumentException("Слишком много предметов в стопке");
         }
        else {

             super.setPlacedFlag(true);
             super.inPack.add(item);
         }
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Максимальное количество:" + maxItems);

    }
}

