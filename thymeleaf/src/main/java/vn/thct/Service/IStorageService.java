package vn.thct.Service;

import java.nio.file.Path;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {

	void init();

	void delete(String storeFileName) throws Exception;

	Path load(String fileName);

	Resource loadAsResource(String fileName);

	void store(MultipartFile file, String storeFilename);

	String getStorageFilename(MultipartFile file, String id);
}
