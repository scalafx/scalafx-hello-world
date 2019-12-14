scalafx-hello-world
===================

Simple example of a ScalaFX application using [Simple-Build-Tool](http://www.scala-sbt.org/) (SBT).


Content
-------

* `src/main/scala/hello/ScalaFXHelloWorld.scala` - sample ScalaFX application.
* `build.sbt` - the main SBT configuration file.
* `project/build.properties` - version of SBT to use.
* `project/plugins.sbt` - plugins used for creation of IDEA and Eclipse projects.


How to build and Run
--------------------

1. Install [Java 11 JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or newer. This project should also work with Java 10. If you are want to use Java 8 look at the [SFX-8](https://github.com/scalafx/scalafx-hello-world/tree/SFX-8) branch of this project.

2. Install [SBT](http://www.scala-sbt.org/)

3. Run the example: change to directory containing this example and use SBT to
   build and run the example:

   ```
    %> sbt run
   ```

   It will download needed dependencies, including Scala and ScalaFX, and run 
   the example code. 


Import into IDEA or NetBeans
----------------------------

IntelliJ IDEA and NetBeans with Scala plugins can directly import SBT projects. 


Create project for Eclipse
-------------------------

If you want to create project that can be used with Eclipse, inside
this project directory, at command prompt type:

    %> sbt eclipse


Additional Information
----------------------

Detailed description of similar example can be found in the blog post
["Getting Started with ScalaFX: Compile and Run"](http://codingonthestaircase.wordpress.com/2013/05/17/getting-started-with-scalafx-compile-and-run-2/).
