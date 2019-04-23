package com.github.joncros.remoteSensors;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.*;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;

import java.util.List;

/**
 * Tests the JSensors library by printing sensor readings to the console
 *
 * @author joncros
 */
public class test {
    public static void main(String[] args) {
        Components components = JSensors.get.components();

        List<Cpu> cpus = components.cpus;
        if (cpus == null) {
            System.out.println("cpus == null");
        }
        else {
            for (final Cpu cpu : cpus) {
                System.out.println("Found CPU component: " + cpu.name);
                if (cpu.sensors != null) {
                    System.out.println("Sensors: ");

                    //Print temperatures
                    List<Temperature> temps = cpu.sensors.temperatures;
                    for (final Temperature temp : temps) {
                        System.out.println(temp.name + ": " + temp.value + " C");
                    }

                    //Print fan speed
                    List<Fan> fans = cpu.sensors.fans;
                    for (final Fan fan : fans) {
                        System.out.println(fan.name + ": " + fan.value + " RPM");
                    }

                    //Pring loads
                    List<Load> loads = cpu.sensors.loads;
                    for (Load load : loads) {
                        System.out.println(load.name + ": " + load.value);
                    }
                }
            }
        }

        List<Mobo> mobos = components.mobos;
        if (mobos != null) {
            for (Mobo mobo : mobos) {
                System.out.println("Found Mobo component: " + mobo.name);
                if (mobo.sensors != null) {
                    System.out.println("Sensors: ");

                    //Print temperatures
                    List<Temperature> temps = mobo.sensors.temperatures;
                    for (Temperature temp : temps) {
                        System.out.println(temp.name + ": " + temp.value + " C");
                    }

                    //Print fan speed
                    List<Fan> fans = mobo.sensors.fans;
                    for (final Fan fan : fans) {
                        System.out.println(fan.name + ": " + fan.value + " RPM");
                    }
                }
            }
        }

        List<Gpu> gpus = components.gpus;
        if (gpus != null) {
            for (final Gpu gpu : gpus) {
                System.out.println("Found GPU component: " + gpu.name);
                if (gpu.sensors != null) {
                    System.out.println("Sensors: ");

                    //Print temperatures
                    List<Temperature> temps = gpu.sensors.temperatures;
                    for (final Temperature temp : temps) {
                        System.out.println(temp.name + ": " + temp.value + " C");
                    }

                    //Print fan speed
                    List<Fan> fans = gpu.sensors.fans;
                    for (final Fan fan : fans) {
                        System.out.println(fan.name + ": " + fan.value + " RPM");
                    }

                    //Pring loads
                    List<Load> loads = gpu.sensors.loads;
                    for (Load load : loads) {
                        System.out.println(load.name + ": " + load.value);
                    }
                }
            }
        }

        List<Disk> disks = components.disks;
        if (disks != null) {
            for (Disk disk : disks) {
                System.out.println("Found disk component: " + disk.name);
                if (disk.sensors != null) {
                    System.out.println("Sensors: ");

                    //Print temperatures
                    List<Temperature> temps = disk.sensors.temperatures;
                    for (final Temperature temp : temps) {
                        System.out.println(temp.name + ": " + temp.value + " C");
                    }

                    //Print fan speed
                    List<Fan> fans = disk.sensors.fans;
                    for (final Fan fan : fans) {
                        System.out.println(fan.name + ": " + fan.value + " RPM");
                    }

                    //Pring loads
                    List<Load> loads = disk.sensors.loads;
                    for (Load load : loads) {
                        System.out.println(load.name + ": " + load.value);
                    }
                }
            }
        }
    }
}
