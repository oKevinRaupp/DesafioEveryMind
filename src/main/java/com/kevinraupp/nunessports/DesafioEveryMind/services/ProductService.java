package com.kevinraupp.nunessports.DesafioEveryMind.services;

import com.kevinraupp.nunessports.DesafioEveryMind.controllers.ProductController;
import com.kevinraupp.nunessports.DesafioEveryMind.converter.Mapper;
import com.kevinraupp.nunessports.DesafioEveryMind.dto.ProductDTO;
import com.kevinraupp.nunessports.DesafioEveryMind.entities.Product;
import com.kevinraupp.nunessports.DesafioEveryMind.exceptions.ProductNotFoundException;
import com.kevinraupp.nunessports.DesafioEveryMind.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProductService {
    private Logger logger = Logger.getLogger(ProductService.class.getName());

    @Autowired
    private ProductRepository repository;

    @Autowired
    PagedResourcesAssembler<ProductDTO> assembler;

    public PagedModel<EntityModel<ProductDTO>> findAll(Pageable pageable) {
        logger.info("Buscando todos os produtos por pagina! [PAGINA = " + pageable.getPageNumber() + "] [ORDEM = " + pageable.getSort() + "]" + " [TAMANHO " + pageable.getPageSize() + "]");
        Page<Product> productPage = repository.findAll(pageable);

        Page<ProductDTO> productDTOPage = productPage.map(product -> Mapper.parseObject(product, ProductDTO.class));
        productDTOPage.map(product -> product.add(linkTo(methodOn(ProductController.class).findById(product.getId())).withSelfRel()));

        Link link = linkTo(methodOn(ProductController.class).findAll(pageable.getPageNumber(),
                pageable.getPageSize(), "asc")).withSelfRel();

        return assembler.toModel(productDTOPage, link);
    }

    public ProductDTO findById(Long id) {
        Product entity = repository.findById(id).get();
        ProductDTO dto = new ProductDTO(entity);
        logger.info("Buscando o produto = " + entity);
        dto.add(linkTo(methodOn(ProductController.class).findAll(0, 1, "asc")).withRel("Lista de produtos"));
        return dto;
    }

    public ProductDTO insert(Product product) {
        logger.info("Criando um produto = " + product);
        repository.save(product);
        ProductDTO dto = new ProductDTO(product);
        dto.add(linkTo(ProductDTO.class).slash(dto.getId()).withSelfRel());
        return dto;
    }

    public ProductDTO update(Long id, Product product) {
        try {
            logger.info("Atualizando um produto = " + product);
            var entity = repository.findById(id).orElseThrow();
            updateProduct(entity, product);
            repository.save(entity);
            ProductDTO dto = new ProductDTO(entity);
            dto.add(linkTo(ProductDTO.class).slash(dto.getId()).withSelfRel());
            return dto;
        } catch (EntityNotFoundException e) {
            logger.info("Produto não encontrado, id = " + id);
            throw new ProductNotFoundException(id);
        }
    }

    public PagedModel<EntityModel<ProductDTO>> findByNameContainsIgnoreCaseOrderByPrice(String name, Pageable pageable) {
        logger.info("Buscando por nome, ordenando por preço! [PAGINA = " + pageable.getPageNumber() + "] [ORDEM = " + pageable.getSort() + "]" + " [TAMANHO " + pageable.getPageSize() + "]");
        Page<Product> productPage = repository.findByNameContainsIgnoreCaseOrderByPrice(name, pageable);

        Page<ProductDTO> productDTOPage = productPage.map(product -> Mapper.parseObject(product, ProductDTO.class));
        productDTOPage.map(product -> product.add(linkTo(methodOn(ProductController.class).findById(product.getId())).withSelfRel()));

        Link link = linkTo(methodOn(ProductController.class).findAll(pageable.getPageNumber(),
                pageable.getPageSize(), "asc")).withSelfRel();

        return assembler.toModel(productDTOPage, link);
    }

    public PagedModel<EntityModel<ProductDTO>> findByNameContainsIgnoreCaseOrderByPriceDesc(String name, Pageable pageable) {
        logger.info("Buscando por nome, ordenando por preço DESC! [PAGINA = " + pageable.getPageNumber() + "] [ORDEM = " + pageable.getSort() + "]" + " [TAMANHO " + pageable.getPageSize() + "]");
        Page<Product> productPage = repository.findByNameContainsIgnoreCaseOrderByPriceDesc(name, pageable);

        Page<ProductDTO> productDTOPage = productPage.map(product -> Mapper.parseObject(product, ProductDTO.class));
        productDTOPage.map(product -> product.add(linkTo(methodOn(ProductController.class).findById(product.getId())).withSelfRel()));

        Link link = linkTo(methodOn(ProductController.class).findAll(pageable.getPageNumber(),
                pageable.getPageSize(), "asc")).withSelfRel();

        return assembler.toModel(productDTOPage, link);
    }

    public PagedModel<EntityModel<ProductDTO>> findByCodeContainsIgnoreCase(String code, Pageable pageable) {
        logger.info("Buscando por código! [PAGINA = " + pageable.getPageNumber() + "] [ORDEM = " + pageable.getSort() + "]" + " [TAMANHO " + pageable.getPageSize() + "]");
        Page<Product> productPage = repository.findByCodeContainsIgnoreCase(code, pageable);

        Page<ProductDTO> productDTOPage = productPage.map(product -> Mapper.parseObject(product, ProductDTO.class));
        productDTOPage.map(product -> product.add(linkTo(methodOn(ProductController.class).findById(product.getId())).withSelfRel()));

        Link link = linkTo(methodOn(ProductController.class).findAll(pageable.getPageNumber(),
                pageable.getPageSize(), "asc")).withSelfRel();

        return assembler.toModel(productDTOPage, link);
    }

    public PagedModel<EntityModel<ProductDTO>> findByDescriptionContainsIgnoreCase(String description, Pageable pageable) {
        logger.info("Buscando por descrição! [PAGINA = " + pageable.getPageNumber() + "] [ORDEM = " + pageable.getSort() + "]" + " [TAMANHO " + pageable.getPageSize() + "]");
        Page<Product> productPage = repository.findByDescriptionContainsIgnoreCase(description, pageable);

        Page<ProductDTO> productDTOPage = productPage.map(product -> Mapper.parseObject(product, ProductDTO.class));
        productDTOPage.map(product -> product.add(linkTo(methodOn(ProductController.class).findById(product.getId())).withSelfRel()));

        Link link = linkTo(methodOn(ProductController.class).findAll(pageable.getPageNumber(),
                pageable.getPageSize(), "asc")).withSelfRel();

        return assembler.toModel(productDTOPage, link);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        logger.info("Deletando um produto, id = " + id);
        repository.deleteById(id);
    }

    private void updateProduct(Product entity, Product product) {
        entity.setName(product.getName());
        entity.setCode(product.getCode());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
    }
}