# BukkitCord
//等待补充
## 开发者API
### 引用
#### Maven
```xml
<repositories>
	<!--Github 线路-->
	<repository>
		<id>DreamlessRealm-Repo</id>
		<url>https://raw.githubusercontent.com/DreamlessRealm/maven-repo/master</url>
	</repository>
	<!--FastGit 镜像线路-->
	<repository>
		<id>DreamlessRealm-Repo-FastGit</id>
		<url>https://raw.fastgit.org/DreamlessRealm/maven-repo/master</url>
	</repository>
	<!--两条线路二选一，按照自己的情况而定-->
</repositories>
```
```xml
<dependency>
	<groupId>top.dsbbs2</groupId>
	<artifactId>bukkitcord</artifactId>
	<version>1.0-SNAPSHOT</version>
	<scope>provided</scope>
</dependency>
```
#### Gradle
##### 仓库
```groovy
repositories {
	//Github 线路
	maven { url 'https://raw.githubusercontent.com/DreamlessRealm/maven-repo/master' }
	//FastGit 镜像线路
	maven { url 'https://raw.fastgit.org/DreamlessRealm/maven-repo/master' }
	//两条线路二选一，按照自己的情况而定
}
```
```text
dependencies {
        provided 'top.dsbbs2:bukkitcord:1.0-SNAPSHOT'
}
```
