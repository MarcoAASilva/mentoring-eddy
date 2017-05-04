# Mentoring Session 01

Welcome to our first session!

## Maven Build

This simple project can be built using Maven that comes bundled with Eclipse Neon

## Traditional build

Or it can be build manually by these incantations

'''
$ cd mentoring-eddy-session01
$ javac -d ./target src/main/java/**/*.java
$ cd target
$ jar cvf Session01.jar *
$ cd ..
$ javadoc -d ./doc -sourcepath ./target/classes


'''

