package nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author guowf
 * @mail guowf_buaa@163.com
 * @description:
 * @data created in 2019/10/17 23:10
 * 通道向另一个通道传输数据
 */
public class ChannelToChannel {
    public static void main(String[] args) throws Exception {
        RandomAccessFile accessFile = new RandomAccessFile("./data.txt", "rw");
        FileChannel fromChannel = accessFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("./toFile.txt", "rw");
        FileChannel toFileChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        // fromChannel.transferTo(position, count, toFileChannel);
        // 两种写法是一致的
        toFileChannel.transferFrom(fromChannel, position, count);

        fromChannel.close();
        toFileChannel.close();
        accessFile.close();
        toFile.close();
    }
}
