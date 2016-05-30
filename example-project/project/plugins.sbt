// Common settings plugin as a project
lazy val root = project.in( file(".") ).dependsOn( file("../../sbt-common-settings") )



// Common settings plugin as an artifact
//resolvers += "Artifacts" at "https://artifacts.example.org/repository"

//addSbtPlugin("build.sbt" % "sbt-common-settings" % "0.0.1") 

