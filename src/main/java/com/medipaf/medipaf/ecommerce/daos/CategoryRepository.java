package com.medipaf.medipaf.ecommerce.daos;

import com.medipaf.medipaf.ecommerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
