class MedianFinder {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        int small = maxHeap.isEmpty() ? Integer.MIN_VALUE : maxHeap.peek();
        int large = minHeap.isEmpty() ? Integer.MAX_VALUE : minHeap.peek();
        if (num < small) {
            maxHeap.offer(num);
        } else if (num > large) {
            minHeap.offer(num);
        } else {
            if (maxHeap.size() <= minHeap.size()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        } else if (minHeap.size() + 1 < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
