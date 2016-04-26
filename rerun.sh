#!/bin/bash

BASEDIR=/input/

export CLASSPATH=$(hadoop classpath)
export HADOOP_CLASSPATH=$CLASSPATH

rm -rf $BASEDIR/OUT
hadoop jar HC_Sandy036.jar HC_Sandy036.HCDriver_Sandy036; input/ $BASEDIR/OUT 

