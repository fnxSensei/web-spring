package org.fnxexample.catalogue.repository;

import org.fnxexample.catalogue.entity.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Integer> {
}