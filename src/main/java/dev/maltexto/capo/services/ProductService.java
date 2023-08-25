package dev.maltexto.capo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.maltexto.capo.entities.Movement;
import dev.maltexto.capo.entities.Product;
import dev.maltexto.capo.entities.enums.MovementType;
import dev.maltexto.capo.exceptions.BadRequestException;
import dev.maltexto.capo.exceptions.EntityAlredyExistsException;
import dev.maltexto.capo.exceptions.EntityNotFoundException;
import dev.maltexto.capo.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MovementService movementService;

    public Product createProduct(Product product) {

        if (product.getInitialBalance() > product.getMinimumQuantity()) {
            throw new BadRequestException("Initial balance cannot be greater than minimum quantity.");
        }

        if (productRepository.existsByBarcode(product.getBarcode())) {
            throw new EntityAlredyExistsException("This barcode is already assigned to another product.");
        }

        Product savedProduct = productRepository.save(product);

        if (product.getInitialBalance() > 0) {
            Movement movement = new Movement();
            movement.setProduct(product);
            movement.setMovementType(MovementType.INITIAL_BALANCE);
            movement.setQuantity(product.getInitialBalance());
            movementService.createMovement(movement);
        }

        return savedProduct;
    }

    public Product updateProduct(Product product) {
        long productId = product.getId();

        if (!productRepository.existsById(productId))
            throw new EntityNotFoundException("Product not found.");

        return productRepository.save(product);
    }

    public Page<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product getProductByBarcode(String barcode) {
        return productRepository.findByBarcode(barcode);
    }

}
