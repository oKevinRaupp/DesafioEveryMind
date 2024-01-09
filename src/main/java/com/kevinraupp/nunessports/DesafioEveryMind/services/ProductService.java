package com.kevinraupp.nunessports.DesafioEveryMind.services;

import com.kevinraupp.nunessports.DesafioEveryMind.dto.ProductDTO;
import com.kevinraupp.nunessports.DesafioEveryMind.entities.Product;
import com.kevinraupp.nunessports.DesafioEveryMind.exceptions.ProductNotFoundException;
import com.kevinraupp.nunessports.DesafioEveryMind.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductService {
    private Logger logger = Logger.getLogger(ProductService.class.getName());

    @Autowired
    private ProductRepository repository;

    public List<ProductDTO> findAll() {
        logger.info("Buscando todos os produtos!");

        List<Product> products = repository.findAll();
        List<ProductDTO> listDTO = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            ProductDTO dto = new ProductDTO(products.get(i));
            listDTO.add(dto);
        }

        return listDTO;
    }

    public ProductDTO findById(Long id) {
        Product entity = repository.findById(id).get();
        ProductDTO dto = new ProductDTO(entity);
        logger.info("Buscando o produto = " + entity);
        return dto;
    }

    public ProductDTO insert(Product product) {
        logger.info("Criando um produto = " + product);
        repository.save(product);
        ProductDTO dto = new ProductDTO(product);
        return dto;
    }

    public ProductDTO update(Long id, Product product) {
        try {
            logger.info("Atualizando um produto = " + product);
            var entity = repository.findById(id).orElseThrow();
            updateProduct(entity, product);
            repository.save(entity);
            ProductDTO dto = new ProductDTO(entity);
            return dto;
        } catch (EntityNotFoundException e) {
            logger.info("Produto não encontrado, id = " + id);
            throw new ProductNotFoundException(id);
        }
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