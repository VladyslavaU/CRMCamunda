package com.crm.camunda.crmcamunda;

import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class ProcessTrigger {
    private final RuntimeService runtimeService;

    @Transactional
    public void triggerProcess() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("setStatus");
    }
}
