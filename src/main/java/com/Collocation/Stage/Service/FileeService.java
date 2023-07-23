package com.Collocation.Stage.Service;

import com.Collocation.Stage.Repository.FileeRepository;
import com.Collocation.Stage.entities.Filee;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class FileeService {
    private final FileeRepository fileeRepository;
    private static final String FILE_STORAGE_PATH = "C:/Users/Amine/Desktop/pdl/front/Front_Suivie_Formation/src/assets/";

    public FileeService(FileeRepository fileeRepository) {
        this.fileeRepository = fileeRepository;
    }

    public Filee uploadImage(MultipartFile file) throws IOException {
        System.out.println("origin file size: " + file.getBytes().length);
        Filee filee = new Filee(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getContentType().getBytes()));

        // Save the file to the file system
        String pathFile = FILE_STORAGE_PATH + file.getOriginalFilename();
        Path path = Paths.get(pathFile);
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        return fileeRepository.save(filee);
    }

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (DataFormatException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
