package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

/**
 * @author guowf
 * @mail guowf_buaa@163.com
 * @description:
 * @data created in 2019/10/17 22:23
 */
public class FileChannelReadExample {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("./data.txt", "rw");
        // 获取文件channel
        FileChannel inChannel = aFile.getChannel();

        // 构建缓存空间
        ByteBuffer buff = ByteBuffer.allocate(5);

        // 读取数据，将channel的内容写入到缓存中
        int bytesRead = inChannel.read(buff);

        // 是否没有数据，有数据，先输出，然后在将buf清空，继续读取
        while (bytesRead != -1) {
            System.out.println("Read: " + bytesRead);
            // 通过调用flip方法，将写模式转换成读模式（模式转换）
            buff.flip();
            while (buff.hasRemaining()) {
                System.out.print((char)buff.get());
            }

            // 清空缓存
            buff.clear();
            bytesRead = inChannel.read(buff);
            System.out.println();
        }
        aFile.close();
    }
}
