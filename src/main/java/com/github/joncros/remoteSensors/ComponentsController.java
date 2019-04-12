package com.github.joncros.remoteSensors;

import com.profesorfalken.jsensors.JSensors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComponentsController {

    @RequestMapping("/sensors")
    public ComponentAdapter components() {
        return new ComponentAdapter();
    }

}
