package net.jaimetorres.pila.htrans.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.jaimetorres.pila.htrans.service.UploadFile;

@RestController
public class ValidarHtransController {

	@Autowired
	private UploadFile subirArchivo;
	
	@PostMapping(path = "/upload")
    public ResponseEntity<?> subirArchivo(@RequestParam("file") MultipartFile file) throws IOException {
		if (file.isEmpty()) {
			return new ResponseEntity<Object>("Seleccione un archivo", HttpStatus.OK);
		} else {
			subirArchivo.saveFile(file);
			return new ResponseEntity<Object>("Archivo subido", HttpStatus.OK);
		}
	}
}
