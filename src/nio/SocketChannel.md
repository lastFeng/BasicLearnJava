### SocketChannel

#### 打开
```java
    SocketChannel socket = SocketChannel.open();
    socket. .connect(new InetSocketAddress("baidu.com", 80));
```
#### 关闭
```java
    socket.close();
``` 
#### 读取数据（同FileChannel）

#### 写入数据（同FileChannel）

#### 非阻塞模式（见selector）
