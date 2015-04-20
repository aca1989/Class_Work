# Makefile for Connected-Components
#

# Compiler
JCC = javac

# Environment
JRE = java

# Flags
JFLAGS = 

# Compiles the program
ConnectedComponents.class: *.java
	$(JCC) $(JFLAGS) *.java

# Runs the program with BFS on MatchSet1.txt
BFS1:
	$(JRE) ConnectedComponents BFS Input/MatchSet1.txt

# Runs the program with DFS on MatchSet1.txt
DFS1:
	$(JRE) ConnectedComponents DFS Input/MatchSet1.txt

# Runs the program with BFS on MatchSet2.txt
BFS2:
	$(JRE) ConnectedComponents BFS Input/MatchSet2.txt

# Runs the program with DFS on MatchSet2.txt
DFS2:
	$(JRE) ConnectedComponents DFS Input/MatchSet2.txt

# Runs the program with BFS on MatchSet3.txt
BFS3:
	$(JRE) ConnectedComponents BFS Input/MatchSet3.txt

# Runs the program with DFS on MatchSet3.txt
DFS3:
	$(JRE) ConnectedComponents DFS Input/MatchSet3.txt

# Cleans the .class files from the folder
clean:
	$(RM) *.class
