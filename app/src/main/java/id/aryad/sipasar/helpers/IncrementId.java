package id.aryad.sipasar.helpers;

public class IncrementId {
    private int currentId = 0;
    public int up(){
        currentId++;
        return currentId;
    }
}
