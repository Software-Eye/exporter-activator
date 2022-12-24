package org.softwareeyes.exporterActivator.admin.reload;

import org.softwareeyes.exporterActivator.admin.reload.models.ForceReloadResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reload")
public class ReloadController {

    @PostMapping(params={"OrganizationId"})
    public ForceReloadResponse forceReload(String OrganizationId) {
        return new ForceReloadResponse(true, 100);
    }
}
