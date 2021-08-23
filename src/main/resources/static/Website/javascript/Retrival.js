
const threatbox = document.querySelector("#content");
const threat = document.querySelector("#threatbox");
function getUrlVars() {
  var vars = {};
  var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (m, key, value) {
    vars[key] = value;
  });
  return vars;
}
const threatid = getUrlVars()['id'];
function sendHttpRequest(method, url) {
    let headers = {
      "Content-Type": "application/json",
      "Key":document.cookie.split("=")[1]
    }
    console.log(headers);
      return fetch(url, {
        method: method,
        headers: headers,
      })
        .then((response) => {
          status = response.status;
          if (response.status >= 200 && response.status < 300) {
            
            return response.json();
          } else {
            if (response.status == 401) {
              alert("You are either not logged in or have an invalid User Key. Please log in to fix this.  If this issue persists, please contact support.");
            }
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

    async function SetupThreats(){
    
      let targets = (await sendHttpRequest("GET",`/threat/all`))
      let i= 0;
      if(targets.length>0){
        threatbox.innerHTML="";
      }
   
      targets.forEach(target => {
          if(i<8){
          let t = `
          <div id = "content" class="content">
          <a href="/threat?id=`+target.id +`">
            <div class="content-overlay"></div>
            <img class="content-image" src="`+target.image+`">
            <div class="content-details fadeIn-bottom">
              <h3 class="content-title">`+target.name+`</h3>
              <p class="content-text">Level:`+target.level+ "</br>" +target.species+ "</br>" +target.chp+ "/" +target.maxHp*target.level+`</p>
            </div>
          </a>
        </div>     
          </a>
      </div>`
      threatbox.innerHTML+= t;
      i++;
   }
      });
  }
  
  async function SingleThreat(){
    let target = (await sendHttpRequest("GET",`/threat/read/`+threatid))
    let leaderboard = (await sendHttpRequest("GET",`/stats/threat/`+threatid))
        let t = `<div class="container"><div class="row"><div class="col-3"></div><div class="col-6">
        <div style="  position: relative;
        text-align: center;height:700px; width: 700px;" class="containerpad"> 
        <img style="width:80%;height:80%;position: absolute;padding: 4%;transform: translate(-50%, 0%)" src="`+target.image+`"></img>
            </br>
            <h1 style="  position: absolute;
            left: 50%;
            transform: translate(-50%, 0%);padding: 4%;" class="title">`+ target.name+`</h1></br>
    
            <h2 style="  position: absolute;
            left: 50%;
            transform: translate(-50%, 650%);" class="title">Level:`+target.level+`</h2> 
            <h2 style="  position: absolute;
            left: 50%;
            transform: translate(-50%, 380%);" class="title">Species: `+ target.species+`</h2> 
            </br>
            <h2 style="  position: absolute;
            left: 50%;
            transform: translate(-50%, 450%);" class="title">Health : ` + target.chp + `/`+target.maxHp*target.level+`</h2> 
            </div>
        </img>
                   </div>
          </div>
          <div class="container"><div class="row"><div class="col-3"></div><div class="col-6">
          <div style=" position: relative;" class="container"> 
        <div id="leaderboard" class="container">
          `
          
          leaderboard.records.forEach(record => {
            t+=`<div class="row"><div class="col-1"></div> <div class="col-5">`+ record.accountName+ `</div><div class="col-1"></div><div style="
            text-align: right;" class="col-5">`+ record.dmg+`</div><div class="col-1"></div></div>`


          });
          t+=`</div></div></div><div class="col-3"></div></div></div></div><div class="col-3"></div></div></div>`
          threat.innerHTML= t;

}