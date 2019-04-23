/**
 * Populates a table on index.html with the sensor readings for a single component (cpu core, gpu, etc).
 * @param (object) component, parsed from JSON
 * @param (jQuery selector) tableRef, reference to the table (such as $('#cpu-sensors'))
*/
function showSensors(component, tableRef) {
	if (component.sensors == null) {
		return;
	}

	// array to hold table rows
	var rows = [];

    // temperature readings
	var temps = component.sensors.temperatures;
	for (j = 0; j < temps.length; j++) {
		var tr = $("<tr></tr>");
		var td1 = $("<td></td>").text(temps[j].name);
		var td2 = $("<td></td>").text(temps[j].value + " C");
		tr.append(td1);
		tr.append(td2);
		rows.push(tr.prop('outerHTML'));
	}

	// fan readings
    var fans = component.sensors.fans;
    for (j = 0; j < fans.length; j++) {
        var tr = $("<tr></tr>");
        var td1 = $("<td></td>").text(fans[j].name);
        var td2 = $("<td></td>").text(fans[j].value + " RPM");
        tr.append(td1);
        tr.append(td2);
        rows.push(tr.prop('outerHTML'));
    }

    // load readings
    var loads = component.sensors.loads;
    for (j = 0; j < loads.length; j++) {
        var tr = $("<tr></tr>");
        var td1 = $("<td></td>").text(loads[j].name);
        var td2 = $("<td></td>").text(loads[j].value);
        tr.append(td1);
        tr.append(td2);
        rows.push(tr.prop('outerHTML'));
    }

    tableRef.append(rows.join());
}

$(document).ready(function() {
    $.ajax({

        // load json holding sensor readings
        url: "http://localhost:8080/sensors"
    }).then(function(data) {

        // parse json into javascript array cpus
		cpus = $.parseJSON(data.cpus);
		if (cpus.length == 0) {
			$('#cpus').hide();
		} else {
			for (i = 0; i < cpus.length; i++) {

			    // display name and sensors for a single cpu core
				var cpu = cpus[i];
				if(cpu.name != null) {
					$('#cpu-sensors').append($("<tr></tr>").append($("<td></td>").text(cpu.name)));
				}
				showSensors(cpu, $('#cpu-sensors'));
			}
		}

		// parse json into javascript array mobos
		mobos = $.parseJSON(data.mobos);
		if (mobos.length == 0) {
			$('#motherboard').hide();
		} else {
			for (i = 0; i < mobos.length; i++) {

			    // display name and sensors for a single motherboard
				var mobo = mobos[i];
				var tableRef = $('#mobo-sensors');
				if (mobo.name != null) {
					tableRef.append($("<tr></tr>").append($("<td></td>").text(mobo.name)));
				}
				showSensors(mobo, tableRef);
			}
		}

		// parse json into javascript array gpus
		gpus = $.parseJSON(data.gpus);
		if (gpus.length == 0) {
			$('#gpus').hide();
		} else {
			for (i = 0; i < gpus.length; i++) {

			    // display name and sensors for a single gpu
				var gpu = gpus[i];
				var tableRef = $('#gpu-sensors');
				if (gpu.name != null) {
					tableRef.append($("<tr></tr>").append($("<td></td>").text(gpu.name)));
				}
				showSensors(gpu, tableRef);
			}
		}

		// parse json into javascript array disks
		disks = $.parseJSON(data.disks);
		if (disks.length == 0) {
			$('#disks').hide();
		} else {
			for (i = 0; i < disks.length; i++) {

			    // display name and sensors for a single gpu
				var disk = disks[i];
				var tableRef = $('#disk-sensors');
				if (disk.name != null) {
					tableRef.append($("<tr></tr>").append($("<td></td>").text(disk.name)));
				}
				showSensors(disk, tableRef);
			}
		}
    });
});