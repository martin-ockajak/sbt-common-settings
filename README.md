## SBT Common Settings Plugin Template
Use and modify this SBT plugin template to share common settings among multiple SBT projects.

Unlike [classic multi-project setup](http://www.scala-sbt.org/1.0/docs/Multi-Project.html) this approach also works for independent builds.

Detailed technical description can be found [here](https://engineering.sharethrough.com/blog/2015/09/23/capturing-common-config-with-an-sbt-parent-plugin/).


## Requirements
SBT 0.13.x or greater


## Setup
* Add _sbt-common-settings_ project into your repository
* Modify shared build configuration as needed:
 * Common SBT plugins in `sbt-common-settings/plugins.sbt`
 * Common SBT settings in `sbt-common_settings/settings/CommonSettings.scala`
* Run `sbt compile` in _sbt-common-settings_ project to validate the configuration.


## Usage

Add common settings reference to `build.sbt` of your SBT projects:

```scala
CommonSettings()
```

* This may be omitted if common settings do not affect other SBT [auto plugins](http://www.scala-sbt.org/1.0/docs/Using-Plugins.html)

Then add common settings plugin dependency by including one of the following in `project/plugins.sbt`:



#### Project dependency

```scala
lazy val root = project.in( file(".") ).dependsOn( file("../../sbt-common-settings") )
```

* Modify the common settings project path accordingly
* This results in slower build but common settings changes are applied immediately.


#### Artifact dependency

```scala
resolvers += "Artifacts" at "https://artifacts.example.org/repository"

addSbtPlugin("build.sbt" % "sbt-common-settings" % "0.0.1") 
```

* Modify the artifacts repository URL and the plugin version accordingly
* This results in faster build but common settings plugin must be published to an artifact repository after changes.



## Example
* See _example-project_


