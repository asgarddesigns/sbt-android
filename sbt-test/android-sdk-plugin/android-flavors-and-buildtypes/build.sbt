
enablePlugins(AndroidApp).withSettings

addCommandAlias("flavor1-release", ";variant release flavor1 ; android:packageRelease")
addCommandAlias("flavor1-debug", ";variant debug flavor1 ; android:packageDebug")
addCommandAlias("flavor2-release", ";variant release flavor2 ; android:packageRelease")
addCommandAlias("flavor2-debug", ";variant debug flavor2 ; android:packageDebug")

android.flavor("flavor1")(
  name := "flavor1"
)

android.flavor("flavor2")(
  name := "flavor2"
)

android.buildType("release")(
  proguardCache := Nil
)

android.buildType("debug")(

)
name := "flavor"
platformTarget := "android-25"

javacOptions in Compile ++= List("-source", "1.7", "-target", "1.7")
packagingOptions in Android := PackagingOptions(excludes = Seq("LICENSE.txt"))

debugIncludesTests in Android := true

instrumentTestRunner in Android :=
  "android.support.test.runner.AndroidJUnitRunner"

libraryDependencies ++=
  "com.android.support.test" % "runner" % "0.2" % "androidTest" ::
    "com.android.support.test.espresso" % "espresso-core" % "2.1" % "androidTest" ::
    Nil

autoScalaLibrary := false

showSdkProgress in Android := false