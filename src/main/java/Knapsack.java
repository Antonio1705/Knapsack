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

        return maxValueOfItems(capacity,items);
    }

    public void deleteItemWeightToBig(int maxWeightOfSack,List<Item> items){
        if (items.size()==1){
            for (int i = 0; i<items.size(); i++){
                if (items.get(i).getItemWeight() >= maxWeightOfSack){
                    items.get(i).setItemWeight(0);
                    items.get(i).setItemValue(0);
                }

            }
        }
    }

    public int maxValueOfItems(int maxWeightOfSack, List<Item> items){
        int ll = 0;
        int maxValue = 0;
        int maxValue2 = 0;
        int currentWeightOfSack = 0;

        for (int n = 0; n<items.size();n ++){
            for (int i = ll; i<items.size();i++){
                if (currentWeightOfSack + items.get(i).getItemWeight() <= maxWeightOfSack){
                    maxValue2 += items.get(i).getItemValue();
                    currentWeightOfSack += items.get(i).getItemWeight();
                }
            }
            if (maxValue<maxValue2){
                maxValue = maxValue2;
            }
            ll +=1;
            maxValue2 = 0;
            currentWeightOfSack = 0;
        }

        return maxValue;
    }


}
