### Pipe
- 管道是2个线程之间的单向数据连接。
- pipe有一个source通道和一个sink通道
- 数据会被写到sink通道，从source通道读取 

#### 创建管道
```java
    Pipe pipe = Pipe.open();
```

#### 向管道中写入
- 访问sink通道
```java
    Pipe.SinkChannel sink = pipe.sink();
```

- 写入数据
```java
    String newData = "New Data..";

    ByteBuffer buf = ByteBuffer.allocate(1024);
    buf.clear();
    buf.put(newData.getBytes());
    
    buf.flip();
    
    while(buf.hasRemaining()) {
        sink.write(buf);
    }
```

#### 从管道中读取
- 访问source通道
```java
    Pipe.SourceChannel source = pipe.source();
```

- 读取数据
```java
    ByteBuffer buf = ByteBuffer.allocate(48);
    int bytesRead = source.read(buf);
```
