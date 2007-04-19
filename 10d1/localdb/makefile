# make file for debugging database
cdb : MakeDB.java BedrockU.conf
	javac MakeDB.java
db :
	java -cp ../mckoi1.0.3/mckoidb.jar:. MakeDB
cadd : GetAddresses.java BedrockU.conf
	javac GetAddresses.java
add: 
	java -cp ../mckoi1.0.3/mckoidb.jar:. GetAddresses
csched:	ChangeSched.java BedrockU.conf
	javac ChangeSched.java
sched:
	java -cp ../mckoi1.0.3/mckoidb.jar:. ChangeSched
cleandb: 
	rm data/*
	rm log/*
cleanclass: 
	rm *.class
