package com.github.joncros.remoteSensors;

import com.google.gson.Gson;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.*;


/**
 * Uses google's Gson to serialize all of the jsensors (@code Component} objects for this machine
 * into JSON.
 *
 * @author joncros
 *
 * <p>Returns four JSON strings corresponding to each type of Component (cpu, mobo, gpu, disk).
 * Each string can be parsed to obtain an array of javascript objects (corresponding to all of the
 * cpu cores, for example). To deserialize into javascript objects, use
 * {@code $.parseJSON(data.Component)} where Component is cpus, mobos, gpus or disks.
 *
 * <p>In line with the jsensors data model, each object has the properties {@code name} and {@code sensors}.
 * {@code sensors} is an object with properties {@code temperatures, fans and loads} and each property
 * is an array of name:value pairs for the corresponding sensor. An example of a cpus string:
 *
 * <pre>{@code cpus	"[{\"name\":\"cpu name\",\"sensors\":{\"temperatures\":[{\"name\":\"Temp Core #1\",\"value\":57.0},
 * {\"name\":\"Temp Core #2\",\"value\":60.0}],\"fans\":[],\"loads\":[{\"name\":
 * \"Load CPU Core #1\",\"value\":60.68376},{\"name\":\"Load CPU Core #2\",\"value\":64.10257},
 * {\"name\":\"Load CPU Total\",\"value\":62.39316},{\"name\":\"Load Memory\",\"value\":85.67255}]}}]"}</pre>
 */
public class ComponentAdapter {
    private String cpus;
    private String mobos;
    private String gpus;
    private String disks;

    public ComponentAdapter() {

        // Get all current sensor readings using jsensors
        Components components = JSensors.get.components();

        // Serialize into JSON strings
        Gson gson = new Gson();
        cpus = gson.toJson(components.cpus);
        mobos = gson.toJson(components.mobos);
        gpus = gson.toJson(components.gpus);
        disks = gson.toJson(components.disks);
    }

    /**
     *
     * @return a json string corresponding to the array of cpu objects.
     */
    public String getCpus() {
        return cpus;
    }

    /**
     *
     * @return a json string corresponding to the array of mobo (motherboard) objects.
     */
    public String getMobos() {
        return mobos;
    }

    /**
     *
     * @return a json string corresponding to the array of gpu objects.
     */
    public String getGpus() {
        return gpus;
    }

    /**
     *
     * @return a json string corresponding to the array of disk objects.
     */
    public String getDisks() {
        return disks;
    }
}
