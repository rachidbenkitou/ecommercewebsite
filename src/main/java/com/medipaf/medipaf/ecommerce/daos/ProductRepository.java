package com.medipaf.medipaf.ecommerce.daos;

import com.medipaf.medipaf.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
