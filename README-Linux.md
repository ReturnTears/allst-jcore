# Linux
```text
1、Linux查看进程信息
ps、 top命令

ps -aux 命令输出格式：
USER PID %CPU %MEM VSZ RSS TTY STAT START TIME COMMAND
格式说明如下：
USER: 行程拥有者
PID: pid
%CPU: 占用的 CPU 使用率
%MEM: 占用的记忆体使用率
VSZ: 占用的虚拟记忆体大小
RSS: 占用的记忆体大小
TTY: 终端的次要装置号码 (minor device number of tty)
STAT: 该行程的状态，linux的进程有5种状态：
START: 行程开始时间
TIME: 执行的时间
COMMAND:所执行的指令

1) ps a 显示现行终端机下的所有程序，包括其他用户的程序。
2）ps -A 显示所有程序。 
3）ps c 列出程序时，显示每个程序真正的指令名称，而不包含路径，参数或常驻服务的标示。 
4）ps -e 此参数的效果和指定"A"参数相同。 
5）ps e 列出程序时，显示每个程序所使用的环境变量。 
6）ps f 用ASCII字符显示树状结构，表达程序间的相互关系。 
7）ps -H 显示树状结构，表示程序间的相互关系。 
8）ps -N 显示所有的程序，除了执行ps指令终端机下的程序之外。 
9）ps s 采用程序信号的格式显示程序状况。 
10）ps S 列出程序时，包括已中断的子程序资料。 
11）ps -t 　指定终端机编号，并列出属于该终端机的程序的状况。 
12）ps u 　以用户为主的格式来显示程序状况。 
13）ps x 　显示所有程序，不以终端机来区分。

Linux 进程状态 Ss、Sl、S+、Z、I＜ 等：
D (TASK_UNINTERRUPTIBLE) 	不可中断的睡眠状态
R (TASK_RUNNING)				正在运行，或在队列中的进程
S (TASK_INTERRUPTIBLE)		可中断的睡眠状态
T (TASK_STOPPED)				停止状态
t (TASK_TRACED)				被跟踪状态
Z (TASK_DEAD - EXIT_ZOMBIE)  退出状态，但没被父进程收尸，成为僵尸状态
W    						进入内存交换（从内核2.6开始无效）
X (TASK_DEAD - EXIT_DEAD)    退出状态，进程即将被销毁

<    高优先级
N    低优先级
L    有些页被锁进内存
s    包含子进程
+    位于前台的进程组；
l    多线程，克隆线程  multi-threaded (using CLONE_THREAD, like NPTL pthreads do)



```