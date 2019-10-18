### Selector

#### Selector的创建
- 通过调用Selector.open()方法创建一个Selector
```java
    Selector selector = Selector.open();
``` 
#### 向Selector注册通道
- 为了将Channel和Selector配合使用，必须将Channel注册到Selector上
```java
    // 设置非阻塞模式
    channel.configureBlocking(false);
    // 设置相应的监听类型事件
    SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
```
- 与Selector一起使用时，Channel必须处于非阻塞模式
- FileChannel与Selector不能一起使用
- 注册的四种监听类型的事件：
   - Connect：连接 -- SelectionKey.OP_CONNECT
   - Accept：接收就绪 -- SelectionKey.OP_ACCEPT
   - Read：读 --  SelectionKey.OP_READ
   - Write：写 -- SelectionKey.OP_WRITE
- 四种监听事件可以组合使用，利用"|"进行组合 
- 这几种类型，实际是整数型常量，并且是2的次幂形式的常量
- 因此使用"|"来进行或计算，可以获得组合
- 利用"&"和某个类型来进行与计算，可以计算是否有该类型的事件

### [selectors](http://ifeve.com/selectors/)