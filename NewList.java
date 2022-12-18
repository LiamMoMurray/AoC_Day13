import java.util.ArrayList;

public class NewList {
    
    private ArrayList<Object> values = new ArrayList<>();
    
    NewList(){

    }

    // public void setLists(ArrayList<NewList> lists) {
    //     this.lists = lists;
    // }

    // public <T> void setValues(ArrayList<T> values) {
    //     this.values = values;
    // }

    // public ArrayList<NewList> getLists() {
    //     return lists;
    // }

    public ArrayList<Object> getValues() {
        return values;
    }

    public void addList(NewList list){
        values.add(list);
    }

    public void addValue(int value){
        values.add(value);
    }

    public void removeValue(int index){
        values.remove(index);
    }

    public void clearList(){
        values.clear();
    }
    
    static boolean compareTo(NewList left, NewList right){

        ArrayList<Object> listLeft = left.getValues();
        ArrayList<Object> listRight = right.getValues();

        for(int i = 0; i < listLeft.size(); i ++){
            

            if(i >= listRight.size()){ //if right is empty 1st, wrong order
                System.out.println("right empty - false");
                return false;
            }

            Object leftObj = listLeft.get(i);
            Object rightObj = listRight.get(i);

            if(leftObj.getClass() == Integer.class && rightObj.getClass() == NewList.class){

                System.out.println("int to list: " + leftObj + " -> " + rightObj);
                int leftVal = (int) leftObj;
                NewList rightVal = (NewList) rightObj;
                compareTo(leftVal, rightVal);

            } else if(leftObj.getClass() == NewList.class && rightObj.getClass() == Integer.class) {

                System.out.println("list to int: " + leftObj + " -> " + rightObj);
                NewList leftVal = (NewList) leftObj;
                int rightVal = (int) rightObj;
                compareTo(leftVal, rightVal);
            }

            // } else if(leftObj.getClass() == NewList.class && rightObj.getClass() == NewList.class){

            //     System.out.println("list to list: " + leftObj + " -> " + rightObj);
            //     NewList leftVal = (NewList) leftObj;
            //     NewList rightVal = (NewList) rightObj;
            //     compareTo(leftVal, rightVal);

            // } 
            
            else if(leftObj.getClass() == Integer.class && rightObj.getClass() == Integer.class){

                int leftVal = (int) leftObj;
                int rightVal = (int) rightObj;
                System.out.println("int to int: " + leftVal + "->" + rightVal);

                int comp = compareTo(leftVal, rightVal);

                if(comp == -1){
                    System.out.println("left smaller - true");
                    return true;
                }  
                
                if (comp == 1){
                    System.out.println("right smaller - false");
                    return false;
                }

            } if(leftObj.getClass() == NewList.class && rightObj.getClass() == NewList.class){

                    System.out.println("list to list: " + leftObj + " -> " + rightObj);
                    NewList leftVal = (NewList) leftObj;
                    NewList rightVal = (NewList) rightObj;
                    compareTo(leftVal, rightVal);
    
                } 
        }

        System.out.println("left empty - true");
        return true;
    }

    public static void compareTo(NewList left, int right){

        NewList valToList = new NewList();

        valToList.addValue(right);

        compareTo(left, valToList);
    }

    public static void compareTo(int left, NewList right){

        NewList valToList = new NewList();

        valToList.addValue(left);

        compareTo(valToList, right);
    }

    public static int compareTo(int left, int right){
        
        if(left < right){
            return -1;
        } else if (left > right){
            return 1;
        } else {
            return 0;
        }

        
    }
}
