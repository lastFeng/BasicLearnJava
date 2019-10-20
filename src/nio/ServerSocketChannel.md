### ServerSocketChannel

- ServerSocketChannel是一个可以监听新进来的TCP连接的通道

#### 打开
- ServerSocketChannel.open();
#### 关闭
- ServerSocketChannel.close();
#### 监听新进来的连接
- serverSocketChannel.accept();
#### 非阻塞模式
- serverSocketChannel.configureBlocking(false);
####