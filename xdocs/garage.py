import RPi.GPIO as GPIO #import the GPIO library
import time

GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)

GPIO.setup(7, GPIO.OUT)
GPIO.output(7, GPIO.HIGH)

name = "Stephane"
print("Hello " + name)


time.sleep(.5)
#End GPIO Added Information

GPIO.output(7, GPIO.LOW)
time.sleep(1)
GPIO.output(7, GPIO.HIGH)
print "Open Garage Door"