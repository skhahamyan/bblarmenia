package com.bbl.armenia.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.eclipse.jetty.servlet.ServletContextHandler.NO_SESSIONS;

public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        final Server server = new Server(8080);
        final ServletContextHandler servletContextHandler = new ServletContextHandler(NO_SESSIONS);
        configureServletContext(server, servletContextHandler);
        addApiContext(servletContextHandler);
        startServer(server);
    }

    private static void configureServletContext(Server server, ServletContextHandler servletContextHandler) {
        servletContextHandler.setContextPath("/");
        server.setHandler(servletContextHandler);
    }

    private static void addApiContext(ServletContextHandler servletContextHandler) {
        ServletHolder servletHolder = servletContextHandler.addServlet(ServletContainer.class, "/api/*");
        servletHolder.setInitOrder(0);
        servletHolder.setInitParameter("jersey.config.server.provider.packages", "com.bbl.armenia.service");
    }

    private static void startServer(Server server) {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            LOGGER.error("Error occurred while starting Jetty", e);
        } finally {
            server.destroy();
        }
    }
}
