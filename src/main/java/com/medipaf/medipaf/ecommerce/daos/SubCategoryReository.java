package com.medipaf.medipaf.ecommerce.daos;

import com.medipaf.medipaf.ecommerce.models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "subCategory", path = "subCategory")
public interface SubCategoryReository extends JpaRepository<SubCategory,Long> {
}
