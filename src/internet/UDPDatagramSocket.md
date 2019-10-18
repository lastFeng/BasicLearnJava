### UDP数据报接收与发送
#### UDP数据报发送
```java
    // 65508是UDP能发送的最大字节数
    byte[] buffer = new byte[1024];
    // 获取地址
    InetAddress address = InetAddress.getByName("jenkov.com");

    // 创建数据报
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
                                address, port);

    // 构件UDP连接，并发送数据
    DatagramSocket socket = new DatagramSocket();
    socket.sent(packet);
    // 抛出异常，或者使用try...with
    socket.close();
```
#### UDP数据报接收
```java
    DatagramSocket socket = new DatagramSocket(ip,port);
    byte[] buffer = new byte[1024];

    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
    // 接收数据报
    socket.receive(packet);
    // 缓存数据
    buffer = packet.getData();
    socket.close();
````