package pl.wiktor.testsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping(path = "/")
    public String getPublic() {
        return "<h1>Welcome Public</h1>";
    }

    @GetMapping(path = "/user")
    public String getUser() {
        return "<h1>Welcome User</h1>";
    }

    @GetMapping(path = "/admin")
    public String getAdmin() {
        return "<h1>Welcome Admin</h1>";
    }

}
