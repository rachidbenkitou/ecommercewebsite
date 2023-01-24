package com.medipaf.medipaf.ecommerce.mappers;

import com.medipaf.medipaf.ecommerce.dtos.ClientDto;
import com.medipaf.medipaf.ecommerce.models.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(imports = UUID.class, componentModel = "spring")
public interface ClientMapper {

    ClientDto modelToDto(Client client);

    List<ClientDto> modelToDtos(List<Client> client);
    @InheritInverseConfiguration
    @Mapping(target = "code", expression = "java(UUID.randomUUID().toString())")
    Client dtoToModel(ClientDto clientDto);
}
