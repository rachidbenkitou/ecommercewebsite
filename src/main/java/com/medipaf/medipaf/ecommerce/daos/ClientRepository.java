package com.medipaf.medipaf.ecommerce.daos;

import com.medipaf.medipaf.ecommerce.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {


}
