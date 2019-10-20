### DatagramChannel
- 是一个能收发UDP包的通道
- 对于通道的操作，也可以进行read和write，但是不保证通道内的数据是完全一致的
#### 打开
```java
    DatagramChannel channel = DatagramChannel.open();
    // 绑定需要的对象
    channel.socket().bind(new InetAddress(9999));
```
#### 接收数据
```java
    ByteBuffer buf = ByteBuffer.allocate(1024);
    buf.clear();
    channel.receive(buf);
``` 

#### 发送数据
```java
    String newData = "New String to ...";
    
    ByteBuffer buf = ByteBuffer.allocate(1024);
    buf.clear();
    buf.put(newData.getBytes());
    buf.flip();
    
    int byteSent = channel.send(buf, new InetSocketAddress("baidu.com", 80));
```
#### 