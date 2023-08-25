package dev.maltexto.capo.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import dev.maltexto.capo.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    public boolean existsByBarcode(String barcode);

    public Product findByBarcode(String barcode);
}
