import sbt.*

object Dependencies {
  val catsVersion           = "2.12.0"
  val catsEffectVersion     = "3.5.5"
  val kittensVersion        = "3.4.0"
  val zioVersion            = "2.1.12"
  val zioPreludeVersion     = "1.0.0-RC34"
  val zioCatsInteropVersion = "23.1.0.3"

  val catsDependencies = Seq(
    "org.typelevel" %% "cats-core"   % catsVersion,
    "org.typelevel" %% "cats-free"   % catsVersion,
    "org.typelevel" %% "cats-effect" % catsEffectVersion,
    "org.typelevel" %% "kittens"     % kittensVersion
  )

  val zioDependencies = Seq(
    "dev.zio" %% "zio"              % zioVersion,
    "dev.zio" %% "zio-interop-cats" % zioCatsInteropVersion,
    "dev.zio" %% "zio-prelude"      % zioPreludeVersion,
    "dev.zio" %% "zio-test"         % zioVersion % Test,
    "dev.zio" %% "zio-test-sbt"     % zioVersion % Test
  )
}
