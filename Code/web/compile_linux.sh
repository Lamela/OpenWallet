CLASSPATH=./WEB-INF/classes:./WEB-INF/lib/*

javac -cp $CLASSPATH -sourcepath src -d ./WEB-INF/classes ../src/openwallet/util/*.java
javac -cp $CLASSPATH -sourcepath src -d ./WEB-INF/classes ../src/openwallet/bean/*.java
javac -cp $CLASSPATH -sourcepath src -d ./WEB-INF/classes ../src/openwallet/dao/*.java
javac -cp $CLASSPATH -sourcepath src -d ./WEB-INF/classes ../src/openwallet/filter/*.java
javac -Xlint:deprecation -Xlint:unchecked -cp $CLASSPATH -sourcepath src -d ./WEB-INF/classes ../src/openwallet/servlet/*.java

jar cf Openwallet.war WEB-INF include admin css fonts images js style.css img *.jsp
cp Openwallet.war ~/Downloads/apache-tomcat-8.5.24/webapps
