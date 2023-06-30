package sdai.com.sis.sesionesdusuario;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.ServletContext;

/**
 * 30/06/2023
 * 
 * @author Sergio_M
 *
 */
public final class SdaiCFG {

	private static final String DIREPRINCI = "DIREPRINCI";

	private static SdaiCFG instancia;
	private final ConcurrentMap<String, Path> almacenDDirectorios;

	private SdaiCFG() {
		this.almacenDDirectorios = new ConcurrentHashMap<>();
	}

	static void createInstancia(ServletContext servletContext) throws Exception {
		if (SdaiCFG.instancia == null) {
			synchronized (SdaiCFG.class) {
				SdaiCFG.instancia = new SdaiCFG();
				SdaiCFG.instancia.load(servletContext);
			}
		}
	}

	public static SdaiCFG getInstancia() {
		return SdaiCFG.instancia;
	}

	private void load(ServletContext servletContext) throws Exception {
		loadCreateDirectorioPrincipal(servletContext);
	}

	private void loadCreateDirectorioPrincipal(ServletContext servletContext) throws Exception {
		String directorio = servletContext.getInitParameter(DIREPRINCI);
		Path path = Paths.get(directorio);
		if (!Files.exists(path))
			Files.createDirectories(path);
		this.almacenDDirectorios.put(DIREPRINCI, path);
	}

	public Path getDirectorioPrincipal() {
		Path path = this.almacenDDirectorios.get(DIREPRINCI);
		return path;
	}

	public String getPathDDirectorioPrincipal() {
		Path path = getDirectorioPrincipal();
		File file = path.toFile();
		String directorio = file.getAbsolutePath();
		return directorio;
	}

}
