package sdai.com.sis.sesionesdusuario;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 30/06/2023
 * 
 * @author Sergio_M
 *
 */
@WebListener
public class SessionListener implements ServletContextListener, HttpSessionListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {

	}

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}

}
