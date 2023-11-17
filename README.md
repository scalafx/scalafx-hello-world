scalafx-hello-world
===================

Simple example of a ScalaFX application using [Simple-Build-Tool](http://www.scala-sbt.org/) (SBT).

Branches
--------

Branch [master](https://github.com/scalafx/scalafx-hello-world/tree/master) contains an example with the current Scala 3
syntax,
branch [Scala2](https://github.com/scalafx/scalafx-hello-world/tree/Scala2) contains the same example with the old Scala
2 syntax.


Content
-------

* `src/main/scala/hello/ScalaFXHelloWorld.scala` - sample ScalaFX application.
* `build.sbt` - the main SBT configuration file.
* `project/build.properties` - version of SBT to use.
* `project/plugins.sbt` - plugins used for creation of IDEA and Eclipse projects.

How to build and Run
--------------------

1. Install [Java 17 JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or newer. 
   If you are want to use Java 8 look at the [SFX-8](https://github.com/scalafx/scalafx-hello-world/tree/SFX-8) branch of this project.

2. Install [SBT](http://www.scala-sbt.org/)

3. Run the example: change to the directory containing this example and use SBT to build and run the example:

   ```
    %> sbt run
   ```

   It will download needed dependencies, including Scala and ScalaFX, and run the example code.

Additional Information
----------------------

Detailed description of similar example can be found in the blog post
["Getting Started with ScalaFX: Compile and Run"](http://codingonthestaircase.wordpress.com/2013/05/17/getting-started-with-scalafx-compile-and-run-2/)
.

Gradle Version
-----------

[Gradle](https://gradle.org/) version of this example can be found
in [ScalaFX-Hello-World-Gradle](https://github.com/scalafx/ScalaFX-Hello-World-Gradle)
