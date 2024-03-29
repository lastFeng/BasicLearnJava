### Buffer的关键内容

- capacity
   - 作为一个内存块，Buffer有一个固定的大小值，也叫“capacity”.你只能往里写capacity个byte、long，char等类型。一旦Buffer满了，需要将其清空（通过读数据或者清除数据）才能继续写数据往里写数据。

- position
   - 当你写数据到Buffer中时，position表示当前的位置。初始的position值为0.当一个byte、long等数据写到Buffer后， position会向前移动到下一个可插入数据的Buffer单元。position最大可为capacity – 1.

   - 当读取数据时，也是从某个特定位置读。当将Buffer从写模式切换到读模式，position会被重置为0. 当从Buffer的position处读取数据时，position向前移动到下一个可读的位置。

- limit
   - 在写模式下，Buffer的limit表示你最多能往Buffer里写多少数据。 写模式下，limit等于Buffer的capacity。

   - 当切换Buffer到读模式时， limit表示你最多能读到多少数据。因此，当切换Buffer到读模式时，limit会被设置成写模式下的position值。换句话说，你能读到之前写入的所有数据（limit被设置成已写数据的数量，这个值在写模式下就是position）
   
### Buffer的操作
- Buffer类型
   - ByteBuffer
   - MappedByteBuffer
   - CharBuffer
   - DoubleBuffer
   - Long/Float/Int/Short-Buffer
- Buffer分配
   - XxxBuffer buff = XxxBuffer.allocate(capacity);
- 向Buffer中写数据
   - 从Channel中写到Buffer  
   ```Java
   FileChannel inChannel = file.getChannel;
   int bytesRead = inChannel.read(buff);
   ```
   - 通过Buffer的put()方法写到Buffer里。 
   ```java
   buff.put(xxx);
   ```
- buff.flip()方法
   - 将Buffer从写模式切换到读模式
- buff.rewind()
   - 重头开始读，但是limit保持不变
- buff.clear()与buff.compact()方法
   - buff.clear()，将position设回0，limit设置成capacity的值，完全清空
   - buff.compact()，将未读的数据拷贝到Buffer的起始处，然后将position设到最后一个未读元素后面
- buff.mark(int) 设置position
- buff.reset()：恢复到这个position
   