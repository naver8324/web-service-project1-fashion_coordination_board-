document.getElementById("login-form").addEventListener("submit", function (e) {
  e.preventDefault();
  var username = document.getElementById("loginId").value;
  var password = document.getElementById("loginId").value;

  // 아이디와 비밀번호의 유효성을 검사합니다.
  if (!isValidUsername(username)) {
    displayErrorMessage("아이디는 4글자 이상이어야 합니다.");
  } else if (!isValidPassword(password)) {
    displayErrorMessage("비밀번호는 6글자 이상이어야 합니다.");
  } else {
    // 로그인 성공 시 여기에 추가 작업을 수행합니다.
//    alert("로그인 성공!");
  }
});

// 아이디의 유효성을 검사합니다.
function isValidUsername(username) {
  return username.length >= 4;
}

// 비밀번호의 유효성을 검사합니다.
function isValidPassword(password) {
  return password.length >= 6;
}

// 에러 메시지를 표시합니다.
function displayErrorMessage(message) {
  var errorMessage = document.getElementById("error-message");
  errorMessage.textContent = message;
}

// 아이디 및 비밀번호 입력칸에 blur 이벤트를 추가하여 입력값이 유효하지 않을 경우 에러 메시지를 표시합니다.
document.getElementById("loginId").addEventListener("blur", function () {
  var username = document.getElementById("loginId").value;
  if (!isValidUsername(username)) {
    displayErrorMessage("아이디는 4글자 이상이어야 합니다.");
  } else {
    displayErrorMessage("");
  }
});

document.getElementById("password").addEventListener("blur", function () {
  var password = document.getElementById("password").value;
  if (!isValidPassword(password)) {
    displayErrorMessage("비밀번호는 6글자 이상이어야 합니다.");
  } else {
    displayErrorMessage("");
  }
});
