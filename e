[1mdiff --git a/Tienda/build.xml b/Tienda/build.xml[m
[1mindex 1245805..4159b6b 100644[m
[1m--- a/Tienda/build.xml[m
[1m+++ b/Tienda/build.xml[m
[36m@@ -7,8 +7,8 @@[m
 <!-- the Compile on Save feature is turned off for the project. -->[m
 <!-- You can turn off the Compile on Save (or Deploy on Save) setting -->[m
 <!-- in the project's Project Properties dialog box.-->[m
[31m-<project name="jdbc" default="default" basedir=".">[m
[31m-    <description>Builds, tests, and runs the project jdbc.</description>[m
[32m+[m[32m<project name="Tienda" default="default" basedir=".">[m
[32m+[m[32m    <description>Builds, tests, and runs the project Tienda.</description>[m
     <import file="nbproject/build-impl.xml"/>[m
     <!--[m
 [m
[36m@@ -58,7 +58,7 @@[m
 [m
     An example of overriding the target for project execution could look like this:[m
 [m
[31m-        <target name="run" depends="jdbc-impl.jar">[m
[32m+[m[32m        <target name="run" depends="Tienda-impl.jar">[m
             <exec dir="bin" executable="launcher.exe">[m
                 <arg file="${dist.jar}"/>[m
             </exec>[m
[1mdiff --git a/Tienda/build/classes/.netbeans_automatic_build b/Tienda/build/classes/.netbeans_automatic_build[m
[1mdeleted file mode 100644[m
[1mindex e69de29..0000000[m
[1mdiff --git a/Tienda/build/classes/.netbeans_update_resources b/Tienda/build/classes/.netbeans_update_resources[m
[1mdeleted file mode 100644[m
[1mindex e69de29..0000000[m
[1mdiff --git a/Tienda/build/classes/Dao/Dao.class b/Tienda/build/classes/Dao/Dao.class[m
[1mdeleted file mode 100644[m
[1mindex c6e4a19..0000000[m
Binary files a/Tienda/build/classes/Dao/Dao.class and /dev/null differ
[1mdiff --git a/Tienda/build/classes/Tienda/Tienda.class b/Tienda/build/classes/Tienda/Tienda.class[m
[1mdeleted file mode 100644[m
[1mindex 6247329..0000000[m
Binary files a/Tienda/build/classes/Tienda/Tienda.class and /dev/null differ
[1mdiff --git a/Tienda/nbproject/build-impl.xml b/Tienda/nbproject/build-impl.xml[m
[1mindex 11e0e2a..dc2cc25 100644[m
[1m--- a/Tienda/nbproject/build-impl.xml[m
[1m+++ b/Tienda/nbproject/build-impl.xml[m
[36m@@ -19,7 +19,7 @@[m [mis divided into following sections:[m
   - cleanup[m
 [m
         -->[m
[31m-<project xmlns:j2seproject1="http://www.netbeans.org/ns/j2se-project/1" xmlns:j2seproject3="http://www.netbeans.org/ns/j2se-project/3" xmlns:jaxrpc="http://www.netbeans.org/ns/j2se-project/jax-rpc" basedir=".." default="default" name="jdbc-impl">[m
[32m+[m[32m<project xmlns:j2seproject1="http://www.netbeans.org/ns/j2se-project/1" xmlns:j2seproject3="http://www.netbeans.org/ns/j2se-project/3" xmlns:jaxrpc="http://www.netbeans.org/ns/j2se-project/jax-rpc" basedir=".." default="default" name="Tienda-impl">[m
     <fail message="Please build using Ant 1.8.0 or higher.">[m
         <condition>[m
             <not>[m
[36m@@ -450,7 +450,7 @@[m [mis divided into following sections:[m
                     </fileset>[m
                 </union>[m
                 <taskdef classname="org.testng.TestNGAntTask" classpath="${run.test.classpath}" name="testng"/>[m
[31m-                <testng classfilesetref="test.set" failureProperty="tests.failed" listeners="org.testng.reporters.VerboseReporter" methods="${testng.methods.arg}" mode="${testng.mode}" outputdir="${build.test.results.dir}" suitename="jdbc" testname="TestNG tests" workingDir="${work.dir}">[m
[32m+[m[32m                <testng classfilesetref="test.set" failureProperty="tests.failed" listeners="org.testng.reporters.VerboseReporter" methods="${testng.methods.arg}" mode="${testng.mode}" outputdir="${build.test.results.dir}" suitename="Tienda" testname="TestNG tests" workingDir="${work.dir}">[m
                     <xmlfileset dir="${build.test.classes.dir}" includes="@{testincludes}"/>[m
                     <propertyset>[m
                         <propertyref prefix="test-sys-prop."/>[m
[36m@@ -601,7 +601,7 @@[m [mis divided into following sections:[m
                 <condition else="-testclass @{testClass}" property="test.class.or.method" value="-methods @{testClass}.@{testMethod}">[m
                     <isset property="test.method"/>[m
                 </condition>[m
[31m-                <condition else="-suitename jdbc -testname @{testClass} ${test.class.or.method}" property="testng.cmd.args" value="@{testClass}">[m
[32m+[m[32m                <condition else="-suitename Tienda -testname @{testClass} ${test.class.or.method}" property="testng.cmd.args" value="@{testClass}">[m
                     <matches pattern=".*\.xml" string="@{testClass}"/>[m
                 </condition>[m
                 <delete dir="${build.test.results.dir}" quiet="true"/>[m
[36m@@ -893,7 +893,7 @@[m [mis divided into following sections:[m
         <delete file="${built-jar.properties}" quiet="true"/>[m
     </target>[m
     <target if="already.built.jar.${basedir}" name="-warn-already-built-jar">[m
[31m-        <echo level="warn" message="Cycle detected: jdbc was already built"/>[m
[32m+[m[32m        <echo level="warn" message="Cycle detected: Tienda was already built"/>[m
     </target>[m
     <target depends="init,-deps-jar-init" name="deps-jar" unless="no.deps">[m
         <mkdir dir="${build.dir}"/>[m
[36m@@ -1378,7 +1378,7 @@[m [mis divided into following sections:[m
         <delete file="${built-clean.properties}" quiet="true"/>[m
     </target>[m
     <target if="already.built.clean.${basedir}" name="-warn-already-built-clean">[m
[31m-        <echo level="warn" message="Cycle detected: jdbc was already built"/>[m
[32m+[m[32m        <echo level="warn" message="Cycle detected: Tienda was already built"/>[m
     </target>[m
     <target depends="init,-deps-clean-init" name="deps-clean" unless="no.deps">[m
         <mkdir dir="${build.dir}"/>[m
[1mdiff --git a/Tienda/nbproject/genfiles.properties b/Tienda/nbproject/genfiles.properties[m
[1mindex fbe39c9..929b1eb 100644[m
[1m--- a/Tienda/nbproject/genfiles.properties[m
[1m+++ b/Tienda/nbproject/genfiles.properties[m
[36m@@ -1,8 +1,8 @@[m
[31m-build.xml.data.CRC32=e786d045[m
[31m-build.xml.script.CRC32=31211a8c[m
[32m+[m[32mbuild.xml.data.CRC32=21b2cc89[m
[32m+[m[32mbuild.xml.script.CRC32=94dac260[m
 build.xml.stylesheet.CRC32=8064a381@1.80.1.48[m
 # This file is used by a NetBeans-based IDE to track changes in generated files such as build-impl.xml.[m
 # Do not edit this file. You may delete it but then the IDE will never regenerate such files for you.[m
[31m-nbproject/build-impl.xml.data.CRC32=e786d045[m
[31m-nbproject/build-impl.xml.script.CRC32=6dd5d6b5[m
[32m+[m[32mnbproject/build-impl.xml.data.CRC32=21b2cc89[m
[32m+[m[32mnbproject/build-impl.xml.script.CRC32=9561f8b2[m
 nbproject/build-impl.xml.stylesheet.CRC32=830a3534@1.80.1.48[m
[1mdiff --git a/Tienda/nbproject/private/private.xml b/Tienda/nbproject/private/private.xml[m
[1mindex 0535cc3..4c7233b 100644[m
[1m--- a/Tienda/nbproject/private/private.xml[m
[1m+++ b/Tienda/nbproject/private/private.xml[m
[36m@@ -3,8 +3,9 @@[m
     <editor-bookmarks xmlns="http://www.netbeans.org/ns/editor-bookmarks/2" lastBookmarkId="0"/>[m
     <open-files xmlns="http://www.netbeans.org/ns/projectui-open-files/2">[m
         <group>[m
[31m-            <file>file:/C:/Users/alejo/OneDrive/PROYECTOS/CursoWeb/Java-MySql/jdbc/src/jdbc/Jdbc.java</file>[m
[31m-            <file>file:/C:/Users/alejo/OneDrive/PROYECTOS/CursoWeb/Java-MySql/jdbc/src/jdbc/Conection/DBConection.java</file>[m
[32m+[m[32m            <file>file:/C:/Users/alejo/OneDrive/PROYECTOS/CursoWeb/Java-MySql/jdbc/src/Tienda/persistencia/dao.java</file>[m
[32m+[m[32m            <file>file:/C:/Users/alejo/OneDrive/PROYECTOS/CursoWeb/Java-MySql/jdbc/src/Tienda/entidades/fabricante.java</file>[m
[32m+[m[32m            <file>file:/C:/Users/alejo/OneDrive/PROYECTOS/CursoWeb/Java-MySql/jdbc/src/Tienda/entidades/producto.java</file>[m
         </group>[m
     </open-files>[m
 </project-private>[m
[1mdiff --git a/Tienda/nbproject/project.properties b/Tienda/nbproject/project.