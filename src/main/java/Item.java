public class Item implements  Comparable<Item>{
    private int itemWeight;
    private int itemValue;
    private double effectivenessInteger;

    public Item(int itemWeight, int itemValue){
        this.itemValue = itemValue;
        this.itemWeight = itemWeight;
        this.effectivenessInteger = ((double) itemValue /(double)itemWeight) *1000;

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

    public double getEffectivenessInteger() {
        return effectivenessInteger;
    }

    @Override
    public int compareTo(Item o) {
        return (int) o.effectivenessInteger -  (int)this.effectivenessInteger;
    }
}
