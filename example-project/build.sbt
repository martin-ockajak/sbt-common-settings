name := "example-project"

version := "1.2.3"

libraryDependencies ++= Seq(
  "com.jsuereth"                        %% "scala-arm"                % "1.4"
)



// Common settings provided by SBT common settings plugin
CommonSettings()

