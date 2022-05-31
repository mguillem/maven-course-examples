# Usage

This folder contains a project with only a few classes. Normally the compiler plugin compiles a project only when files have been changed. Here it is not the case: a compilation is performed by each call to compile:


```
$> mvn compile compile
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------< maven.course.exercises:mvn.08.exercise-debug >------------
[INFO] Building mvn.08.exercise-debug 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ mvn.08.exercise-debug ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /exercises/mvn.08.exercise-debug/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ mvn.08.exercise-debug ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 10 source files to /exercises/mvn.08.exercise-debug/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ mvn.08.exercise-debug ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /exercises/mvn.08.exercise-debug/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ mvn.08.exercise-debug ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 10 source files to /exercises/mvn.08.exercise-debug/target/classes
...
```

# Exercise goal
- find what is the reason of the cache invalidation (without looking at each class, imagine this happens on avery large project)

