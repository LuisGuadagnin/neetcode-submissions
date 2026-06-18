class MedianFinder {
    PriorityQueue<Integer> lowerNumbersMaxHeap = new PriorityQueue<>(
        (n1, n2) -> n2.compareTo(n1)
    );
    PriorityQueue<Integer> higherNumbersMinHeap = new PriorityQueue<>(
        (n1, n2) -> n1.compareTo(n2)
    );

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (higherNumbersMinHeap.isEmpty()) {
            higherNumbersMinHeap.add(num);
        } else if (num > higherNumbersMinHeap.peek()) {
            higherNumbersMinHeap.add(num);

            if (higherNumbersMinHeap.size() == lowerNumbersMaxHeap.size() + 2) {
                lowerNumbersMaxHeap.add(higherNumbersMinHeap.poll());
            }
        } else {
            lowerNumbersMaxHeap.add(num);

            if (lowerNumbersMaxHeap.size() == higherNumbersMinHeap.size() + 2) {
                higherNumbersMinHeap.add(lowerNumbersMaxHeap.poll());
            }
        }

        System.out.println("higherNumbersMinHeap: " + higherNumbersMinHeap);
        System.out.println("lowerNumbersMaxHeap: " + lowerNumbersMaxHeap);
    }
    
    public double findMedian() {
        if (lowerNumbersMaxHeap.size() > higherNumbersMinHeap.size()) {
            return lowerNumbersMaxHeap.peek();
        } else if (lowerNumbersMaxHeap.size() < higherNumbersMinHeap.size()) {
            return higherNumbersMinHeap.peek();
        } else {
            return ((double)(lowerNumbersMaxHeap.peek() + higherNumbersMinHeap.peek()))/2.0;
        }
    }
}
