scalaVersion := "2.12.10"
name := "spark-nlp-proj"
version := "1.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.3"
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "3.0.3"
libraryDependencies += "com.johnsnowlabs.nlp" %% "spark-nlp" % "3.4.4"