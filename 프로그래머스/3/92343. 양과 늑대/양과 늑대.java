import java.util.*;

class Solution {
    private static class Info {
        int node, sheep, wolf;
        HashSet<Integer> visited;
        
        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node; // 현재 위치
            this.sheep = sheep; // 양의 수
            this.wolf = wolf; // 늑대의 수
            this.visited = visited; // 방문한 노드
        }
    }
    
    private static ArrayList<Integer>[] tree;
    
    private static void buildTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        for(int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        buildTree(info, edges); // 트리 생성
        int answer = 0;
        
        ArrayDeque<Info> queue = new ArrayDeque<>(); // BFS를 위한 큐 생성
        queue.add(new Info(0, 1, 0, new HashSet<>())); // 초기 상태 설정 
        
        while(!queue.isEmpty()) { // BFS 시작
            Info now = queue.poll(); // 큐에서 현재 상태 꺼냄 
            answer = Math.max(answer, now.sheep); // 최대 양의 수 업데이트 
            now.visited.addAll(tree[now.node]); // 방문한 노드 집합에 현재 노드의 이웃 노드 추가 
            
            for(int next : now.visited) { // 인접한 노드들 탐색 
                HashSet<Integer> set = new HashSet<>(now.visited); // 기존 해시셋 데이터 복사
                set.remove(next); // 현재 방문한 정점을 해시셋에서 제거 
                
                if(info[next] == 1) { // 늑대일 경우 
                    if(now.sheep != now.wolf + 1) {
                        queue.add(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                } else { // 양일 경우 
                    queue.add(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
        }
        
        return answer;
    }
}