import sbt._

class ExecutableProject(info: ProjectInfo) extends DefaultProject(info)  {
  override def mainClass = Some("com.philipsears.wordler.Wordler")
}
