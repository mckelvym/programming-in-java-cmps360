# make file for creating and starting socket database
create:
	java -jar ../mckoi1.0.3/mckoidb.jar -conf ./BedrockU.conf -create "admin" "9999"
start : 
	java -jar ../mckoi1.0.3/mckoidb.jar -conf BedrockU.conf
cdb : MakeDB.java BedrockU.conf
	javac MakeDB.java
cadd : GetAddresses.java
	javac GetAddresses.java
csched:	ChangeSched.java
	javac ChangeSched.java
cleandb: 
	rm data/*
	rm log/*
cleanclass: 
	rm *.class
