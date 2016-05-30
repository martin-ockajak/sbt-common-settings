// Artifact
organization := "build.sbt"

name := "sbt-common-settings"

version := "0.0.1"

sbtPlugin := true


// Sources
scalaSource in Compile := baseDirectory.value / "settings"


// Publishing
publishTo := Some("Artifacts" at "https://artifacts.example.org/repository")

//credentials += Credentials(baseDirectory.value / "repository.conf") 



/**
 * Common SBT plugins for dependent projects.
 */
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")

addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.1.10")

addSbtPlugin("org.scalastyle" % "scalastyle-sbt-plugin" % "0.8.0")

addSbtPlugin("de.johoop" % "cpd4sbt" % "1.1.5")

