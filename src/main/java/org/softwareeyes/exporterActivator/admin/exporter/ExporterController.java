package org.softwareeyes.exporterActivator.admin.exporter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exporter")
public class ExporterController {
    @GetMapping(params = {"OrganizationId", "ExporterTitle"})
    public void getExporterConfiguration(String organizationId, String exporterTitle){

    }

}
