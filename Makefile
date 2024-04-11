compile :
	javac src/academic/model/*.java src/academic/controller/*.java src/academic/view/Driver1.java -d bin

test :
	cd bin && java academic.view.Driver1



