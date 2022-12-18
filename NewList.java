import java.util.ArrayList;

public class NewList {
    
    private ArrayList<Object> values = new ArrayList<>();
    
    NewList(){

    }

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

        for(int i = 0; i < listLeft.size(); i++){

            if(i >= listRight.size()){
                return false;
            }

            Object l = listLeft.get(i);
            Object r = listRight.get(i);

        }

        return true;
    }
}
