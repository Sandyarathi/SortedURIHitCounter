#!/bin/bash

export CLASSPATH=$(hadoop classpath)
export HADOOP_CLASSPATH=$CLASSPATH

javac -d classes HCMapper_Sandy036.java
javac -d classes HCReducer_Sandy036.java
jar -cvf HC_Sandy036.jar -C classes/ .
javac -classpath $CLASSPATH:HC_Sandy036.jar -d classes HCDriver_Sandy036.java
jar -uvf HC_Sandy036.jar -C classes/ .
