ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.5.2"

lazy val root = (project in file("."))
  .dependsOn(andromeda)
  .aggregate(andromeda)

lazy val andromeda = project
