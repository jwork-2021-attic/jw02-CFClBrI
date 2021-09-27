package S181860086;

public class QuickSorter implements Sorter {
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

    private void quickSort(int left, int right) {
        if (left >= right)
            return;
        int basic = a[left];
        int ps = left, pq = left + 1;
        while (pq <= right) {
            if (a[pq] < basic) {
                ps++;
                if (ps != pq) {
                    swap(ps, pq);     
                }                               
            }
            pq++;
        }
        if (ps != left) {
            swap(ps, left);
        }            
        quickSort(left, ps - 1);
        quickSort(ps + 1, right);
    }

    @Override
    public void sort() {
        quickSort(0, a.length - 1);
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}
