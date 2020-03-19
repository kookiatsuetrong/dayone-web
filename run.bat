set JAVA_HOME=\tools\jdk-14
\tools\apache-maven\bin\mvn.cmd package
\tools\jdk-14\bin\java -jar jetty.jar --port 4000 target/main-web
