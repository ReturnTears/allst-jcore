# JDK
```text
Java 解决 JDK14没有jre问题
第一步
用管理员权限打开命令提示符
第二步
进入jdk目录
输入bin\jlink.exe --module-path jmods --add-modules java.desktop --output jre（可直接复制这条链接）
第三步
查看jdk安装目录是否出现jre文件夹
```