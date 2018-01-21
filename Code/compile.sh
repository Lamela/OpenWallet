#!bin/bash
#author Sandratra
#bash -x compile.sh $1

if [ $# -eq 1 ]; then
  if [ $1 == "compile" ]; then

    javac -classpath ./classes -sourcepath ./src -d ./classes ./openwallet/bean/*.java
    javac -classpath ./classes -sourcepath ./src -d ./classes ./src/openwallet/dao/*.java
    javac -classpath ./classes -sourcepath ./src -d ./classes ./src/openwallet/filter/*.java
    javac -classpath ./classes -sourcepath ./src -d ./classes ./src/openwallet/servlet/*.java
    javac -classpath ./classes -sourcepath ./src -d ./classes ./src/openwallet/util/*.java
    javac -classpath ./classes -sourcepath ./src -d ./classes ./src/openwallet/dao/*.java

    javac -classpath  /usr/share/java/junit4.jar:./classes:./classestest -sourcepath ./srctest:./src -d ./classestest ./srctest/openwallet/dao/*.java
    javac -classpath  /usr/share/java/junit4.jar:./classes:./classestest -sourcepath ./srctest:./src -d ./classestest ./srctest/openwallet/*.java
  elif  [ $1 == "exec" ]; then
    java -classpath classes openwallet.SuiteAll
  elif  [ $1 == "clear"]; then
    rm -rf ./classes/
  else
    echo "argument non reconnu"
  fi
fi
