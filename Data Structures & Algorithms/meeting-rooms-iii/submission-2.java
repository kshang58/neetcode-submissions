class Solution {
    class Room {
        int id;
        int availableTime;
        public Room(int id, int availableTime) {
            this.id = id;
            this.availableTime = availableTime;
        }
    }
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Room> busyRoom = new PriorityQueue<>((a, b) -> {
            if (a.availableTime != b.availableTime) {
                return Integer.compare(a.availableTime, b.availableTime);
            }
            return Integer.compare(a.id, b.id);
        });
        PriorityQueue<Integer> availableRoom = new PriorityQueue<>();
        int[] used = new int[n];
        int globalMax = 0;
        for (int i = 0; i < n; i ++) {
            availableRoom.offer(i);
        }
        for (int[] meeting : meetings) {
            while (!busyRoom.isEmpty() && busyRoom.peek().availableTime <= meeting[0]) {
                availableRoom.offer(busyRoom.poll().id);
            }
            if (availableRoom.isEmpty()) {
                Room roomUse = busyRoom.poll();
                used[roomUse.id] ++;
                busyRoom.offer(new Room(roomUse.id, roomUse.availableTime + meeting[1] - meeting[0]));
            } else {
                int curId = availableRoom.poll();
                busyRoom.offer(new Room(curId, meeting[1]));
                used[curId] ++;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i ++) {
            if (used[i] > globalMax) {
                globalMax = used[i];
                result = i;
            }
        }
        return result;
    }
}