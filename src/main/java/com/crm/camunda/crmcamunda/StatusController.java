package com.crm.camunda.crmcamunda;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@AllArgsConstructor
public class StatusController {
    private final ProcessTrigger processTrigger;

    @PostMapping
    public void setStatus() {
        processTrigger.triggerProcess();
    }
}
