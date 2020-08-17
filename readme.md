## How it works

Having the pairs introduced, for each of them we should consider 4 scenarios:
- two values of a pair are new in the graph base (which is a map with vertices and number of graph which they belong to). Having that situation, a new graph number is created, and it is consisted of these two values.
- one of values is already connected to some graph. If it is so, the other vertex connects to the same graph.
- two values of a pair are already in the graph base, but they are connected to distinct graphs. In this scenario, new graph number is created and every vertex switches to that value (every one from the graph of first and second vertex).
- two vertices of a pair already exist in the graph base, and they belong to the same graph. Just ignore.