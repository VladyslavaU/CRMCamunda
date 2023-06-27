package com.crm.camunda.crmcamunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SetStatus implements JavaDelegate {

    private final CompanySaleRepository repository;

    public SetStatus(CompanySaleRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void execute(DelegateExecution execution) {
        Object id = execution.getVariable("id");
        System.out.println("Value of 'id' variable: " + id);      //  Object id = execution.getVariable("id");
       // System.out.println("Value of 'id' variable: " + id);
      //  Long id = Long.parseLong((String) execution.getVariable("id"));
        /*System.out.println("Received id: " + id);

        repository.setLead(id);
        System.out.println("Lead set for id: " + id);*/
    }
}