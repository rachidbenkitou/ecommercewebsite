package com.medipaf.medipaf.ecommerce.daos;

import com.medipaf.medipaf.ecommerce.models.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Ordered, Long> {
}
