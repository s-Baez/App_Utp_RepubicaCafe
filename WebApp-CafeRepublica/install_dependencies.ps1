Invoke-WebRequest -Uri "https://download.java.net/java/early_access/jdk11/7/GPL/openjdk-11.0.1_windows-x64_bin.zip" -OutFile "openjdk.zip"
Expand-Archive -Path "openjdk.zip" -DestinationPath "C:\Program Files\Java"
$env:JAVA_HOME = "C:\Program Files\Java\jdk-11.0.1"
$env:PATH = "$env:JAVA_HOME\bin;$env:PATH"
java -version

Invoke-WebRequest -Uri "https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.23.zip" -OutFile "mysql-connector.zip"
Expand-Archive -Path "mysql-connector.zip" -DestinationPath "C:\Program Files\MySQL"

Invoke-WebRequest -Uri "https://apache.osuosl.org/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.zip" -OutFile "maven.zip"
Expand-Archive -Path "maven.zip" -DestinationPath "C:\Program Files\Apache Maven"
$env:MAVEN_HOME = "C:\Program Files\Apache Maven\apache-maven-3.8.1"
$env:PATH = "$env:MAVEN_HOME\bin;$env:PATH"
mvn -v

Invoke-WebRequest -Uri "https://downloads.apache.org/tomcat/tomcat-10/v10.1.10/bin/apache-tomcat-10.1.10-windows-x64.zip" -OutFile "tomcat.zip"
Expand-Archive -Path "tomcat.zip" -DestinationPath "C:\opt"
Rename-Item "C:\opt\apache-tomcat-10.1.10" "C:\opt\tomcat"

java -version
mvn -v
& "C:\opt\tomcat\bin\version.bat"