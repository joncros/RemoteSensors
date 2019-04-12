package com.github.joncros.remoteSensors;

import com.google.gson.Gson;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.*;

public class ComponentAdapter {
    private String cpus;
    private String mobos;
    private String gpus;
    private String disks;

    public ComponentAdapter() {
        Components components = JSensors.get.components();
        Gson gson = new Gson();
        cpus = gson.toJson(components.cpus);
        mobos = gson.toJson(components.mobos);
        gpus = gson.toJson(components.gpus);
        disks = gson.toJson(components.disks);
    }

    public String getCpus() {
        return cpus;
    }

    public String getMobos() {
        return mobos;
    }

    public String getGpus() {
        return gpus;
    }

    public String getDisks() {
        return disks;
    }
}
