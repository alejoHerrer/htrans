package net.jaimetorres.pila.htrans.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFile {

	private String folder = ".//resources//files//";
	
	public void saveFile(MultipartFile file) throws IOException {
        File carpeta = new File(folder);
		if (carpeta.isDirectory() && carpeta.listFiles().length==0) {
        	if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                Path path = Paths.get(folder + file.getOriginalFilename());
                Files.write(path,bytes);
            }
		} else {
			List<File> list = Arrays.asList(carpeta.listFiles());
			list.stream().forEach(e->e.delete());
			if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                Path path = Paths.get(folder + file.getOriginalFilename());
                Files.write(path,bytes);
            }
		}
    }
}
