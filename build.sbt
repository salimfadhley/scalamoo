name := "scalamoo"
version := "0.0.2"
scalaVersion := "2.12.2"

resolvers += "scalac repo" at "https://raw.githubusercontent.com/ScalaConsultants/mvn-repo/master/"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "com.typesafe" % "config" % "1.3.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.4"