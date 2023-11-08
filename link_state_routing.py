import sys

class Graph:
      def __init__(self, vertices):
          self.V = vertices
          self.graph = [[0 for _ in range(vertices)] for _ in range(vertices)]

      def add_edge(self, u, v, weight):
          self.graph[u][v] = weight
          self.graph[v][u] = weight  # Assuming it's an undirected graph

      def dijkstra(self, src):
          visited = [False] * self.V
          distance = [sys.maxsize] * self.V
          distance[src] = 0

          for _ in range(self.V):
              u = self.min_distance(distance, visited)
              visited[u] = True
              for v in range(self.V):
                  if not visited[v] and self.graph[u][v] > 0 and distance[u] + self.graph[u][v] < distance[v]:
                      distance[v] = distance[u] + self.graph[u][v]

          self.print_solution(src, distance)

      def min_distance(self, distance, visited):
          min_dist = sys.maxsize
          min_index = 0
          for v in range(self.V):
              if distance[v] < min_dist and not visited[v]:
                  min_dist = distance[v]
                  min_index = v
          return min_index

      def print_solution(self, src, distance):
          print("Shortest path distances from source vertex:", src)
          print("Vertex \t Distance from Source")
          for node in range(self.V):
              print(node, "\t", distance[node])


if __name__ == "__main__":
      num_vertices = int(input("Enter the number of vertices: "))
      graph = Graph(num_vertices)

      num_edges = int(input("Enter the number of edges: "))
      for _ in range(num_edges):
          u, v, weight = map(int, input("Enter edge (u, v) and weight: ").split())
          graph.add_edge(u, v, weight)

      source = int(input("Enter the source node:"))

      graph.dijkstra(source)

"""
Enter the number of vertices: 5
Enter the number of edges: 7
Enter edge (u, v) and weight: 0 1 2
Enter edge (u, v) and weight: 0 2 5
Enter edge (u, v) and weight: 1 2 1
Enter edge (u, v) and weight: 1 3 4
Enter edge (u, v) and weight: 2 3 3
Enter edge (u, v) and weight: 2 4 7
Enter edge (u, v) and weight: 3 4 2
Enter the source node: 0

Shortest path distances from source vertex: 0
Vertex 	 Distance from Source
0 	 0
1 	 2
2 	 3
3 	 6
4 	 8
"""
