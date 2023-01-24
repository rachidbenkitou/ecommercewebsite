package com.medipaf.medipaf.ecommerce.services.servicesInter;

import com.medipaf.medipaf.ecommerce.dtos.ClientDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.ClientNoFoundException;

import java.util.List;

public interface ClientService {

    List<ClientDto> findAll();

    ClientDto findById(Long id) throws ClientNoFoundException;

    ClientDto save(ClientDto clientDto);

    ClientDto update(ClientDto clientDto);

    void delete(Long id);
}
