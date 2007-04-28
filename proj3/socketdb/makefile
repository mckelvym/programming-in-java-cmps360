# make file for creating and starting socket database
create:
	java -jar ../mckoi1.0.3/mckoidb.jar -conf ./test.conf -create "admin" "teacher"
start : 
	java -jar ../mckoi1.0.3/mckoidb.jar -conf test.conf
cleandb: 
	rm data/*
	rm log/*
