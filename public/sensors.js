function showSensors(component, tableRef) {
	if (component.sensors == null) {
		return;
	}
	var rows = [];
	var temps = component.sensors.temperatures;
		for (j = 0; j < temps.length; j++) {
			var tr = $("<tr></tr>");
			var td1 = $("<td></td>").text(temps[j].name);
			var td2 = $("<td></td>").text(temps[j].value + " C");
			tr.append(td1);
			tr.append(td2);
			rows.push(tr.prop('outerHTML'));
		}
		var fans = component.sensors.fans;
		for (j = 0; j < fans.length; j++) {
			var tr = $("<tr></tr>");
			var td1 = $("<td></td>").text(fans[j].name);
			var td2 = $("<td></td>").text(fans[j].value + " RPM");
			tr.append(td1);
			tr.append(td2);
			rows.push(tr.prop('outerHTML'));
		}
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
        url: "http://localhost:8080/sensors"
    }).then(function(data) {
		cpus = $.parseJSON(data.cpus);
		if (cpus.length == 0) {
			$('#cpus').hide();
		} else {
			for (i = 0; i < cpus.length; i++) {
				var cpu = cpus[i];
				if(cpu.name != null) {
					$('#cpu-sensors').append($("<tr></tr>").append($("<td></td>").text(cpu.name)));
				}
				showSensors(cpu, $('#cpu-sensors'));
			}
		}
		mobos = $.parseJSON(data.mobos);
		if (mobos.length == 0) {
			$('#motherboard').hide();
		} else {
			for (i = 0; i < mobos.length; i++) {
				var mobo = mobos[i];
				var tableRef = $('#mobo-sensors');
				if (mobo.name != null) {
					tableRef.append($("<tr></tr>").append($("<td></td>").text(mobo.name)));
				}
				showSensors(mobo, tableRef);
			}
		}
		gpus = $.parseJSON(data.gpus);
		if (gpus.length == 0) {
			$('#gpus').hide();
		} else {
			for (i = 0; i < gpus.length; i++) {
				var gpu = gpus[i];
				var tableRef = $('#gpu-sensors');
				if (gpu.name != null) {
					tableRef.append($("<tr></tr>").append($("<td></td>").text(gpu.name)));
				}
				showSensors(gpu, tableRef);
			}
		}
		disks = $.parseJSON(data.disks);
		if (disks.length == 0) {
			$('#disks').hide();
		} else {
			for (i = 0; i < disks.length; i++) {
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