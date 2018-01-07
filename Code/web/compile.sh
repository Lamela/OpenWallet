CLASSPATH=./WEB-INF/classes:./WEB-INF/lib/*

javac -cp $CLASSPATH -sourcepath src -d ./WEB-INF/classes ../src/openwallet//bean/*.java

