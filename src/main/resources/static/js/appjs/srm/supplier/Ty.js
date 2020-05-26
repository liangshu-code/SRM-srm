function Ty() {

	$.ajax({
		cache : true,
		type : "POST",
		url : "/supTy",
		data : {'id' : 1},
		async : false,
		error : function(request) {
			alert("Connection error");
		},
		success : function(data) {
		console.log(data)
		var regCapital =data.regCapital
        var rc = document.getElementById("registeredCapital");
        rc.value = regCapital;

        var dateEstablishment =data.estiblishTime
        var Date = document.getElementById("dateEstablishment");
        Date.value = dateEstablishment;

        var businessRegistration =data.regLocation
        var bg = document.getElementById("businessRegistration");
        bg.value = businessRegistration;

 	    var orgNumber =data.orgNumber
        var og = document.getElementById("organizationCode");
        og.value = orgNumber;

     	var staffNumRange =data.staffNumRange
        var sf = document.getElementById("staffSize");
        sf.value = staffNumRange;
		}
	});

}

