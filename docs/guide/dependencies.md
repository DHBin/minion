# 引入依赖

```shell script
git clone https://gitee.com/FYMD/minion.git
cd minion
mvn run install 
```

```xml
    <dependencyManagement>
        <dependencies>
            <!--minion-->
            <dependency>
                <groupId>cn.dhbin</groupId>
                <artifactId>minion</artifactId>
                <version>${minion.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```
