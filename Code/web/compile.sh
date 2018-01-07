CLASSPATH=./WEB-INF/classes:./WEB-INF/lib/*

javac -cp $CLASSPATH -sourcepath src -d ./WEB-INF/classes ../src/openwallet/util/*.java
javac -cp $CLASSPATH -sourcepath src -d ./WEB-INF/classes ../src/openwallet/bean/*.java
javac -cp $CLASSPATH -sourcepath src -d ./WEB-INF/classes ../src/openwallet/dao/*.java
