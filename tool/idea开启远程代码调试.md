概述：
由于在开发过程中，某些问题或者功能需要远程调试服务器端代码去分析解决。参考了1.5.2 eclipse开启远程代码调试 此篇文章，整理了idaa开启远程代码调试。希望可以帮助到大家。

1、在idea中打开edit configurations选项

![avatar](https://github.com/sanwancoder/tech_study/blob/master/images/IdeaRemoteDebug/step1.png?raw=true)
2、新建Remote选项

![avatar](https://github.com/sanwancoder/tech_study/blob/master/images/IdeaRemoteDebug/step2.png?raw=true)

3、配置Remote
name: 可随意填写，建议填写有实际意义的名称

debugger mode: 选择 attach to remote jvm选项

transport: 选择socket

host: 填写远端服务器的ip地址

port: 端口号可自定义（必须为本地服务和远端服务都没有被占用的端口，防止端口冲突）

command lin arguments for reomte jvm: idea自动补全,若没有自动补全可手动输入

use module classpath: 选择需要远端调试的项目



![avatar](https://github.com/sanwancoder/tech_study/blob/master/images/IdeaRemoteDebug/step3.png?raw=true)

4、配置devops中相关服务
在devops中找到相关项目，编辑项目的运行命令，如下图所示，加入命令：-jar -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=9897,suspend=n 

点击保存，并重启该项目的服务。

ps："address=9897": 9897为在idea中配置remote port时相同的端口。


![avatar](https://github.com/sanwancoder/tech_study/blob/master/images/IdeaRemoteDebug/step4.png?raw=true)


5、debug启动idea中的项目
在idea中打入需要调试的代码断点。选择刚才配置好的remoe（warming）,执行debug启动方式。此时访问远端服务器上部署的项目的相关接口时，就会进入本地idea中的断点调试。
![avatar](https://github.com/sanwancoder/tech_study/blob/master/images/IdeaRemoteDebug/5.png?raw=true)


