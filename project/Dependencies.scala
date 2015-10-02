import sbt._

object Version {
  val scala        = "2.11.7"
  val scalaTest    = "2.2.4"
  val logback      = "1.1.3"
  val slf4j        = "1.7.12"
  val scalaLogging = "3.1.0"
  val squants      = "0.5.3"
  val nScalaTime   = "2.2.0"
}

object Dependencies {

  val airScala = List(
    // Scala Wrappers for Joda-Time
    "org.slf4j"                  %   "slf4j-api"       % Version.slf4j,
    "ch.qos.logback"             %   "logback-core"    % Version.logback,
    "ch.qos.logback"             %   "logback-classic" % Version.logback,
    "org.scalatest"              %%  "scalatest"       % Version.scalaTest     % "test"
  )
}
