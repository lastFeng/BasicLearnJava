### ServerSocket

#### 创建一个ServerSocket连接
```java
    // port为服务器监听端口，客户端用来连接的端口号
    ServerSocket serverSocket = new ServerSocket(port);
```

#### 监听请求连接
```java
    ServerSocket serverSocket = new ServerSocket(port);
    boolean isStoped = false;
    while(!isStopped) {
        // 等待客户端Socket的连接，没有连接时处于阻塞状态
        Socket clientSocket = serverSocket.accept();

        // TODO: something with clientSocket
        isStopped = true;
        clientSocket.close();
    }
    serverSocket.close();
```
