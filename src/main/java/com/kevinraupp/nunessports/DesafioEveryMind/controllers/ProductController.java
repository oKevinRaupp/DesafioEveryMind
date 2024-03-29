package com.kevinraupp.nunessports.DesafioEveryMind.controllers;

import com.kevinraupp.nunessports.DesafioEveryMind.dto.ProductDTO;
import com.kevinraupp.nunessports.DesafioEveryMind.entities.Product;
import com.kevinraupp.nunessports.DesafioEveryMind.services.ProductService;
import com.kevinraupp.nunessports.DesafioEveryMind.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Produtos", description = "Endpoint para controlar produtos.")
@RestController
@RequestMapping(value = "/api/v1/produtos")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Buscar produtos", description = "Buscar todos os produtos", tags = {"Produtos"},
            responses = {@ApiResponse(description = "Success", responseCode = "200", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
    public ResponseEntity<PagedModel<EntityModel<ProductDTO>>> findAll(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size,
                                                                       @RequestParam(value = "direction", defaultValue = "asc") String direction) {
        if (size > 25) size = 25;
        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "name"));
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping(value = "/findByNameOrderByPrice/{name}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Buscar por nome", description = "Buscar os produtos que contêm o {nome} ordenado por preço.", tags = {"Produtos"},
            responses = {@ApiResponse(description = "Success", responseCode = "200", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
    public ResponseEntity<PagedModel<EntityModel<ProductDTO>>> findByNameContainsIgnoreCaseOrderByPrice(@PathVariable(value = "name") String name,
                                                                                                        @RequestParam(value = "page", defaultValue = "0") int page,
                                                                                                        @RequestParam(value = "size", defaultValue = "10") int size,
                                                                                                        @RequestParam(value = "direction", defaultValue = "asc") String direction) {
        if (size > 25) size = 25;
        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "price"));
        return ResponseEntity.ok(service.findByNameContainsIgnoreCaseOrderByPrice(name, pageable));
    }

    @GetMapping(value = "/findByNameOrderByPriceDesc/{name}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Buscar por nome", description = "Buscar os produtos que contêm o {nome} ordenado por preço DESC.", tags = {"Produtos"},
            responses = {@ApiResponse(description = "Success", responseCode = "200", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
    public ResponseEntity<PagedModel<EntityModel<ProductDTO>>> findByNameContainsIgnoreCaseOrderByPriceDesc(@PathVariable(value = "name") String name,
                                                                                                        @RequestParam(value = "page", defaultValue = "0") int page,
                                                                                                        @RequestParam(value = "size", defaultValue = "10") int size,
                                                                                                        @RequestParam(value = "direction", defaultValue = "asc") String direction) {
        if (size > 25) size = 25;
        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "price"));
        return ResponseEntity.ok(service.findByNameContainsIgnoreCaseOrderByPriceDesc(name, pageable));
    }

    @GetMapping(value = "/findByCode/{code}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Buscar por codigo", description = "Buscar os produtos que contém o {código}", tags = {"Produtos"},
            responses = {@ApiResponse(description = "Success", responseCode = "200", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
    public ResponseEntity<PagedModel<EntityModel<ProductDTO>>> findByCodeContainsIgnoreCase(@PathVariable(value = "code") String code,
                                                                                            @RequestParam(value = "page", defaultValue = "0") int page,
                                                                                            @RequestParam(value = "size", defaultValue = "10") int size,
                                                                                            @RequestParam(value = "direction", defaultValue = "asc") String direction) {
        if (size > 25) size = 25;
        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "name"));
        return ResponseEntity.ok(service.findByCodeContainsIgnoreCase(code, pageable));
    }

    @GetMapping(value = "/findByDescription/{description}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Buscar por descrição", description = "Buscar os produtos que contém a {descrição}", tags = {"Produtos"},
            responses = {@ApiResponse(description = "Success", responseCode = "200", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
    public ResponseEntity<PagedModel<EntityModel<ProductDTO>>> findByDescriptionContainsIgnoreCase(@PathVariable(value = "description") String description,
                                                                                                   @RequestParam(value = "page", defaultValue = "0") int page,
                                                                                                   @RequestParam(value = "size", defaultValue = "10") int size,
                                                                                                   @RequestParam(value = "direction", defaultValue = "asc") String direction) {
        if (size > 25) size = 25;
        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "name"));
        return ResponseEntity.ok(service.findByDescriptionContainsIgnoreCase(description, pageable));
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Buscar um produto", description = "busca um produto passando um {id}", tags = {"Produtos"},
            responses = {@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
    public ProductDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Cria um novo produto", description = "Cria um novo produto passando um {RequestBody} em JSON, XML or YML!", tags = {"Produtos"},
            responses = {@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductDTO> insert(@RequestBody Product product) {
        var entity = service.insert(product);
        return ResponseEntity.ok(entity);
    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Atualiza um produto", description = "Atualiza um produto passando um {id} e um {RequestBody} em JSON, XML or YML!", tags = {"Produtos"},
            responses = {@ApiResponse(description = "Updated", responseCode = "200", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody Product product) {
        var produto = service.update(id, product);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleta um produto", description = "Deleta um produto passando um {id}", tags = {"Produtos"},
            responses = {@ApiResponse(description = "No content", responseCode = "204", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}