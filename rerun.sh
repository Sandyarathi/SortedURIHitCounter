#!/bin/bash

BASEDIR=/Sandy036LAB3/URIHitCounter

export CLASSPATH=$(hadoop classpath)
export HADOOP_CLASSPATH=$CLASSPATH

rm -rf $BASEDIR/OUT
hadoop jar HC_Sandya036.jar HC_Sandya036.HCDriver_Sandya036; $BASEDIR/DATA/ $BASEDIR/OUT 

