public class Queue {
    Tree[] queue = new Tree[10];
    int lastLast=0;

   public void add(Tree tree){

   }
   public void sort(){
       int n = queue.length;
       for (int i = 1; i < n; ++i) {
           Tree key = queue[i];
           int j = i - 1;
           while (j >= 0 && queue[j].root.count > key.root.count) {
               queue[j + 1] = queue[j];
               j = j - 1;
           }
           queue[j + 1] = key;
       }
   }
}
