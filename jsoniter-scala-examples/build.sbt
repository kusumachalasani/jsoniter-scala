val `jsoniter-scala-examples` = project.in(file("."))
  .settings(
    scalaVersion := "2.13.1",
    scalacOptions ++= Seq("-Xmacro-settings:print-codecs"),
    crossScalaVersions := Seq("2.13.1", "2.12.11", "2.11.12"),
    mainClass in assembly := Some("com.github.plokhotnyuk.jsoniter_scala.examples.Example01"),
    libraryDependencies ++= Seq(
      "org.graalvm.nativeimage" % "svm" % "20.0.0" % "compile-internal", // required only for compilation to GraalVM native-image
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % "latest.integration",
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "latest.integration" % "compile-internal" // required only in compile-time
    ),
    assemblyShadeRules in assembly := Seq(
      ShadeRule.rename("com.github.plokhotnyuk.jsoniter_scala.core.**" -> "shaded.jsoniter_scala.latest.integration.core.@1").inAll
    )
  )
