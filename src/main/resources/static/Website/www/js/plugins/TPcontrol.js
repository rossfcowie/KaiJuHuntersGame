//=============================================================================
// TPcontrol.js
//=============================================================================
 
/*:
 * @plugindesc Some custom TP values based on states, best used with passive states from yanfly
 * @author by Alevel3mage
 *
 @param ---General---
 * @default
 *
 * @param  State1Num
 * @desc Which state ID has the highest priority to change TP value.
 * @default 152
 *
 * @param  State1val
 * @desc What value does State 1 set tp to.
 * @default 1
 *
  * @param  State2Num
 * @desc Which state ID has the second highest priority to change TP value.
 * @default 153
 *
 * @param  State2val
 * @desc What value does State 2 set tp to.
 * @default 2
 *
  * @param  State3Num
 * @desc Which state ID has the third highest priority to change TP value.
 * @default 154
 *
 * @param  State3val
 * @desc What value does State 3 set tp to.
 * @default 6
 *
  * @param  State4Num
 * @desc Which state ID has the highest priority to change TP value.
 * @default 155
 *
 * @param  State4val
 * @desc What value does State 4 set tp to.
 * @default 32
 *
  * @param  State5Num
 * @desc Which state ID has the highest priority to change TP value.
 * @default 156
 *
 * @param  State5val
 * @desc What value does State 5 set tp to.
 * @default 128
 *
  * @param  State6Num
 * @desc Which state ID has the highest priority to change TP value.
 * @default 157
 *
 * @param  State6val
 * @desc What value does State 6 set tp to.
 * @default 8
 *
  * @param  State7Num
 * @desc Which state ID has the highest priority to change TP value.
 * @default 158
 *
 * @param  State7val
 * @desc What value does State 7 set tp to.
 * @default 5
 *
  * @param  State8Num
 * @desc Which state ID has the highest priority to change TP value.
 * @default 159
 *
 * @param  State8val
 * @desc What value does State 8 set tp to.
 * @default 6
 *
  * @param  State9Num
 * @desc Which state ID has the highest priority to change TP value.
 * @default 160
 *
 * @param  State9val
 * @desc What value does State 9 set tp to.
 * @default 10
 *
  * @param  State10Num
 * @desc Which state ID has the highest priority to change TP value.
 * @default 161
 *
 * @param  State10val
 * @desc What value does State 10 set tp to.
 * @default 4
 *
 * @param  State11Num
 * @desc Which state ID has the highest priority to change TP value.
 * @default 162
 *
 * @param  State11val
 * @desc What value does State 11 set tp to.
 * @default 10
 *
  * @param  State12Num
 * @desc Which state ID has the highest priority to change TP value.
 * @default 163
 *
 * @param  State12val
 * @desc What value does State 12 set tp to.
 * @default 100
 *
  * @param  State13Num
 * @desc Which state ID has the highest priority to change TP value.
 * @default 164
 *
 * @param  State13val
 * @desc What value does State 13 set tp to.
 * @default 12
 *
  * @param  State14Num
 * @desc Which state ID has the highest priority to change TP value.
 * @default 165
 *
  * @param  State14val
 * @desc What value does State 14 set tp to.
 * @default 24
 *
   * @param  StateHPNum
 * @desc Which state ID  changes TP value to be the characters max hp.
 * @default 166
 *
   * @param  StateMPNum
 * @desc Which state ID  changes TP value to be the characters max mp.
 * @default 167
 *
   * @param  StateATKNum
 * @desc Which state ID  changes TP value to be the characters atk.
 * @default 168
 *
   * @param  StateDEFNum
 * @desc Which state ID  changes TP value to be the characters def.
 * @default 169
 *
   * @param  StateMATNum
 * @desc Which state ID  changes TP value to be the characters mat.
 * @default 170
 *
   * @param  StateMDFNum
 * @desc Which state ID  changes TP value to be the characters mdf.
 * @default 171
 *
    * @param  StateAGINum
 * @desc Which state ID  changes TP value to be the characters agi.
 * @default 172
 *
   * @param  StateLUKNum
 * @desc Which state ID  changes TP value to be the characters luk.
 * @default 173
 *
 * @help set state ID to 0 to disable
 *
*/

var params = PluginManager.parameters('TPcontrol');
var state1num = Number(params['State1Num']||152);
var state1val = Number(params['State1val']||1);

var state2num = Number(params['State2Num']||152);
var state2val = Number(params['State2val']||1);

var state3num = Number(params['State3Num']||152);
var state3val = Number(params['State3val']||1);

var state4num = Number(params['State4Num']||152);
var state4val = Number(params['State4val']||1);

var state5num = Number(params['State5Num']||152);
var state5val = Number(params['State5val']||1);

var state6num = Number(params['State6Num']||152);
var state6val = Number(params['State6val']||1);


var state7num = Number(params['State7Num']||152);
var state7val = Number(params['State7val']||1);

var state8num = Number(params['State8Num']||152);
var state8val = Number(params['State8val']||1);

var state9num = Number(params['State9Num']||152);
var state9val = Number(params['State9val']||1);

var state10num = Number(params['State10Num']||152);
var state10val = Number(params['State10val']||1);

var state11num = Number(params['State11Num']||152);
var state11val = Number(params['State11val']||1);

var state12num = Number(params['State12Num']||152);
var state12val = Number(params['State12val']||1);

var state13num = Number(params['State13Num']||152);
var state13val = Number(params['State13val']||1);

var state14num = Number(params['State14Num']||152);
var state14val = Number(params['State14val']||1);

var stateHPnum = Number(params['StateHPNum']||152);
var stateMPnum = Number(params['StateMPNum']||1);
var stateATKnum = Number(params['StateATKNum']||152);
var stateDEFnum = Number(params['StateDEFNum']||1);
var stateMATnum = Number(params['StateMATNum']||152);
var stateMDFnum = Number(params['StateMDFNum']||1);
var stateAGInum = Number(params['StateAGINum']||152);
var stateLUKnum = Number(params['StateLUKNum']||1);


 
(function(){
Game_BattlerBase.prototype.maxTp = function() {
    var tp_value = 3;

if (this.isStateAffected(state1num)) {
	tp_value = state1val;
    }else if(this.isStateAffected(state2num)){
	tp_value = state2val;
	}else if(this.isStateAffected(state3num)){
	tp_value = state3val;
	}else if(this.isStateAffected(state4num)){
	tp_value = state4val;
	}else if(this.isStateAffected(state5num)){
	tp_value = state5val;
	}else if(this.isStateAffected(state6num)){
	tp_value = state6val;
	}else if(this.isStateAffected(state7num)){
	tp_value = state7val;
	}else if(this.isStateAffected(state8num)){
	tp_value = state8val;
	}else if(this.isStateAffected(state9num)){
	tp_value = state9val;
	}else if(this.isStateAffected(state10num)){
	tp_value = state10val;
	}else if(this.isStateAffected(state11num)){
	tp_value = state11val;
	}else if(this.isStateAffected(state12num)){
	tp_value = state12val;
	}else if(this.isStateAffected(state13num)){
	tp_value = state13val;
	}else if(this.isStateAffected(state14num)){
	tp_value = state14val;
	}else if(this.isStateAffected(stateHPnum)){
	tp_value = this.param(0);
	}else if(this.isStateAffected(stateMPnum)){
	tp_value = this.param(1);
	}else if(this.isStateAffected(stateATKnum)){
	tp_value = this.param(2);
	}else if(this.isStateAffected(stateDEFnum)){
	tp_value = this.param(3);
	}else if(this.isStateAffected(stateMATnum)){
	tp_value = this.param(4);
	}else if(this.isStateAffected(stateMDFnum)){
	tp_value = this.param(5);
	}else if(this.isStateAffected(stateAGInum)){
	tp_value = this.param(6) * 3;
	}else if(this.isStateAffected(stateLUKnum)){
	tp_value = this.param(7);
	}else{
		tp_value = 3;
}
	
  return tp_value;
};
})();
(function(){

Game_Battler.prototype.initTp = function() {
    this.setTp(0);
};
})();
(function(){

Game_Battler.prototype.chargeTpByDamage = function(damageRate) {
    this.gainSilentTp(0);
};
})();
















