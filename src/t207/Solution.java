package t207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses]; // 每个节点的入度
        ArrayList<List<Integer>> adjacency = new ArrayList<>(); // 存储相邻关系 方向从左到右
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // cp [1,0]表示学习课程1 需要 先学习课程0
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            // 表示下标为cp[1](先修课)是[x,y,...]的先修课，意思是将它修完[x,y,...]的入度就可以减少1了
            adjacency.get(cp[1]).add(cp[0]);
        }
        // 通过队列先把入度为0的插入
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        // BFS
        while (!queue.isEmpty()) {
            Integer pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)) {
                // 学完这一门之后
                if (--indegrees[cur] == 0) {
                    // 如果入度为零了
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }
}
