# Mentoring Eddy

## Session 02

After a brief pause, we're ready for the second session.

The repo has been renamed simply as "mentoring-eddy", as it will now contain code from all the sessions

To get the HEAD of the repo:

```
$ git clone https://github.com/MarcoAASilva/mentoring-eddy
```

To get the available tags on the remote:

```
$ git ls-remote --tags
```

To move to a specific tag:

```
$ git checkout tags/SWING0

...

$ git checkout master
```


## Session 01

Welcome to our first session!

## Maven Build

This simple project can be built using Maven that comes bundled with Eclipse Neon, or via the command line:

```
$ mvn clean site package

```

## Traditional build

Or it can be build manually by these incantations

```
$ cd mentoring-eddy-session01
$ javac -d ./target src/main/java/**/*.java
$ cd target
$ jar cvf ./dist/mentoring-eddy-0.0.1.jar *
$ cd ..
$ javadoc -d ./docs -sourcepath ./target/classes
```


