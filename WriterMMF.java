import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class WriterMMF {
    public static void main(String[] args) throws Exception {
        FileChannel fc = new RandomAccessFile("mmf.txt", "rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, 4);
        byte[] buffer = args[0].getBytes();
        for(int i = 0; i < 100; i++) {
            System.out.print("Write: ");
            for (int j = 0; j < 4; j++) {
                out.position(j);
                out.put(buffer[0]);
                System.out.print(new String(buffer));
            }
            System.out.println();
        }
        fc.close();
    }
}
