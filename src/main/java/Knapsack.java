import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Knapsack{

    List<Item> items;

    public  int[] weight;
    public  int[] value;

    public int maximumValue(int capacity,List<Item> itemList ) {
        this.items = itemList;

        weight = new int[items.size()];
        value = new int[items.size()];

        Item[] itemsArray = new Item[items.size()];

        for (int i = 0; i < items.size(); i++) {
            itemsArray[i] = items.get(i);
            weight[i] = items.get(i).getItemWeight();
            value[i] = items.get(i).getItemValue();

        }


        List<Item> newItemList = Arrays.asList(itemsArray);

        return knapSack(weight.length, capacity);
    }

    public int  knapSack(int pointer, int capacity) {
        if (pointer == 0 || capacity == 0){
            return 0;
        } else if (this.weight[pointer-1] > capacity) {
            return  knapSack(pointer-1,capacity);
        }else {
            int  kk = knapSack(pointer-1,capacity);
            int kk2 = value[pointer-1] + knapSack(pointer-1,capacity - weight[pointer-1]);
            /// the both can be used
            //int result = Math.max(kk,kk2);
            return kk > kk2 ?  kk:kk2;
        }
    }



/*
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

    public List<Item> effectiveness(List<Item> itemsList){
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
