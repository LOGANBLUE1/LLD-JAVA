package behaviouralPatterns.chainOfResponsibility;

import behaviouralPatterns.chainOfResponsibility.middleware.Middleware;
import behaviouralPatterns.chainOfResponsibility.middleware.RoleCheckMiddleware;
import behaviouralPatterns.chainOfResponsibility.middleware.ThrottlingMiddleware;
import behaviouralPatterns.chainOfResponsibility.middleware.UserExistsMiddleware;
import behaviouralPatterns.chainOfResponsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        // All checks are linked. Client can build various chains using the same
        // components.
//        Middleware middleware = Middleware.link(
//                new ThrottlingMiddleware(2),
//                new UserExistsMiddleware(server),
//                new RoleCheckMiddleware()
//        );
//        // Server gets a chain from client code.
//        server.setMiddleware(middleware);
    }

    void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            System.out.println("Trying to log in...");
            success = server.logIn(email, password);
        } while (!success);
    }

}