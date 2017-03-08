
enablePlugins(AndroidApp)

addCommandAlias("flavor1-release", ";variant release flavor1 ; android:packageRelease")
addCommandAlias("flavor1-debug", ";variant debug flavor1 ; android:packageDebug")
addCommandAlias("flavor2-release", ";variant release flavor2 ; android:packageRelease")
addCommandAlias("flavor2-debug", ";variant debug flavor2 ; android:packageDebug")

android.flavor("flavor1")(
  debugIncludesTests in Android := true,
  libraryDependencies ++=
    "com.android.support.test" % "runner" % "0.2" % "androidTest" ::
    "com.android.support.test.espresso" % "espresso-core" % "2.1" % "androidTest" ::
    Nil,
  instrumentTestRunner in Android :=
  "android.support.test.runner.AndroidJUnitRunner",
  packagingOptions in Android := PackagingOptions(excludes = Seq("LICENSE.txt")),
  javacOptions in Compile ++= List("-source", "1.7", "-target", "1.7")
)

android.flavor("flavor2")(
  name := "flavor2",
  debugIncludesTests in Android := true,
  libraryDependencies ++=
    "com.android.support.test" % "runner" % "0.2" % "androidTest" ::
      "com.android.support.test.espresso" % "espresso-core" % "2.1" % "androidTest" ::
      Nil,
  instrumentTestRunner in Android :=
    "android.support.test.runner.AndroidJUnitRunner",
  packagingOptions in Android := PackagingOptions(excludes = Seq("LICENSE.txt")),
  javacOptions in Compile ++= List("-source", "1.7", "-target", "1.7")
)

android.buildType("release")(
  proguardCache := Nil
)

android.buildType("debug")(
  // During release mode, we target API 19 and use MultiDex instead of DexShars,
  // and want to disable the ProGuard cache to force a full rebuild
)
name := "flavor1"
platformTarget := "android-25"
debugIncludesTests in Android := false

autoScalaLibrary := false

showSdkProgress in Android := false

javacOptions in Compile ++= List("-source", "1.7", "-target", "1.7")
