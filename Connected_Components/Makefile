# Makefile for Connected-Components
#

JCC = javac
JRE = java
JFLAGS = 

ConnectedComponents.class: *.java
	$(JCC) $(JFLAGS) *.java

BFS1:
	$(JRE) ConnectedComponents BFS Input/MatchSet1.txt

DFS1:
	$(JRE) ConnectedComponents DFS Input/MatchSet1.txt

BFS2:
	$(JRE) ConnectedComponents BFS Input/MatchSet2.txt

DFS2:
	$(JRE) ConnectedComponents DFS Input/MatchSet2.txt

BFS3:
	$(JRE) ConnectedComponents BFS Input/MatchSet3.txt

DFS3:
	$(JRE) ConnectedComponents DFS Input/MatchSet3.txt

clean:
	$(RM) *.class