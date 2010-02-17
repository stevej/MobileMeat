import sbt._

trait Defaults {
  def androidPlatformName = "android-2.1"
}

class Mobilemeat(info: ProjectInfo) extends AndroidProject(info) with Defaults with MarketPublish {
  override def shouldCheckOutputDirectories = false
  override def updateAction = task { None }

  val scalatest = "org.scalatest" % "scalatest" % "1.0" % "test"
  val keyalias = "saladwithsteve_keys"
  override def keystorePath = Path.userHome / ".keystore" / "saladwithsteve.keystore"

  class TestProject(info: ProjectInfo) extends AndroidTestProject(info) with Defaults
}
