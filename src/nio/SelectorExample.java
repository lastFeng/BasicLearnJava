package nio;

import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author guowf
 * @mail guowf_buaa@163.com
 * @description:
 * @data created in 2019/10/18 21:54
 */
public class SelectorExample {
    public static void main(String[] args) throws Exception{
        SocketChannel channel = SocketChannel.open();
        Selector selector = Selector.open();
        // 设置非阻塞
        channel.configureBlocking(false);
        // 设置操作类型
        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);

        while (true) {
            // 通过selector来选择Channel，为0就意味着没有准备好
            int readyChannel = selector.select();
            if (readyChannel == 0) {
                continue;
            }
            // 选择已经准备就绪的可操作位置
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey keyIter = (SelectionKey) iterator.next();
                if (keyIter.isAcceptable()) {
                    // ... a connection was accepted by a ServerSocketChannel
                } else if (keyIter.isConnectable()) {
                    // ... a connection was established with a remote server
                } else if (keyIter.isReadable()) {
                    // ... a channel is ready for reading
                } else if (keyIter.isWritable()) {
                    // ... a channel is ready for writing
                }
                iterator.remove();
            }
        }
    }
}
