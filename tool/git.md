# Git


## Git客户端
- PC端
  - [SmartGit](https://www.syntevo.com/smartgit/) 
  - [Sourcetree](https://cn.atlassian.com/software/sourcetree)   ***推荐免费***
  - [TortoiseGit](https://tortoisegit.org/)
- 手机端 
  - Grape For GitHub


![avatar](https://github.com/sanwancoder/it_study_lib/blob/master/images/GrapeForGitHub.png?raw=true)



## Gitflow

### 流程图

![avatar](https://github.com/sanwancoder/it_study_lib/blob/master/images/git-flow-nvie.png?raw=true)


### Git-flow项目

- [https://github.com/nvie/gitflow](https://github.com/nvie/gitflow) ***SourceTree已经集成git-flow***


## Git学习资料

- [廖雪峰 Git教程](https://www.liaoxuefeng.com/wiki/896043488029600)
- [Learn Version Control with Git](https://www.git-tower.com/learn/git/ebook/cn/command-line/introduction#start)
- [git命令](https://git-scm.com/docs)
- [https://learngitbranching.js.org/](https://learngitbranching.js.org/)

## GitHub使用秘籍
  - [GitHub秘籍](https://github.com/tiimgreen/github-cheat-sheet/blob/master/README.zh-cn.md) 




## Git命令

### 关联远程分支
```
 1. echo "# first repo" >> README.md
 2. git init
 3. git add README.md
 4. git commit -m "first commit"
 5. git remote add origin https://github.com/zhangsan/zhangsan_first_repo.git
 6. git push -u origin master
```
### 对于已经存在的仓库 关联
```
git branch --set-upstream-to=origin/remote_branch  your_branch

其中，origin/remote_branch是你本地分支对应的远程分支；your_branch是你当前的本地分支。
```

### git commit 但是没有使用git push，现在发现有文件误提交了
```
1. git log  找到你想撤销的commit_id
2. git reset --hard commit_id 完成撤销,同时将代码恢复到前一commit_id 对应的版本。
3. git reset commit_id 完成Commit命令的撤销，但是不对代码修改进行撤销，可以直接通过git commit 重新提交对本地代码的修改。
```

### 代码需要回滚到特定版本并提交
```
1. git reset --hard 83ff2785
2. git push --force
```

###  git提交建议 
```
git提交建议：
<类型>（模块）：commit内容
类型包括：
1）init--项目初始化；
2）feat--新功能；
3）fix--修复bug；
4）docs--文档操作；
5）opt--优化；
6）style--格式化；
7）refactor--重构；
8）save--单纯保存记录
```

### 分支管理
```
1. 切换到远程分支
git checkout -b dev origin/dev，作用是checkout远程的dev分支，在本地起名为dev分支，并切换到本地的dev分支
2. 本地切换分支
git checkout branchName  切换到branchName分支
3. 删除本地分支
git branch -d BranchName
4. 删除远程分支
git push origin --delete <BranchName>
```

### 创建新分支并推送
```
1. 在本地新建分支
git branch newbranch
2. 把本地分支push到远程
git push origin newbranch
```

#### 重命名远程分支
```
1. 删除远程分支
git push --delete origin dzh_dzh_yzsj_gaw_from_5.1
2. 重命名分支
git branch -m dzh_dzh_yzsj_gaw_from_5.1 dzh_yzsj_gaw_from_5.1
3.  重命名后的分支提到远程分支
git push origin dzh_yzsj_gaw_from_5.1
4. 关联
git branch --set-upstream-to=origin/dzh_yzsj_gaw_from_5.1
```
- [git 分支重命名  CSDN](https://blog.csdn.net/weixin_39800144/article/details/81634106)

### 标签管理
```
1. 打标签
git tag -a v0.1 -m "version 0.1 released" 1094adb  作用: 给 1094adb 这次提交打上标签v0.1 备注是version 0.1 released
2. 远程推送标签
git push origin --tags
3. 显示已有的标签
git tag      列出全部的标签
git show v1.4 显示v1.4标签详情
4. 删除远程标签
git push origin --delete tag <tagName>
5. 删除本地标签
git tag -d <tagName>

```
[Git-scm 6 Git 基础 - 打标签](https://git-scm.com/book/zh/v1/Git-%E5%9F%BA%E7%A1%80-%E6%89%93%E6%A0%87%E7%AD%BE)


### 代码提交
```
1. git add fileName 增加文件
2. git commit  -m "修改内容"
3. git pull 
4. 处理冲突 git add commit 
5. git push
```

## 好文
- [Git 在团队中的最佳实践--如何正确使用Git Flow](https://www.cnblogs.com/wish123/p/9785101.html)

## 疑难问题解决
  - [mac下git命令行乱码问题解决](https://blog.csdn.net/happycodefly/article/details/88385140)
  

  
