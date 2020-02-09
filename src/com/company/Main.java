package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<int[]> resList = new ArrayList<>();
        Queue<NestedInteger> q = new LinkedList<>();
        for (NestedInteger child : nestedList) {
            q.offer(child);
        }
        int depth = 1;
        while (!q.isEmpty()){
            int size = q.size();
            for (int s = 0; s < size; s++) {
                NestedInteger curr = q.poll();
                if (curr.isInteger()) {
                    resList.add(new int[]{curr.getInteger(), depth});
                    continue;
                }
                for (NestedInteger child : curr.getList()) {
                    q.offer(child);
                }
            }
            depth++;
        }
        int res = 0;
        for (int[] element : resList) {
            res += element[0] * (depth - element[1]);
        }
        return res;
    }
}


class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweighted = 0, weighted = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger())
                    unweighted += ni.getInteger();
                else
                    nextLevel.addAll(ni.getList());
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        return weighted;
    }
}