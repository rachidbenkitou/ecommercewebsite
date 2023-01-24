package com.medipaf.medipaf.ecommerce.services.servicesImpl;

import com.medipaf.medipaf.ecommerce.daos.ClientRepository;
import com.medipaf.medipaf.ecommerce.dtos.ClientDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.ClientNoFoundException;
import com.medipaf.medipaf.ecommerce.mappers.ClientMapper;
import com.medipaf.medipaf.ecommerce.models.Client;
import com.medipaf.medipaf.ecommerce.services.servicesInter.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<ClientDto> findAll() {

        List<ClientDto> clientDtos=clientMapper.modelToDtos(clientRepository.findAll());
        return clientDtos;
    }

    @Override
    public ClientDto findById(Long id) throws ClientNoFoundException {

        Client client= clientRepository.findById(id)
                .orElseThrow(() -> new ClientNoFoundException("Client Not Found!"));

        ClientDto clientDto= clientMapper.modelToDto(client);

        return clientDto;

    }

    @Override
    public ClientDto save(ClientDto clientDto) {

        Client client=clientMapper.dtoToModel(clientDto);

        Client saved=clientRepository.save(client);

        return clientMapper.modelToDto(saved);
    }

    @Override
    public ClientDto update(ClientDto clientDto) {

        Client client=clientMapper.dtoToModel(clientDto);

        Client saved=clientRepository.save(client);

        return clientMapper.modelToDto(saved);
    }

    @Override
    public void delete(Long id) {

        clientRepository.deleteById(id);

    }
}
