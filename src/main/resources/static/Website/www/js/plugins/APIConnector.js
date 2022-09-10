//=============================================================================
// APIConnector.js
//=============================================================================

/*:
 * @plugindesc Provides connection to the RPGmakerMVMultiplayerAPI (https://github.com/rossfcowie/RPGmakerMVMultiplayerAPI)
 * @author Ross Cowie
 *
 * @help This plugin does not provide plugin commands.
 *
 * @param ServerUrl
 * @desc The server to connect to
 * @default http://localhost:8088
 *
 * 
 *
 * 
 */

var parameters = PluginManager.parameters('APIConnector');
var ServerUrl = parameters['ServerUrl'].toLowerCase();

var accountid = 1// getUrlVars()['id'];
var players = [{},{}];
var monsters = [{},{},{},{}];
var player = {
  "username":"usernamer",
  "x":5,
  "y":5,
  "mapID":1,
  "hp":1,
  "mp":1,
  "mhp":1,
  "mmp":1,
  "atk":1,
  "def":1,
  "mat":1,
  "mdf":1,
  "agi":1,
  "luk":1
}
function getUrlVars() {
  var vars = {};
  try {
  var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (m, key, value) {
    vars[key] = value;
  });
  return vars;
  } catch (error) {
    vars['id'] = 1;
    return vars;
  }
  
}
async function postMyself(name) {
  player.username = name;
  player.hp = $gameActors.actor(1).hp
  player.mp = $gameActors.actor(1).mp
  player.mhp = $gameActors.actor(1).mhp
  player.mmp = $gameActors.actor(1).mmp
  player.atk = $gameActors.actor(1).atk
  player.def = $gameActors.actor(1).def
  player.mat = $gameActors.actor(1).mat
  player.mdf = $gameActors.actor(1).mdf
  player.agi = $gameActors.actor(1).agi
  player.luk = $gameActors.actor(1).luk
    const response = await fetch(ServerUrl+"/playerLocations", { 
      method: "Post",
      headers: {
          "Content-type": "application/json"
      },
      body: JSON.stringify(player)
      }).then((res)=>{
          if (res.status !== 200) {
            console.log(
              `Looks like there was a problem.Status Code: ${res.status}`
            );
            return res.json();
          }
          res.json().then(data =>{player = data; });
        })
        .catch((err) =>{ console.log(err); return});
        
  };

async function getPlayers() {
  fetch(ServerUrl+"/playerLocations/here/"+player.mapID).then((res)=>{
    if (res.status !== 200) {
      console.log(
        `Looks like there was a problem.Status Code: ${res.status}`
      );
      return;
    }
    res.json()
    .then(data => {players = data;})
  }).catch((err) => console.log(err));
};

function getPlayer(id) {
  for (playera of players) {
    if(playera.id ==id){
      return playera;
  }
};
}

async function getThreats() {
  fetch(ServerUrl+"/threat/all").then((res)=>{
    if (res.status !== 200) {
      console.log(
        `Looks like there was a problem.Status Code: ${res.status}`
      );
      return;
    }
    res.json()
    .then(data => {monsters = data;})
  }).catch((err) => console.log(err));
};

function getPlayer(id) {
  for (playera of players) {
    if(playera.id ==id){
      return playera;
  }
};
}


async function noteDamage(monster,dmg){
  fetch(ServerUrl+"/threat/atk/"+monsters[monster].id+"/"+accountid+"/"+dmg, { 
    method: "Put",
    headers: {
        "Content-type": "application/json"
    }}).then((res)=>{
    if (res.status !== 200) {
      console.log(
        `Looks like there was a problem.Status Code: ${res.status}`
      );
      return;
    }
    res.json()
    .then(data => {monsters = data;})
  }).catch((err) => console.log(err));
};


async function getThreats() {
  fetch(ServerUrl+"/threat/all").then((res)=>{
    if (res.status !== 200) {
      console.log(
        `Looks like there was a problem.Status Code: ${res.status}`
      );
      return;
    }
    res.json()
    .then(data => {monsters = data;})
  }).catch((err) => console.log(err));
};

function getPlayer(id) {
  for (playera of players) {
    if(playera.id ==id){
      return playera;
  }
};
}


async function getAllPlayers(){
  getPlayers();

  for (playera of players) {
    if($gameMap._mapId == playera.mapID){
    if(playera.id ==player.id){

    }else{
    Galv.SPAWN.event(1,playera.x,playera.y);

    $gameMap._events[$gameMap._lastSpawnEventId].mid =playera.id;

  }
  }
}}

async function moveMyself(mapID,x,y) {
  player.x = x;
  player.y = y;
  player.mapID = mapID;
    const response = await fetch(ServerUrl+"/playerLocations", { 
      method: "Put",
      headers: {
          "Content-type": "application/json"
      },
      body: JSON.stringify(player)
      }).then((res)=>{
          if (res.status !== 200) {
            console.log(
              `Looks like there was a problem.Status Code: ${res.status}`
            );
            return;
          }else{

          }
          res.json().then()
        })
        .catch((err) =>{ console.log(err); return});
  };

async function updateMyself(mapID,x,y) {
player.x = x;
player.y = y;
player.mapID = mapID;
player.hp = $gameActors.actor(1).hp
player.mp = $gameActors.actor(1).mp
player.mhp = $gameActors.actor(1).mhp
player.mmp = $gameActors.actor(1).mmp
player.atk = $gameActors.actor(1).atk
player.def = $gameActors.actor(1).def
player.mat = $gameActors.actor(1).mat
player.mdf = $gameActors.actor(1).mdf
player.agi = $gameActors.actor(1).agi
player.luk = $gameActors.actor(1).luk
  const response = await fetch(ServerUrl+"/playerLocations", { 
    method: "Put",
    headers: {
        "Content-type": "application/json"
    },
    body: JSON.stringify(player)
    }).then((res)=>{
        if (res.status !== 200) {
          console.log(
            `Looks like there was a problem.Status Code: ${res.status}`
          );
          return;
        }else{

        }
        res.json().then()
      })
      .catch((err) =>{ console.log(err); return});
};

Scene_GameEnd.prototype.commandToTitle = function() {
  this.fadeOutAll();
  sleepmyself();
  SceneManager.goto(Scene_Title);
};

async function sleepmyself() {
    const response = await fetch(ServerUrl+"/playerLocations/"+player.id, { 
      method: "Put",
      headers: {
          "Content-type": "application/json"
      },
      body: JSON.stringify(player)
      }).then((res)=>{
          if (res.status !== 200) {
            console.log(
              `Looks like there was a problem.Status Code: ${res.status}`
            );
            return;
          }else{

          }
          res.json().then()
        })
        .catch((err) =>{ console.log(err); return});
  };

function getMyX(id){
  for (playera of players) {
    if(playera.id == id){
      return playera.x;
    }
  }
}
function getMyY(id){
  for (playera of players) {
    if(playera.id == id){
      return playera.y;
    }
  }
}