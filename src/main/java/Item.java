public class Item {

    private String name;
    private Double weight;
    private Boolean flatFlag;
    private Boolean placedFlag = false;
    private Double height;//высота
    private Double width;//ширина
    private Double length;

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, Double weight, Boolean flatFlag, Double height, Double width, Double length) {
        this.name = name;
        this.weight = weight;
        this.flatFlag = flatFlag;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public Item() {
    }


    public Boolean getPlacedFlag() {
        return placedFlag;
    }

    public void setPlacedFlag(Boolean placedFlag) {
         this.placedFlag = placedFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


    public Boolean getFlatFlag() {
        return flatFlag;
    }

    public void setFlatFlag(Boolean flatFlag) {
        this.flatFlag = flatFlag;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }


    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }



    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public void print() {
        System.out.println("Имя: " + name);
        System.out.println("Вес: " + weight);
        System.out.println("Предмет плоской: " + flatFlag);
        System.out.println("Высота: " + height);
        System.out.println("Ширина: " + width);
        System.out.println("Длина: " + length);
    }

    }
