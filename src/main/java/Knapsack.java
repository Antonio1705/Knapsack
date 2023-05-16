import java.util.Arrays;
import java.util.List;

class Knapsack{

    List<Item> items;

    public int maximumValue(int capacity,List<Item> itemList ){
        this.items = itemList;
        if (items.size() == 0){
            return 0;
        }
        deleteItemWeightToBig(capacity,items);
        if (items.size() == 1){
            return items.get(0).getItemValue();
        }

        Item[] itemsArray = new Item[items.size()];

        for (int i = 0; i<items.size();i++){
            itemsArray[i] = items.get(i);
        }

        Arrays.sort(itemsArray);
        for(int it = 0; it < itemsArray.length;it++){
            System.out.println(itemsArray[it].getEffectivenessInteger());
        }
        /*Collections.sort(items, new Comparator<Item>(){
            public int compare(Item item1, Item item2){
                return Double.valueOf( item1.getEffectivenessInteger()).compareTo(item2.getEffectivenessInteger());
            }
        });*/

        List<Item> newItemList = Arrays.asList(itemsArray);
        return maxValueOfItems(capacity,newItemList);
    }

    public void deleteItemWeightToBig(int maxWeightOfSack,List<Item> items){

            for (int i = 0; i<items.size(); i++){
                if (items.get(i).getItemWeight() > maxWeightOfSack){
                    items.get(i).setItemWeight(0);
                    items.get(i).setItemValue(0);
                }
            }
    }

    public int maxValueOfItems(int capacity, List<Item> itemsI){
        int currentStartItem = 0;
        int maxValue = 0;
        int maxValue2 = 0;
        int currentWeightOfSack = 0;

        for (int n = 0; n<itemsI.size();n ++){
            for (int i = currentStartItem; i<itemsI.size();i++){
                if (currentWeightOfSack + itemsI.get(i).getItemWeight() <= capacity){
                    maxValue2 += itemsI.get(i).getItemValue();
                    currentWeightOfSack += itemsI.get(i).getItemWeight();
                }
            }
            if (maxValue<maxValue2){
                maxValue = maxValue2;
            }
            currentStartItem +=1;
            maxValue2 = 0;
            currentWeightOfSack = 0;
        }

        return maxValue;
    }

    /*public List<Item> effectiveness(List<Item> itemsList){
        Item itemCurrent;
        for(int i = 0; i<itemsList.size()-1;i++){
            if ((int)itemsList.get(i).getEffectivenessInteger() < (int)itemsList.get(i+1).getEffectivenessInteger()){
                continue;
            }
            itemCurrent = itemsList.get(i);
            itemsList.set(i,itemsList.get(i+1));
            itemsList.set(i+1,itemCurrent);

            effectiveness(itemsList);
        }
        return itemsList;
    }*/


}
