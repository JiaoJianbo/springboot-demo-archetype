# springboot-demo-archetype
A maven archetype for creating a spring boot demo project.

可以像一个普通 Maven 工程一样，从头开始搭建。也可以从现有的一个 Maven 工程抽出一个 archetype 工程作为基础。
`mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:create-from-project` 或者简写为 `mvn archetype:create-from-project`.

比如在 springboot-demo2 工程目录下执行 `mvn archetype:create-from-project`，最终会生成一个 archetype 的 Maven 工程，位于 target\generated-sources\archetype 目录下。我们便可以拷贝这个 archetype 作为一个初始化的工程，在此基础上在加入需要的功能。

## 项目的基本结构如下：

![project structure](/doc/images/project-structure.jpg)

首先，这是跟普通的Maven 工程结构一样。有 src/main, src/test， 有 pom.xml 文件。

将来使用 archetype 工程创建出来的工程的内容都位于`src/main/resources/archetype-resources` 目录下。 其中`META-INF/maven/archetype-metadata.xml` 和 `projects/basic/archetype.properties` 是两个比较重要的配置文件。


## 常见配置

## 自定义配置

## 配置的使用

    - 文件中使用配置
    - 文件名中使用配置
    
## 如何使用自定义的 archetype

`archetype:crawl`

`archetype:generate`

参考：

[Maven Archetype Plugin](http://maven.apache.org/archetype/maven-archetype-plugin/)  

[Archetype Metadata](http://maven.apache.org/archetype/maven-archetype-plugin/specification/archetype-metadata.html)