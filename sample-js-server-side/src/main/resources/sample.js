

function hello(name) { 
	println('Hello, ' + serviceSample.getSampleDto().getName()); 
}

function executeCallback() {
	serviceSample.getRandomValue();
}

function printSampleDto(sampleDto) {
	println('ID: ' + sampleDto.getId() + ' Name: ' + sampleDto.getName()); 
}