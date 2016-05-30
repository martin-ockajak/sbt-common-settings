import sbt.Keys._
import sbt._
import org.scalastyle.sbt.ScalastylePlugin._
import de.johoop.cpd4sbt.CopyPasteDetector._
import de.johoop.cpd4sbt.OutputType

object CommonSettings extends AutoPlugin {
  /**
    * Common keys.
    */
  object autoImport {
    lazy val analyze = taskKey[Unit]("Performs static code analysis.")
  }

  import autoImport._

  /**
    * Common settings.
    */
  override def projectSettings = Seq(
    // Artifact
    organization := "org.example",

    // Dependencies
    libraryDependencies ++= Seq(
      "com.typesafe.scala-logging"          %% "scala-logging"            % "3.4.0",
      "ch.qos.logback"                      %  "logback-classic"          % "1.1.7"
    ),

    // Compile
    scalaVersion := "2.11.8",
    scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xfuture", "-Xlint", "-Xlog-free-terms",
      "-Xlog-free-types", "-Ywarn-dead-code", "-Ywarn-numeric-widen", "-Ywarn-unused", "-Ywarn-unused-import"),
    javacOptions ++= Seq("-encoding", "UTF-8"),

    // Test
    testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oDF"),

    // Analyze
    scalastyleConfig := baseDirectory.value / "scalastyle-config.xml",
    cpdOutputType := OutputType.Console,
    analyze := {},
    analyze <<= analyze dependsOn ((scalastyle in Compile).toTask(""), cpd)

    // Plugin settings
  ) ++ cpdSettings

  override def trigger = AllRequirements

  def apply() = projectSettings
}

