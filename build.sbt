name := "scalamoo"
version := "0.0.1"
scalaVersion := "2.11.8"

val jackson_version = "2.1.1"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "2.2.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scala-lang.modules" %% "scala-pickling" % "0.10.1",
  "org.specs2" %% "specs2-core" % "3.8.3" % "test",
  "com.fasterxml.jackson.core" % "jackson-core" % jackson_version,
  "com.fasterxml.jackson.core" % "jackson-annotations" % jackson_version,
  "com.fasterxml.jackson.core" % "jackson-databind" % jackson_version,
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % jackson_version
)

scalacOptions in Test ++= Seq("-Yrangepos")