### FileChannel

#### 打开FileChannel
```java
    RandomAccessFile file = new RandomAccessFile("./data.txt", "rw");
    FileChannnel channel = file.getChannel();
```
####  从FileChannel中读取数据
```java
    ByteBuffer buf = ByteBuffer.allocate(48);
    int bytesRead = channel.read(buf);
```
#### 向Channel中写入数据
```java
    String newData = "new String to write file";
    ByteBuffer buf = ByteBuffer.allocate(48);
    buf.clear();
    buf.put(newData.getBytes());
    
    // 读模式准换为写模式
    channel.flip()
    
    // 只要buf中还有值，就一直往里写
    while(buf.hasRemaining()){
        channel.write(buf);
    }
```
#### FileChannel的position方法
- 有时候可能需要在FileChannel的某个特定位置进行数据的读写操作。可以使用position进行操作
```java
    // 获取当前位置
    long pos = channel.position();
    // 设置指定位置,如果在文件结束符之后，返回则是-1
    channel.position(pos + 123);
```
#### FileChannel的size方法
- 返回该实例所关联文件的大小
#### FileChannel的truncate方法
- 截取一个文件。指定长度后面的部分将被删除；（超过长度的部分）
#### FileChannel的force方法
- 将通道里尚未写入磁盘的数据强制写入磁盘上。

```java
    channel.force(true);
``` 
