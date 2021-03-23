### 介绍 

maven是一个跨平台的项目管理工具，主要服务于Java平台的项目构建、依赖管理和项目信息管理。项目构建：通过插件帮你完成项目的清理、编译、测试、打包、部署；依赖管理：通过坐标从maven仓库导入java类库（jar文件）；项目信息管理：项目描述、开发者列表、版本控制系统地址、许可证、缺陷管理系统地址等。
- 官网
   - [https://maven.apache.org/](https://maven.apache.org/)
- 学习
	- 1、maven跳过单元测试-maven.test.skip和skipTests的区别
```
	-DskipTests，不执行测试用例，但编译测试用例类生成相应的class文件至target/test-classes下。
	-Dmaven.test.skip=true，不执行测试用例，也不编译测试用例类。
```
- 使用
- 踩坑 

### aliyun插件仓库
```
<pluginRepository>
		<id>aliyun-plugin</id>
			<url>https://maven.aliyun.com/repository/public</url>
			<releases>
				<enabled>true</enabled>
			</releases>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
</pluginRepository>
```

```
<repository>
			<id>aliyun_mvn</id>
			<name>aliyun maven</name>
			<url>http://maven.aliyun.com/nexus/content/groups/public/</url>
			<layout>default</layout>
			<!-- 是否开启发布版构件下载 -->
			<releases>
					<enabled>true</enabled>
			</releases>
			<!-- 是否开启快照版构件下载 -->
			<snapshots>
					<enabled>false</enabled>
			</snapshots>
 </repository>
```

### 知识总结
- 1、maven跳过单元测试-maven.test.skip和skipTests的区别

	-DskipTests，不执行测试用例，但编译测试用例类生成相应的class文件至target/test-classes下。

	-Dmaven.test.skip=true，不执行测试用例，也不编译测试用例类。

### 书籍推荐

- [Maven实战](https://book.douban.com/subject/5345682/)  **看此书足矣**

### 相关知识总结
- [Settings Reference](http://maven.apache.org/settings.html)
