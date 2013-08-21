SOURCE = -source 1.4

all: List.class MainClass.class 

List.class: List.java
	javac $(SOURCE) -d . -classpath . List.java

MainClass.class: MainClass.java
	javac $(SOURCE) -d . -classpath . MainClass.java
clean:
	rm -f *.class 
