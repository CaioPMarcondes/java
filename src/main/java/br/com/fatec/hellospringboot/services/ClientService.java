package br.com.fatec.hellospringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fatec.hellospringboot.entities.Client;
import br.com.fatec.hellospringboot.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;

    public List<Client> getClients(){
        return repository.findAll();
    }
    public Client getClientByID(int id){
        return repository.findById(id).orElseThrow(
        () -> new EntityNotFoundException("Cliente nao encontrado") 
        );
    }
        public void deleteClientById(int id){

            if(this.repository.existsById(id)){
                this.repository.deleteById(id);
            }
            else{
                throw new EntityNotFoundException("Cliente nao encontrado");
            }
            
        }
        }

        
