package Training_java_Spring.boot.client.controller;

import Training_java_Spring.boot.client.dto.request.ClientRequest;
import Training_java_Spring.boot.client.dto.response.ClientResponse;
import Training_java_Spring.boot.client.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
@Slf4j
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse create(@RequestBody ClientRequest request){
        log.info(" === Start api create new client === ");
        log.info(" === Request Body : {} ", request);
        ClientResponse response = service.create(request);
        log.info(" === Finish api create new client, Client Id {} : === ",response.getId());
        return response;
    }
}