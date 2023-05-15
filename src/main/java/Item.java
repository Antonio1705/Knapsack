public class Item {
    private int itemWeight;
    private int itemValue;
    public Item(int itemWeight, int itemValue){
        this.itemValue = itemValue;
        this.itemWeight = itemWeight;

    }

    public int getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(int itemWeight) {
        this.itemWeight = itemWeight;
    }

    public void setItemValue(int itemValue) {
        this.itemValue = itemValue;
    }

    public int getItemValue() {
        return itemValue;
    }
}
