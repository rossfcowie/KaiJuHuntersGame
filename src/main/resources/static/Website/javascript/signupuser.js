

const getUserName = document.querySelector("#uname");
const getPassword = document.querySelector("#pass");
const getConfirmationPassword = document.querySelector("#confpassword");
const createAccountBtn = document.querySelector("#submit");
const loginBtn = document.querySelector("#login");
var status;

function sendHttpRequest(method, url, data) {
  console.log(data);
  return fetch(url, {
    method: method,
    body: JSON.stringify(data),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      status = response.status;
      if (response.status >= 200 && response.status < 300) {
        return response.json();
      } else {
        return response.json().then((errData) => {
          console.log(errData);
          throw new Error("Something went wrong - server-side");
        });
      }
    })
    .catch((error) => {
      console.log(error);
      throw new Error("Something went wrong");
    });
}

async function createPost(uname, pass) {
  const post = {
    uname: uname,
    pass: pass,
  };
  await sendHttpRequest("POST", `/users/signup`, post);
  console.log(status);
  if (status == 226) {
    console.log(uname + "in use");
  }
  if (status == 201) {
    console.log("It works!");
    window.location.href = "/home";
  }
  status = 0;
}

createAccountBtn.addEventListener("click", (event) => {
  event.preventDefault();
  const enteredUserName = getUserName.value;
  const enteredPassword = getPassword.value;
  if (validatePassword) {
    createPost(enteredUserName, enteredPassword);
  } else {
    console.log("Passwords do not match!");
  }
});

function validatePassword() {
  if (getPassword.value != getConfirmationPassword.value) {
    alert("Passwords do not match.");
    return false;
  }
  return true;
}
