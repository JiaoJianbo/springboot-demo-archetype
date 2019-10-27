# springboot-demo-archetype
A maven archetype for creating a spring boot demo project.

可以像一个普通 Maven 工程一样，从头开始搭建。也可以从现有的一个 Maven 工程抽出一个 archetype 工程作为基础。
`mvn archetype:create-from-project` 或使用完整的命令 `mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:create-from-project`.

比如在 springboot-demo2 工程目录下执行 `mvn archetype:create-from-project`，最终会生成一个 archetype 的 Maven 工程，位于 
target\generated-sources\archetype 目录下。我们便可以拷贝这个 archetype 作为一个初始化的工程，在此基础上在加入需要的功能。

## 项目的基本结构如下：

![project structure](/doc/images/project-structure.jpg)

首先，这是跟普通的Maven 工程结构一样。有 src/main, src/test， 有 pom.xml 文件。

将来使用 archetype 工程创建出来的工程的内容都位于`src/main/resources/archetype-resources` 目录下。 
其中`META-INF/maven/archetype-metadata.xml` 和 `projects/basic/archetype.properties` 是两个比较重要的配置文件。


## 常见配置

默认配置通常有 groupId, artifactId, version, package。package 的默认值跟 groupId 一样。 

## 自定义配置

通常我们也会添加一些自定义的配置作为变量来创建不同的基础工程。如在这个 archetype 中加入了配置项 `port`，这样在创建新工程时可以通过 
`port` 参数指定不同的应用端口。 

自定义配置写在 `META-INF/maven/archetype-metadata.xml` 中，也可以设定默认值。

```xml
<archetype-descriptor>
  <fileSets>
    <!-- 
    ......
    -->
  </fileSets>
  <requiredProperties>
    <requiredProperty key="version">
      <defaultValue>0.0.1-SNAPSHOT</defaultValue>
    </requiredProperty>
    <requiredProperty key="port"/>
    <requiredProperty key="resource"/>
    <requiredProperty key="author"/>
  </requiredProperties>
</archetype-descriptor>
```

另外，还需要特别注意，这里配置的变量最终还要在 `src/test/resources/projects/basic/archetype.properties` 中配置，并给个默认值。
```properties
###自定义配置
port=8080
resource=Employee
author=Bobby
```
还要一点需要注意，要想使配置的变量生效，需要 `META-INF/maven/archetype-metadata.xml` 中相应的 `fileSet` 添加属性 `filtered="true"`，
```xml
    <fileSet filtered="true" encoding="UTF-8">
      <directory>src/main/resources</directory>
      <includes>
        <include>**/*.yml</include>
      </includes>
    </fileSet>
```
这样，YAML 中配置的 `port` 值在初始化工程时才会被具体的变量值替换。否则，`port: ${port}`，并不会替换成对应的参数值。 



因为这些值需要在插件的 `integration-test` 阶段用到，否则就会报错，
```text
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-archetype-plugin:3.1.2:integration-test (default-integration-test) on project springboot-demo-archet
ype:
[ERROR] Archetype IT 'basic' failed: Missing required properties in archetype.properties: port, resource, author
[ERROR] -> [Help 1]
```

## 配置的使用

### 文件中使用配置
    
使用 `${}` 括住变量名，即可。如 `${package}`。
        
### 文件名中使用配置
    
有时候我们需要动态生成文件名，即在文件名中使用配置的变量。那么就在配置参数**前后加两个下滑线**，如 `__resource__`。
    
## 如何使用自定义的 archetype

当我们的 archetype 工程准备好之后，就可以使用了。

首先，可以使用 `mvn clean install`，将 archetype 工程安装到本地。如果 `BUILD SUCCESS`，就会安装该 archetype 工程到本地的 Maven 仓库中，
并更新（如果以前没有会新生成一个） Maven 仓库根目录下的 `archetype-catalog.xml` 文件。如果不能自动生成，可以使用 `mvn archetype:crawl` (
或者 `mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:crawl`)单独生成一次。
```xml
<archetype-catalog xsi:schemaLocation="http://maven.apache.org/plugins/maven-archetype-plugin/archetype-catalog/1.0.0 http://maven.apache.org/xsd/archetype-catalog-1.0.0.xsd"
    xmlns="http://maven.apache.org/plugins/maven-archetype-plugin/archetype-catalog/1.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <archetypes>
    <archetype>
      <groupId>com.bravo.demo</groupId>
      <artifactId>springboot-demo-archetype</artifactId>
      <version>0.0.1-SNAPSHOT</version>
      <description>Demo project for Spring Boot</description>
    </archetype>
  </archetypes>
</archetype-catalog>
```

archetype 工程安装到本地仓库后，接下来就可以使用它来初始化新的工程了。可以使用命令 `mvn archetype:generate -DarchetypeCatalog=local`，
然后采用交互式一步一步进行创建。

![gernerate from local](/doc/images/generate-from-local.jpg)

或者使用一条完整的命令
```
mvn archetype:generate -DarchetypeGroupId=com.bravo.demo -DarchetypeArtifactId=springboot-demo-archetype -DarchetypeVersion=0.0.1-SNAPSHOT -DgroupId=com.bravo.demo -DartifactId=archetype-demo -Dport=8888 -Dauthor=Bobby -Dresource=User -DarchetypeCatalog='local' -DinteractiveMode=false
```

最终生成的工程的结构：

![generated project structure](/doc/images/generated-proj-structure.jpg)

除了使用本地的 archetype 工程外，还可以使用远程 Maven 仓库的 archetype。只要不指定参数 `archetypeCatalog` 的值，或者指定值为 `'remote'`。

maven-archetype-plugin 插件以前的 2.x 版本还支持使用 `http://` 和 `file:///` 的方式指定 `archetypeCatalog`。但是在 3.x 版本中已经不支持了。

参考：

[Maven Archetype Plugin](http://maven.apache.org/archetype/maven-archetype-plugin/)  

[Archetype Metadata](http://maven.apache.org/archetype/maven-archetype-plugin/specification/archetype-metadata.html)
