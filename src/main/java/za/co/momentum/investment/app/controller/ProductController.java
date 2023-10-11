package za.co.momentum.investment.app.controller;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import za.co.momentum.investment.app.entity.Product;

import java.util.List;

@Api(tags = "Product API")
public interface ProductController {
    @ApiOperation("Add new data")
    public Product save(@RequestBody Product product);

    @ApiOperation("Find by Id")
    public Product findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<Product> list();

    @ApiOperation("Pagination request")
    public Page<Product> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public Product update(@RequestBody Product dto, @PathVariable("id") Long id);
}