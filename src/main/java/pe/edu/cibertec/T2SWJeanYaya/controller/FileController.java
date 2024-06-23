package pe.edu.cibertec.T2SWJeanYaya.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.T2SWJeanYaya.model.bd.ArchivoDto;
import pe.edu.cibertec.T2SWJeanYaya.service.IFileService;


import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/files")
public class FileController {

    private final IFileService fileService;
    private final Set<String> extensionesPermitidas = Set.of("pdf", "png", "docx");
    private final long tamanioMaximo = 25 * 1024 * 1024; // 25MB

    @Autowired
    public FileController(IFileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/archivos")
    public ResponseEntity<ArchivoDto> subirArchivos(
            @RequestParam("files") List<MultipartFile> multipartFileList
    ) throws Exception {
        for (MultipartFile file : multipartFileList) {
            String extension = getFileExtension(file.getOriginalFilename());
            if (!extensionesPermitidas.contains(extension)) {
                return new ResponseEntity<>(ArchivoDto.builder()
                        .mensaje("Una o más extensiones de archivos no son válidas").build(), HttpStatus.BAD_REQUEST);
            }
        }
        fileService.guardarArchivos(multipartFileList);
        return new ResponseEntity<>(ArchivoDto.builder()
                .mensaje("Archivos subidos correctamente").build(), HttpStatus.OK);
    }

    @PostMapping("/archivo")
    public ResponseEntity<ArchivoDto> subirArchivo(
            @RequestParam("file") MultipartFile file
    ) throws Exception {
        if (file.getSize() > tamanioMaximo) {
            return new ResponseEntity<>(ArchivoDto.builder()
                    .mensaje("El archivo excede el tamaño máximo permitido de 25MB").build(), HttpStatus.BAD_REQUEST);
        }
        fileService.guardarArchivo(file);
        return new ResponseEntity<>(ArchivoDto.builder()
                .mensaje("Archivo subido correctamente").build(), HttpStatus.OK);
    }

    private String getFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "";
        }
        return filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
    }

}
