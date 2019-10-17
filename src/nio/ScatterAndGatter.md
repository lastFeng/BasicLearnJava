### Scatter/Gather
#### Scatter(分散):将Channel的数据分散到多个buffer中
```java
    ByteBuffer header = ByteBuffer.alocate(128);
    ByteBuffer body = ByteBuffer.alocate(1024);
    
    BufferBuffer[] bufferArray = {header, body};
    chanel.read(bufferArray);
```
#### Gather（聚集）:将多个buffer的数据收集到一个Channel钟
```java
    ByteBuffer header = ByteBuffer.alocate(128);
    ByteBuffer body = ByteBuffer.alocate(1024);
    
    int headNumber = inChanner.read(header);
    int bodyNumber = inChanner.read(body);
    
    ByteBuffer[] bufferArray = {header, body};
    outChannel.write(bufferArray);
```