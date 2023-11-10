/**
 * 
 */

function isEmpty(input) {
	return (!input.value);
}

function isNotNumber(input) {
	return isNaN(input.value);
}

function atLeastLetter(input, length) {
	return (input.value.length < length);
}

function atValueMax(input, num) {
	return (input.value > num);
}

function atValueMin(input, num) {
	return (input.value < num);
}

function isNotType(input, type) {
	type = "." + type;
	return (input.value.indexOf(type) == -1);
}

function start() {

	let nameB = document.ff.names;
	let heightB = document.ff.height;
	let weightB = document.ff.weight;
	let picB = document.ff.photo;

	if (isEmpty(nameB)) {
		alert('이름을 입력해주세요!');
		nameB.value = "";
		nameB.focus();
		return false;
	} else if (atLeastLetter(nameB, 2)) {
		alert('이름을 2자 이상 입력해주세요!');
		nameB.value = "";
		nameB.focus();
		return false;
	} else if (isEmpty(heightB)) {
		alert('키를 입력해주세요!');
		heightB.value = "";
		heightB.focus();
		return false;
	} else if (isNotNumber(heightB)) {
		alert('키에 숫자를 입력해주세요!');
		heightB.value = "";
		heightB.focus();
		return false;
	} else if (atLeastLetter(heightB, 3)) {
		alert('키를 100cm 이상으로 입력해주세요!');
		heightB.value = "";
		heightB.focus();
		return false;
	} else if (atValueMax(heightB, 250)) {
		alert('키를 250cm 이하로 입력해주세요!');
		heightB.value = "";
		heightB.focus();
		return false;
	} else if (isEmpty(weightB)) {
		alert('몸무게를 입력해주세요!');
		weightB.value = "";
		weightB.focus();
		return false;
	} else if (isNotNumber(weightB)) {
		alert('몸무게에 숫자를 입력해주세요!');
		weightB.value = "";
		weightB.focus();
		return false;
	} else if (atLeastLetter(weightB, 2)) {
		alert('몸무게를 10kg 이상으로 입력해주세요!');
		weightB.value = "";
		weightB.focus();
		return false;
	} else if (atValueMax(weightB, 200)) {
		alert('몸무게를 200kg 이하로 입력해주세요!');
		weightB.value = "";
		weightB.focus();
		return false;
	} else if (isEmpty(picB)) {
		alert('파일을 추가해주세요!');
		picB.value = "";
		picB.focus();
		return false;
	} else if (isNotType(picB, "jpg") && isNotType(picB, "png")
		&& isNotType(picB, "gif") && isNotType(picB, "GIF")
		&& isNotType(picB, "PNG")) {
		alert('유효한 확장자의 파일을 추가헤주세요!\n.jpg/.png/.gif/.GIF/.PNG');
		picB.value = "";
		picB.focus();
		return false;
	}

	return true;

}