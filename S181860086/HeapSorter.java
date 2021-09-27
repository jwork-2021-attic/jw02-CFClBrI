package S181860086;

public class HeapSorter implements Sorter {
    
    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    public void HeapAdjust(int root, int length) {
        int parent = root, child = 2 * parent + 1;      
        while (child < length) {            
            if (child + 1 < length && a[child] < a[child + 1]) {
                child++;
            }            
            if (a[parent] >= a[child]) {
                break;      
            }                      
            swap(parent, child);            
            parent = child;
            child = 2 * child + 1;
        }        
    }

    @Override
    public void sort() {
        for (int i = a.length / 2; i >= 0; i--) {
            HeapAdjust(i, a.length);
        }     
        for (int i = a.length - 1; i > 0; i--) {
            swap(0, i);            
            HeapAdjust(0, i);
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}
