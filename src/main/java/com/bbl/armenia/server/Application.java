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
    private static Server server;
    private static ServletContextHandler servletContextHandler;

    public static void main(String[] args) {
        server = new Server(8080);
        servletContextHandler = new ServletContextHandler(NO_SESSIONS);
        configureServletHolder();
        configureServletContextHandler();
        startServer(server);
    }

    private static void configureServletHolder() {
        ServletHolder servletHolder = servletContextHandler.addServlet(ServletContainer.class, "/api/*");
        servletHolder.setInitOrder(0);
        servletHolder.setInitParameter("jersey.config.server.provider.packages", "com.bbl.armenia.service");
    }

    private static void configureServletContextHandler() {
        servletContextHandler.setContextPath("/");
        server.setHandler(servletContextHandler);
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
