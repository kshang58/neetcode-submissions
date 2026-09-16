class Solution {
    private class meetingRoom {
        long endTime;
        int room;
        public meetingRoom(long endTime, int room) {
            this.endTime = endTime;
            this.room = room;
        }
    }
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int[] meetingCounts = new int[n];
        PriorityQueue<Integer> availableRoom = new PriorityQueue<>();
        PriorityQueue<meetingRoom> busyRoom =
                new PriorityQueue<>((a, b) -> {
                if (a.endTime != b.endTime) {
                    return Long.compare(a.endTime, b.endTime);
                }
                return Integer.compare(a.room, b.room);
        });
        for (int i = 0; i < n; i ++) {
            availableRoom.offer(i);
        }
        for (int[] meeting : meetings) {
            while (!busyRoom.isEmpty() && meeting[0] >= busyRoom.peek().endTime) {
                availableRoom.offer(busyRoom.peek().room);
                busyRoom.poll();
            }
            if (!availableRoom.isEmpty()) {
                int roomNum = availableRoom.poll();
                meetingCounts[roomNum] ++;
                busyRoom.offer(new meetingRoom(meeting[1], roomNum));
            } else {
                meetingRoom cur = busyRoom.poll();
                long endT = cur.endTime;
                busyRoom.offer(new meetingRoom(meeting[1] - meeting[0] + endT, cur.room));
                meetingCounts[cur.room] ++;
            }
        }
        int roomC = 0;
        int rslt = 0;
        for (int i = 0; i < n; i ++) {
            if (meetingCounts[i] > roomC) {
                rslt = i;
                roomC = meetingCounts[i];
            }
        }
        return rslt;
    }
}













