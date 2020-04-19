#!/bin/sh
echo -- Starting JGDO  ----------------
cd /home/pi/jgdo/
nohup java  -Djgdo.home.path=/home/pi/jgdo/ -jar jgdo-1.0-SNAPSHOT-jar-with-dependencies.jar </dev/null >jgdo.log 2>&1 &