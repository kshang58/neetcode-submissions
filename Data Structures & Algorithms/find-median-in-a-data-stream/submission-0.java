class MedianFinder {
    Queue<Integer> smallMaxHeap;
    Queue<Integer> largeMinHeap;
    public MedianFinder() {
        smallMaxHeap = new PriorityQueue<>((a, b) -> b  - a);
        largeMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        int small = smallMaxHeap.isEmpty() ? Integer.MIN_VALUE : smallMaxHeap.peek();
        int large = largeMinHeap.isEmpty() ? Integer.MAX_VALUE : largeMinHeap.peek();
        if (num <= small) {
            smallMaxHeap.offer(num);
        } else if (num >= large) {
            largeMinHeap.offer(num);
        } else {
            if (smallMaxHeap.size() <= largeMinHeap.size()) {
                smallMaxHeap.offer(num);
            } else {
                largeMinHeap.offer(num);
            }
        }
        if (largeMinHeap.size() > smallMaxHeap.size()) {
            smallMaxHeap.offer(largeMinHeap.poll());
        } else if (largeMinHeap.size() + 1 < smallMaxHeap.size()) {
            largeMinHeap.offer(smallMaxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (largeMinHeap.size() == smallMaxHeap.size()) {
            return (smallMaxHeap.peek() + largeMinHeap.peek()) / 2.0;
        } else {
            return smallMaxHeap.peek();
        }
    }
}
