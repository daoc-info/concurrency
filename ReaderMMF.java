import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ReaderMMF {
    
    public static void main(String[] args) throws Exception {
        FileChannel fc = new RandomAccessFile("mmf.txt", "rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, 4);
        byte[] buffer = new byte[4];
        Thread.sleep(1);
        for(int i = 0; i < 200; i++) {
            out.position(0);
            out.get(buffer);
            System.out.println("Read(" + i + "): " + new String(buffer));
        }
        fc.close();
    }
}
