CLASSPATH=./WEB-INF/classes:./WEB-INF/lib/*

javac -cp $CLASSPATH -sourcepath src -d ./WEB-INF/classes ../src/openwallet/util/*.java
javac -cp $CLASSPATH -sourcepath src -d ./WEB-INF/classes ../src/openwallet/bean/*.java
javac -cp $CLASSPATH -sourcepath src -d ./WEB-INF/classes ../src/openwallet/dao/*.java
javac -cp $CLASSPATH -sourcepath src -d ./WEB-INF/classes ../src/openwallet/filter/*.java
javac -cp $CLASSPATH -sourcepath src -d ./WEB-INF/classes ../src/openwallet/servlet/*.java

jar cf Openwallet.war WEB-INF include admin
cp Openwallet.war /Library/apache-tomcat-8.5.23/webapps
