package com.github.joncros.remoteSensors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Maps the JSON serializing all of the sensor readings for the current machine to
 * http://localhost:8080/sensors.
 *
 * @author joncros
 */
@RestController
public class ComponentsController {

    /**
     * Serves the required JSON in response to HTTP GET requests at /sensors. <p>Uses a ComponentAdapter
     * to serialize jsensors Component objects into JSON.
     * @return JSON consisting of the four strings {@code cpus, mobos, gpus disks} that serializes the
     * sensor readings
     */
    @RequestMapping("/sensors")
    public ComponentAdapter components() {
        return new ComponentAdapter();
    }

}
