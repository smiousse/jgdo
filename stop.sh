#!/bin/sh
echo -- Stopping JGDO  ----------------
kill $(ps aux | grep '[j]gdo' | awk '{print $2}')