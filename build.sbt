name := "scalamoo"
version := "0.0.2"
scalaVersion := "2.12.2"

resolvers += "scalac repo" at "https://raw.githubusercontent.com/ScalaConsultants/mvn-repo/master/"

libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
libraryDependencies += "org.scala-lang.modules" %% "scala-pickling" % "0.10.1"
libraryDependencies += "org.specs2" %% "specs2-core" % "3.8.3" % "test"
libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2" % "test"
libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.3"
libraryDependencies += "io.scalac" %% "slack-scala-bot-core" % "0.2.1"