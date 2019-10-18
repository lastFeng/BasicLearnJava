### Socket

#### 创建Socket
```java
   Socket socket = new Socket("ip|domain", port);
```

#### Socket发送数据
```java
    Socket socket = new Socket("jenkov.com", 80);
    OutputStream out = socket.getOutputStream();

    // 向socket的输出流中发送数据
    out.write("some data".getBytes());
    // 将数据写入内存中
    out.flush();

    // 关闭流与socket
    out.close();
    socket.close();
```

#### Socket读取数据
```java
    Socket socket = new Socket("jenkov.com", 80);
    InputStream in = socket.getInputStream();

    int data = in.read();
    // ...read more data

    in.close();
    socket.close();
```