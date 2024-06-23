package pe.edu.cibertec.T2SWJeanYaya.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {
    void guardarArchivo(MultipartFile archivo) throws Exception;
    void guardarArchivos(List<MultipartFile> archivosList) throws Exception;
}
