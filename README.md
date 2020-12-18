# student_docker_maven_plugin

docker image: https://hub.docker.com/repository/docker/thiethaa/student-docker-plugin

to pull and run image:
         
         docker pull thiethaa/student-docker-plugin:v4.0.0
         
         docker run -p 8000:8080 thiethaa/student-docker-plugin:v4.0.0  
        
        http://localhost:8000/welcome
        

Build docker image:

                <build>
                    <plugins>
                        <plugin>
                            <groupId>com.spotify</groupId>
                            <artifactId>dockerfile-maven-plugin</artifactId>
                            <version>1.4.13</version>
                            <executions>
                                <execution>
                                    <id>default</id>
                                    <goals>
                                        <goal>build</goal>
                                        <goal>push</goal>
                                    </goals>
                                </execution>
                            </executions>
                            <configuration>
                                <repository>${project.artifactId}</repository>
                                <tag>latest</tag>
                                <buildArgs>
                                    <JAR_FILE>target/${project.build.finalName}.jar</JAR_FILE>
                                </buildArgs>
                            </configuration>
                        </plugin>
                    </plugins>
                    <finalName>${project.artifactId}</finalName>
                </build>

Build and Push Docker image to Docker Hub:

     <build>
          <plugins>
              <plugin>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-maven-plugin</artifactId>
              </plugin>
              <plugin>
                  <groupId>com.spotify</groupId>
                  <artifactId>dockerfile-maven-plugin</artifactId>
                  <version>1.4.13</version>
                  <configuration>
                      <!--added useMavenSettingAuth tag and set to be true to read the credential from settings.xml under ~/.m2 folder-->
                      <useMavenSettingsForAuth>true</useMavenSettingsForAuth>
                      <!-- ***********************************************************************************************************-->
                      <repository>thiethaa/${project.artifactId}</repository>
                      <!--change docker image tag -->
                      <tag>v2</tag>
                      <!--*************************-->
                      <buildArgs>
                          <JAR_FILE>target/${project.build.finalName}.jar</JAR_FILE>
                      </buildArgs>
                  </configuration>
                  <executions>
                      <execution>
                          <id>default</id>
                          <phase>install</phase>
                          <goals>
                              <goal>build</goal>
                              <goal>push</goal>
                          </goals>
                      </execution>
                  </executions>
              </plugin>
          </plugins>
          <finalName>student-docker-build-push-from-maven-plugin</finalName>
      </build>
      
      
  Create settings.xml file under ~/.m2 folder for Authentication:
  
          <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
                  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                                  https://maven.apache.org/xsd/settings-1.0.0.xsd">
            <servers>
                <server>
                    <id>docker.io</id>
                    <username>Your username</username>
                    <password>Your password</password>
                    <configuration>
                        <email>Your Email</email>
                    </configuration>
                </server>
            </servers>
        </settings>
  
