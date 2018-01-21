#!bin/bash
#author Sandratra
#bash -x compile.sh $1

if [ $# -eq 1 ]; then
  if [ $1 == "compile" ]; then
    javac -classpath  ./web/WEB-INF/classes/openwallet/bean/*.class:/usr/share/java/junit4.jar:./classes:./classestest -sourcepath ./srctest -d ./classestest/openwallet/bean ./srctest/openwallet/bean/*.java
    javac -classpath  ./web/WEB-INF/classes/openwallet/bean/*.class:/usr/share/java/junit4.jar:./classestest -sourcepath ./srctest -d ./classestest ./srctest/openwallet/*.java
  elif  [ $1 == "exec" ]; then
    java -classpath classestest openwallet.SuiteAll
  elif  [ $1 == "remove"]; then
    rm -rf ./classes/
    rm -rf ./classestest/
  else
    echo "argument non reconnu"
  fi
fi
