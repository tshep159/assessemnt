package za.co.momentum.investment.app.controller;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import za.co.momentum.investment.app.entity.Client;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;

@Api(tags = "Client API")
@RestControllerEndpoint(id = "/api")
public interface ClientController {
    @ApiOperation("Add new data")
    public Client save(@RequestBody Client clientDTO);
//    public Client findByOneId(@PathVariable("id") Long id);
    @ApiOperation("Delete based on primary key")
    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id);
    @ApiOperation("List All data")
    @GetMapping
    List<Client> list();
    @GetMapping("/page-query")
    Page<Client> pageQuery(Pageable pageable);
    @PutMapping("/{id}")
    @ApiOperation("update data")
    Client update(@RequestBody Client clientDTO, @PathVariable("id") Long id);
}
